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

@WebServlet("/registrationchoice")
public class RegistrationChoice extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		StudentDAO studentdao = new StudentDAO();
	    CourseDAO coursedao = new CourseDAO();
	    RegistrationDAO registrationdao = new RegistrationDAO();

		String option  = req.getParameter("registrationOption");
		
		 // ************************register*********************************
		
		 if(option.equals("register"))
	        {
			 	
			    List<Student> students = null;
				try 
				{
					students = studentdao.getAllStudent();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}

			    List<Course> courses = null;
				try
				{
					courses = coursedao.getAllCourse();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}

			    req.setAttribute("students", students);

			    req.setAttribute("courses", courses);
			    RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/registration/New-registration-enter.jsp");
	            rd.forward(req, resp);
	        }
		 // ************************view********************************* 
		 
	        else if(option.equals("viewe"))
	        {
	        	resp.sendRedirect("getallregistration");
	        }
		 // ************************update*********************************
		 
	        else if(option.equals("update"))
	        {
	        	try
	            {
	                List<Registration> registrations = registrationdao.getAllRegistrations();
	                req.setAttribute("registrations", registrations);
	                RequestDispatcher rd = req.getRequestDispatcher( "/WEB-INF/views/registration/registration-edit.jsp");
	                rd.forward(req, resp);
	            }
	            catch(Exception e)
	            {
	                e.printStackTrace();
	            }
	        }
		 	
		 // ************************delete*********************************
		 
	        else if(option.equals("delete"))
	        {

				try 
				{
					 List<Registration> registrations = registrationdao.getAllRegistrations();
					  req.setAttribute("registrations", registrations);
					  RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/registration/registration-delete.jsp");
			            rd.forward(req, resp);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
	        	
	        }
		 
	       
	}
}
