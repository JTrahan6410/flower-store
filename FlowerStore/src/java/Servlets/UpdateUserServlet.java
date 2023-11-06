package Servlets;

import Business.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/****************************
 * Project
 * @author Jose V Gomez
 * 9/16/23
 ***************************/
@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/UpdateUserServlet"})
public class UpdateUserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Extract user input from request parameters
        String emailInput = request.getParameter("email");
        String firstNameInput = request.getParameter("firstName");
        String lastNameInput = request.getParameter("lastName");
        String passwordInput = request.getParameter("userPassword");

        // Log for debugging purposes
        log("Attempting to update user - Email: " + emailInput + ", First Name: " + firstNameInput + ", Last Name: " + lastNameInput + ", Password: " + passwordInput);

        try {
            // Retrieve the current user from session
            HttpSession session = request.getSession(false);
            if (session == null) {
                throw new IllegalStateException("Session not found");
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new IllegalStateException("User not found in session");
            }

            // Update user details
            user.setEmail(emailInput);
            user.setFirstName(firstNameInput);
            user.setLastName(lastNameInput);
            user.setUserPassword(passwordInput);
            // Persist changes to the database
            user.updateDB();
            // Log user info after update
            user.display();
            // Forward to the account page
            RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
            rd.forward(request, response);
        } catch (ServletException | IOException | IllegalStateException e) {
            log("UpdateUserServlet Exception: " + e.getMessage(), e);
            // Forward to an error page or handle the exception appropriately
             response.sendRedirect("errorPage.jsp");
            // Alternatively, use RequestDispatcher for consistency with the rest of the application.
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
        return "Short description";
    }// </editor-fold>

}