package com.studentcourse.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter implements Filter
{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  throws IOException, ServletException
	{
		 HttpServletRequest req = (HttpServletRequest) request;

	        HttpServletResponse resp = (HttpServletResponse) response;
	        
	        String path =
	                req.getRequestURI();

	        
	        if(path.endsWith("login.jsp") || path.endsWith("login") || path.contains("css"))
	        {
	            chain.doFilter(request, response);
	            return;
	        }
	        
	        HttpSession session = req.getSession(false);
	        
	        if(session == null || session.getAttribute("userName")==null)
	        {
	        	resp.sendRedirect(req.getContextPath()+"/login.jsp");
	        	System.out.println(path);
	        	return;
	        }
	        chain.doFilter(req, resp);
	}
}
