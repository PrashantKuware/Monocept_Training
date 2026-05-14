package com.studentcourse.controller.student;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet
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
		String name = req.getParameter("name");
		
		
		// *************************Checking name, Email *********************
		if(name==null || name.trim().isEmpty())
		{
			req.setAttribute("error", "Invalid Name");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student/student-delete.jsp");
			rd.forward(req, resp);
			return;
		}
		
	
		
		// ************************* delete new student *********************
		Student student = null;
		try {
			student = studentdao.checkStudentAvailability(name);
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		}

        if (student == null) 
        {

			req.setAttribute("error", "Student data is not available");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student/student-delete.jsp");
			rd.forward(req, resp);
			return;
        	
        }
        else 
        {
        	 try {
        		 studentdao.deleteStudentRecord(name);
			 } 
        	 catch (Exception e) 
        	 {
				e.printStackTrace();
			 }
         	req.setAttribute("success", "Student deleted Successfully");
 			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student/student-delete.jsp");
 			rd.forward(req, resp);
 			return;
		}
		
		
    }
}
