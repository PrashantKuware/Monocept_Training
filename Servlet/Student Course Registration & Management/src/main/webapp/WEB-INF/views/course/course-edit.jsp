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

<!-- Top Buttons -->

<div class="top-buttons">

    <a href="home" class="home-btn">
        Home
    </a>

    <a href="logout" class="logout-btn">
        Logout
    </a>

</div>

	<form action="updatecourse" method="post">
	<h3>Update Courses</h3>
		Course Name  <input type="text" name='courseName' placeholder="Enter course name"> <br/><br/>
		Duration  <input type="text" name='duration' placeholder="Enter in months"><br/><br/>
		Fees  <input type="number" name='fees' placeholder="Enter fees"><br/><br/>
		Trainer Name  <input type="text" name='trainerName' placeholder="Enter trainer name"><br/><br/>
		

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