package Servlets;

import Business.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation for updating user details.
 * This servlet handles the process of updating user information such as email, first name,
 * last name, and password, and then redirects to the account page.
 * 
 * @author Jose V Gomez
 * @since 2023-09-16
 * @author Jacob Trahan
 * @since 2023-11-16
 * @version 1.5
 * 
 */
@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/UpdateUserServlet"})
public class UpdateUserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP {@code GET} and {@code POST} methods.
     * Updates the user information in the session and database.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Extract user information from request parameters
        String firstNameInput = request.getParameter("firstName");
        String lastNameInput = request.getParameter("lastName");
        String emailInput = request.getParameter("email");
        String passwordInput = request.getParameter("userPassword");

        try {
            // Retrieve user object from session
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("u1");

            // Check if user object exists and update user information
            if (user != null) {
                user.setEmail(emailInput);
                user.setFirstName(firstNameInput);
                user.setLastName(lastNameInput);
                user.setUserPassword(passwordInput);

                // Update user details in database
                user.updateDB();

                // Update user object in session
                session.setAttribute("u1", user);
            }

            // Forward request to account page
            request.getRequestDispatcher("account.jsp").forward(request, response);

        } catch (ServletException | IOException e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP {@code POST} request.
     * Calls {@code processRequest} to process the request.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for updating user information";
    }// </editor-fold>
}
