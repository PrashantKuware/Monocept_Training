package com.studentcourse.controller.student;

import java.io.IOException;
import java.sql.Connection;

import com.studentcourse.dao.StudentDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet
{
	
	StudentDAO studentdao = new StudentDAO();
		
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
			String name = req.getParameter("name").trim().toUpperCase();
			String email = req.getParameter("email").trim().toLowerCase();
			String age = req.getParameter("age");
			String phone = req.getParameter("phone");
			String city = req.getParameter("city").trim().toUpperCase();
			
			
			// *************************Checking name, Email *********************
			if(	name==null || name.trim().isEmpty()
					|| email == null || email.trim().isEmpty()
					|| phone == null || phone.trim().isEmpty()
					|| city == null || city.trim().isEmpty())
			{
				req.setAttribute("error", "Invalid input");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student/student-edit.jsp");
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
				 req.setAttribute("error", "Age must be numeric");
			            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student/student-edit.jsp");
			            rd.forward(req, resp);
			            return;
			}
			
			// *************************Checking age *********************
			
			if(tempAge < 18)
			{
				 req.setAttribute("error", "Age should not be less then 18 ");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student/student-edit.jsp");
				rd.forward(req, resp);
				return;
				
			}
			
			// *************************Checking phone *********************
			
			if(!phone.matches("^(\\+91[-\\s]?)?[6-9][0-9]{9}$"))
			{
				req.setAttribute("error", "Invalid Phone No");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student/New-student-enter.jsp");
				rd.forward(req, resp);
				return;
				
			}
			
			// ************************* insert updated data *********************
			
			int count = 0;
			try 
			{
				count = studentdao.UpdateStudent(name, email, tempAge, phone, city);
			} 
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}
			{
				if (count > 0) {
					req.setAttribute("success", "Student data updated Successfully");
					RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student/student-edit.jsp");
					rd.forward(req, resp);
					return;
				} else 
				{
					req.setAttribute("error", "There is some error in updating Student");
					RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student/student-edit.jsp");
					rd.forward(req, resp);
					return;
				}
			}
			
	    }
}
