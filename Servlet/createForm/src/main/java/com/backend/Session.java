package com.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/session")
public class Session extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		
		if(email.equals("abc@gmail.com") && password.equals("abc123"))
		{
//			req.setAttribute("name", "Prashant K.");
			
			HttpSession session = req.getSession();
			session.setAttribute("name", "Prashant K.");
			
			RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			rd.forward(req, resp);
		}
		else
		{
			resp.setContentType("Text/html");
			out.print("<h3 style='color:red'>Email id and Password didn't matched</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/session.html");
			rd.include(req, resp);
		}
	}
}
