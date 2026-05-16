<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.studentcourse.model.Student" %>
<%@ page import="com.studentcourse.model.Course" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/registration.css">

</head>
<body>
	<%
	List<Student> students = (List<Student>) request.getAttribute("students");

	List<Course> courses = (List<Course>) request.getAttribute("courses");
	
	String error = (String) request.getAttribute("error");
    String success = (String) request.getAttribute("success");
%>

	<form action="addregistration" method="post">
	 <h2>Student Course Registration</h2>
		
		 <label>Select Student</label>

    <select name="studentId" required>

        <option value=""> Select Student</option>

        <%
		if(students != null)
		{
		    for(Student s : students)
		    {
		%>

        <option value="<%= s.getId() %>">

            <%= s.getName() %>

        </option>

        <%
        
		    }
        }
        %>

    </select>

    <br><br>
		

 	<!-- Course Dropdown -->

    <label>Select Course</label>

    <select name="courseId" required>

        <option value=""> Select Course</option>

        <%
        if(courses != null)
        {
        for(Course c : courses)
        {
        %>

        <option value="<%= c.getCourseId() %>">

            <%= c.getCourseName() %>

        </option>

        <%
        }
        }
        %>

    </select>

    <br><br>

    <!-- Date -->

    <label>Registration Date</label>

    <input type="date" name="registrationDate" required>

    <br><br>

    <!-- Status -->

    <label>Status</label>

    <select name="status" required>

        <option value=""> Select Status</option>

        <option value="Active">Active</option>

        <option value="Completed">Completed</option>

        <option value="Cancelled">Cancelled</option>

    </select>

    <br><br>

    <button type="submit">
        Register
    </button>
 	
 	<!-- Error Message -->
 <%
if(error != null)
{
%>

<h3 class="error-message"> <%= error %></h3>

<%
}
%>

<!-- Success Message -->
<%
if(success != null)
{
%>

<h3 class="success-message"> <%= success %></h3>

<%
}
%>
	</form>
</body>
</html>