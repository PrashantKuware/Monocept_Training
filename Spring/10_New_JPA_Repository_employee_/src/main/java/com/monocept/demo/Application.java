package com.monocept.demo;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.monocept.demo.model.Employee;
import com.monocept.demo.service.EmployeeService;

@SpringBootApplication
public class Application implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private EmployeeService service;

	@Override
	public void run(String... args) throws Exception
	{
		 Employee emp1 = new Employee( "Prashant", 24, "IND", new BigDecimal("5000"));
	     Employee emp2 = new Employee( "Rahul", 30, "MUM", new BigDecimal("8200"));
	     Employee emp3 = new Employee( "Aman",28, "DEL", new BigDecimal("12000"));
	     
//	     service.saveEmployee(emp1);
//	     service.saveEmployee(emp2);
//	     service.saveEmployee(emp3);
	     
	  // Read All
	     
//	     System.out.println("All employees");
//	     service.getAllEmployee().forEach(System.out::println);
	     
	     // Read By ID
//	     System.out.println(" employees by Id");
//	     System.out.println(service.getEmpById(1));
	     
	     // Read By Name
//	     System.out.println(" employees by Name");
//	     System.out.println(service.getEmpByName("prashant"));
	     
	  // Read By Age
//	     System.out.println(" employees by age");
//	     System.out.println(service.getEmpByAge(30));
	     
	  // Read By City Code
//	     System.out.println(" employees by city code");
//	     System.out.println(service.getEmpByCityCode("MUM"));
	     
	     // Salary Greater Than 1000
	     System.out.println("Salary Greater Than 1000");
	     service.getSalaryGreaterThen().forEach(System.out::println);
	}
	
}
