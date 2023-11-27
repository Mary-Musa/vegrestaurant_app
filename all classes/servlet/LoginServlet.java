
	package servlet;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;	
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.LoginWrapper;
import models.User;
import service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	  private static final long serialVersionUID = 1L;
	    private UserService userService;

	    public void init() {
	        userService = new UserService();
	    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	String userType = "";
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginWrapper loginObject = new LoginWrapper();
        
        loginObject.setEmail(email);
        loginObject.setPassword(password);


        try {
           userType = userService.loginUser(loginObject);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if(userType.equals("USER")) {
        	response.sendRedirect("userdashboard.jsp");
        }
        else if(userType.equals("ADMIN")) {
            response.sendRedirect("adminview.jsp");
        }
        else {
        	System.out.println("user is:"+" "+userType);
            response.sendRedirect("login.jsp");
        }
    }
}
