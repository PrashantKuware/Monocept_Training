package com.example.demo.dto.request;

import com.example.demo.enums.ExpenseStatus;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaimReviewRequestDTO {
    @NotNull(message = "Review status is required")
    private ExpenseStatus status;
    @Size(max = 255, message = "Remark must not exceed 255 characters")
    private String remark;
}