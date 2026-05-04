package com.backend;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/uploadResume")
public class ResumeUploadServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException
    {
        
        String name = req.getParameter("name");

        String email = req.getParameter("email");

        String resume = req.getParameter("resume");

        String skills = req.getParameter("skills");

        
        if(name == null
                || name.trim().length() < 3)
        {
            req.setAttribute( "error", "Name must contain at least 3 characters");

            RequestDispatcher rd = req.getRequestDispatcher("/resumeForm.jsp");

            rd.forward(req, resp);

            return;
        }


        
        if(skills == null || skills.trim().isEmpty())
        {
            req.setAttribute("error", "Please Enter At Least One Skill");

            RequestDispatcher rd = req.getRequestDispatcher( "/resumeForm.jsp");

            rd.forward(req, resp);

            return;
        }

        List<String> skillList = Arrays.asList(skills.split(","));

       
        req.setAttribute("name", name);

        req.setAttribute("email", email);

        req.setAttribute("resume", resume);

        req.setAttribute("skills", skillList);

        
        RequestDispatcher rd = req.getRequestDispatcher( "/showResume.jsp");

        rd.forward(req, resp);
    }
}