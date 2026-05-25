package com.monocept.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.monocept.demo.DAO.EmployeeDao;
import com.monocept.demo.model.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner runner(EmployeeDao empdao)
	{
		return runner -> {
//			createEmp(empdao);
//			updateEmployee(empdao);
			deleteEmployee(empdao);
		};
	}

	private void deleteEmployee(EmployeeDao empdao) 
	{
		System.out.println("Deleting Employee");
		empdao.deletEmp(5);
		System.out.println("Employee deleted");
	}

	private void updateEmployee(EmployeeDao empdao) 
	{
		System.out.println("Updating Employee");
		Employee foundEmp = empdao.findbyid(1);
		foundEmp.setName("Pt. Jatin Kishore");
		empdao.updateEmp(foundEmp);
		System.out.println(" Employee name updated");
	}

	private void createEmp(EmployeeDao empdao) {
		System.out.println("Creating new Employee");
		Employee emp = new Employee(5,"Jatin sharma","BIT","Ranchi");
		empdao.empSave(emp);	
		System.out.println(" new Employee created with id : "+emp.getId());
	}
}
