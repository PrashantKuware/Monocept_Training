package com.monocept.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.demo.entity.Student;
import com.monocept.demo.exception.StudentNotFoundException;
import com.monocept.demo.repo.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentController 
{
	private StudentRepository repository;
	
	@Autowired
	public StudentController(StudentRepository repository) {
		this.repository = repository;
	}


	@PostMapping("/create")
	public Student saveStudent(@RequestBody Student student)
	{
		return repository.save(student);
	}
	
	@PostMapping("/multipleCreate")
	public List<Student> createMultipleStudent (@RequestBody List<Student> student)
	{
		return repository.saveAll(student);
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getStudentById(@PathVariable int id )
	{
		Optional<Student> foundStd = repository.findById(id);
		return foundStd;
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student updaStudent)
	{
		Student existingStudent = repository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
		existingStudent.setStdName(updaStudent.getStdName());
		existingStudent.setStdAge(updaStudent.getStdAge());
		
		return repository.save(existingStudent);
	}
}
