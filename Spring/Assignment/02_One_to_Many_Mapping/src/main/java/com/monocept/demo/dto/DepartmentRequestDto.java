package com.monocept.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DepartmentRequestDto {

    @JsonProperty("department_name")
    @NotBlank
    private String departmentName;

    @NotBlank
    private String location;

    @NotEmpty
    @Valid
    private List<EmployeeRequestDto> employees;
}