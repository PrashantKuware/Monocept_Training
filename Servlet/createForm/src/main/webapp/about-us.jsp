<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String myname = (String) session.getAttribute("name");
%>
<h3 style='color:green'>Welcome at About page : <%= myname %></h3>
<a href="home.jsp">Home</a>
<a href="profile.jsp">profile</a>
</body>
</html>