package com.monocept.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentRequestDto 
{
	@NotBlank(message = "Name cannot be blank")
	@Column(nullable = false)
	@JsonProperty("full_name")
	String fullName;
	
	@NotNull
	@Min(1)
	@Column(nullable = false)
	int age;
	
	@Valid
	@NotNull
	private StudentProfileRequestDto profile;
}
