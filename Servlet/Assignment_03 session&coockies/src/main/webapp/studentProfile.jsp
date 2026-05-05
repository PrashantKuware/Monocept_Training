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
	String success = (String) request.getAttribute("success");
	String name = (String) session.getAttribute("nameSet");
%>
<h3> Welcome to the profile page : <%= name %></h3>

<%
    if(success != null)
    {
%>

<h3 style="color:green"><%= success %></h3>

<%
    }
%>
</body>
</html>