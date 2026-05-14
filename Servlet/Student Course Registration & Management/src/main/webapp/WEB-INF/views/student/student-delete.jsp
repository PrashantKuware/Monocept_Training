<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/studentDelete.css">

</head>
<body>

<%
	String error = (String) request.getAttribute("error");
    String success = (String) request.getAttribute("success");
%>

	<form action="delete" method="post">
	<h3>Delete Student</h3>
		Name  <input type="text" name='name' placeholder="Enter your name"> <br/><br/>

 	<button type="submit">Submit</button>
 	
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