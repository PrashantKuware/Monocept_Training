package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.BudgetRequestDTO;
import com.example.demo.dto.response.BudgetResponseDTO;
import com.example.demo.entity.DepartmentBudget;
@Component
public class BudgetMapper {
    public DepartmentBudget toEntity(BudgetRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return DepartmentBudget.builder()
                .department(dto.getDepartment())
                .month(dto.getMonth())
                .year(dto.getYear())
                .budgetAmount(dto.getBudgetAmount())
                .build();
    }
    public BudgetResponseDTO toResponseDTO(DepartmentBudget entity) {
        if (entity == null) {
            return null;
        }
        return BudgetResponseDTO.builder()
                .id(entity.getId())
                .department(entity.getDepartment())
                .month(entity.getMonth())
                .year(entity.getYear())
                .budgetAmount(entity.getBudgetAmount())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}