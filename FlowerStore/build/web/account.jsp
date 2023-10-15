<%-- 
    Document   : account
    Created on : Sep 9, 2023, 10:20:31 AM
    Author     : cargle
--%>
<%@page import="Business.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <meta name="viewpart" content="width=device-width, intital-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="accountStyle.css">
        <title>User Account</title>
    </head>
    <body>
        <header>
            <a href="index.html" class="logo">Atlanta flowers<span>.</span></a>
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <a href="product.jsp">products</a>
                <a href="login.jsp" style="float: right">login</a>
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
                </tr>
                <tr>
                    
                    <td><%=u1.getEmail()%></td>
                    <td><%=u1.getUserPassword()%></td>
                    <td><%=u1.getFirstName()%></td>
                    <td><%=u1.getLastName()%></td>
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
                    <a href="#">home</a>
                    <a href="#">about</a>
                    <a href="#">products</a>
                    <a href="#">review</a>
                    <a href="#">contact</a>
                </div>
                <div class="box">
                    <h3>extra links</h3>
                    <a href="#">my account</a>
                    <a href="#">my order</a>
                    <a href="#">my favorite</a>
                </div>
                <div class="box">
                    <h3>locations</h3>
                    <a href="#">Georgia</a>
                    <a href="#">Florida</a>
                    <a href="#">Tennesee</a>
                    <a href="#">Alabama</a>
                </div>
                <div class="box">
                    <h3>contact info</h3>
                    <a href="#">+123-456-7890</a>
                    <a href="#">example@email.com</a>
                    <a href="#">Mumbai,India -400104</a>
                    <img src="assets/pymnt-1.jpg" alt="">
                </div>
            </div>
            <div class="credit"> created by <span> Group 2 CIST 2931 </span> | all rights reserved </div>
        </section>
    </body>
</html>