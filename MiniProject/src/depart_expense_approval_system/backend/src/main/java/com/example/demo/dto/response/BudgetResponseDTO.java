package com.example.demo.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.enums.Department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetResponseDTO {
    private Long id;
    private Department department;
    private Integer month;
    private Integer year;
    private BigDecimal budgetAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}