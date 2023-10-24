<%-- 
    Document   : editAccount
    Created on : Sep 29, 2023, 9:48:09 PM
    Author     : Jose V Gomez
--%>

<%@page import="Business.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewpart" content="width=device-width, intital-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <title>User Account</title>
    </head>
    <body>
        <header>
            <a href="index.jsp" class="logo">Atlanta flowers<span>.</span></a>
            <nav class="navbar">
            <a href="index.jsp">home</a>
            <a href="product.jsp">products</a>
            <a href="catalog.jsp">cart</a>
        <% 
            HttpSession session1 = request.getSession(false);
            if(session1 == null || session1.getAttribute("u1") == null){
        %>
            <a href="login.jsp" style="float: right">login</a>
        <%
            }else{
        %>
            <a href="account.jsp">account</a> |
            <a href="login.jsp" style="float: right">logout</a>
        <%}%>
            </nav>
	</header>
        
        <%
            
            User u1;
            u1 = (User)session.getAttribute("u1");
        %>
                
        <section class="home">
        <form action="UpdateUserServlet" method="post" id="update-form" name="update-form">
                 
            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" value="<%=u1.getEmail()%>"><br><br>
                        
            <label for="userPassword">Password:</label><br>
            <input type="text" id="userPassword" name="userPassword" value="<%=u1.getUserPassword()%>"><br><br>
                        
            <label for="firstName">First Name:</label><br>
            <input type="text" id="firstName" name="firstName" value="<%=u1.getFirstName()%>"><br><br>
                        
            <label for="lastName">Last Name:</label><br>
            <input type="text" id="lastName" name="lastName" value="<%=u1.getLastName()%>"><br><br>
                        
            <input class="btn" type="submit" value="Update">
            <input class="btn" type="reset" value="Reset">
                </form>
                </section>
                
        
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