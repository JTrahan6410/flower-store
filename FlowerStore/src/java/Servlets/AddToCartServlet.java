package Servlets;

import Business.Cart;
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
 * AddToCartServlet is a servlet class that handles adding items to the user's shopping cart.
 * It responds to both GET and POST requests, with GET requests adding items to the cart
 * and POST requests delegating to the GET method.
 *
 * This servlet expects a "productCode" parameter in the request to identify the product to add to the cart.
 *
 * The servlet maintains a session-based shopping cart using an ArrayList of Cart objects.
 * If the cart doesn't exist in the session, it creates a new cart and adds the specified item.
 * If the item is already in the cart, it displays a message indicating that it's already in the cart.
 * If the item is not in the cart, it adds it to the cart.
 *
 * @author Jose V Gomez
 * @author Jacob Trahan - added Javadocs
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/add-to-cart"})
public class AddToCartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    /**
     * Process the GET request to add an item to the user's shopping cart.
     *
     * @param request  The HttpServletRequest object representing the client's request.
     * @param response The HttpServletResponse object for sending the response back to the client.
     * @throws ServletException If a servlet-specific error occurs.
     * @throws IOException      If an I/O error occurs when processing the request or response.
     */
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
                Cart cm = new Cart();
                cm.setProductCode(productCode);
                cm.setQuantity(1);
                cartList.add(cm);
                session.setAttribute("cart-list", cartList);
                response.sendRedirect("catalog.jsp");
            } else {
                boolean exists = false;
                for (Cart c : cartList) {
                    if (c.getProductCode().equals(productCode)) {
                        exists = true;
                        out.println("<h3 style='color:crimson; text-align:center'>Item already exist in cart. <a href='cart.jsp'>Go to Cart Page</a></h3>");
                        break;
                    }
                }
                if (!exists) {
                    Cart cm = new Cart();
                    cm.setProductCode(productCode);
                    cm.setQuantity(1);
                    cartList.add(cm);
                    response.sendRedirect("catalog.jsp");
                }
            }
        }
    }

    /**
     * Process the POST request by delegating to the doGet method.
     *
     * @param request  The HttpServletRequest object representing the client's request.
     * @param response The HttpServletResponse object for sending the response back to the client.
     * @throws ServletException If a servlet-specific error occurs.
     * @throws IOException      If an I/O error occurs when processing the request or response.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // Delegate POST request to doGet method
    }

    /**
     * Get information about this servlet.
     *
     * @return A string containing a brief description of this servlet.
     */
    @Override
    public String getServletInfo() {
        return "AddToCartServlet adds items to the user's shopping cart";
    }
}
