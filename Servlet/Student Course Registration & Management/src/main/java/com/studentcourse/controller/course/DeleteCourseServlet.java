package com.studentcourse.controller.course;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Course;
import com.studentcourse.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletecourse")
public class DeleteCourseServlet extends HttpServlet
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String courseName = req.getParameter("coursename");
		
		
		// *************************Checking course name *********************
		if(courseName==null || courseName.trim().isEmpty())
		{
			req.setAttribute("error", "Invalid Course Name");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/course/course-delete.jsp");
			rd.forward(req, resp);
			return;
		}
		
	
		
		// ************************* check availability and delete *********************
		
		Course course = null;
		try 
		{
			course = coursedao.checkCourseAvailability(courseName);
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		}

        if (course == null) 
        {

			req.setAttribute("error", "Course data is not available");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/course/course-delete.jsp");
			rd.forward(req, resp);
			return;
        	
        }
        else 
        {
        	 try {
        		 coursedao.deleteCourseRecord(courseName);
			 } 
        	 catch (Exception e) 
        	 {
				e.printStackTrace();
			 }
         	req.setAttribute("success", "Course deleted Successfully");
 			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/course/course-delete.jsp");
 			rd.forward(req, resp);
 			return;
		}
		
		
    }
}
