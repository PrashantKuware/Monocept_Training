package com.monocept.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.monocept.demo.DTO.PageResponseDTO;
import com.monocept.demo.DTO.StudentRequestDTO;
import com.monocept.demo.DTO.StudentResponseDTO;
import com.monocept.demo.entity.Student;

public interface StudentService 
{
	public StudentResponseDTO saveStudent(StudentRequestDTO resquestDTO);

	public List<StudentResponseDTO> saveAllStudent(List<StudentRequestDTO> studentRequest);

	public Optional<Student> findById(int id);

	public Student updateStudent(int id, Student updaStudent);

	public Student updatePartially(int id, Map<String, Object> updatedData);

	public void deleteStudent(int id);

	public PageResponseDTO<StudentResponseDTO> getAllStudentWithPagination (int pageNumber, int pageSize);

}
