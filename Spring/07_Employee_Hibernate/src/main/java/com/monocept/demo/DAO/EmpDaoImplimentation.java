package com.monocept.demo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.demo.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class EmpDaoImplimentation implements EmployeeDao
{
	private EntityManager manager;
	
	@Autowired
	public EmpDaoImplimentation(EntityManager manager)
	{
		this.manager=manager;
	}

	@Override
	@Transactional
	public void empSave(Employee employee) 
	{
		manager.persist(employee);
	}

	@Override
	@Transactional
	public void updateEmp(Employee employee) {
		manager.merge(employee);
	}

	@Override
	public Employee findbyid(int id) {
		return manager.find(Employee.class, id);
	}

	@Override
	@Transactional
	public void deletEmp(int id) 
	{
		Employee foundEmp=manager.find( Employee.class, id);
		manager.remove(foundEmp);
	}
}
