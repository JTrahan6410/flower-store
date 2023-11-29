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
public class LoginServletOld extends HttpServlet {

    /**
     * Processes requests for both HTTP {@code GET} and {@code POST} methods.
     * Handles user login by verifying credentials and managing session attributes.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        //properties
        String email, pwInput;
        try{
            //Read user input from login form
            //userIDInput = Integer.parseInt(request.getParameter("userid"));
            email = request.getParameter("email");
            pwInput = request.getParameter("userpw");
            //make a decision to continue 
            //If email input and password input is not empty
            if(!email.isEmpty() && !pwInput.isEmpty()){
                
                User u1 = new User();
                u1.selectDB(email);
                u1.display();
                HttpSession session1 = request.getSession(true);
                session1.setAttribute("u1", u1);
                System.out.println("User added to session...");
                
            //if user id and user pw are in database forward to patient account page
            if(email.equals(u1.getEmail()) && pwInput.equals(u1.getUserPassword())){
                RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
                rd.forward(request, response);
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("loginError.jsp");
                rd.forward(request, response);
            }
                
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("loginError.html");
                rd.forward(request, response);
            }   
        
        }catch(ServletException | IOException e){

            System.out.println(e);
            
        }finally{
            System.out.println("LoginServlet Ending...");
            out.close();
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