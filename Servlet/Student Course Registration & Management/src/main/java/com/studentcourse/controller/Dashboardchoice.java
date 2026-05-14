package com.studentcourse.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/parameter")
public class Dashboardchoice extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String option  = req.getParameter("dashboardparameter");
		
		 if(option == null || option.equals("select"))
	        {
	            req.getSession().setAttribute("selectError", "Please Select Valid Option");
//	            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
//	            rd.forward(req, resp);
	            resp.sendRedirect("dashboard");
	            
	            return;
	        }
		 
		 if(option.equals("student"))
	        {
			 RequestDispatcher rd = req.getRequestDispatcher( "/WEB-INF/views/student/studentForm.jsp");
			 rd.forward(req, resp);
	        }

	        else if(option.equals("course"))
	        {
	        	 RequestDispatcher rd = req.getRequestDispatcher( "/WEB-INF/views/course/courseForm.jsp");
				 rd.forward(req, resp);
	        }

	        else if(option.equals("registration"))
	        {
	        	 RequestDispatcher rd = req.getRequestDispatcher( "/WEB-INF/views/registration/registrationForm.jsp");
				 rd.forward(req, resp);
	        }

	        else
	        {
	        	req.setAttribute("error",  "Invalid Option Selected");
	            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
	            rd.forward(req, resp);
	        }
	}
}
