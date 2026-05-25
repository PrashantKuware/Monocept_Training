package com.monocept.demo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="new_employee")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Name can not be empty")
	@Size(min=3, max=30, message="name must be between 3 to 30 character")
	@Column(name="employee_name", nullable = false, length = 30)
	private String name;
	
	@Min(value=18, message="Minimum age should be 18")
	@Max(value=60, message="Maximum age shoulg be 60")
	@Column(nullable = false)
	private int age;
	
	@NotBlank(message="city can not be empty")
	@Pattern(regexp = "^[A-Z]{3}$", message = "City code must be 3 uppercase letters")
	@Column(name="city_code", nullable = false, length = 3)
	private String cityCode;
	
	@DecimalMin(value="1000.00", message="salary must be greater then 1000")
	@Column(nullable = false)
	private BigDecimal salary;

	public Employee(
	        String name,
	        int age,
	        String cityCode,
	        BigDecimal salary)
	{
		this.name = name;
		this.age = age;
		this.cityCode = cityCode;
		this.salary = salary;
	}

	public Employee() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", cityCode=" + cityCode + ", salary="
				+ salary + "]";
	}
	
	
}
