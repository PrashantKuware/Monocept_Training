package com.java.assignments.student_management_system.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.assignments.student_management_system.model.Branch;
import com.java.assignments.student_management_system.util.DBUtil;
import java.sql.Connection;

public class BranchDAO 
{
	public List<Branch> getBranchesByDept(int deptId) 
	{

	    List<Branch> list = new ArrayList<>();
	    String sqlQuery = "SELECT * FROM branch WHERE dept_id=?";

	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sqlQuery)) 
	    {

	        statement.setInt(1, deptId);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) 
	        {
	            list.add(new Branch(
	                    resultSet.getInt("branch_id"),
	                    resultSet.getString("branch_name"),
	                    resultSet.getInt("dept_id")
	            ));
	        }

	    } catch (Exception e) {}

	    return list;
	}
	
}
