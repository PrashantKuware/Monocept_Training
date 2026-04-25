package com.java.assignments.student_management_system.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.assignments.student_management_system.model.Department;
import com.java.assignments.student_management_system.util.DBUtil;
import java.sql.Connection;

public class DepartmentDAO 
{
	public List<Department> getAllDepartments() 
	{

	    List<Department> list = new ArrayList<>();
	    String sqlQuery = "SELECT * FROM department";

	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sqlQuery);
	         ResultSet resultSet = statement.executeQuery())
	    {

	        while (resultSet.next()) 
	        {
	            list.add(new Department(
	                    resultSet.getInt("dept_id"),
	                    resultSet.getString("dept_name")
	            ));
	        }

	    } catch (Exception e) {}

	    return list;
	}
}
