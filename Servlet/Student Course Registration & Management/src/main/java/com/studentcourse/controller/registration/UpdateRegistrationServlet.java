package com.studentcourse.controller.registration;

import java.io.IOException;
import java.sql.Connection;

import com.studentcourse.dao.RegistrationDAO;
import com.studentcourse.dao.StudentDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateregistration")
public class UpdateRegistrationServlet extends HttpServlet
{
	
	RegistrationDAO registrationdao = new RegistrationDAO();
		
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
			try
	        {
	            int registrationId = Integer.parseInt(req.getParameter("registrationId"));
	            String status = req.getParameter("status");
	            registrationdao.updateRegistrationStatus(registrationId, status);
	            resp.sendRedirect("getallregistration");
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
			
	    }
}
