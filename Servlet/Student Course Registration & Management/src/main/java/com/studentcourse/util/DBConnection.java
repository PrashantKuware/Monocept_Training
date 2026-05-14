package com.studentcourse.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection 
{
	public static Connection getConnection() throws Exception 
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/student_course_db";
	String user = "root";
	String password = "root";
	 
	return DriverManager.getConnection(url, user, password);
	}
}
