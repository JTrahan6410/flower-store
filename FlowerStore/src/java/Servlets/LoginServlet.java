package Servlets;

import Business.*;
import Database.DatabaseHook;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * JACOB TRAHAN - adapted from Jose Gomez (9/18/23)
 * Adv Sys Project - Nov 5, 2023
 *
 */

// WebServlet annotation for declaring servlet mapping
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    // The init method is called once when the servlet is first loaded
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // Initialize DatabaseHook with ServletContext for database path retrieval
        DatabaseHook.initialize(config.getServletContext());
        // Optionally, log the path for debugging purposes
        System.out.println("Database Path Initialized: " + DatabaseHook.getDatabasePath());
    }
    
    // The main method to process requests for both HTTP GET and POST methods
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Read user input from login form
            String email = request.getParameter("userid");
            String pwInput = request.getParameter("userpw");

            // Logging the user input for debugging purposes
            System.out.println("Userid: " + email);
            System.out.println("Userpw: " + pwInput);

            // Create a User object and retrieve user details from DB
            User user = new User();
            user.selectDB(email);
            user.display();

            // Storing the User object in session for further use
            HttpSession session = request.getSession();
            session.setAttribute("u1", user);
            System.out.println("User added to session...");

            // Decision-making: If user id and user password match, forward to account page; else forward to error page
            if (email.equals(user.getEmail()) && pwInput.equals(user.getUserPassword())) {
                request.getRequestDispatcher("account.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("loginError.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Log the exception for debugging and inform the user
            e.printStackTrace(); // For debugging purposes
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An internal server error occurred.");
        }
        // The PrintWriter is automatically closed by the try-with-resources statement
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
