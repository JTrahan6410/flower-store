package Servlets;

import Business.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet for handling user login functionality.
 * This servlet processes user login requests, authenticates credentials,
 * and redirects to the appropriate page based on the authentication result.
 *
 * @author Jose V Gomez
 * @since 2023-09-16
 * @author Jacob
 * @since 2023-10-24
 * @version 1.3
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    try (PrintWriter out = response.getWriter()) {
        String email = request.getParameter("email");
        String pwInput = request.getParameter("userpw");

        // Validate user inputs
        if (email != null && !email.isEmpty() && pwInput != null && !pwInput.isEmpty()) {
            User u1 = new User();
            u1.selectDB(email);  // Load user details from the database

            // Check if the loaded user matches the email and password
            if (email.equals(u1.getEmail()) && pwInput.equals(u1.getUserPassword())) {
                HttpSession session = request.getSession(true);
                session.setAttribute("u1", u1);  // Add user to session
                request.getRequestDispatcher("account.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("loginError.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("loginError.html").forward(request, response);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP {@code GET} request.
     * Delegates to {@code processRequest}.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP {@code POST} request.
     * Delegates to {@code processRequest}.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
        return "Servlet for user login handling";
    }// </editor-fold>

}
