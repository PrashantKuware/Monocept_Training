package com.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServlet;

public class CrudQuries extends HttpServlet {
	private Connection connection;

	public CrudQuries(Connection connection) {
		this.connection = connection;
	}

// 1. Print Student Table

	public List<Student> getAllStudent()
	{
	    List<Student> students = new ArrayList<>();

	    try
	    {
	        PreparedStatement statement = connection.prepareStatement("select * from student");

	        ResultSet result = statement.executeQuery();

	        while(result.next())
	        {
	            Student student = new Student(
	                            result.getString("name"),
	                            result.getString("email"),
	                            result.getInt("age"),
	                            result.getString("course"),
	                            result.getString("batch")
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

	public int inserNewStudent(String name, String email, int tempAge, String course, String batch) {
		String sqlQuery2 = "insert into student values (?,?,?,?,?)";
		int count = 0;
		try {
			PreparedStatement statement2 = connection.prepareStatement(sqlQuery2);

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

	public void studentUpdateUsingId(String course, String batch, String name) {
		String sqlQuery8 = "update student set course = ?, batch=? where name = ?";

		try (PreparedStatement statement8 = connection.prepareStatement(sqlQuery8)) {
			statement8.setString(1, course);
			statement8.setString(2, batch);
			statement8.setString(3, name);

			statement8.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 4. Delete a student record using their id.

	public void deleteStudentRecord(String name) {
		String sqlQuery10 = "delete from student where studentid=?";

		try (PreparedStatement statement10 = connection.prepareStatement(sqlQuery10)) {
			statement10.setString(1, name);
			statement10.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
