<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resume Submission</title>
</head>

<body>

<%
    String error = (String) request.getAttribute("error");       
%>

<h2>Job Portal - Resume Submission</h2>

<form action="uploadResume" method="post">

    Name: <input type="text"  name="name">
     <br><br>
   
    Email:  <input type="email" name="email">
  	 <br><br>
   
    Resume Summary:
    <br>

    <textarea name="resume"  rows="6" cols="40"></textarea>
        <br><br>     
              

    Skills (comma separated): <input type="text" name="skills">
     <br><br>
           

    <button type="submit">  Submit Resume </button>
       
</form>

<%
    if(error != null)
    {
%>

 	<h3 style="color:red"><%= error %></h3>

<%
    }
%>

</body>
</html>