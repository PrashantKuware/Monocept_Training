package com.studentcourse.controller.course;

import java.io.IOException;
import java.sql.Connection;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.dao.StudentDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updatecourse")
public class UpdateCourseServlet extends HttpServlet
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
			String courseName = req.getParameter("courseName").trim().toUpperCase();
			String duration = req.getParameter("duration").trim().toUpperCase();
			String fees = req.getParameter("fees");
			String trainerName = req.getParameter("trainerName").trim().toUpperCase();
			

			// *************************Checking course, duration, fees, trainer should not be null or empty *********************
			if(	courseName==null || courseName.trim().isEmpty()
					|| trainerName == null || trainerName.trim().isEmpty()
					|| duration == null || duration.trim().isEmpty()
					|| fees == null || fees.trim().isEmpty())
			{
				req.setAttribute("error", "Invalid input");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/course/course-edit.jsp");
				rd.forward(req, resp);
				return;
			}
			
			
			int tempDuration = 0;
			int tempFees = 0;
			try
			{
				tempDuration = Integer.parseInt(duration);
				tempFees = Integer.parseInt(fees);
			}
			catch(NumberFormatException e)
			{
				 req.setAttribute("error", "Duration and fees must be numeric");
			            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/course/course-edit.jsp");
			            rd.forward(req, resp);
			            return;
			}
			
			// *************************Checking duration *********************
			
			if(tempDuration < 0 || tempDuration > 60)
			{
				 req.setAttribute("error", "Duration should not be less then 0 or greater than 60 months ");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/course/course-edit.jsp");
				rd.forward(req, resp);
				return;
				
			}
			
			// *************************Checking fees *********************
			if(tempFees < 0 )
			{
				 req.setAttribute("error", "Fees should not be less then 0 ");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/course/course-edit.jsp");
				rd.forward(req, resp);
				return;
				
			}
			
			
			// ************************* insert updated data *********************
			
			int count = 0;
			try 
			{
				count = coursedao.UpdateCourse(courseName, tempDuration, tempFees, trainerName);
			} 
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}
			{

				if (count > 0)
				{
					req.setAttribute("success", "Course data updated Successfully");
					RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/course/course-edit.jsp");
					rd.forward(req, resp);
					return;
				}
				else 
				{
					req.setAttribute("error", "There is some error in updating course data");
					RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/course/course-edit.jsp");
					rd.forward(req, resp);
					return;
				}
			}
			
	    }
}
