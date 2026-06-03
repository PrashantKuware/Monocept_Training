package com.monocept.demo.service;

import java.util.List;

import com.monocept.demo.dto.PageResponseDto;
import com.monocept.demo.dto.StudentRequestDto;
import com.monocept.demo.dto.StudentResponseDto;

public interface StudentService 
{
	StudentResponseDto createStudent(StudentRequestDto requestDto);
	List<StudentResponseDto> getAllStudents(); 
	PageResponseDto<StudentResponseDto> getAllStudentsWithPagination(int pageNumber, int pageSize);
	StudentResponseDto getStudentById(Long id);
	StudentResponseDto updateStudent(Long id, StudentRequestDto requestDto); 
	void deleteStudent(Long id); 
}
