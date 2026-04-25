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
	
	public boolean addBranch(String name, int deptId) {

	    String sqlQuery = "INSERT INTO branch(branch_name, dept_id) VALUES (?, ?)";

	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

	        statement.setString(1, name);
	        statement.setInt(2, deptId);

	        return statement.executeUpdate() > 0;

	    } catch (Exception e) {
	        return false;
	    }
	}

	public List<Branch> getAllBranches() {

	    List<Branch> list = new ArrayList<>();
	    String sqlQuery = "SELECT branch_id, distinct(branch_name) FROM branch";

	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sqlQuery);
	         ResultSet resultSet = statement.executeQuery()) {

	        while (resultSet.next()) {
	            list.add(new Branch(
	                    resultSet.getInt("branch_id"),
	                    resultSet.getString("branch_name"),
	                    resultSet.getInt("dept_id")));
	        }

	    } catch (Exception e) {}

	    return list;
	}
	
}
