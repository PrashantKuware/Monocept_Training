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
	    String sqlQuery =
	            "SELECT " +
	            "r.registration_id, " +
	            "r.student_id, " +
	            "r.course_id, " +
	            "s.student_name, " +
	            "c.course_name, " +
	            "r.registration_date, " +
	            "r.status " +
	            "FROM registrations r " +
	            "JOIN students s " +
	            "ON r.student_id = s.student_id " +
	            "JOIN courses c " +
	            "ON r.course_id = c.course_id";

	    List<Registration> registrations = new ArrayList<>();

	    try(Connection connection = DBConnection.getConnection();
	        PreparedStatement statement =
	                connection.prepareStatement(sqlQuery);
	        ResultSet resultSet = statement.executeQuery())
	    {

	    	while(resultSet.next())
	    	{
	    	    Registration registration = new Registration(

	    	            resultSet.getInt("registration_id"),

	    	            resultSet.getInt("student_id"),

	    	            resultSet.getInt("course_id"),

	    	            resultSet.getString("registration_date"),

	    	            resultSet.getString("student_name"),

	    	            resultSet.getString("course_name"),

	    	            resultSet.getString("status")
	    	    );

	    	    registrations.add(registration);
	    	}
	    }
	    catch(SQLException e)
	    {
	        e.printStackTrace();
	    }

	    return registrations;
	}

	public boolean checkDuplicateRegistration(int studentId, int courseId) throws Exception
	{
		String query = "select * from registrations " +
			    "where student_id=? " +
			    "and course_id=? " +
			    "and status='Active'";

			    try(Connection connection = DBConnection.getConnection();
			    		PreparedStatement statement =connection.prepareStatement(query))
			    {
			        statement.setInt(1, studentId);

			        statement.setInt(2, courseId);

			        ResultSet resultSet = statement.executeQuery();

			        return resultSet.next();
			    }
	}

	public int addRegistration(int studentId, int courseId, String registrationDate, String status) throws Exception
	{
		 String sql = "insert into registrations " +
				    "(student_id,course_id," +
				    "registration_date,status) " +
				    "values (?,?,?,?)";

				    try(Connection connection = DBConnection.getConnection();
				    		PreparedStatement statement = connection.prepareStatement(sql))
				    {
				        statement.setInt(1, studentId);

				        statement.setInt(2, courseId);

				        statement.setString(3, registrationDate);

				        statement.setString(4, status);

				        return statement.executeUpdate();
				    }
		
	}

	public int deleteRegistration(int registrationId) throws Exception
	{
	    String sqlQuery = "DELETE FROM registrations " + "WHERE registration_id = ?";

	    int result = 0;

	    try(Connection connection = DBConnection.getConnection();
	    		PreparedStatement statement = connection.prepareStatement(sqlQuery))
	    {
	        statement.setInt(1, registrationId);

	        result = statement.executeUpdate();
	    }
	    catch(SQLException e)
	    {
	        e.printStackTrace();
	    }

	    return result;
	}
	
	public int updateRegistrationStatus( int registrationId, String status) throws Exception
	{
	    String sqlQuery =
	            "UPDATE registrations " +
	            "SET status = ? " +
	            "WHERE registration_id = ?";

	    int result = 0;

	    try(Connection connection = DBConnection.getConnection();

	        PreparedStatement statement = connection.prepareStatement(sqlQuery))
	    {
	        statement.setString(1, status);
	        statement.setInt(2, registrationId);
	        result = statement.executeUpdate();
	    }
	    catch(SQLException e)
	    {
	        e.printStackTrace();
	    }

	    return result;
	}
}
