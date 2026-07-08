package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.response.ApiResponse;
import com.example.demo.dto.response.FinanceSummaryDTO;
import com.example.demo.service.ExpenseClaimService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/v1/finance-summary")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class FinanceSummaryController {
    private final ExpenseClaimService claimService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<FinanceSummaryDTO>>> getMonthlyFinanceSummary(
            @RequestParam Integer month,
            @RequestParam Integer year
    ) {
        log.info("REST Request - getMonthlyFinanceSummary - month: {}, year: {}", month, year);
        List<FinanceSummaryDTO> response = claimService.getMonthlyFinanceSummary(month, year);
        return ResponseEntity.ok(ApiResponse.success(response, "Monthly summary compiled successfully"));
    }
}
