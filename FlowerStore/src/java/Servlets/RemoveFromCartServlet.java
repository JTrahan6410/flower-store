package Servlets;

import Business.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Servlet implementation for removing a product from the shopping cart.
 * This servlet handles the process of removing an item from the user's shopping cart
 * based on the product code provided in the request parameter. It updates the cart list
 * in the session and redirects the user to the cart page.
 * 
 * @author Jose V Gomez
 * @since 2023-11-14
 * @author Jacob Trahan
 * @since 2023-11-22
 * @version 1.1
 */
@WebServlet(name = "RemoveFromCartServlet", urlPatterns = {"/remove-from-cart"})
public class RemoveFromCartServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * Removes the product from the shopping cart and redirects to the cart page.
     * The product to be removed is identified by its product code, which is
     * obtained from the request parameter "productCode".
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the response content type to HTML
        response.setContentType("text/html;charset=UTF-8");
        
        // Retrieve the product code from the request
        String productCode = request.getParameter("productCode");
        if (productCode != null) {
            // Get the shopping cart list from session
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            
            // Remove the product from the cart list
            if (cart_list != null) {
                Iterator<Cart> iterator = cart_list.iterator();
                while (iterator.hasNext()) {
                    Cart c = iterator.next();
                    if (c.getProductCode().equals(productCode)) {
                        iterator.remove();
                        break;
                    }
                }
            }
        }
        
        // Redirect to the cart page
        response.sendRedirect("cart.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for removing a product from the shopping cart";
    }
}
