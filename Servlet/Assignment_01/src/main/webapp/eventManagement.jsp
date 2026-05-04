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
String success = (String) request.getAttribute("successful");
 %>
 
<form action="event" method="post">
<h3>Welcome to Event Management system</h3>
	Name : <input type="text" name="name" placeholder="Enter name">
	<br/><br/>
	Email : <input type="email" name="email" placeholder="Enter email">
	<br/><br/>
	Number of Seats : <input type="number" name="seats" placeholder="Enter seats">
	<br/><br/>
	Date : <input type="date" name="date" placeholder="Enter date">
	<br/><br/>
	<label for="currency">Choose a Department:</label>
<select name="department" >
<option value="select">Select</option>
  <option value="technical">Technical</option>
  <option value="workshop">Workshop</option>
  <option value="networking">Networking</option>
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