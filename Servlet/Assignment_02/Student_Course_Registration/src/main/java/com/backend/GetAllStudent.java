package com.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/getallatudent")
public class GetAllStudent extends HttpServlet
{
	Connection connection;
	CrudQuries query = new CrudQuries(connection);
	
	@Override
	public void init() throws ServletException
	{
		try
		{
			 Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println( e.getMessage());
		} 
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		CrudQuries query = new CrudQuries(connection);
		
		
		List<Student> studentList = null;
		try {
			studentList = query.getAllStudent();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		req.setAttribute("students", studentList);

		RequestDispatcher rd = req.getRequestDispatcher("/studentTable.jsp");

		rd.forward(req, resp);
	}
	
	@Override
	public void destroy()
	{
		try
		{
			if(connection != null)
			{
				connection.close();
				 System.out.println("Connection Closed");
			}
		}
		catch(SQLException e)
		{
			System.out.println( e.getMessage());
		}
	}
}
