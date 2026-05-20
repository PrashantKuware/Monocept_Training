<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Registration</title>

<link rel="stylesheet"
href="<%= request.getContextPath() %>/css/studentRegister.css?v=<%= System.currentTimeMillis() %>">

</head>

<body>

<%
    String error = (String) request.getAttribute("error");
    String success = (String) request.getAttribute("success");
%>

<!-- Top Buttons -->

<div class="top-buttons">

    <a href="home" class="home-btn">
        Home
    </a>

    <a href="logout" class="logout-btn">
        Logout
    </a>

</div>

<!-- Form -->

<form action="courseregister" method="post">

    <h3>Enter New Course</h3>

    <label>Course Name</label>

    <input type="text"
           name="courseName"
           placeholder="Enter course name">

    <label>Duration</label>

    <input type="text"
           name="duration"
           placeholder="Enter in months">

    <label>Fees</label>

    <input type="number"
           name="fees"
           placeholder="Enter fees">

    <label>Trainer Name</label>

    <input type="text"
           name="trainerName"
           placeholder="Enter trainer name">

    <button type="submit">
        Submit
    </button>

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

<!-- Success Message -->

<%
if(success != null)
{
%>

    <h3 class="success-message">
        <%= success %>
    </h3>

<%
}
%>

</form>

</body>
</html>