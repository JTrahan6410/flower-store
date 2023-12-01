<%-- 
    Document   : product
    Created on : Sep 2, 2023, 9:29:59 PM
    Author     : lena
--%>
<%@page import="Business.*"%>
<%@page import="Connection.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
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
        <title>Product Page</title>
        <link rel="stylesheet" type ="text/css" href="style.css">
        <link rel="stylesheet" type ="text/css" href="catalogStyle.css">
        <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <a href="index.jsp" class="logo">Atlanta Flowers<span>.</span></a>
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <a href="catalog.jsp">products</a>
        <% if(cart_list != null && !cart_list.isEmpty()){%>
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
        <section class="products" id="products">
            <h1 class="heading"> latest <span>products</span></h1>
            <div class="box-container">
            <%
                Product prod1 = new Product();
                List<Product> products = prod1.getAllProducts();
                //prod1 = (Product)session.getAttribute("p1");
                //prod1.selectDB("P114");
                
            %>

                <%for(Product p:products){%>
                <div class="box">
                    <span class="discount"> -10%</span>
                    <div class="image">
                        <img src="<%= p.getProductImage() %>" alt="">
                        <div class="icons">
                            
                            <a href="add-to-cart?productCode=<%= p.getProductCode() %>" class="cart-btn">add to cart</a>
                            
                        </div>
                    </div>
                    <div class="content">
                        <h3><%= p.getProductName() %></h3>
                        <div class="price">$ <%= dcf.format(p.getProductCost()) %> </div>
                    </div>
                </div>
          <%}%>
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
