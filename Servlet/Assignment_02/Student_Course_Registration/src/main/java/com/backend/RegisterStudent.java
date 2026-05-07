package com.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterStudent extends HttpServlet
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String age = req.getParameter("age");
		String course = req.getParameter("course");
		String batch = req.getParameter("batch");
		
		// *************************Checking name, Email *********************
		if(name==null || name.trim().isEmpty()|| email == null || email.trim().isEmpty())
		{
			req.setAttribute("error", "Invalid email or Name");
			RequestDispatcher rd = req.getRequestDispatcher("/studentForm.jsp");
			rd.forward(req, resp);
			return;
		}
		
		int tempAge = 0;
		try
		{
			 tempAge = Integer.parseInt(age);
		}
		catch(NumberFormatException e)
		{
			 req.setAttribute("error", "Age must be numeric");
		            RequestDispatcher rd = req.getRequestDispatcher("/studentForm.jsp");
		            rd.forward(req, resp);
		            return;
		}
		
		// *************************Checking age *********************
		
		if(tempAge < 18)
		{
			 req.setAttribute("error", "Age should not be less then 18 ");
			RequestDispatcher rd = req.getRequestDispatcher("/studentForm.jsp");
			rd.forward(req, resp);
			return;
			
		}
		
		// *************************Checking course, batch *********************
		
		if(course == null || course.trim().isEmpty() || course.equals("select")
				||batch == null || batch.trim().isEmpty() || batch.equals("select"))
		{
			req.setAttribute("error", "Course or Batch should be choosen");
			RequestDispatcher rd = req.getRequestDispatcher("/studentForm.jsp");
			rd.forward(req, resp);
			return;
		}
		
		
		
		// ************************* insert new student *********************
		
		int count = 0;
		try 
		{
			count = query.inserNewStudent(name, email, tempAge, course, batch);
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		{
			if (count > 0) {
				req.setAttribute("success", "Student register Successfully");
				RequestDispatcher rd = req.getRequestDispatcher("/studentForm.jsp");
				rd.forward(req, resp);
				return;
			} else {
				req.setAttribute("error", "Student is not registered");
				RequestDispatcher rd = req.getRequestDispatcher("/studentForm.jsp");
				rd.forward(req, resp);
				return;
			}
		}
		
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
