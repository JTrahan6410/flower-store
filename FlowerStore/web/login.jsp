<%-- 
    Document   : login
    Created on : Oct 4, 2023, 4:21:25 PM
    Author     : Nick Boudreaux
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
<html lang="en">
    <head>
        <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login</title>
        <link rel="stylesheet" href="style.css">
        <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">
        <script>
            //Function to validate customer id and password
            function validateForm(){
                let email = document.forms["login-form"]["email"].value;
                let password = document.forms["login-form"]["userpw"].value;
            //Pop-up a message if customerid or password is empty 
                if(email === "" || password === ""){
                    alert("Please enter a valid Email and password.");
                    return false;
                }    
            }
        </script>
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
                <a href="login.jsp" style="float: right">login</a>
            </nav>
        </header>
        <section class="home" id="home">
            <form action="LoginServlet" method="post" id="login-form" name="login-form" onsubmit="return validateForm()">
                <h1 style="text-align: center; font-weight: bolder; font-size: 25px">Login</h1>
                
                <label for="email">Email:</label><br>
                <input type="email" id="email" name="email" placeholder="Email"><br>
                
                <label for="userpw">Password:</label><br>
                <input type="password" id="userpw" name="userpw" placeholder="Password"><br>
                
                <input class="btn" type="submit" value="Login">
                <p>Don't have an account with us? <a href="createAccount.jsp">Create one!</a></p>
            </form>
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