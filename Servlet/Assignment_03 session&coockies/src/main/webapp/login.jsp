<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="jakarta.servlet.http.Cookie" %>

<%

String savedUsername = "";

Cookie[] cookies = request.getCookies();

if(cookies != null)
{
    for(Cookie cookie : cookies)
    {
        if(cookie.getName().equals("username"))
        {
            savedUsername = cookie.getValue();
        }
    }
}

%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Remember Username</title>

<style>

body{
    font-family: Arial;
    background-color: #f0f2f5;
}

.container{
    width: 350px;
    margin: 100px auto;
    background: white;
    padding: 30px;
    border-radius: 10px;
}

input{
    width: 90%;
    padding: 10px;
    margin: 10px;
}

button{
    padding: 10px 15px;
}

</style>

</head>

<body>

<div class="container">

    <h2>Login Page</h2>

    <form action="click" method="post">

        <input type="text"
               name="username"
               placeholder="Enter Username"
               value="<%= savedUsername %>"
               required>

        <input type="password"
               name="password"
               placeholder="Enter Password"
               required>

        <br>

        <input type="checkbox"
               name="remember">

        Remember Username

        <br><br>

        <button type="submit">
            Login
        </button>

    </form>

    <br>

    <a href="deleteCookie">
        Delete Saved Username
    </a>

</div>

</body>
</html>