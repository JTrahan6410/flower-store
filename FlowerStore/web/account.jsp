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
                <% if(cart_list != null && !cart_list.isEmpty()){ %>
                    <a href="cart.jsp">cart<i class="fa badge fa-shopping-cart">${ cart_list.size() }</i></a>
                <% } else { %>
                    <a href="cart.jsp">cart<i class="fa fa-shopping-cart"></i></a>
                <% } %>   
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
            User u1;
            u1 = (User)session.getAttribute("u1");
        %>
        <div id="accounts-box">
            <h2>Welcome back, <%=u1.getFirstName()%></h2>
            <table id="accounts-table" style="width:100%">
            <caption><%=u1.getFirstName()%>'s Account</caption>
                <tr>
                    <th>Email</th>
                    <th>Password</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Street</th>
                    <th>City</th>
                    <th>State</th>
                    <th>Zip</th>
                </tr>
                <tr>
                    
                    <td><%=u1.getEmail()%></td>
                    <td><%=u1.getUserPassword()%></td>
                    <td><%=u1.getFirstName()%></td>
                    <td><%=u1.getLastName()%></td>
                    <td><%=u1.getStreetAddress()%></td>
                    <td><%=u1.getCity()%></td>
                    <td><%=u1.getState()%></td>
                    <td><%=u1.getZIP()%></td>
                </tr>
            </table>
            <a class="btn" href="editAccount.jsp"> edit account info </a>
        </div>
        <section class="orderSec">
        <h2>Your Orders</h2>
            <div class="account_orders">
                <h3 id="recent_order">Recent Order</h3>
                <div class="viewOrders"><a href="#orders">View All Orders</a></div>
                <div class="box">
                        <div class="order_image">
                            <img src="assets/img-flwr-4.jpg" alt="">
                        </div>
                        <div class="order_content">
                            <h3>flower pot</h3>
                            <div class="order_price"> $12.00 <span>$15.99</span></div>
                        </div>
                </div>
            </div>
        </section>
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