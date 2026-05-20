<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/studentDelete.css?v=<%= System.currentTimeMillis() %>">

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

	<form action="deletecourse" method="post">
	<h3>Delete Course</h3>
		Course  <input type="text" name='coursename' placeholder="Enter Course"> <br/><br/>

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