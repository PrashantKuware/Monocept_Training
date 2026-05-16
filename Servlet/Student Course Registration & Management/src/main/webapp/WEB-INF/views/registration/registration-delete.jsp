<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.List" %>
<%@ page import="com.studentcourse.model.Registration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/registrationDelete.css">

</head>
<body>

<%
	List<Registration> registrations = (List<Registration>) request.getAttribute("registrations");
	String error = (String) request.getAttribute("error");
    String success = (String) request.getAttribute("success");
%>

	<form action="deleteregistration" method="post">
	<h3>Delete Registration</h3>
		  <label>Select Registration ID</label>

        <select name="registrationId" required>

            <option value=""> Select Registration ID</option>

<%
if(registrations != null)
{
    for(Registration r : registrations)
    {
%>

            <option value="<%= r.getRegistrationId() %>">

                Registration ID :
                <%= r.getRegistrationId() %>

                -

                <%= r.getStudentName() %>

                (

                <%= r.getCourseName() %>

                )

            </option>

<%
    }
}
%>

        </select>

 	<button type="submit">Submit</button>
 	
 	<!-- Error Message -->
 <%
if(error != null)
{
%>

<h3 class="error-message">
    <%= error %>
</h3>

<%
}
%>

<!-- Success Message -->
<%
if(success != null)
{
%>

<h3 class="success-message">
    <%= success %>
</h3>

<%
}
%>
	</form>
</body>
</html>