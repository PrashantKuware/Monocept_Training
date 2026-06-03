package com.monocept.demo.service;

import java.awt.print.Pageable;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.monocept.demo.dto.PageResponseDto;
import com.monocept.demo.dto.StudentProfileRequestDto;
import com.monocept.demo.dto.StudentRequestDto;
import com.monocept.demo.dto.StudentResponseDto;
import com.monocept.demo.exception.ResourceNotFoundException;
import com.monocept.demo.model.Student;
import com.monocept.demo.model.StudentProfile;
import com.monocept.demo.repository.StudentProfileRepository;
import com.monocept.demo.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 

public class StudentServiceImpl implements StudentService
{
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private StudentProfileRepository profileRepository;
	
	@Override
	public StudentResponseDto createStudent(StudentRequestDto requestDto) 
	{
		String email = requestDto.getProfile().getEmail();
		if(profileRepository.existsByEmail(email))
		{
			throw new IllegalArgumentException("Profile already eist with email : "+email);
		}
		
		Student student = mapper.map(requestDto, Student.class);
		StudentProfile profile = mapper.map(requestDto.getProfile(), StudentProfile.class);
		student.setProfile(profile);
		profile.setStudent(student);
		Student savedStudent = repository.save(student);
		return mapper.map(savedStudent, StudentResponseDto.class);
		
	}

	@Override
	public List<StudentResponseDto> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResponseDto<StudentResponseDto> getAllStudentsWithPagination(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentResponseDto getStudentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentResponseDto updateStudent(Long id, StudentRequestDto requestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
