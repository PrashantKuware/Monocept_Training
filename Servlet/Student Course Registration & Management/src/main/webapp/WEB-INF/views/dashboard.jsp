<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Dashboard</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/dashboard.css">

</head>

<body>

<%
String selectError =
(String) session.getAttribute("selectError");

String error =
(String) request.getAttribute("error");

String username =
(String) session.getAttribute("userName");

Integer student =
(Integer) request.getAttribute("studentCount");

Integer courses =
(Integer) request.getAttribute("coursescount");

Integer registration =
(Integer) request.getAttribute("registration");
%>

<div class="container">

    <!-- Heading -->

    <h2>
        Welcome to Student Portal :
        <span><%= username %></span>
    </h2>

    <!-- Dashboard Cards -->

    <div class="dashboard-card">

        <div class="card">

            <h3>Total Students</h3>

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

    <!-- Form -->

   <form action="parameter"
      method="post"
      class="course-form">

    <label for="course">
        Choose an Option
    </label>

    <select name="dashboardparameter"
            id="course">

        <option value="select">Select</option>

        <option value="student">
            Open Student Section
        </option>

        <option value="course">
            Open Course Section
        </option>

        <option value="registration">
            Student-Course Registration Section
        </option>

    </select>

    <button type="submit">
        Submit
    </button>

</form>

    <!-- Logout -->

    <div class="logout-container">

        <a href="logout"
           class="logout-btn">

            Logout

        </a>

    </div>

    <!-- Error Message -->

<%
if(error != null)
{
%>

    <h3 class="error-message">
        <%= error %>
    </h3>

<%
}
%>

<!-- Select Error -->

<%
if(selectError != null)
{
%>

    <h3 class="error-message">
        <%= selectError %>
    </h3>

<%
session.removeAttribute("selectError");
}
%>

</div>

</body>
</html>