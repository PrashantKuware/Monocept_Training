package com.backend;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clickMe")
public class SendRedirect extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
//		String search = req.getParameter("keyword");
		resp.sendRedirect("https://www.gsmarena.com");
		return;
//		resp.sendRedirect(req.getContextPath()+"/clickMe");
//		resp.sendRedirect("https://www.gsmarena.com/search?q=");
	}
}
