package com.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil 
{
	public static Connection getConnection() throws Exception 
	 {
		 String url = "jdbc:mysql://localhost:3306/servlet";
			String user = "root";
			String password = "root";
		 
	        return DriverManager.getConnection(url, user, password);
	  }
}
