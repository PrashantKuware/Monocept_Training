package com.monocept.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> 
{
	
}
