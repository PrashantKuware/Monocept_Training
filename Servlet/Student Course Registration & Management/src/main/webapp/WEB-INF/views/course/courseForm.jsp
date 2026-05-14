<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/studentForm.css">

</head>
<body>
	<div class="container">

		<form action="coursechoice" method="post" class="course-form">

			<h2>Welcome to the Courses Portal</h2>

			<div class="option">
				<input type="radio" id="option1" name="courseOption" value="register"> 
				<label for="option1"> Register Course </label>
			</div>

			<div class="option">

				<input type="radio" id="option2" name="courseOption" value="viewe">
					<label for="option2"> Get All Courses </label>

			</div>

			<div class="option">
				<input type="radio" id="option3" name="courseOption" value="update"> 
				<label for="option3">Update Course </label>
			</div>

			<div class="option">
				<input type="radio" id="option4" name="courseOption" value="delete"> 
				<label for="option4"> Delete Course </label>
			</div>
			
			 <button type="submit"> Submit </button>
		</form>

	</div>
</body>
</html>