package com.monocept.demo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.monocept.demo.model.Student;

import jakarta.persistence.EntityManager;

public interface StudentDao 
{
	
	
	public void save(Student student);
	
	Student findByid(Integer id);
	
	List<Student> findAllStudent();
	
	
}
