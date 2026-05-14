package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.model.Registration;
import com.studentcourse.util.DBConnection;

public class RegistrationDAO 
{
	public List<Registration> getAllRegistrations() throws Exception
	{
		String sqlQuery = "select * from registrations";
	    List<Registration> registrations = new ArrayList<>();

	    try(Connection connection = DBConnection.getConnection();
		         PreparedStatement statement = connection.prepareStatement(sqlQuery);
		         ResultSet resultSet = statement.executeQuery())
	    {

	        while(resultSet.next())
	        {
	        	Registration registration = new Registration(
	            		resultSet.getInt("registration_id"),
	            		resultSet.getInt("student_id"),
	            		resultSet.getInt("course_id"),
	            		resultSet.getString("registration_date"),
	            		resultSet.getString("status")
	                    );

	        	registrations.add(registration);
	        }
	    }
	    catch(SQLException e)
	    {
	        System.out.println( e.getMessage());
	    }

	    return registrations;
	}
}
