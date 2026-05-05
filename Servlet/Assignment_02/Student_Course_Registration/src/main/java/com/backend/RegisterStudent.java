package com.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

	String url = "jdbc:mysql://localhost:3306/servlet";
	String user = "root";
	String password = "root";
	
	@Override
	public void init() throws ServletException
	{
		try
		{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection(url, user, password);
			 System.out.println("Connection Created");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println( e.getMessage());
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
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
		
		// *************************Operation *********************
		

		CrudQuries query = new CrudQuries(connection);
		
		// *************************Read all student *********************
		
		List<Student> studentList = query.getAllStudent();

		req.setAttribute("students", studentList);

		RequestDispatcher rd = req.getRequestDispatcher("/studentTable.jsp");

		rd.forward(req, resp);
		
		// ************************* insert new student *********************
		
//		int count=query.inserNewStudent(name, email, tempAge, course, batch);
//		{
//			if (count > 0) {
//				req.setAttribute("success", "Student register Successfully");
//				RequestDispatcher rd = req.getRequestDispatcher("/studentForm.jsp");
//				rd.forward(req, resp);
//				return;
//			} else {
//				req.setAttribute("error", "Student is not registered");
//				RequestDispatcher rd = req.getRequestDispatcher("/studentForm.jsp");
//				rd.forward(req, resp);
//				return;
//			}
//		}
		
		// *************************update student student *********************
		
		// *************************delete student *********************
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
