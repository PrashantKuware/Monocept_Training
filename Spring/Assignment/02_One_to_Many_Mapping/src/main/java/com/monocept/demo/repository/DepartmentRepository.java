package com.monocept.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monocept.demo.model.Department;

@Repository
public interface DepartmentRepository
        extends JpaRepository<Department, Long> {

    boolean existsByDepartmentName(String departmentName);

    boolean existsByDepartmentNameAndIdNot(
            String departmentName,
            Long id);
}