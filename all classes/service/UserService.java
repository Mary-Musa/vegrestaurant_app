package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.LoginWrapper;
import models.User;

public class UserService {
	
    public int registerUser(User user) throws ClassNotFoundException {
    	
        String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (firstName, lastName, email, location, phone, password, userType) VALUES " +
            " (?, ?, ?, ?,?,?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/restaurant_db?useSSL=false", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//            preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getLocation());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getUserType());

            System.out.println("the prepared statement is"+" "+preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
         

        } catch (SQLException e) {
            // process sql exception
            System.out.println("the exception is"+" "+e);

            printSQLException(e);
        }
        return result;
    }
   
     
    
	public String loginUser(LoginWrapper loginObject) throws ClassNotFoundException {
		
        boolean status = false;
        String userType = "";

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/restaurant_db?useSSL=false", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from users where email = ? and password = ? ")) {
            preparedStatement.setString(1, loginObject.getEmail());
            preparedStatement.setString(2, loginObject.getPassword());

            System.out.println(preparedStatement);
            
            java.sql.ResultSet rs = preparedStatement.executeQuery();
            
            User user = new User(); // creating user obj
            
            while (rs.next()){
           
            	userType = rs.getString("userType");
            	System.out.println("The user type is:"+" "+ userType);
            }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
       
        return userType;
    }
	

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
	public int deleteUser(String email ) throws ClassNotFoundException {
		
        int status = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/restaurant_db?useSSL=false", "root", "");

            // Step 2:delete a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE email = ?")) {
            preparedStatement.setString(1, email);

            System.out.println(preparedStatement);
            
            status = preparedStatement.executeUpdate();

            
            System.out.println("The status is:"+" "+ status);
            
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }
	
	
	
	
	
	// a method to update a user 
	
	
	
	
	public int updateUser(User user) {
	    int result = 0;

	    try {
	        //  JDBC driver
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        //  a users table with columns: email, firstName, lastName, location, phone, password
	        String sql = "UPDATE users SET firstName=?, lastName=?, location=?, phone=?, password=? WHERE email=?";

	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db?useSSL=false", "root", "");
	             PreparedStatement statement = connection.prepareStatement(sql)) {

	            // Set parameters
	            statement.setString(1, user.getFirstName());
	            statement.setString(2, user.getLastName());
	            statement.setString(3, user.getLocation());
	            statement.setString(4, user.getPhone());
	            statement.setString(5, user.getPassword());
	            statement.setString(6, user.getEmail());

	            //  the update query
	            result = statement.executeUpdate();
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        // Handle exceptions
	        e.printStackTrace();
	    }

	    return result;
	}

	
	   


}

