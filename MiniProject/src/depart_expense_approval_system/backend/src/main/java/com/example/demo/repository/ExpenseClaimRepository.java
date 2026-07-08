package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ExpenseClaim;
import com.example.demo.enums.Department;
@Repository
public interface ExpenseClaimRepository extends JpaRepository<ExpenseClaim, Long>, JpaSpecificationExecutor<ExpenseClaim> {
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM ExpenseClaim e " +
           "WHERE e.department = :department " +
           "AND e.status = com.example.demo.enums.ExpenseStatus.APPROVED " +
           "AND FUNCTION('MONTH', e.expenseDate) = :month " +
           "AND FUNCTION('YEAR', e.expenseDate) = :year")
    BigDecimal sumApprovedExpenses(
            @Param("department") Department department,
            @Param("month") Integer month,
            @Param("year") Integer year
    );
    @Query("SELECT e.status, COUNT(e), COALESCE(SUM(e.amount), 0) FROM ExpenseClaim e " +
           "WHERE e.department = :department " +
           "AND FUNCTION('MONTH', e.expenseDate) = :month " +
           "AND FUNCTION('YEAR', e.expenseDate) = :year " +
           "GROUP BY e.status")
    List<Object[]> getMonthlyStatusMetrics(
            @Param("department") Department department,
            @Param("month") Integer month,
            @Param("year") Integer year
    );
}