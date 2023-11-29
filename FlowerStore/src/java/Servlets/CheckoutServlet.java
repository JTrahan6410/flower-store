package Servlets;

import Business.*;
import java.io.IOException;
import java.sql.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Jake
 */
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Declares variables
            int expMonth, expYear;
            Date orderRequested, cardExpiry;
            String cardNumber, cardCVV, greetingCardType, greetingCardMessage;
            double orderTotal;
            boolean hasGreetingCard;
        
        // Retrieve information from session
        HttpSession session = request.getSession();
        ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");
        User user = (User) session.getAttribute("user");
        cardNumber = request.getParameter("cardNumber");
        cardCVV = request.getParameter("cardNumber");
        greetingCardMessage = request.getParameter("greetingCardMessage");
        
        
        // Gets expiration values, creates LocalDate object for better handling, then a sql.Date object
        expMonth = Integer.parseInt(request.getParameter("month"));
        expYear = Integer.parseInt(request.getParameter("year"));
        LocalDate localDate = LocalDate.of(expYear, expMonth, 1);
        cardExpiry = Date.valueOf(localDate);
        
        // gets the greeting card checkbox value
        hasGreetingCard = Boolean.parseBoolean(request.getParameter("greetingCardCheckbox"));
        
        if (cartList == null || user == null) {
            // Redirect to error page or handle error
            response.sendRedirect("index.jsp");
            return;
        }
        
        // Creates Order object and sets attributes
        Order order = new Order();
        order.setUserID(user.getUserID());
        order.setOrderDateTime(new Date(System.currentTimeMillis()));
        order.setCardNumber(cardNumber);
        order.setCardExpiry(cardExpiry);
        order.setCardCVV(cardCVV);
        order.setHasGreetingCard(hasGreetingCard);
        order.setGreetingCardMessage(greetingCardMessage);
        
        
        
        // Iterate over cart items to create OrderLine objects
        for (Cart cartItem : cartList) {
            OrderLine orderLine = new OrderLine();
            orderLine.setOrderID(order.getOrderID()); // Assuming orderID is set after inserting order
            orderLine.setProductCode(cartItem.getProductCode());
            orderLine.setProductQuantity((short) cartItem.getQuantity());
            orderLine.setProductCost(cartItem.getProductCost()); // Assuming getProductCost() retrieves cost

            // Persist OrderLine object to database
             orderLine.insertDB();
        }

        // Clear cart after processing
        session.removeAttribute("cart-list");

        // Redirect to confirmation page or further processing
        response.sendRedirect("orderConfirmation.jsp");
    }
}