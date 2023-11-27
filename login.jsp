<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>login form</title>
<link rel="stylesheet"href="CSS/login.css">
    </head>
    <body>

       <h2>WELCOME TO OUR LOGIN PAGE </h2>
        <form action="<%= request.getContextPath() %>/login" method="post">
           

            <label for="email">Email Add:</label>
            <input type="email" name="email"id="email"placeholder="your email here"><br><br>

            <label for ="password">Password:</label>
            <input type="password" name="password"id="pass"placeholder="your password"><br><br>

            <button type="submit">LOGIN HERE</button>

        </form>

    </body>
</html>