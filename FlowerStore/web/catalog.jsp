<%-- 
    Document   : product
    Created on : Sep 2, 2023, 9:29:59 PM
    Author     : lena
--%>
<%@page import="Business.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <link rel="stylesheet" type ="text/css" href="style.css">
        <link rel="stylesheet" type ="text/css" href="catalogStyle.css">
    </head>
    <body>
        <header>
            <a href="index.jsp" class="logo">Atlanta flowers<span>.</span></a>
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <a href="catalog.jsp">products</a>
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
                <a href="LogoutServlet" style="float: right">logout</a>
        <%}%>
            </nav>
        </header>
        <section class="products" id="products">
            <h1 class="heading"> latest <span>products</span></h1>
            <div class="box-container">
            <%
                Product prod1 = new Product();
                List<Product> products = prod1.getAllProducts();
                //prod1 = (Product)session.getAttribute("p1");
                prod1.selectDB("P114");
                
            %>

                <%for(Product p:products){%>
                <div class="box">
                    <span class="discount"> -10%</span>
                    <div class="image">
                        <img src="<%= p.getProductImage() %>" alt="">
                        <div class="icons">
                            
                            <a href="#" class="cart-btn">add to cart</a>
                            
                        </div>
                    </div>
                    <div class="content">
                        <h3><%= p.getProductName() %></h3>
                        <div class="price">$ <%= p.getProductCost() %> <span>$15.99</span></div>
                    </div>
                </div>
          <%}%>
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
                    <a href="#">mumbai,india -400104</a>
                    <img src="assets/pymnt-1.jpg" alt="">
                </div>
            </div>
            <div class="credit"> created by <span> Group 2 CIST 2931 </span> | all rights reserved </div>
        </section>
    </body>
</html>
