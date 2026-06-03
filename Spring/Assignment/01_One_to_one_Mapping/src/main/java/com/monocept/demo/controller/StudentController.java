package com.monocept.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.demo.dto.StudentRequestDto;
import com.monocept.demo.dto.StudentResponseDto;
import com.monocept.demo.model.Student;
import com.monocept.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController 
{
	@Autowired
	private StudentService service;
	
	@PostMapping("/create")
	public StudentResponseDto saveStudent(@RequestBody StudentRequestDto requestDto)
	{
		return service.createStudent(requestDto);
	}
	
	@PostMapping("/createMultiple")
	public Student saveMultipleStudent()
	{
		
	}
	
	@GetMapping("/{id}")
	public Student getStudentById()
	{
		
	}
	
	@GetMapping("/{name}")
	public Student getStudentByName()
	{
		
	}
	
	@PutMapping("/{id}")
	public Student updateStudent()
	{
		
	}
	
	@PatchMapping("/{id}")
	public Student updatePartially()
	{
		
	}
	
	@DeleteMapping("/{id}")
	public Student deleteStudent()
	{
		
	}
	
	@GetMapping("/page")
	public Student getAllStudentWithPagination()
	{
		
	}
}
