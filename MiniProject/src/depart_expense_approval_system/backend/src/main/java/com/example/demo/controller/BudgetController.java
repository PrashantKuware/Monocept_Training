package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.BudgetRequestDTO;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.dto.response.BudgetResponseDTO;
import com.example.demo.service.DepartmentBudgetService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/v1/budgets")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*") // Allow frontend access
public class BudgetController {
    private final DepartmentBudgetService budgetService;
    @PostMapping
    public ResponseEntity<ApiResponse<BudgetResponseDTO>> createBudget(@Valid @RequestBody BudgetRequestDTO dto) {
        log.info("REST Request - createBudget - dept: {}, month: {}, year: {}", 
                dto.getDepartment(), dto.getMonth(), dto.getYear());
        BudgetResponseDTO response = budgetService.createBudget(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Budget created successfully"));
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<BudgetResponseDTO>>> getAllBudgets() {
        log.info("REST Request - getAllBudgets");
        List<BudgetResponseDTO> response = budgetService.getAllBudgets();
        return ResponseEntity.ok(ApiResponse.success(response, "Budgets retrieved successfully"));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BudgetResponseDTO>> getBudgetById(@PathVariable Long id) {
        log.info("REST Request - getBudgetById - ID: {}", id);
        BudgetResponseDTO response = budgetService.getBudgetById(id);
        return ResponseEntity.ok(ApiResponse.success(response, "Budget retrieved successfully"));
    }
}
