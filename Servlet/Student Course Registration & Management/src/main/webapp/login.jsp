<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="index.css">
</head>
<body>
<%
String error = (String) request.getAttribute("error");

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

	 <div class="container">

        <form action="login" method="post">
        <h3>Welcom to Admin Login portal</h3>

        <input type="text"
               name="username"
               placeholder="Enter Username"
               value="<%= savedUsername %>"
               required>

        <input type="password"
               name="password"
               placeholder="Enter Password"
               required>

          <div class="remember-section">

       		 <input type="checkbox" name="remember">

      		 <label>Remember Username</label>

          </div>

        <button type="submit">Login</button>


<%
    if(error != null)
    {
%>

<h3 style="color:red"><%= error %></h3>

<%
    }
%>

    </form>

    </div>
</body>
</html>