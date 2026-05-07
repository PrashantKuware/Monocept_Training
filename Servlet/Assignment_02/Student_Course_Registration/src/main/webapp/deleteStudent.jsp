<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Insert title here</title>
</head>
<body>

<%
	String error = (String) request.getAttribute("error");
    String success = (String) request.getAttribute("success");
%>

	<form action="delete" method="post">
	<h3>Welcome to Student Portal</h3>
		Name  <input type="text" name='name' placeholder="Enter your name"> <br/><br/>

 	<button type="submit">Submit</button>
 	
 	<!-- Error Message -->
 <%
    if(error != null)
    {
%>

<h3 style="color:red"><%= error %></h3>

<%
    }
%>

<!-- Success Message -->
<%
    if(success != null)
    {
%>

<h3 style="color:green"><%= success %></h3>

<%
    }
%>
	</form>
</body>
</html>