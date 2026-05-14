package com.studentcourse.controller;

import java.io.IOException;
import java.util.List;

import com.studentcourse.dao.AdminDAO;
import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewStudentsServlet extends HttpServlet
{
	StudentDAO studentdao = new StudentDAO();
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
		
		
		List<Student> studentList = null;
		try 
		{
			studentList = studentdao.getAllStudent();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		req.setAttribute("students",  studentList);


		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");

		rd.forward(req, resp);
	}
	
}
