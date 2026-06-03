package com.monocept.demo.service;

import java.util.List;

import com.monocept.demo.dto.DepartmentRequestDto;
import com.monocept.demo.dto.DepartmentResponseDto;
import com.monocept.demo.dto.PageResponseDto;

public interface DepartmentService {

    DepartmentResponseDto createDepartment(
            DepartmentRequestDto dto);

    List<DepartmentResponseDto> getAllDepartments();

    PageResponseDto<DepartmentResponseDto>
    getAllDepartmentsWithPagination(
            int pageNumber,
            int pageSize);

    DepartmentResponseDto getDepartmentById(Long id);

    DepartmentResponseDto updateDepartment(
            Long id,
            DepartmentRequestDto dto);

    void deleteDepartment(Long id);
}