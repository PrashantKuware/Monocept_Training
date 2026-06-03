package com.monocept.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.demo.model.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer>  
{
	boolean existsByEmail(String email);
	boolean existsByEmailAndIdNot(String email, int id);
}
