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
import java.io.PrintWriter;

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


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            User u1 = (User)session.getAttribute("u1");
            
            // Only update attributes that have non-null and non-empty values
            String emailInput = request.getParameter("email");
            if (emailInput != null && !emailInput.isEmpty()) u1.setEmail(emailInput);
            
            String firstNameInput = request.getParameter("firstName");
            if (firstNameInput != null && !firstNameInput.isEmpty()) u1.setFirstName(firstNameInput);

            String lastNameInput = request.getParameter("lastName");
            if (lastNameInput != null && !lastNameInput.isEmpty()) u1.setLastName(lastNameInput);

            String passwordInput = request.getParameter("userPassword");
            if (passwordInput != null && !passwordInput.isEmpty()) u1.setUserPassword(passwordInput);

            String streetAddressInput = request.getParameter("streetAddress");
            if (streetAddressInput != null && !streetAddressInput.isEmpty()) u1.setStreetAddress(streetAddressInput);

            String cityInput = request.getParameter("city");
            if (cityInput != null && !cityInput.isEmpty()) u1.setCity(cityInput);

            String stateInput = request.getParameter("state");
            if (stateInput != null && !stateInput.isEmpty()) u1.setState(stateInput);

            String ZIPInput = request.getParameter("ZIP");
            if (ZIPInput != null && !ZIPInput.isEmpty()) u1.setZIP(ZIPInput);

            // Update user information in the database
            u1.updateDB();
            u1.display();

            // Forward to account page
            RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Error in UpdateUserServlet: " + e.getMessage());
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp"); // Redirect to error page on exception
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Processes requests for both HTTP {@code GET} and {@code POST} methods.
     * Updates the user information in the session and database.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
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
