package com.studentcourse.controller.student;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/studentchoice")
public class StudentChoice extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String option  = req.getParameter("studentOption");
		
		 if(option.equals("register"))
	        {
			 RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student/New-student-enter.jsp");
	            rd.forward(req, resp);
	        }

	        else if(option.equals("viewe"))
	        {
	        	resp.sendRedirect("getallatudent");
	        }

	        else if(option.equals("update"))
	        {
	        	RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student/student-edit.jsp");
	            rd.forward(req, resp);
	        }
		 	
	        else if(option.equals("delete"))
	        {
	        	RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student/student-delete.jsp");
	            rd.forward(req, resp);
	        }
		 
	       
	}
}
