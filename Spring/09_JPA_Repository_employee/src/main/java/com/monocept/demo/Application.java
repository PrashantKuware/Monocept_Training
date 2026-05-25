package com.monocept.demo;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.monocept.demo.Repository.EmployeeRepo;
import com.monocept.demo.model.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	private final EmployeeRepo emprepo;
	
	Application(EmployeeRepo emprepo) {
		this.emprepo = emprepo;
	}
	
	@Bean
	CommandLineRunner runner (EmployeeRepo emprepo)
	{
		return runner -> {
			Employee emp1 = new Employee(101,"Ravi Kishan","Labour","Bihar");
			Employee emp2 = new Employee(102,"Pawan singh","Dancer","Patna");
			
			// create
			
//			emprepo.save(emp1);
//			emprepo.save(emp2);
			
			// update
			
//			Optional<Employee> findById = emprepo.findById(101);
//			Employee tempEmployee = findById.get();
//			tempEmployee.setName("golu");
//			emprepo.save(tempEmployee);
			
			// delete
			
//			emprepo.delete(emp2);
			
			// read
//			List <Employee> foundedstd = emprepo.findAll();
//			for(Employee e : foundedstd)
//			{
//				System.out.println(e.getId()+" : "+e.getName()+": "+e.getCompany()+": "+e.getCity());
//			}
			
			// read by city
			 Employee getByCity = emprepo.getByCity("patna");
			 System.out.println(getByCity);
			 
			// read by name
			 Employee getByName = emprepo.getByName("golu");
			 System.out.println(getByName);
		};
	}
}
