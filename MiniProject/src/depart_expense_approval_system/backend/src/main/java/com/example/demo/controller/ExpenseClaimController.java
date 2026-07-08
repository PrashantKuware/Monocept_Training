package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.ClaimReviewRequestDTO;
import com.example.demo.dto.request.ExpenseClaimRequestDTO;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.dto.response.ExpenseClaimResponseDTO;
import com.example.demo.dto.response.PaginatedResponse;
import com.example.demo.enums.Department;
import com.example.demo.enums.ExpenseCategory;
import com.example.demo.enums.ExpenseStatus;
import com.example.demo.service.ExpenseClaimService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/v1/expense-claims")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class ExpenseClaimController {
    private final ExpenseClaimService claimService;
    @PostMapping
    public ResponseEntity<ApiResponse<ExpenseClaimResponseDTO>> submitClaim(@Valid @RequestBody ExpenseClaimRequestDTO dto) {
        log.info("REST Request - submitClaim - employee: {}, amount: {}", dto.getEmployeeName(), dto.getAmount());
        ExpenseClaimResponseDTO response = claimService.submitClaim(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Expense claim submitted successfully"));
    }
    @GetMapping
    public ResponseEntity<ApiResponse<PaginatedResponse<ExpenseClaimResponseDTO>>> getClaimsWithFilters(
            @RequestParam(required = false) Department department,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) ExpenseCategory category,
            @RequestParam(required = false) ExpenseStatus status,
            @RequestParam(required = false) String employeeName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt,desc") String sort
    ) {
        log.info("REST Request - getClaimsWithFilters - dept: {}, status: {}, employeeName: {}", department, status, employeeName);
        
        // Handle sorting parameters (e.g. "createdAt,desc")
        String[] sortParts = sort.split(",");
        String sortField = sortParts[0];
        Sort.Direction sortDir = sortParts.length > 1 && sortParts[1].equalsIgnoreCase("asc") 
                ? Sort.Direction.ASC 
                : Sort.Direction.DESC;
        
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDir, sortField));
        
        Page<ExpenseClaimResponseDTO> filteredPage = claimService.getClaimsWithFilters(
                department, month, year, category, status, employeeName, pageable
        );
        
        return ResponseEntity.ok(ApiResponse.success(
                PaginatedResponse.fromPage(filteredPage),
                "Claims retrieved successfully"
        ));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ExpenseClaimResponseDTO>> getClaimById(@PathVariable Long id) {
        log.info("REST Request - getClaimById - ID: {}", id);
        ExpenseClaimResponseDTO response = claimService.getClaimById(id);
        return ResponseEntity.ok(ApiResponse.success(response, "Claim details retrieved successfully"));
    }
    @PutMapping("/{id}/review")
    public ResponseEntity<ApiResponse<ExpenseClaimResponseDTO>> reviewClaim(
            @PathVariable Long id,
            @Valid @RequestBody ClaimReviewRequestDTO dto
    ) {
        log.info("REST Request - reviewClaim - ID: {}, Status: {}", id, dto.getStatus());
        ExpenseClaimResponseDTO response = claimService.reviewClaim(id, dto);
        return ResponseEntity.ok(ApiResponse.success(response, "Claim reviewed successfully"));
    }
}