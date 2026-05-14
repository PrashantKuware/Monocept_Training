package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.dao.RegistrationDAO;
import com.studentcourse.dao.StudentDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class DashboardServlet
        extends HttpServlet
{
    StudentDAO studentdao = new StudentDAO();

    CourseDAO coursedao = new CourseDAO();

    RegistrationDAO registrationdao = new RegistrationDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            int studentCount = studentdao.getAllStudent().size();

            int courseCount = coursedao.getAllCourse().size();

            int registrationCount = registrationdao.getAllRegistrations().size();
            

            req.setAttribute("studentCount", studentCount);

            req.setAttribute("coursescount", courseCount);

            req.setAttribute("registration", registrationCount);

            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");

            rd.forward(req, resp);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}