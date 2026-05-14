package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.model.Student;
import com.studentcourse.util.DBConnection;

public class StudentDAO 
{
	public List<Student> getAllStudent() throws Exception
	{
		String sqlQuery = "select * from students";
	    List<Student> students = new ArrayList<>();

	    try(Connection connection = DBConnection.getConnection();
		         PreparedStatement statement = connection.prepareStatement(sqlQuery);
		         ResultSet resultSet = statement.executeQuery())
	    {

	        while(resultSet.next())
	        {
	            Student student = new Student(
	            		resultSet.getInt("student_id"),
	            		resultSet.getString("student_name"),
	            		resultSet.getString("email"),
	            		resultSet.getString("phone"),
	            		resultSet.getInt("age"),
	            		resultSet.getString("city")
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

		public int inserNewStudent(String name, String email, String phone, int age, String city) throws Exception 
		{
			String sqlQuery2 = "insert into students (student_name, email, phone, age, city) values (?,?,?,?,?)";
			int count = 0;
			try(Connection connection = DBConnection.getConnection();
	        PreparedStatement statement2 = connection.prepareStatement(sqlQuery2))
			{

				statement2.setString(1, name);
				statement2.setString(2, email);
				statement2.setString(3, phone);
				statement2.setInt(4, age);
				statement2.setString(5, city);

				count = statement2.executeUpdate();

			} 
			catch (SQLException e) 
			{
				System.out.println(e.getMessage());
			}
			return count;
		}

		// 3. Update the name of a student using their name.

		public int UpdateStudent( String name, String email, int age, String phone, String city) throws Exception 
		{
			String sqlQuery8 = "update students set age = ?, email=?, phone=?, city=? where student_name = ?";
			int count = 0;
			try (Connection connection = DBConnection.getConnection();
					PreparedStatement statement8 = connection.prepareStatement(sqlQuery8)) 
			{
				statement8.setInt(1, age);
				statement8.setString(2, email);
				statement8.setString(3, phone);
				statement8.setString(4, city);
				statement8.setString(5, name);

				count=statement8.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}

		// 4. Delete a student record using their id.

		public int deleteStudentRecord(String name) throws Exception 
		{
			String sqlQuery10 = "delete from students where student_name=?";
			int count = 0;
			try (Connection connection = DBConnection.getConnection();
					PreparedStatement statement10 = connection.prepareStatement(sqlQuery10)) 
			{
				statement10.setString(1, name);
				count=statement10.executeUpdate();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return count;
		}
		
		// 4. check student is available or not.

			public Student checkStudentAvailability(String name) throws Exception 
			{
				String sqlQuery10 = "select * from students where student_name=?";
				
				try (Connection connection = DBConnection.getConnection();
						PreparedStatement statement = connection.prepareStatement(sqlQuery10)) 
				{
					statement.setString(1, name);
					ResultSet resultSet = statement.executeQuery();

		            if (resultSet.next()) 
		            {
		                return new Student(
		                		resultSet.getInt("student_id"),
			            		resultSet.getString("student_name"),
			            		resultSet.getString("email"),
			            		resultSet.getString("phone"),
			            		resultSet.getInt("age"),
			            		resultSet.getString("city"));
		            } 
				}
		            catch (SQLException e) 
		            {
		            	e.printStackTrace();
		            }
				return null;
				}	

}
