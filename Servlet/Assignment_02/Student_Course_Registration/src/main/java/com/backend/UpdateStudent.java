package com.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateStudent extends HttpServlet
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
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String age = req.getParameter("age");
		
		
		// *************************Checking name, Email *********************
		if(name==null || name.trim().isEmpty()|| email == null || email.trim().isEmpty())
		{
			req.setAttribute("error", "Invalid email or Name");
			RequestDispatcher rd = req.getRequestDispatcher("/updateStudent.jsp");
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
		            RequestDispatcher rd = req.getRequestDispatcher("/updateStudent.jsp");
		            rd.forward(req, resp);
		            return;
		}
		
		// *************************Checking age *********************
		
		if(tempAge < 18)
		{
			 req.setAttribute("error", "Age should not be less then 18 ");
			RequestDispatcher rd = req.getRequestDispatcher("/updateStudent.jsp");
			rd.forward(req, resp);
			return;
			
		}
		
		
		
		// ************************* insert new student *********************
		
		int count = 0;
		try 
		{
			count = query.UpdateStudent(name, email, tempAge);
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		{
			if (count > 0) {
				req.setAttribute("success", "Student data updated Successfully");
				RequestDispatcher rd = req.getRequestDispatcher("/updateStudent.jsp");
				rd.forward(req, resp);
				return;
			} else 
			{
				req.setAttribute("error", "There is some error in updating Student");
				RequestDispatcher rd = req.getRequestDispatcher("/updateStudent.jsp");
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
