package com.monocept.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class StudentResponseDTO 
{
	private String stdName;
	private int stdAge;
	
//	public StudentResponseDTO() 
//	{
//	}
//
//	public StudentResponseDTO(String stdName, int stdAge)
//	{
//		this.stdName = stdName;
//		this.stdAge = stdAge;
//	}
//
//	public String getStdName() {
//		return stdName;
//	}
//
//	public void setStdName(String stdName) {
//		this.stdName = stdName;
//	}
//
//	public int getStdAge() {
//		return stdAge;
//	}
//
//	public void setStdAge(int stdAge) {
//		this.stdAge = stdAge;
//	}
//
//	@Override
//	public String toString() {
//		return "StudentResponseDTO [stdName=" + stdName + ", stdAge=" + stdAge + "]";
//	}
	
	
}
