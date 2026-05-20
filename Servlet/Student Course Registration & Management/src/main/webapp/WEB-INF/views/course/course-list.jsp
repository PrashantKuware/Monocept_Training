<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>

<%@ page import="com.studentcourse.model.Course" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/studentList.css?v=<%= System.currentTimeMillis() %>">

</head>
<body>
	<%
    	List<Course> courses = (List<Course>) request.getAttribute("courses");
	%>

<h2>Course Details</h2>

<table border="1" cellpadding="10">

<tr>

    <th>Course Name</th>
    <th>Duration (in months)</th>
    <th>Fees</th>
    <th>Trainer Name</th>

</tr>

<%
    for(Course s : courses)
    {
%>

<tr>

    <td><%= s.getCourseName() %></td>

    <td><%= s.getDuration() %></td>

    <td><%= s.getFees() %></td>

    <td><%= s.getTrainer() %></td>


</tr>

<%
    }
%>

</table>
<!-- Top Buttons -->

<div class="top-buttons">

    <a href="home" class="home-btn">
        Home
    </a>

    <a href="logout" class="logout-btn">
        Logout
    </a>

</div>

</body>
</html>