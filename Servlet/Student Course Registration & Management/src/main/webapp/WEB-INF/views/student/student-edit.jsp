<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/studentEdit.css?v=<%= System.currentTimeMillis() %>">

</head>

<body>
	<%
	String error = (String) request.getAttribute("error");
    String success = (String) request.getAttribute("success");
%>

<div class="top-buttons">

    <a href="home" class="home-btn">
        Home
    </a>

    <a href="logout" class="logout-btn">
        Logout
    </a>

</div>

	<form action="update" method="post">
	<h3>Update Student</h3>
		Name  <input type="text" name='name' placeholder="Enter your name"> <br/><br/>
		Email  <input type="email" name='email' placeholder="Enter your email"><br/><br/>
		Phone  <input type="tel" name='phone' placeholder="Enter your phone number"><br/><br/>
		Age  <input type="number" name='age' placeholder="Enter your age"><br/><br/>
		City  <input type="text" name='city' placeholder="Enter your city"><br/><br/>
		

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