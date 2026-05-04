package com.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/submit")
public class GetExample extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		System.out.println("Name :"+name);
		System.out.println("Email :"+email);
		System.out.println("Password :"+password);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Name : "+ name);
		out.println("Email : "+ email);
		out.println("Password :"+password);
	}
}
