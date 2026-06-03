package com.monocept.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="students")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int stdId;
	

	@NotBlank(message="Name can not be empty")
	@Size(min=3, max=30, message="name must be between 3 to 30 character")
	@Column(name="student_name", nullable = false, length = 30)
	String stdName;
	
	@Min(value=18, message="Minimum age should be 18")
	@Max(value=60, message="Maximum age shoulg be 60")
	@Column(nullable = false)
	int stdAge;
	
	@NotBlank(message="Department can not be empty")
	@Size(min=3, max=30, message="Department must be between 3 to 30 character")
	String stdDepartment;

	public Student(String stdName, int stdAge, String stdDepartment)
	{
		this.stdName = stdName;
		this.stdAge = stdAge;
		this.stdDepartment = stdDepartment;
	}

//	public Student() {
//	}
//
//	
//
//	@Override
//	public String toString() {
//		return "Student [stdId=" + stdId + ", stsName=" + stdName + ", stdAge=" + stdAge + ", stdDepartment="
//				+ stdDepartment + "]";
//	}
//
//	public int getStdId() {
//		return stdId;
//	}
//
//	public void setStdId(int stdId) {
//		this.stdId = stdId;
//	}
//
//	
//	
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
//	public String getStdDepartment() {
//		return stdDepartment;
//	}
//
//	public void setStdDepartment(String stdDepartment) {
//		this.stdDepartment = stdDepartment;
//	}

	
	
}
