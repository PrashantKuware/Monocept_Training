package com.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/course")
public class Courses extends HttpServlet
{
	HashMap<String, List<String>> hm = new HashMap<>();
	{
		hm.put("cs",  Arrays.asList("B.Sc","B.Tech","B.E","M.Tech"));
		hm.put("ele",  Arrays.asList("B.Sc","B.Tech","B.E"));
		hm.put("it",  Arrays.asList("B.Sc","B.Tech"));
		hm.put("arch",  Arrays.asList("B.Sc","B.Tech","B.E"));
		hm.put("ds",  Arrays.asList("B.Sc","B.Tech"));
		hm.put("commerce",  Arrays.asList("B.Com", "M.Com"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String dept = req.getParameter("department");
		 resp.setContentType("text/html");

	        PrintWriter out = resp.getWriter();
	        
	        if(dept == null ||  dept.trim().isEmpty())
		{
				out.print("<h3 style='color:red'>Invalid input </h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/course.html");
				rd.include(req, resp);
				return;
		}
	        
	        if(!hm.containsKey(dept))
	        {
	        	  out.println("<h2 style='color:red'>Course is not available</h2>");
	        	  RequestDispatcher rd = req.getRequestDispatcher("/course.html");
				  rd.include(req, resp);
	              return;
	        }
		
	        List<String> courses = hm.get(dept);
	        {
	        	resp.setContentType("text/html");
	        	RequestDispatcher rd = req.getRequestDispatcher("/course.html");
	        	rd.include(req, resp);
	        	out.println("<h2 style='color:green'>For the selected department, Your courses are : </h2>");
	        	out.println("<ul>");

	        	for(String course : courses)
	        	{
	        	    out.println("<li>" + course + "</li>");
	        	}

	        	out.println("</ul>");
	        }
	}
}
