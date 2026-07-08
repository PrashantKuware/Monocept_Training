package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.dto.request.ClaimReviewRequestDTO;
import com.example.demo.dto.request.ExpenseClaimRequestDTO;
import com.example.demo.dto.response.ExpenseClaimResponseDTO;
import com.example.demo.dto.response.FinanceSummaryDTO;
import com.example.demo.enums.Department;
import com.example.demo.enums.ExpenseCategory;
import com.example.demo.enums.ExpenseStatus;
public interface ExpenseClaimService {
    ExpenseClaimResponseDTO submitClaim(ExpenseClaimRequestDTO dto);
    
    Page<ExpenseClaimResponseDTO> getClaimsWithFilters(
            Department department,
            Integer month,
            Integer year,
            ExpenseCategory category,
            ExpenseStatus status,
            String employeeName,
            Pageable pageable
    );
    
    ExpenseClaimResponseDTO getClaimById(Long id);
    
    ExpenseClaimResponseDTO reviewClaim(Long id, ClaimReviewRequestDTO dto);
    
    List<FinanceSummaryDTO> getMonthlyFinanceSummary(Integer month, Integer year);
}