<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
 </head>
<body>

<%
	String error = (String) request.getAttribute("error");
    String success = (String) request.getAttribute("success");
%>

	<form action="register" method="post">
	<h3>Welcome to Student Registration System</h3>
		Name  <input type="text" name='name' placeholder="Enter your name"> <br/><br/>
		Email  <input type="email" name='email' placeholder="Enter your email"><br/><br/>
		Age  <input type="number" name='age' placeholder="Enter your age"><br/><br/>
		<label for="currency">Choose a Course</label>
	<select name="course" >
	<option value="select">Select</option>
	  <option value="Java Full Stack">Java Full Stack</option>
	  <option value="Python Full Stack">Python Full Stack </option>
	  <option value="MERN Stack">MERN Stack</option>
	  <option value="Data Analytics">Data Analytics</option>
	  <option value="Data Science">Data Science</option>
	   <option value="commerce">Commerce</option>
	</select><br/><br/>
	
	<label for="currency">Choose a Batch</label>
	<select name="batch" >
	<option value="select">Select</option>
	  <option value="6AM-to-9AM">6AM-to-9AM </option>
	  <option value="9AM-to-12AM">9AM-to-12AM </option>
	  <option value="1PM-to-3PM">1PM-to-3PM</option>
	  <option value="4PM-to-7PM">4PM-to-7PM</option>
	  <option value="6PM-to-9PM">6PM-to-9PM</option>
	</select><br/><br/>

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