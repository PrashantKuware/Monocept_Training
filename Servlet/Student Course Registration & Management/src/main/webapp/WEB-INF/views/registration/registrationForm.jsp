<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/studentForm.css?v=<%= System.currentTimeMillis() %>">

</head>
<body>
<%
	
	
	String error = (String) request.getAttribute("error");
%>

<div class="top-buttons">

    <a href="home" class="home-btn">
        Home
    </a>

    <a href="logout" class="logout-btn">
        Logout
    </a>

</div>

	<div class="container">

		<form action="registrationchoice" method="post" class="course-form">

			<h2>Welcome to the Student-Courses Registration</h2>

			<div class="option">
				<input type="radio" id="option1" name="registrationOption" value="register"> 
				<label for="option1"> Register Student In Course </label>
			</div>

			<div class="option">

				<input type="radio" id="option2" name="registrationOption" value="viewe">
					<label for="option2"> Get All Registrations </label>

			</div>

			<div class="option">
				<input type="radio" id="option3" name="registrationOption" value="update"> 
				<label for="option3">Update Registration </label>
			</div>

			<div class="option">
				<input type="radio" id="option4" name="registrationOption" value="delete"> 
				<label for="option4"> Delete Registration </label>
			</div>
			
			 <button type="submit"> Submit </button>
		</form>


	</div>
	<!-- Error Message -->
 <%
if(error != null)
{
%>

<h3 class="error-message" style="color:red"> <%= error %></h3>

<%
}
%>
</body>
</html>