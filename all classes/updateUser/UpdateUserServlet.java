package updateUser;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import service.UserService;

@WebServlet("/Update")
public class UpdateUserServlet extends HttpServlet {
    private UserService userService;

    public void init() {
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET requests if needed
        // For simplicity, send an error response
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Error: Page not found");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String location = request.getParameter("location");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        User updatedUser = new User();
        updatedUser.setEmail(email);
        updatedUser.setFirstName(firstName);
        updatedUser.setLastName(lastName);
        updatedUser.setLocation(location);
        updatedUser.setPhone(phone);
        updatedUser.setPassword(password);

        try {
            int result = userService.updateUser(updatedUser);

            if (result > 0) {
                // Successfully updated user
                response.getWriter().println("Update successful!");
            } else {
                // Handle update failure
                response.getWriter().println("Update failed!");
            }
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            response.getWriter().println("Error during update!");
        }
    }
}
