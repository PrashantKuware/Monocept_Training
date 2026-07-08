package com.example.demo.service.impl;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.request.ClaimReviewRequestDTO;
import com.example.demo.dto.request.ExpenseClaimRequestDTO;
import com.example.demo.dto.response.ExpenseClaimResponseDTO;
import com.example.demo.dto.response.FinanceSummaryDTO;
import com.example.demo.entity.DepartmentBudget;
import com.example.demo.entity.ExpenseClaim;
import com.example.demo.enums.Department;
import com.example.demo.enums.ExpenseCategory;
import com.example.demo.enums.ExpenseStatus;
import com.example.demo.exception.BudgetExceededException;
import com.example.demo.exception.InvalidExpenseStateException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.ExpenseClaimMapper;
import com.example.demo.repository.DepartmentBudgetRepository;
import com.example.demo.repository.ExpenseClaimRepository;
import com.example.demo.service.ExpenseClaimService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseClaimServiceImpl implements ExpenseClaimService {
    private final ExpenseClaimRepository claimRepository;
    private final DepartmentBudgetRepository budgetRepository;
    private final ExpenseClaimMapper claimMapper;
    @Override
    @Transactional
    public ExpenseClaimResponseDTO submitClaim(ExpenseClaimRequestDTO dto) {
        log.info("Submitting new expense claim for employee: {}, department: {}, amount: {}", 
                dto.getEmployeeName(), dto.getDepartment(), dto.getAmount());
        ExpenseClaim claim = claimMapper.toEntity(dto);
        claim.setStatus(ExpenseStatus.PENDING); // Explicitly force PENDING status
        
        ExpenseClaim savedClaim = claimRepository.save(claim);
        return claimMapper.toResponseDTO(savedClaim);
    }
    @Override
    @Transactional(readOnly = true)
    public Page<ExpenseClaimResponseDTO> getClaimsWithFilters(
            Department department,
            Integer month,
            Integer year,
            ExpenseCategory category,
            ExpenseStatus status,
            String employeeName,
            Pageable pageable
    ) {
        log.info("Fetching filtered claims with pagination parameters");
        Specification<ExpenseClaim> spec = Specification.where(null);
        if (department != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("department"), department));
        }
        if (category != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("category"), category));
        }
        if (status != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("status"), status));
        }
        if (employeeName != null && !employeeName.trim().isEmpty()) {
            spec = spec.and((root, query, cb) -> cb.like(
                    cb.lower(root.get("employeeName")), 
                    "%" + employeeName.trim().toLowerCase() + "%"
            ));
        }
        if (month != null) {
            spec = spec.and((root, query, cb) -> cb.equal(
                    cb.function("MONTH", Integer.class, root.get("expenseDate")), 
                    month
            ));
        }
        if (year != null) {
            spec = spec.and((root, query, cb) -> cb.equal(
                    cb.function("YEAR", Integer.class, root.get("expenseDate")), 
                    year
            ));
        }
        return claimRepository.findAll(spec, pageable).map(claimMapper::toResponseDTO);
    }
    @Override
    @Transactional(readOnly = true)
    public ExpenseClaimResponseDTO getClaimById(Long id) {
        log.info("Fetching claim by ID: {}", id);
        return claimRepository.findById(id)
                .map(claimMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("ExpenseClaim with ID " + id + " not found"));
    }
    @Override
    @Transactional
    public ExpenseClaimResponseDTO reviewClaim(Long id, ClaimReviewRequestDTO dto) {
        log.info("Reviewing claim ID: {}, target status: {}", id, dto.getStatus());
        // Fetch target claim
        ExpenseClaim claim = claimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ExpenseClaim with ID " + id + " not found"));
        // Rule: Only PENDING claims can be updated
        if (claim.getStatus() != ExpenseStatus.PENDING) {
            log.error("Claim ID: {} is in status: {} and cannot be reviewed", id, claim.getStatus());
            throw new InvalidExpenseStateException(
                    "Only pending claims can be approved or rejected. Current status: " + claim.getStatus()
            );
        }
        int expenseMonth = claim.getExpenseDate().getMonthValue();
        int expenseYear = claim.getExpenseDate().getYear();
        if (dto.getStatus() == ExpenseStatus.APPROVED) {
            log.info("Initiating budget evaluation for department: {}, month: {}, year: {}", 
                    claim.getDepartment(), expenseMonth, expenseYear);
            // Fetch budget for the claim's department, month, and year with a PESSIMISTIC WRITE lock
            DepartmentBudget budget = budgetRepository.findByDepartmentAndMonthAndYearWithLock(
                    claim.getDepartment(), 
                    expenseMonth, 
                    expenseYear
            ).orElseThrow(() -> {
                log.error("No budget allocated for department: {} in period: {}/{}", 
                        claim.getDepartment(), expenseMonth, expenseYear);
                return new ResourceNotFoundException(
                        String.format("No budget exists for department %s in %02d/%d. Approve fails.", 
                                claim.getDepartment(), expenseMonth, expenseYear)
                );
            });
            // Calculate current total of APPROVED claims for that department/month/year
            BigDecimal approvedSum = claimRepository.sumApprovedExpenses(
                    claim.getDepartment(), 
                    expenseMonth, 
                    expenseYear
            );
            BigDecimal proposedSum = approvedSum.add(claim.getAmount());
            // Validate against the budget limit
            if (proposedSum.compareTo(budget.getBudgetAmount()) > 0) {
                log.error("Budget exceeded for department: {}. Allocated: {}, Approved: {}, Proposed approval: {}", 
                        claim.getDepartment(), budget.getBudgetAmount(), approvedSum, claim.getAmount());
                throw new BudgetExceededException(
                        String.format("Approval failed: budget limits exceeded. Allocated budget: %s, Current approved expenditures: %s, Claim amount: %s",
                                budget.getBudgetAmount(), approvedSum, claim.getAmount())
                );
            }
            claim.setStatus(ExpenseStatus.APPROVED);
        } else if (dto.getStatus() == ExpenseStatus.REJECTED) {
            // Rule: Validation is triggered if rejected. Let's make sure remark is provided
            if (dto.getRemark() == null || dto.getRemark().trim().isEmpty()) {
                throw new IllegalArgumentException("A review remark is required when rejecting claims.");
            }
            claim.setStatus(ExpenseStatus.REJECTED);
        }
        claim.setReviewRemark(dto.getRemark() != null ? dto.getRemark().trim() : null);
        claim.setReviewedAt(LocalDateTime.now());
        ExpenseClaim updatedClaim = claimRepository.save(claim);
        log.info("Claim ID: {} updated successfully to status: {}", id, updatedClaim.getStatus());
        return claimMapper.toResponseDTO(updatedClaim);
    }
    @Override
    @Transactional(readOnly = true)
    public List<FinanceSummaryDTO> getMonthlyFinanceSummary(Integer month, Integer year) {
        log.info("Generating finance summary for period: {}/{}", month, year);
        if (month == null || year == null) {
            throw new IllegalArgumentException("Month and year parameters are required for financial summary.");
        }
        List<FinanceSummaryDTO> summaries = new ArrayList<>();
        for (Department dept : Department.values()) {
            // Fetch Budget (No lock needed for summary view)
            BigDecimal budgetAmount = budgetRepository.findByDepartmentAndMonthAndYear(dept, month, year)
                    .map(DepartmentBudget::getBudgetAmount)
                    .orElse(BigDecimal.ZERO);
            // Fetch metrics breakdown
            List<Object[]> metrics = claimRepository.getMonthlyStatusMetrics(dept, month, year);
            BigDecimal approvedSum = BigDecimal.ZERO;
            BigDecimal pendingSum = BigDecimal.ZERO;
            long approvedCount = 0;
            long pendingCount = 0;
            long rejectedCount = 0;
            for (Object[] metric : metrics) {
                ExpenseStatus status = (ExpenseStatus) metric[0];
                long count = (long) metric[1];
                BigDecimal sum = (BigDecimal) metric[2];
                switch (status) {
                    case APPROVED:
                        approvedSum = sum;
                        approvedCount = count;
                        break;
                    case PENDING:
                        pendingSum = sum;
                        pendingCount = count;
                        break;
                    case REJECTED:
                        rejectedCount = count;
                        break;
                }
            }
            BigDecimal remainingBudget = budgetAmount.subtract(approvedSum);
            summaries.add(FinanceSummaryDTO.builder()
                    .department(dept)
                    .monthlyBudget(budgetAmount)
                    .totalApprovedExpense(approvedSum)
                    .totalPendingExpense(pendingSum)
                    .remainingBudget(remainingBudget)
                    .numberOfApprovedClaims(approvedCount)
                    .numberOfPendingClaims(pendingCount)
                    .numberOfRejectedClaims(rejectedCount)
                    .build());
        }
        return summaries;
    }
}