package com.studentcourse.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.studentcourse.dao.AdminDAO;
import com.studentcourse.model.Admin;

import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginPageServlet extends HttpServlet
{
	AdminDAO admindao = new AdminDAO();
	
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
		String usrName = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		
		Admin admin = admindao.loginAdmin(usrName,password);
		
		if(admin != null)
		{
			HttpSession session = req.getSession();
			session.setAttribute("userName", usrName);
			
			if(remember != null)
			{
				Cookie cookie = new Cookie("userName", usrName);
				cookie.setMaxAge(500);
				resp.addCookie(cookie);
			}
			else
			{
				Cookie cookie = new Cookie("userName", "");
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
			 resp.sendRedirect("dashboard");
//			RequestDispatcher rd = req.getRequestDispatcher("dashboard");
//
//            rd.forward(req, resp);
		}
		 else
	        {
			 req.setAttribute("error", "Username or Password is incorrect");
			 RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			 rd.forward(req, resp);
	         
	        }
	}
	
}
