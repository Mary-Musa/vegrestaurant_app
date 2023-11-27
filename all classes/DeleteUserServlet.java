import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet{
	
	
    private UserService userService;

    public void init() {
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	int result = 0;
    	String email = request.getParameter("email");
    	System.out.println("The email in the request:"+" "+ email.trim());
    	try {
	           result = userService.deleteUser(email.trim());
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
    	
    }

}
