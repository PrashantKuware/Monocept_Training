package com.monocept.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monocept.demo.model.Employee;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(
            String email,
            Long id);
}