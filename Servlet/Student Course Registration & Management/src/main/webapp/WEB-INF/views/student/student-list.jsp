<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>

<%@ page import="com.studentcourse.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/studentList.css">

</head>
<body>
	<%
    	List<Student> students = (List<Student>) request.getAttribute("students");
	%>

<h2>Student Details</h2>

<table border="1" cellpadding="10">

<tr>

    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Age</th>
    <th>City</th>

</tr>

<%
    for(Student s : students)
    {
%>

<tr>

    <td><%= s.getName() %></td>

    <td><%= s.getEmail() %></td>

    <td><%= s.getPhone() %></td>

    <td><%= s.getAge() %></td>

    <td><%= s.getCity() %></td>

</tr>

<%
    }
%>

</table>
</body>
</html>