package com.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Click")
public class FirstRequestDispatcher extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		resp.setContentType("Text/html");
		
		
		out.println("<h1>I am from include First</h1>");
//		out.flush();
		
		ServletContext context = getServletContext();
		RequestDispatcher rd=context.getRequestDispatcher("/SecondRequestDispatcher");
		rd.include(req, resp);
		
		out.println("<h1>I am from include First</h1>");
		out.close();
	}
}
