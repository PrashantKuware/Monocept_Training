package com.monocept.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.demo.DTO.PageResponseDTO;
import com.monocept.demo.DTO.StudentRequestDTO;
import com.monocept.demo.DTO.StudentResponseDTO;
import com.monocept.demo.entity.Student;
import com.monocept.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController 
{
	
	@Autowired
	private StudentService service;


	@PostMapping("/create")
	public StudentResponseDTO saveStudent(@RequestBody StudentRequestDTO resquestDTO)
	{
		return service.saveStudent(resquestDTO);
	}
	
	@PostMapping("/multipleCreate")
	public List<StudentResponseDTO> createMultipleStudent (@RequestBody List<StudentRequestDTO> multipleStudent)
	{
		return service.saveAllStudent(multipleStudent);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id )
	{
		Student foundStd = service.findById(id).orElse(null);
		if(foundStd != null)
		{
			return ResponseEntity.ok().body(foundStd);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student updaStudent)
	{
		Student updateStudent = service.updateStudent(id, updaStudent);
		if(updateStudent != null)
		{
			return ResponseEntity.ok(updateStudent);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Student> updatePartially(@PathVariable int id, @RequestBody Map<String, Object> updatedData)
	{
		Student partiallyUpdate = service.updatePartially(id, updatedData);
		if(partiallyUpdate != null)
		{
			return ResponseEntity.ok(partiallyUpdate);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id)
	{
		service.deleteStudent(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/page")
	public PageResponseDTO<StudentResponseDTO> getAllStudentWithPagination (@RequestParam (defaultValue = "0") int pageNumber, @RequestParam (defaultValue = "2") int pageSize)
	{
		return service.getAllStudentWithPagination(pageNumber, pageSize);
	}
}
