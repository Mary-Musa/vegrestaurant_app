<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
    <head>
        <title>SignUp form</title>
<link rel="stylesheet"href="CSS/signup.css">
    </head>
    
    <body>
        <h1>WELCOME TO OUR SIGNUP PAGE</h1>
        <form action="<%= request.getContextPath() %>/register" method="post">
            <label for="firstname">FirstName:</label>
            <input type="text" name="firstName"id="name"placeholder="your firstname here"><br><br>

            <label for="lastname">LastName:</label>
            <input type="text" name="lastName"id="name"placeholder="your othername here"><br><br>

            <label for="email">Email Add:</label>
            <input type="email" name="email"id="email"placeholder="your email here"><br><br>

            <label for="location">Location:</label>
            <input type="text" name="location"id="location"placeholder="your physical address here"><br><br>

            <label for="phone">Phone No:</label>
            <input type="number" name="phone"id="phone"placeholder="your phone number "><br><br>

            <label for="password">Password:</label>
            <input type="password" name="password"id="pass"placeholder="your password"><br><br>

            <button type="submit">SIGNUP HERE</button>

        </form>
    </body>
</html>