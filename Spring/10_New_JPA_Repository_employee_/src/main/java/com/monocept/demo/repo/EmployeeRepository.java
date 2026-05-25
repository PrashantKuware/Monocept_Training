package com.monocept.demo.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monocept.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

	List<Employee> findByName(String name);
	
	List<Employee> findByAge(int age);
	
	List<Employee> findByCityCode(String code);
	
	List<Employee> findBySalaryGreaterThan(BigDecimal salary);
}
