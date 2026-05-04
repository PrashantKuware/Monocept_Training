<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resume Preview</title>
</head>

<body>

<%
    String name = (String) request.getAttribute("name");

    String email = (String) request.getAttribute("email");

    String resume = (String) request.getAttribute("resume");

    List<String> skills = (List<String>) request.getAttribute("skills");
%>

<h2>Resume Preview</h2>

<h3>Name : <%= name %></h3>

<h3>Email : <%= email %></h3>

<h3>Resume Summary :</h3>

<p>
    <%= resume %>
</p>

<h3>Skills :</h3>

<ul>

<%
    for(String skill : skills)
    {
%>

<li>
    <%= skill.trim() %>
</li>

<%
    }
%>

</ul>

</body>
</html>