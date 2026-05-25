package com.monocept.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.demo.model.Employee;
import com.monocept.demo.repo.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository repository;
	
	public void saveEmployee(Employee employee)
	{
		repository.save(employee);
		System.out.println("Employee Saved");
	}

	public List<Employee> getAllEmployee() 
	{
		return repository.findAll();
	}

	public Employee getEmpById(int id) 
	{
		Optional<Employee> emp = repository.findById(id);
		 return emp.orElse(null);
	}

	public List<Employee> getEmpByName(String name) 
	{
		return repository.findByName(name);
	}
	
	public List<Employee> getEmpByAge(int age)
	{
		return repository.findByAge(age);
	}
	
	public List<Employee> getEmpByCityCode(String code)
	{
		return repository.findByCityCode(code);
	}
	
	public List<Employee> getSalaryGreaterThen()
	{
		 return repository.findBySalaryGreaterThan(new BigDecimal("1000"));
	}
}
