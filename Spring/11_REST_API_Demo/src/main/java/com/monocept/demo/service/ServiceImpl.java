package com.monocept.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.monocept.demo.DTO.PageResponseDTO;
import com.monocept.demo.DTO.StudentRequestDTO;
import com.monocept.demo.DTO.StudentResponseDTO;
import com.monocept.demo.entity.Student;
import com.monocept.demo.exception.StudentNotFoundException;
import com.monocept.demo.repo.StudentRepository;

@Service
public class ServiceImpl implements StudentService
{
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private StudentRepository repository;

	public ServiceImpl(ModelMapper mapper, StudentRepository repository) 
	{
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public StudentResponseDTO saveStudent(StudentRequestDTO resquestDTO) 
	{
		Student student = mapper.map(resquestDTO, Student.class);
		Student saveStudent = repository.save(student);
		return mapper.map(saveStudent, StudentResponseDTO.class);
	}
	

	@Override
	public List<StudentResponseDTO> saveAllStudent(List<StudentRequestDTO> studentRequest)
	{
		List<Student> students = studentRequest.stream().map(dto -> mapper.map(dto, Student.class)).toList();
		List<Student> savedStudent = repository.saveAll(students);
		List<StudentResponseDTO> response = savedStudent.stream().map(student -> mapper.map(student, StudentResponseDTO.class)).toList();
		return response;
		
		// wrong code
//		Student student = mapper.map(studentRequest, Student.class);
//		Student saveStudent = repository.saveAll(student);
//		return (List<StudentResponseDTO>) mapper.map(saveStudent, StudentResponseDTO.class);
	}

	@Override
	public Optional<Student> findById(int id) {
		return repository.findById(id);
	}

	@Override
	public Student updateStudent(int id, Student newStudent) {
		Student studentData = repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		
			studentData.setStdName(newStudent.getStdName());
		    studentData.setStdAge(newStudent.getStdAge());
		    studentData.setStdDepartment(newStudent.getStdDepartment());

		    return repository.save(studentData);
		
	}

	@Override
	public Student updatePartially(int id, Map<String, Object> updatedData) {
		
		Student existingStudent = repository.findById(id).orElse(null);
		
		if(updatedData.containsKey("stdName"))
		{
			existingStudent.setStdName((String) updatedData.get("stdName")) ;
		}
		
		if(updatedData.containsKey("stdAge"))
		{
			existingStudent.setStdAge((Integer) updatedData.get("stdAge"));
	
		}
		if(updatedData.containsKey("stdDepartment"))
		{
			existingStudent.setStdDepartment((String) updatedData.get("stdDepartment"));
	
		}
		else
		{
			  throw new StudentNotFoundException(id);
		}
		
		return repository.save(existingStudent);
		
	}

	@Override
	public void deleteStudent(int id) 
	{
		Student existingStudent = repository.findById(id).orElse(null);
		if(existingStudent != null)
		{
			repository.delete(existingStudent);
		}
		else
		{
			  throw new StudentNotFoundException(id);
		}
		
	}
	
	@Override
	public PageResponseDTO<StudentResponseDTO> getAllStudentWithPagination (int pageNumber, int pageSize)
	{
		Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
		Page<Student> studentPage = repository.findAll(pageable);
		List<Student> students = studentPage.getContent();
		List<StudentResponseDTO> studentResponses = new ArrayList<>();
		
		for(Student s : students)
		{
			StudentResponseDTO responseDto = mapper.map(s, StudentResponseDTO.class);
			studentResponses.add(responseDto);
		}
		
		PageResponseDTO<StudentResponseDTO> pageResponseDto = new PageResponseDTO<>();
		
		pageResponseDto.setContent(studentResponses);
		pageResponseDto.setPageNumber(studentPage.getNumber());
		pageResponseDto.setPageSize(studentPage.getSize());
		pageResponseDto.setTotalCount(studentPage.getTotalElements());
		pageResponseDto.setLastPage(studentPage.isLast());
		pageResponseDto.setTotalPages(studentPage.getTotalPages());
		
		return pageResponseDto;
	}
}
