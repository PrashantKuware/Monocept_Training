package com.studentcourse.controller.registration;

import java.io.IOException;
import java.util.List;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.dao.RegistrationDAO;
import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Course;
import com.studentcourse.model.Registration;
import com.studentcourse.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getallregistration")
public class GetAllRegistration extends HttpServlet
{

	RegistrationDAO registrationDao = new RegistrationDAO();
	
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
		
		try 
		{
			 List<Registration> registrationList = registrationDao.getAllRegistrations();

	            req.setAttribute("registrations", registrationList);


            RequestDispatcher rd = req.getRequestDispatcher( "/WEB-INF/views/registration/registration-list.jsp");
            rd.forward(req, resp);
		} 
		catch (Exception e) 
		{
			 req.setAttribute("error", "Unable to fetch registrations");

	            RequestDispatcher rd = req.getRequestDispatcher( "/WEB-INF/views/registration/registrationForm.jsp");

	            rd.forward(req, resp);
		}

		
	}
	
	
}
