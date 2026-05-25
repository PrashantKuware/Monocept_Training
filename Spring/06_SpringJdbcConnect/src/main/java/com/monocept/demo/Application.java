package com.monocept.demo;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.monocept.demo.DAO.StudentDao;
import com.monocept.demo.model.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao stdDao)
	{
		return runner -> {
			
//			createStudent(stdDao);
//			readStudent(stdDao);
			findAll(stdDao);
		};
	}
	
	private void findAll(StudentDao stdDao) 
	{
		System.out.println("Reading All student data");
		List<Student> fndAllStd = stdDao.findAllStudent();
		for(Student s : fndAllStd)
		{
			System.out.println("ID"+s.getId()+"Name"+s.getName()+"City"+s.getCity());
		}
		System.out.println("Found the All student data"+fndAllStd);
	}

	private void readStudent(StudentDao stdDao) 
	{
		System.out.println("Reading student data");
		Student fndStd = stdDao.findByid(2);
		System.out.println("Found the student data"+fndStd);
	}

	private void createStudent(StudentDao stdDao)
	{
		System.out.println("Creating new student object");
		Student tempStd = new Student(2, "Raju Rastogi", "Ahamdabad");
		
		System.out.println("Saving the student record");
		stdDao.save(tempStd);
		
		System.out.println("Saved the student, Id : "+tempStd.getId());
	}
}
