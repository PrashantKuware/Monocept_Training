package com.monocept.demo;

import java.beans.BeanProperty;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private final StudentRepository studentRepository;

	Application(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner runner (StudentRepository studentRepository)
	{
		return runner ->
		{
//			Student sts1 = new Student(1,"Amit",43);
//			Student sts2 = new Student(2,"Namit",434);
//			
//			studentRepository.save(sts1);
//			studentRepository.save(sts2);
			
			List <Student> foundedstd = studentRepository.findAll();
			for(Student s : foundedstd)
			{
				System.out.println(s.id+" : "+s.name+": "+s.age);
			}
		};
	}
}
