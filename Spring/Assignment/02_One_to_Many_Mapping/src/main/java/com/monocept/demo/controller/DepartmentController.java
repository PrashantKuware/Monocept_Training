package com.monocept.demo.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.demo.dto.DepartmentRequestDto;
import com.monocept.demo.dto.DepartmentResponseDto;
import com.monocept.demo.dto.PageResponseDto;
import com.monocept.demo.service.DepartmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
@Validated
public class DepartmentController {

    private final DepartmentService departmentService;

    private static final Logger logger =
            LoggerFactory.getLogger(DepartmentController.class);

    /**
     * Create Department
     */
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DepartmentResponseDto> createDepartment(
            @Valid @RequestBody DepartmentRequestDto requestDto) {

        logger.info("Create Department API called");

        DepartmentResponseDto response =
                departmentService.createDepartment(requestDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Get All Departments
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments() {

        logger.info("Get All Departments API called");

        return ResponseEntity.ok(
                departmentService.getAllDepartments());
    }

    /**
     * Get Departments With Pagination
     */
    @GetMapping("/page")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<PageResponseDto<DepartmentResponseDto>>
            getAllDepartmentsWithPagination(

                    @RequestParam(defaultValue = "0")
                    int pageNumber,

                    @RequestParam(defaultValue = "5")
                    int pageSize) {

        logger.info(
                "Pagination API called. pageNumber={}, pageSize={}",
                pageNumber,
                pageSize);

        return ResponseEntity.ok(
                departmentService.getAllDepartmentsWithPagination(
                        pageNumber,
                        pageSize));
    }

    /**
     * Get Department By Id
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<DepartmentResponseDto>
            getDepartmentById(@PathVariable Long id) {

        logger.info("Get Department By Id API called : {}", id);

        return ResponseEntity.ok(
                departmentService.getDepartmentById(id));
    }

    /**
     * Update Department
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DepartmentResponseDto>
            updateDepartment(

                    @PathVariable Long id,

                    @Valid
                    @RequestBody DepartmentRequestDto requestDto) {

        logger.info("Update Department API called : {}", id);

        return ResponseEntity.ok(
                departmentService.updateDepartment(
                        id,
                        requestDto));
    }

    /**
     * Delete Department
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void>
            deleteDepartment(@PathVariable Long id) {

        logger.info("Delete Department API called : {}", id);

        departmentService.deleteDepartment(id);

        return ResponseEntity.noContent().build();
    }
}