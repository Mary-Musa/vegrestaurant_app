<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("userid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "restaurant_db";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>
<head>
<title>Admin dashboard</title>
<link rel="stylesheet"href="CSS/admin.css">
</head>
<h1>Admin Dashboard</h1>
<h2>Retrieving data from database users in jsp</h2>
<table border=" 1" id ="table">
<tr>
<td>id</td>
<td>firstName</td>
<td>lastName</td>
<td>location</td>
<td>phone</td>
<td>password</td>
<td id="email">email</td>
<td>Action</td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from users";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("id") %></td>
<td><%=resultSet.getString("firstName") %></td>
<td><%=resultSet.getString("lastName") %></td>
<td><%=resultSet.getString("location") %></td>
<td><%=resultSet.getString("phone") %></td>
<td><%=resultSet.getString("password") %></td>
<td id ="email"><%=resultSet.getString("email") %></td>
<td> <a href="http://localhost:8081/jsp-web-app/delete?email= <%=resultSet.getString("email") %>" id="link"><button>Delete</button></a>  <button>Update</button></td>

</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 
    <script>
        function deleteUser() {
        	var theTbl = document.getElementById('table');
            // Get the email from the input field
            var email = document.getElementById("table").rows[1].cells[6].innerText;

            // Update the href attribute of the hyperlink with the email
            document.getElementById("link").href = "http://localhost:8081/jsp-web-app/delete?email=" + email;
        }
    </script>
</body>
</html>