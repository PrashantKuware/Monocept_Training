package com.studentcourse.controller.registration;

import java.io.IOException;
import java.util.List;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.dao.RegistrationDAO;
import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Course;
import com.studentcourse.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addregistration")
public class AddRegistrationServlet extends HttpServlet
{
	RegistrationDAO registrationDao = new RegistrationDAO();
	 StudentDAO studentdao = new StudentDAO();
	 CourseDAO coursedao = new CourseDAO();
	 
	 @Override
	    protected void doPost(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException
	    {
	        try
	        {
	            int studentId = Integer.parseInt(req.getParameter("studentId"));

	            int courseId = Integer.parseInt( req.getParameter("courseId"));

	            String registrationDate = req.getParameter("registrationDate");

	            String status = req.getParameter("status");

	            boolean exists = registrationDao.checkDuplicateRegistration(studentId, courseId);
	            
	           

			    List<Student> students = null;
				students = studentdao.getAllStudent();
			
			    List<Course> courses = null;
				courses = coursedao.getAllCourse();
			
				req.setAttribute("students", students);
				req.setAttribute("courses", courses);

	            if(exists)
	            {
	                req.setAttribute( "error", "Student already registered");
	                RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/registration/New-registration-enter.jsp");
	                rd.forward(req, resp);
	                return;
	            }

	            registrationDao.addRegistration( studentId, courseId, registrationDate, status);
	            
	            req.setAttribute("students", students);
			    req.setAttribute("courses", courses);
	            req.setAttribute( "success", "Student registered in course successfully ");
                RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/registration/New-registration-enter.jsp");
                rd.forward(req, resp);
                return;
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
}
