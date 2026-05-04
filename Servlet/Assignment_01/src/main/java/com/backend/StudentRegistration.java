package com.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class StudentRegistration extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String age = req.getParameter("age");
		String course = req.getParameter("course");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		if(name == null || name.trim().isEmpty() 
				|| email == null || email.trim().isEmpty()
				|| age == null || age.trim().isEmpty()
				|| course == null || course.trim().isEmpty() || course.equals("select"))
		{
//			out.print("<h3 style='color:red'>Invalid input </h3>");
			 req.setAttribute("error", "Invalid input");
			RequestDispatcher rd = req.getRequestDispatcher("/studentRegistration.jsp");
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
//			 out.print("<h3 style='color:red'>Age must be numeric</h3>");
			 req.setAttribute("error", "Age must be numeric");
		            RequestDispatcher rd = req.getRequestDispatcher("/studentRegistration.jsp");
		            rd.forward(req, resp);
		            return;
		}
		
		if(tempAge < 18)
		{
//			out.print("<h3 style='color:red'>Age should not be less then 18 </h3>");
			 req.setAttribute("error", "Age should not be less then 18 ");
			RequestDispatcher rd = req.getRequestDispatcher("/studentRegistration.jsp");
			rd.forward(req, resp);
			return;
			
		}
		
		
			resp.setContentType("text/html");
//			out.println("<h2 style='color:green'>Student register successfully</h2>");
			 req.setAttribute("success", "Student register successfully ");
        	RequestDispatcher rd = req.getRequestDispatcher("/studentRegistration.jsp");
        	rd.forward(req, resp);
		
	}
}
