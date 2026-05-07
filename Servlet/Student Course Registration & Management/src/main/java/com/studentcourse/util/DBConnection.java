package com.studentcourse.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection 
{
	public static void main(String[] args) throws ClassNotFoundException
	{
	String url = "jdbc:mysql://localhost:3306/student_course_db";
	String user = "root";
	String password = "root";
	 
	try(Connection connection = DriverManager.getConnection(url, user, password))
    {
        System.out.println("Connection Successful");
    }
    catch(Exception e) 
	{
        e.printStackTrace();
    }
	
	}
}
