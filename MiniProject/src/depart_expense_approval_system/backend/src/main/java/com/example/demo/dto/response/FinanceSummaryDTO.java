package com.example.demo.dto.response;

import java.math.BigDecimal;

import com.example.demo.enums.Department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinanceSummaryDTO {
    private Department department;
    private BigDecimal monthlyBudget;
    private BigDecimal totalApprovedExpense;
    private BigDecimal totalPendingExpense;
    private BigDecimal remainingBudget;
    private long numberOfPendingClaims;
    private long numberOfApprovedClaims;
    private long numberOfRejectedClaims;
}