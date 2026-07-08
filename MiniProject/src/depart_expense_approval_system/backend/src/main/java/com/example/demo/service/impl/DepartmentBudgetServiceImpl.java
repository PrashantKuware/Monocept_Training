package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.request.BudgetRequestDTO;
import com.example.demo.dto.response.BudgetResponseDTO;
import com.example.demo.entity.DepartmentBudget;
import com.example.demo.exception.DuplicateBudgetException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.BudgetMapper;
import com.example.demo.repository.DepartmentBudgetRepository;
import com.example.demo.service.DepartmentBudgetService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentBudgetServiceImpl implements DepartmentBudgetService {
    private final DepartmentBudgetRepository budgetRepository;
    private final BudgetMapper budgetMapper;
    @Override
    @Transactional
    public BudgetResponseDTO createBudget(BudgetRequestDTO dto) {
        log.info("Creating budget for department: {}, month: {}, year: {}", 
                dto.getDepartment(), dto.getMonth(), dto.getYear());
        // Validate uniqueness constraint
        budgetRepository.findByDepartmentAndMonthAndYear(
                dto.getDepartment(), 
                dto.getMonth(), 
                dto.getYear()
        ).ifPresent(existing -> {
            log.error("Duplicate budget detected for department: {}, period: {}/{}", 
                    dto.getDepartment(), dto.getMonth(), dto.getYear());
            throw new DuplicateBudgetException(
                    String.format("A budget already exists for department %s in %02d/%d", 
                            dto.getDepartment(), dto.getMonth(), dto.getYear())
            );
        });
        DepartmentBudget budget = budgetMapper.toEntity(dto);
        DepartmentBudget savedBudget = budgetRepository.save(budget);
        return budgetMapper.toResponseDTO(savedBudget);
    }
    @Override
    @Transactional(readOnly = true)
    public List<BudgetResponseDTO> getAllBudgets() {
        log.info("Fetching all department budgets");
        return budgetRepository.findAll().stream()
                .map(budgetMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public BudgetResponseDTO getBudgetById(Long id) {
        log.info("Fetching budget by ID: {}", id);
        return budgetRepository.findById(id)
                .map(budgetMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Budget with ID " + id + " not found"));
    }
}