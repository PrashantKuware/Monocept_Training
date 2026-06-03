package com.monocept.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class StudentResponseDto 
{
	int id;
	
	@JsonProperty("full_name")
	String fullName;
	
	int age;
	
	private StudentProfileRequestDto profile;
}
