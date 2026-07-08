package com.example.demo.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.demo.enums.Department;
import com.example.demo.enums.ExpenseCategory;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseClaimRequestDTO {
    @NotBlank(message = "Employee name is required")
    @Size(min = 2, max = 100, message = "Employee name must be between 2 and 100 characters")
    @Pattern(regexp = "^(?!\\s+$).*", message = "Employee name cannot consist of whitespace only")
    private String employeeName;
    @NotNull(message = "Department is required")
    private Department department;
    @NotNull(message = "Expense category is required")
    private ExpenseCategory category;
    @NotNull(message = "Expense amount is required")
    @DecimalMin(value = "0.01", message = "Expense amount must be greater than zero")
    @DecimalMax(value = "100000.00", message = "Expense amount exceeds maximum limit of 100,000.00")
    private BigDecimal amount;
    @NotNull(message = "Expense date is required")
    @PastOrPresent(message = "Expense date cannot be in the future")
    private LocalDate expenseDate;
    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;
}