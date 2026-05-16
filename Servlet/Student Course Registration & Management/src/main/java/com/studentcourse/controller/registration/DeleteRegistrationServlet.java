package com.studentcourse.controller.registration;

import java.io.IOException;
import java.util.List;

import com.studentcourse.dao.RegistrationDAO;
import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Registration;
import com.studentcourse.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteregistration")
public class DeleteRegistrationServlet extends HttpServlet
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

            int count = registrationdao.deleteRegistration(registrationId);

            if(count > 0)
            {
                req.setAttribute("success", "Registration Deleted Successfully");
            }
            else
            {
                req.setAttribute("error", "Registration Not Found");
            }

            List<Registration> registrations = registrationdao.getAllRegistrations();

            req.setAttribute("registrations", registrations);

            RequestDispatcher rd = req.getRequestDispatcher( "/WEB-INF/views/registration/registration-delete.jsp");

            rd.forward(req, resp);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		
    }
}
