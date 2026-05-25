package com.monocept.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.demo.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>
{
	public Employee getByName(String name);
	public Employee getByCity(String city);
}
