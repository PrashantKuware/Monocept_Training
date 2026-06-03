package com.monocept.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class StudentProfileResponseDto 
{
	int id;
	
	String email;
	
	long phone;
	
	String city;
	
	
}
