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
 * @author Jose V Gomez - adapted by Jacob Trahan
 * 9/16/23 - last updated 11/2/23
 ***************************/
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String firstNameInput, lastNameInput, emailInput, passwordInput;
            emailInput = request.getParameter("email");
            firstNameInput = request.getParameter("firstname");
            lastNameInput = request.getParameter("lastname");
            passwordInput = request.getParameter("password");
            
            //logging for debugging purposes
            log("User Info: " + firstNameInput + ", " + lastNameInput);
            
            try {
            // Create a new User object and set its attributes
            User newUser = new User();
            newUser.setEmail(emailInput);
            newUser.setUserPassword(passwordInput);
            newUser.setFirstName(firstNameInput);
            newUser.setLastName(lastNameInput);
            newUser.setAdmin(false); // Default admin status set to false for new accounts
            
            // Insert the new user into the database
            newUser.insertDB();
            
            
            newUser.selectDB(emailInput);
            newUser.display();
            // adds new user to the session
            HttpSession session = request.getSession();
            session.setAttribute("user", newUser);
            log("User added to session...");

            // Forward to the account page
            RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
            rd.forward(request, response);

        } catch (ServletException | IOException e) {
            log("CreateAccountServlet Exception: " + e.getMessage(), e);
            // Forward to an error page or handle the exception appropriately
             response.sendRedirect("errorPage.jsp");
            // Alternatively, you can use a RequestDispatcher as shown above for consistency.
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