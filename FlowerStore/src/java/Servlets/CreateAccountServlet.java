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
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String firstNameInput, lastNameInput, emailInput, passwordInput;
        try{
            emailInput = request.getParameter("email");
            firstNameInput = request.getParameter("firstname");
            lastNameInput = request.getParameter("lastname");
            passwordInput = request.getParameter("password");
            
            System.out.println("User Updated Info: " + firstNameInput + ", " + lastNameInput);
            
            User u1 = new User();
//            u1.insertDB(emailInput, passwordInput, firstNameInput,lastNameInput,);
             u1.selectDB(emailInput);
                u1.display();
                HttpSession session1 = request.getSession();
                session1.setAttribute("u1", u1);
                System.out.println("User added to session...");


            u1.display();
            
            RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
            rd.forward(request, response);
            
        }catch(Exception e){
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