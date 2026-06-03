package com.monocept.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DepartmentResponseDto {

    private Long id;

    @JsonProperty("department_name")
    private String departmentName;

    private String location;

    private List<EmployeeResponseDto> employees;
}