package com.monocept.demo.DTO;

import com.monocept.demo.entity.Student;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class StudentRequestDTO 
{
	private String stdName;
	private int stdAge;
	String stdDepartment;
	
//	public StudentRequestDTO(String stdName, int stdAge, String stdDepartment) {
//		super();
//		this.stdName = stdName;
//		this.stdAge = stdAge;
//		this.stdDepartment = stdDepartment;
//	}
//
//	public StudentRequestDTO(String stdName, int stdAge) {
//		this.stdName = stdName;
//		this.stdAge = stdAge;
//	}
//	
//	public StudentRequestDTO() {
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
//		return "StudentRequestDTO [stdName=" + stdName + ", stdAge=" + stdAge + ", stdDepartment=" + stdDepartment
//				+ "]";
//	}
//
//	public String getStdDepartment() {
//		return stdDepartment;
//	}
//
//	public void setStdDepartment(String stdDepartment) {
//		this.stdDepartment = stdDepartment;
//	}
//	
	
}
