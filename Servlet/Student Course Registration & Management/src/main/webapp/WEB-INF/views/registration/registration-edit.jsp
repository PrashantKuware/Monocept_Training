<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.studentcourse.model.Registration" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Update Registration Status</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/registrationEdit.css">

</head>

<body>

<%
List<Registration> registrations = (List<Registration>) request.getAttribute("registrations");
%>

<div class="container">

<form action="updateregistration"
      method="post">

    <h2>Update Registration</h2>

    <label>Select Registration</label>

    <select name="registrationId" required>

        <option value="">
            Select Registration
        </option>

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

    <br><br>

    <label>Select Status</label>

    <select name="status" required>

        <option value=""> Select Status </option>

        <option value="Active"> Active </option>

        <option value="Completed"> Completed </option>

        <option value="Cancelled"> Cancelled </option>

    </select>

    <br><br>

    <button type="submit">  Update Status </button>

</form>

</div>

</body>
</html>