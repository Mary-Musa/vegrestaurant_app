<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User Form</title>
</head>
<body>
    <form action="update" method="post">
        <label>Email:</label>
        <input type="text" name="email" value=""><br>

        <label>First Name:</label>
        <input type="text" name="firstName" value=""><br>

        <label>Last Name:</label>
        <input type="text" name="lastName" value=""><br>

        <label>Location:</label>
        <input type="text" name="location" value=""><br>

        <label>Phone:</label>
        <input type="text" name="phone" value=""><br>

        <label>Password:</label>
        <input type="password" name="password"><br>

        <input type="submit" value="Update User">
    </form>
</body>
</html>
