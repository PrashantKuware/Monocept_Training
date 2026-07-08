package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.request.BudgetRequestDTO;
import com.example.demo.dto.response.BudgetResponseDTO;
public interface DepartmentBudgetService {
    BudgetResponseDTO createBudget(BudgetRequestDTO dto);
    List<BudgetResponseDTO> getAllBudgets();
    BudgetResponseDTO getBudgetById(Long id);
}