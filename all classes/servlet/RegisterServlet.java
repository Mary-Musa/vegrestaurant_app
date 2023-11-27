package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	
	  private static final long serialVersionUID = 1L;
	    private UserService userService;

	    public void init() {
	        userService = new UserService();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        int result = 0;

	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String phone = request.getParameter("phone");
	        String location = request.getParameter("location");
	        
	        User user = new User();
	        user.setFirstName(firstName);
	        user.setLastName(lastName);
	        user.setEmail(email);
	        user.setPassword(password);
	        user.setPhone(phone);
	        user.setLocation(location);
	        user.setUserType("USER");

	        try {
	           result = userService.registerUser(user);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        if(result == 0) {
	       
	        	response.sendRedirect("SignUp.jsp"); 
	        	}

	        response.sendRedirect("login.jsp");
	    }

//		private boolean isDuplicateEntry(String email) {
//			// TODO Auto-generated method stub
//			return false;
//		}

}
