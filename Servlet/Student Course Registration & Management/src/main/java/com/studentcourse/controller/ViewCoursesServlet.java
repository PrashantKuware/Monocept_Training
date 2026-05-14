package com.studentcourse.controller;

import java.io.IOException;
import java.util.List;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.model.Course;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewCoursesServlet extends HttpServlet
{
	
		CourseDAO coursedao = new CourseDAO();
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
			
			
			List<Course> courseList = null;
			try {
				courseList = coursedao.getAllCourse();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			

			req.setAttribute("courses",  courseList);


			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");

			rd.forward(req, resp);
		}
		

}
