<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="index.css">
<title>Insert title here</title>
</head>
<body>
	 <div class="container">

        <form>

            <h2>Welcome to the Student Portal</h2>

            <div class="option">
                <input type="radio" id="option1" name="studentOption">
                <label for="option1">
                    <a href="studentForm.jsp">Register Student</a>
                </label>
            </div>

	            <div class="option">
	
	    <input type="radio"
	           id="option2"
	           name="studentOption"
	           onclick="window.location.href='getallatudent'">
	
	    <label for="option2">
	        Get All Students
	    </label>
	
				</div>

            <div class="option">
                <input type="radio" id="option3" name="studentOption">
                <label for="option3">
                    <a href="updateStudent.jsp">Update Student</a>
                </label>
            </div>

            <div class="option">
                <input type="radio" id="option4" name="studentOption">
                <label for="option4">
                    <a href="deleteStudent.jsp">Delete Student</a>
                </label>
            </div>
            
        </form>

    </div>
</body>
</html>