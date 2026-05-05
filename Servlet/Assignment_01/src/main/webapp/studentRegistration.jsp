<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String error = (String) request.getAttribute("error");
    String success = (String) request.getAttribute("success");
%>
<form action="register" method="post">
<h2>Welcome to Student Registration Portal</h2>
<input type='text' name='name' placeholder='Enter your name : '><br/><br/>
<input type='email' name='email' placeholder='Enter your email : '><br/><br/>
<input type="number" name='age' placeholder='Enter your age : '><br/><br/>

<label for="currency">Choose a Course:</label>
<select name="course" >
<option value="select">Select</option>
  <option value="cs">Computer Science</option>
  <option value="ele">Electronics</option>
  <option value="it">Information Technology</option>
  <option value="arch">Architecture</option>
  <option value="ds">Data Science</option>
   <option value="commerce">Commerce</option>
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