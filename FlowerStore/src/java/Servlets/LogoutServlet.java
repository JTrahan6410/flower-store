package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation for handling user logout.
 * This servlet invalidates the user's session and redirects them to the login page,
 * effectively logging the user out of the application.
 *
 * @author Jose V Gomez
 * @since 2023-10-22
 * @author Jacob Trahan
 * @since 2023-11-14
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Invalidates the current session and redirects the user to the login page.
     *
     * @param request  The HttpServletRequest object representing the client's request.
     * @param response The HttpServletResponse object for sending the response back to the client.
     * @throws ServletException If a servlet-specific error occurs.
     * @throws IOException      If an I/O error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Invalidate the current user session
        HttpSession session = request.getSession();  
        session.invalidate(); 
        
        // Forward to the login page
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Handles user logout and session invalidation";
    }
}
