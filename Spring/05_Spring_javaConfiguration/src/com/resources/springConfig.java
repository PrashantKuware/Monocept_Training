package com.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.beans.Student;

@Configuration
public class springConfig 
{
	@Bean
	public Student stdId1()
	{
		Student std = new Student();
		std.setName("Prashant Kuware");
		std.setEmail("prashant@reddifmail.com");
		std.setRollno(102);
		return std;
	}
}
