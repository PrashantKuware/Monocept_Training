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

@WebServlet("/delete")
public class DeleteStudent extends HttpServlet 
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
		
		
		// *************************Checking name, Email *********************
		if(name==null || name.trim().isEmpty())
		{
			req.setAttribute("error", "Invalid Name");
			RequestDispatcher rd = req.getRequestDispatcher("/deleteStudent.jsp");
			rd.forward(req, resp);
			return;
		}
		
	
		
		// ************************* delete new student *********************
		Student student = null;
		try {
			student = query.checkStudentAvailability(name);
		} catch (Exception e)
		{
			
			e.printStackTrace();
		}

        if (student == null) 
        {

			req.setAttribute("error", "Student data is not available");
			RequestDispatcher rd = req.getRequestDispatcher("/deleteStudent.jsp");
			rd.forward(req, resp);
			return;
        	
        }
        else 
        {
        	 try {
				query.deleteStudentRecord(name);
			 } catch (Exception e) 
        	 {
				e.printStackTrace();
			 }
         	req.setAttribute("success", "Student deleted Successfully");
 			RequestDispatcher rd = req.getRequestDispatcher("/deleteStudent.jsp");
 			rd.forward(req, resp);
 			return;
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
