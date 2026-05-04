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

@WebServlet("/weather")
public class Weather extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String city = req.getParameter("city");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if(city == null || !city.equalsIgnoreCase("Delhi"))
		{
			
			out.print("<h3 style='color:red'>Invalid city or no value provided</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/weather.html");
			rd.include(req, resp);
			return;
		}
		else 
		{
			req.setAttribute("city", "Delhi");
			req.setAttribute("Temperature", 45);
			req.setAttribute("Humidity", 27);
			
			RequestDispatcher rd = req.getRequestDispatcher("/showCity.jsp");
			rd.forward(req, resp);
		}
		
	}
}
