package com.monocept.demo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentProfileRequestDto 
{
	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Invalid email format")
	@Column(nullable = false, unique = true)
	String email;
	
	@Column(nullable = false)
	long phone;
	
	@Column(nullable = false)
	String city;
}
