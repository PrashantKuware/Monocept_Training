package com.monocept.demo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.demo.model.Student;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StdImplementation implements StudentDao
{
	private EntityManager entityMgr;
	
	@Autowired
	public StdImplementation(EntityManager entityMgr)
	{
		this.entityMgr=entityMgr;
	}
	
	@Override
	@Transactional
	public void save(Student student) 
	{
		entityMgr.persist(student);
	}
	
	@Override
	public Student findByid(Integer id)
	{
		return entityMgr.find(Student.class, id);
//		return entityMgr.find(Student.class);
	}
	
	public List <Student> findAllStudent()
	{
		TypedQuery<Student> query = entityMgr.createQuery("From student", Student.class);
		return query.getResultList();
	}
	
}
