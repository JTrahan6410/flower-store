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
 * CreateAccountServlet is a servlet class responsible for handling the creation of user accounts.
 * It processes user input from an HTML form and inserts the user's information into a database.
 * After successfully creating the account, it forwards the user to an account page.
 *
 * This servlet expects various user details as input parameters, such as email, first name, last name, password,
 * street address, city, state, and ZIP code. It then creates a new User object with the provided information,
 * inserts the user into the database, and sets the user object in the session for further interactions.
 *
 * @author Jose V Gomez
 * @since 2023-09-16
 * @version 1.3
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

    /**
     * Handles the creation of a user account by processing user input, inserting the user's information into the database,
     * and setting the user object in the session.
     *
     * @param request  The HttpServletRequest object representing the client's request.
     * @param response The HttpServletResponse object for sending the response back to the client.
     * @throws ServletException If a servlet-specific error occurs.
     * @throws IOException      If an I/O error occurs when processing the request or response.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String firstNameInput, lastNameInput, emailInput, passwordInput, streetAddressInput, cityInput, stateInput, ZIPInput;
        try{
            emailInput = request.getParameter("email");
            firstNameInput = request.getParameter("firstname");
            lastNameInput = request.getParameter("lastname");
            passwordInput = request.getParameter("password");
            streetAddressInput = request.getParameter("streetAddress");
            cityInput = request.getParameter("city");
            stateInput = request.getParameter("state");
            ZIPInput = request.getParameter("ZIP");

            System.out.println("User Updated Info: " + firstNameInput + ", " + lastNameInput);

            User u1 = new User(emailInput, passwordInput, firstNameInput, lastNameInput, streetAddressInput, cityInput, stateInput, ZIPInput, false);
            u1.insertDB();
            u1.selectDB(emailInput);
                u1.display();
                HttpSession session1 = request.getSession();
                session1.setAttribute("u1", u1);
                System.out.println("User added to session...");


            u1.display();

            RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
            rd.forward(request, response);

        }catch(ServletException | IOException e){
            System.out.println(e);
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
        return "Servlet for creating user accounts";
    }// </editor-fold>

}
