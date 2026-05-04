package com.backend;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if(email.equals("alpha@gmail.com") && password.equals("alpha123"))
		{
			RequestDispatcher rd =  req.getRequestDispatcher("/profile.jsp");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd =  req.getRequestDispatcher("/requestDispatcher.html");
			rd.forward(req, resp);
		}
	}
}
