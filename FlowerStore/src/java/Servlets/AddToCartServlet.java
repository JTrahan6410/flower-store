package Servlets;

import Business.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Jose V Gomez
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/add-to-cart"})
public class AddToCartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            ArrayList<Cart> cartList = new ArrayList<>();
            
            String productCode = request.getParameter("productCode");
            Cart cm = new Cart();
            cm.setProductCode(productCode);
            cm.setQuantity(1);
            
            HttpSession session1 = request.getSession();
            session1.getAttribute("cart-list");
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session1.getAttribute("cart-list");
            
            if(cart_list == null){
                
                cartList.add(cm);
                session1.setAttribute("cart-list", cartList);
                response.sendRedirect("catalog.jsp");
                
            }else{
                
                cartList = cart_list;
                boolean exist = false;
                
                for(Cart c:cart_list){
                    if(c.getProductCode().equals(productCode)){
                        exist = true;
                        out.println("<h3 style='color:crimson; text-align:center'>Item already exist in cart.<a href='cart.jsp'>Go to Cart Page</a>");
                    }
                }
                    if(!exist){
                        cartList.add(cm);
                        response.sendRedirect("catalog.jsp");
                    }
            }
        }
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
