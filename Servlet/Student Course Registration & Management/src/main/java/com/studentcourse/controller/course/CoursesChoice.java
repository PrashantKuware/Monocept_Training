package com.studentcourse.controller.course;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coursechoice")
public class CoursesChoice extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String option  = req.getParameter("courseOption");
		
		 if(option.equals("register"))
	        {
			 RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/course/New-course-enter.jsp");
	            rd.forward(req, resp);
	        }

	        else if(option.equals("viewe"))
	        {
	        	resp.sendRedirect("getallcourses");
	        }

	        else if(option.equals("update"))
	        {
	        	RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/course/course-edit.jsp");
	            rd.forward(req, resp);
	        }
		 	
	        else if(option.equals("delete"))
	        {
	        	RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/course/course-delete.jsp");
	            rd.forward(req, resp);
	        }
		 
	       
	}
}
