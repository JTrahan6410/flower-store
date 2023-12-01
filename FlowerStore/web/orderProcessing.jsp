<%-- 
    Document   : account
    Created on : Sep 9, 2023, 10:20:31 AM
    Author     : cargle
--%>
<%@page import="Business.*"%>
<%@page import="Connection.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if(cart_list != null){
        Product prod1 = new Product(DbCon.getConnection());
        cartProduct = prod1.getCartProducts(cart_list);
        request.setAttribute("cart_list", cart_list);

    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewpart" content="width=device-width, intital-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="accountStyle.css">
        <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">
        <title>User Account</title>
    </head>
    <body>
        <header>
            <a href="index.jsp" class="logo">Atlanta Flowers<span>.</span></a>
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <a href="catalog.jsp">products</a>
                <% if(cart_list!=null){%>
                <a href="cart.jsp">cart<i class="fa badge fa-shopping-cart" value=${ cart_list.size() }></i></a>
        <% }else{%>
                <a href="cart.jsp">cart<i class="fa fa-shopping-cart" value=${ cart_list.size() }></i></a>
         <%} %>    
        <% 
            HttpSession session1 = request.getSession(false);
            if(session1 == null || session1.getAttribute("u1") == null){
        %>
            <a href="login.jsp" style="float: right">login</a>
        <%
            }else{
        %>
            <a href="account.jsp">account</a> |
            <a href="LogoutServlet" style="float: right">logout</a>
        <%}%>
            </nav>
	</header>
        
        <% 
            Order order1 = new Order();
            List<Order> orders = order1.getAllOrders();
        %>
        <div id="accounts-box">
            <h2>Order Processing</h2>
            <table id="accounts-table" style="width:100%">
            <caption>Order Processing</caption>
                <tr>
                    <th>Order ID</th>
                    <th>User ID</th>
                    <th>Order Date/Time</th>
                    <th>Order Total</th>
                    <th>Greeting Card Message</th>
                    <th>Order Status</th>
                </tr>
                <%for(Order o:orders){%>
                <tr>
                    <td><%= o.getOrderID() %></td>
                    <td><%= o.getUserID() %></td>
                    <td><%= o.getOrderDateTime() %></td>
                    <td>$ <%= o.getOrderTotal() %></td>
                    <td><%= o.getGreetingCardMessage() %></td>
                    <td><select style="width:50%; height:45px; font-size: 15px" name="status" id="status-menu">
                        <option value="<%= o.getOrderStatus() %>"><%= o.getOrderStatus() %></option>
                        <option value="Open">Open</option> 
                        <option value="Ready">Ready</option> 
                        <option value="Delivered">Delivered</option> 
                        </select></td> 
                </tr>
                <%}%>
            </table>
            <a class="btn" href=""> Set Order Status </a>
        </div>
        <section class="footer">
            <div class="box-container">
                <div class="box">
                    <h3>quick links</h3>
                        <a href="index.jsp">home</a>
                        <!--<a href="#">about</a>-->
                        <a href="product.jsp">products</a>
                        <!--<a href="#">review</a>-->
                        <!--<a href="#">contact</a>-->
                </div>
                <div class="box">
                    <h3>extra links</h3>
                        <a href="account.jsp">my account</a>
                        <a href="cart.jsp">my cart</a>
                        <!--<a href="#">my favorite</a>-->
                </div>
                <div class="box">
                    <h3>locations</h3>
                    Georgia<br>
                    Florida<br>
                    Tennessee <br>
                    Alabama <br>
                </div>
                <div class="box">
                    <h3>contact info</h3>
                        <a href=“tel:404-123-4567”>404-123-4567</a>
                        <a href="mailto:help@atlflowers.com">help@atlflowers.com</a>
                        <a href="#">Atlanta, GA 30116</a>
                        <img src="assets/pymnt-1.jpg" alt="">
                </div>
            </div>
            <div class="credit"> created by <span> Group 2 CIST 2931 </span> | all rights reserved </div>
        </section>
    </body>
</html>