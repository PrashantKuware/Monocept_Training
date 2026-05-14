package com.backend;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/click")
public class LoginServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
                          throws ServletException, IOException
    {
        String username = req.getParameter("username");

        String password = req.getParameter("password");

        String remember =
                req.getParameter("remember");

        if(remember != null)
        {
            Cookie cookie =
                    new Cookie("username", username);

            cookie.setMaxAge(15);

            resp.addCookie(cookie);
        }
        else
        {
            Cookie cookie =
                    new Cookie("username", "");

            cookie.setMaxAge(0);

            resp.addCookie(cookie);
        }

        resp.sendRedirect("login.jsp");
    }
}