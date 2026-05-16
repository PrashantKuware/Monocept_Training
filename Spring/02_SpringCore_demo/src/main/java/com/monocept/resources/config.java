package com.monocept.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.monocept.demo.Address;
import com.monocept.demo.Student;

@Configuration
public class config 
{
	@Bean
	public Address createAddressObj()
	{
		Address addr = new Address();
		addr.setHouseno(101);
		addr.setCity("Delhi");
		addr.setPincode(835215);
		return addr;
	}
	
	@Bean
	public Student createStudentObj()
	{
		Student std = new Student();
		std.setName("prashant");
		std.setRollno(145344028);
		std.setAddress(createAddressObj());
		return std;
	}
}
