package com.java.student_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {

	public static void main(String[] args) 
	{
		String url = "jdbc:mysql://localhost:3306/STUDENT_INFORMATION_SYSTEM";
		String user = "root";
		String password = "root";
		 
		 try (Connection connection = DriverManager.getConnection(url, user, password))
		 {
			 AssociatedQueries query = new AssociatedQueries(connection);
//			 query.getAllStudent();
//			 query.inserNewStudent();
			 query.insertStudentUsingBatchProcessing();
		 }
		 catch(SQLException e)
		 {
			System.out.println( e.getMessage());
		 }
		
//		System.out.println("Connection created");
		
		
	}
	
}
