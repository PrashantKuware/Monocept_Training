package com.backend;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/event")
public class ConferenceBookingServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String seats = req.getParameter("seats");
		String date = req.getParameter("date");
		String dept = req.getParameter("department");
		
		int tempSeat = Integer.parseInt(seats);
		if(tempSeat <= 5)
		{
			req.setAttribute("error", "Seats can not be less then 5");
			RequestDispatcher rd = req.getRequestDispatcher("/eventManagement.jsp");
			rd.forward(req, resp);
			return;
		}
		
		if(dept.equals("select"))
		{
			req.setAttribute("error", "Select Department");
			RequestDispatcher rd = req.getRequestDispatcher("/eventManagement.jsp");
			rd.forward(req, resp);
			return;
		}
		
		req.setAttribute("successful", "Event Management details successfully registered");
		RequestDispatcher rd  = req.getRequestDispatcher("/eventManagement.jsp");
		rd.forward(req, resp);
		return;
	}
}
