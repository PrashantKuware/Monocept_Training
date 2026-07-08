package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.ExpenseClaimRequestDTO;
import com.example.demo.dto.response.ExpenseClaimResponseDTO;
import com.example.demo.entity.ExpenseClaim;
@Component
public class ExpenseClaimMapper {
    public ExpenseClaim toEntity(ExpenseClaimRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return ExpenseClaim.builder()
                .employeeName(dto.getEmployeeName() != null ? dto.getEmployeeName().trim() : null)
                .department(dto.getDepartment())
                .category(dto.getCategory())
                .amount(dto.getAmount())
                .expenseDate(dto.getExpenseDate())
                .description(dto.getDescription())
                .build();
    }
    public ExpenseClaimResponseDTO toResponseDTO(ExpenseClaim entity) {
        if (entity == null) {
            return null;
        }
        return ExpenseClaimResponseDTO.builder()
                .id(entity.getId())
                .employeeName(entity.getEmployeeName())
                .department(entity.getDepartment())
                .category(entity.getCategory())
                .amount(entity.getAmount())
                .expenseDate(entity.getExpenseDate())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .reviewRemark(entity.getReviewRemark())
                .reviewedAt(entity.getReviewedAt())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}