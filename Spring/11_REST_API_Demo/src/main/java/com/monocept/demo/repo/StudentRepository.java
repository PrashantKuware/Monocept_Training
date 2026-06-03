package com.monocept.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

	
}
