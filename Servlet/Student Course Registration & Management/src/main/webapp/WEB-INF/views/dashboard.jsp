<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/dashboard.css">
</head>
<body>

<%
String selectError = (String) session.getAttribute("selectError");

String error = (String) request.getAttribute("error");

String username = (String) session.getAttribute("userName");

Integer student = (Integer) request.getAttribute("studentCount");

Integer courses = (Integer) request.getAttribute("coursescount");

Integer registration = (Integer) request.getAttribute("registration");
%>

<div class="container">

    <h2>
        Welcome to Student Portal :
        <span><%= username %></span>
    </h2>

    <div class="dashboard-card">

        <div class="card">
            <h3 >Total Students</h3>
            <p><%= student %></p>
        </div>

        <div class="card">
            <h3>Total Courses</h3>
            <p><%= courses %></p>
        </div>

        <div class="card">
            <h3>Total Registrations</h3>
            <p><%= registration %></p>
        </div>

    </div>

    <form action="parameter" method="post" class="course-form">

        <label for="course">
            Choose an Option
        </label>

        <select name="dashboardparameter" id="course">

            <option value="select"> Select </option>

            <option value="student">Open Student Section</option>

            <option value="course">Open Course Section</option>

            <option value="registration">Student-Course Registration Section</option>

        </select>

        <button type="submit"> Submit </button>

    </form>

    <a href="logout" class="logout-btn"> Logout </a>
<!-- Error Message -->
 <%
    if(error != null)
    {
%>

<h3 style="color:red"><%= error %></h3>

<%
    }
%>
<!-- Select option Error Message -->
 <%
    if(selectError != null)
    {
%>

<h3 style="color:red"><%= selectError %></h3>

<%
session.removeAttribute("selectError");
    }
%>
</div>

</body>
</html>