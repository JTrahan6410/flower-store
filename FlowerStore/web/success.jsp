<%-- 
    Document   : success
    Created on : Sep 25, 2023, 1:46:22 PM
    Author     : lena
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
        <title>Checkout Success</title>
        <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" type ="text/css" href="style.css">
        <link rel="stylesheet" type ="text/css" href="successStyle.css">
        <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
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
      <body>
          
      <div class="card">
      <div style="border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto;">
        <i class="checkmark">✓</i>
      </div>
        <h1>Thank you for your purchase!</h1> 
        <p>We received your purchase request;<br/> we'll be in touch shortly!</p>
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

