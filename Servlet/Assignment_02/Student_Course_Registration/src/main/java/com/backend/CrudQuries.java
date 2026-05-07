package com.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.backend.DBUtil;

import jakarta.servlet.http.HttpServlet;

public class CrudQuries extends HttpServlet 
{
	private Connection connection;

	public CrudQuries(Connection connection) {
		this.connection = connection;
	}

// 1. Print Student Table

	public List<Student> getAllStudent() throws Exception
	{
		String sqlQuery = "select * from student";
	    List<Student> students = new ArrayList<>();

	    try(Connection connection = DBUtil.getConnection();
		         PreparedStatement statement = connection.prepareStatement(sqlQuery);
		         ResultSet resultSet = statement.executeQuery())
	    {

	        while(resultSet.next())
	        {
	            Student student = new Student(
	            		resultSet.getString("name"),
	            		resultSet.getString("email"),
	            		resultSet.getInt("age"),
	            		resultSet.getString("course"),
	            		resultSet.getString("batch")
	                    );

	            students.add(student);
	        }
	    }
	    catch(SQLException e)
	    {
	        System.out.println( e.getMessage());
	    }

	    return students;
	}
	
// 2. Insert a new student record into the student table.

	public int inserNewStudent(String name, String email, int tempAge, String course, String batch) throws Exception 
	{
		String sqlQuery2 = "insert into student values (?,?,?,?,?)";
		int count = 0;
		try(Connection connection = DBUtil.getConnection();
        PreparedStatement statement2 = connection.prepareStatement(sqlQuery2))
		{

			statement2.setString(1, name);
			statement2.setString(2, email);
			statement2.setInt(3, tempAge);
			statement2.setString(4, course);
			statement2.setString(5, batch);

			count = statement2.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return count;
	}

	// 3. Update the name of a student using their id.

	public int UpdateStudent( String name, String email, int age) throws Exception 
	{
		String sqlQuery8 = "update student set age = ?, email=? where name = ?";
		int count = 0;
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement8 = connection.prepareStatement(sqlQuery8)) 
		{
			statement8.setInt(1, age);
			statement8.setString(2, email);
			statement8.setString(3, name);

			count=statement8.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// 4. Delete a student record using their id.

	public int deleteStudentRecord(String name) throws Exception 
	{
		String sqlQuery10 = "delete from student where name=?";
		int count = 0;
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement10 = connection.prepareStatement(sqlQuery10)) 
		{
			statement10.setString(1, name);
			count=statement10.executeUpdate();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return count;
	}
	
	// 4. check student is available or not.

		public Student checkStudentAvailability(String name) throws Exception 
		{
			String sqlQuery10 = "select * from student where name=?";
			
			try (Connection connection = DBUtil.getConnection();
					PreparedStatement statement = connection.prepareStatement(sqlQuery10)) 
			{
				statement.setString(1, name);
				ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) 
	            {
	                return new Student(
	                        resultSet.getString("name"),
	                        resultSet.getString("email"),
	                        resultSet.getInt("age"),
	                        resultSet.getString("course"),
	                        resultSet.getString("batch"));
	            } 
			}
	            catch (SQLException e) 
	            {
	            	e.printStackTrace();
	            }
			return null;
			}	

}
