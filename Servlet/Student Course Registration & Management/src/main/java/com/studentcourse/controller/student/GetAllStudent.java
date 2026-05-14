package com.studentcourse.controller.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getallatudent")
public class GetAllStudent extends HttpServlet
{

	StudentDAO studentdao = new StudentDAO();
	
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
		resp.setContentType("text/html");
		
		List<Student> studentList = null;
		try 
		{
			studentList = studentdao.getAllStudent();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		req.setAttribute("students", studentList);
	
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student/student-list.jsp");

		rd.forward(req, resp);
	}
	
	
}
