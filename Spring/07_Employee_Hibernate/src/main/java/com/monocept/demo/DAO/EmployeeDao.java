package com.monocept.demo.DAO;
import com.monocept.demo.model.Employee;

public interface EmployeeDao 
{
	public void empSave(Employee employee);
	public void updateEmp(Employee employee);
	public Employee findbyid(int id);
	public void deletEmp(int id);
}
