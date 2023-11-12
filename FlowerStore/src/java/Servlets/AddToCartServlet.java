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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            String productCode = request.getParameter("productCode");
            HttpSession session = request.getSession();
            ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");
            
            if (cartList == null) {
                cartList = new ArrayList<>();
                Cart cartItem = new Cart();
                cartItem.setProductCode(productCode);
                cartItem.setQuantity(1);
                cartList.add(cartItem);
                session.setAttribute("cart-list", cartList);
                response.sendRedirect("catalog.jsp");
            } else {
                boolean exists = false;
                for (Cart item : cartList) {
                    if (item.getProductCode().equals(productCode)) {
                        exists = true;
                        out.println("<h3 style='color:crimson; text-align:center'>Item already exists in cart. <a href='cart.jsp'>Go to Cart Page</a></h3>");
                        break;
                    }
                }
                if (!exists) {
                    Cart cartItem = new Cart();
                    cartItem.setProductCode(productCode);
                    cartItem.setQuantity(1);
                    cartList.add(cartItem);
                    response.sendRedirect("catalog.jsp");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Adds Product to Cart";
    }// </editor-fold>

}
