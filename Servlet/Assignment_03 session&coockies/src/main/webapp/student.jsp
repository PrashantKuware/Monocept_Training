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
%>
<form action="login" method="post"> 
	Name : <input type="text" name="name" ><br/><br/>
	Email : <input type="email" name="email" ><br/><br/>
	Password : <input type="password" name="password" ><br/><br/>
	
	<button type="submit" value="submit">Submit</button>
	
	<!-- Error Message -->
 <%
    if(error != null)
    {
%>

<h3 style="color:red"><%= error %></h3>

<%
    }
%>
</form>
</body>
</html>