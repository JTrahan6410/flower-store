package Servlets;

import Business.*;
import Connection.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose V Gomez
 */
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
         // Declares variables
            int expMonth, expYear;
            Date orderRequested, cardExpiry;
            String cardNumber, cardCVV, greetingCardType, greetingCardMessage;
            double orderTotal;
            boolean hasGreetingCard;
        
        try (PrintWriter out = response.getWriter()) {
            
            //retrieve all cart products
            HttpSession session = request.getSession(true);
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
            User u1 = (User) session.getAttribute("u1");
            //double total1 = (Double) session.getAttribute("total");
            cardNumber = request.getParameter("cardNumber");
            cardCVV = request.getParameter("cardCVV");
            greetingCardMessage = request.getParameter("greetingCardMessage");
            
             // Gets expiration values, creates LocalDate object for better handling, then a sql.Date object
            expMonth = Integer.parseInt(request.getParameter("month"));
            expYear = Integer.parseInt(request.getParameter("year"));
            LocalDate localDate = LocalDate.of(expYear, expMonth, 1);
            cardExpiry = Date.valueOf(localDate);
            
            // gets the greeting card checkbox value
            hasGreetingCard = Boolean.parseBoolean(request.getParameter("greetingCardCheckbox"));
            

             // Creates Order object and sets attributes
            Order order = new Order();
//            order.setUserID(u1.getUserID());
            order.setOrderDateTime(new Date(System.currentTimeMillis()));
            //order.setOrderRequested(new Date(System.currentTimeMillis()));
            //order.setOrderTotal(total1);
            order.setCardNumber(cardNumber);
            order.setCardExpiry(cardExpiry);
            order.setCardCVV(cardCVV);
            order.setHasGreetingCard(hasGreetingCard);
            order.setGreetingCardMessage(greetingCardMessage);
            
            order.insertDB();
            
            //check cart list
            if(cart_list != null){
                for(Cart c:cart_list){
                    OrderLine orderLine = new OrderLine();
                    orderLine.setOrderID(order.getOrderID());
                    orderLine.setProductCode(c.getProductCode());
                    orderLine.setProductCost(c.getProductCost());
                    orderLine.setOrderID(order.getOrderID());
                    orderLine.setProductQuantity(c.getQuantity());
                    
                    OrderLine ordered = new OrderLine(DbCon.getConnection());
                    boolean result = ordered.insertOrderLineDB(orderLine);
                    if(!result)break;
                }
                cart_list.clear();
                session.removeAttribute("cart-list");
                response.sendRedirect("success.jsp");
            }
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
