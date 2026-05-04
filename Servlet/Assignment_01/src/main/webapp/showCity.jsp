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
	String city = (String) request.getAttribute("city");
	Integer temp = (Integer) request.getAttribute("Temperature");
	Integer humidity = (Integer) request.getAttribute("Humidity");
%>
<h3>Welcome to Weather Service</h3>
<h3 style='color:green'>city Name : <%= city %></h3>
<h3 style='color:green'>Temperature : <%= temp %></h3>
<h3 style='color:green'>humidity : <%= humidity %></h3>
</body>
</html>