package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DepartmentBudget;
import com.example.demo.enums.Department;

import jakarta.persistence.LockModeType;

@Repository
public interface DepartmentBudgetRepository extends JpaRepository<DepartmentBudget, Long> {
    Optional<DepartmentBudget> findByDepartmentAndMonthAndYear(
            Department department,
            Integer month,
            Integer year
    );
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT b FROM DepartmentBudget b WHERE b.department = :department AND b.month = :month AND b.year = :year")
    Optional<DepartmentBudget> findByDepartmentAndMonthAndYearWithLock(
            @Param("department") Department department,
            @Param("month") Integer month,
            @Param("year") Integer year
    );
    List<DepartmentBudget> findByDepartment(Department department);
    List<DepartmentBudget> findByYear(Integer year);
}