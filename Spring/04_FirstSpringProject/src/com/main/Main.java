package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Student;

public class Main 
{

	public static void main(String[] args) 
	{
		String configLocation = "/com/resources/applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		Student std = (Student) context.getBean("stdId");
		std.display();
	}

}

//1 spring-beans-xxx.jar
//2 spring-core-xxx.jar
//3 spring-context-xxx.jar
//4 common-logging-xxx.jar
//5 spring-expression-xxx.jar