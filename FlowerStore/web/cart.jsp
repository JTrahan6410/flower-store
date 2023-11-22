<%-- 
    Document   : cart
    Created on : Nov 5, 2023, 6:12:48 PM
    Author     : Jose V Gomez
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
        double total = prod1.getTotalCartPrice(cart_list);
        request.setAttribute("total", total);
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
        <section class="products" id="products">
            <h1 class="heading">Cart</h1>
            <div class="box-container">
            
            
            <div id="accounts-box">
                <h2><a class="btn" href="checkout.jsp">Check Out</a> Total Price: $ ${ (total>0)?dcf.format(total):0 }</h2>
            <table id="accounts-table" style="width:100%">
                <tr>
                        <th>Product Name</th>
                        <th>Product Image</th>
                        <th>Product Description</th>
                        <th>Product Cost</th>
                        <th>Quantity</th>
                        <th>Cancel</th>
                </tr>
                <% if(cart_list != null){
                    for(Cart c:cartProduct){%>
                    
                    <tr>
                        <td><%= c.getProductName() %></td>
                        <td><img width="200" height="220" src="<%= c.getProductImage() %>" alt="alt"/></td>
                        <td><%= c.getProductDescription() %></td>
                        <td>$<%= dcf.format(c.getProductCost()) %></td>
                        <td><%= c.getQuantity() %></td>
                        <td><a class="btn" href="remove-from-cart?productCode=<%= c.getProductCode() %>">Remove</a> </td>
                    </tr>
                    <%}
                    }%>
            </table>
                
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
