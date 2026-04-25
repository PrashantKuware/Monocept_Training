package com.java.assignments.student_management_system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBUtil 
{
	 public static Connection getConnection() throws Exception 
	 {
		 String url = "jdbc:mysql://localhost:3306/STUDENT_MANAGEMENT_SYSTEM";
			String user = "root";
			String password = "root";
		 
	        return DriverManager.getConnection(url, user, password);
	  }
	
}
