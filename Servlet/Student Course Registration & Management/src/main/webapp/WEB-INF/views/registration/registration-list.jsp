<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.studentcourse.model.Registration" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Registration List</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/studentList.css?v=<%= System.currentTimeMillis() %>">

</head>

<body>

<%
List<Registration> registrations =
(List<Registration>) request.getAttribute("registrations");
%>

<div class="container">

    <h2>Student Course Registration List</h2>

    <table>

        <tr>

            <th>Registration ID</th>

            <th>Student Name</th>

            <th>Course Name</th>

            <th>Registration Date</th>

            <th>Status</th>

        </tr>

<%
if(registrations != null)
{
    for(Registration r : registrations)
    {
%>

        <tr>

            <td><%= r.getRegistrationId() %></td>

            <td><%= r.getStudentName() %></td>

            <td><%= r.getCourseName() %></td>

            <td><%= r.getRegistrationDate() %></td>

            <td><%= r.getStatus() %></td>

        </tr>

<%
    }
}
%>

    </table>


<div class="top-buttons">

    <a href="home" class="home-btn">
        Home
    </a>

    <a href="logout" class="logout-btn">
        Logout
    </a>

</div>

</div>

</body>
</html>