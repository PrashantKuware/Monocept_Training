package com.backend;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Student extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String nameGet = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		if (email.equals("alpha@gmail.com") && password.equals("alpha123")) {
			HttpSession session = req.getSession();
			session.setAttribute("nameSet", nameGet);

			req.setAttribute("success", "Student successfully login");
			RequestDispatcher rd = req.getRequestDispatcher("/studentProfile.jsp");
			rd.forward(req, resp);
			System.out.println(session.getId());
			return;
		} else {
			req.setAttribute("error", "EmailId or password doesn't match");
			RequestDispatcher rd = req.getRequestDispatcher("/student.jsp");
			rd.forward(req, resp);
			return;
		}
	}
}
