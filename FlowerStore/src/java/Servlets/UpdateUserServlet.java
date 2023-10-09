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
        
        PrintWriter out = response.getWriter();
        String firstNameInput, lastNameInput, emailInput, passwordInput;
        
        
        try{
            
            emailInput = request.getParameter("email");
            firstNameInput = request.getParameter("firstName");
            lastNameInput = request.getParameter("lastName");
            passwordInput = request.getParameter("userPassword");
            
            
            System.out.println("Patient Updated Info: " + firstNameInput + ", " + lastNameInput);
            
            User u1;
            HttpSession ses1 = request.getSession();
            u1 = (User)ses1.getAttribute("u1");
            
            
            u1.setEMail(emailInput);
            u1.setFirstName(firstNameInput);
            u1.setLastName(lastNameInput);
            u1.setUserPassword(passwordInput);
            
            
            u1.updateDB();
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
        return "Short description";
    }// </editor-fold>

}
