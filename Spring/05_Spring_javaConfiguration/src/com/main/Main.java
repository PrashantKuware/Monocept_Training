package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beans.Student;
import com.resources.springConfig;

public class Main 
{
	public static void main(String[] args)
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(springConfig.class);
//		
//		Student std = (Student) context.getBean("stdId1");
//		std.display();
		

		Student std = (Student) context.getBean(Student.class);
		std.display();
	}
}
