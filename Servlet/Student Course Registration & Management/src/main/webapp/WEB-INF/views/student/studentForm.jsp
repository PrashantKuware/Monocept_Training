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
<div class="top-buttons">

    <a href="home" class="home-btn" >
        Home
    </a>

    <a href="logout" class="logout-btn" >
        Logout
    </a>

</div>
	<div class="container">

		<form action="studentchoice" method="post" class="course-form">

			<h2>Welcome to the Student Portal</h2>

			<div class="option">
				<input type="radio" id="option1" name="studentOption" value="register"> 
				<label for="option1"> Register Student </label>
			</div>

			<div class="option">

				<input type="radio" id="option2" name="studentOption" value="viewe">
					<label for="option2"> Get All Students </label>

			</div>

			<div class="option">
				<input type="radio" id="option3" name="studentOption" value="update"> 
				<label for="option3">Update Student </label>
			</div>

			<div class="option">
				<input type="radio" id="option4" name="studentOption" value="delete"> 
				<label for="option4"> Delete Student </label>
			</div>
			
			 <button type="submit"> Submit </button>
		</form>

	</div>
</body>
</html>