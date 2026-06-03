package com.monocept.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EmployeeRequestDto {

    @JsonProperty("employee_name")
    @NotBlank
    private String employeeName;

    @Email
    @NotBlank
    private String email;

    @Positive
    private Double salary;
}