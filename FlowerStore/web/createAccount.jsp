<%-- 
    Document   : createAccount
    Created on : Oct 4, 2023, 4:23:35 PM
    Author     : Nick Boudreaux
--%>
<%@page import="Business.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if(cart_list != null){
        Product prod1 = new Product();
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
        <title>Create Account</title>
        <link rel="stylesheet" href="style.css">
        <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">
        <script>
            //Function to validate customer id and password
            function validateForm(){
                let x = document.forms["create-account-form"]["customerid"].value;
                let x2 = document.forms["create-account-form"]["pwd"].value;
            //Pop-up a message if customerid or password is empty 
                if(x === "" || x2 === ""){
                    alert("Must enter a valid Customer ID and password.");
                    return false;
                }    
            //Pop-up a message when customerid is not a number
                if(isNaN(x)){
                    alert("Customer ID must be a number.");
                    return false;
                }
            //Pop-up a message when customer id is not a number between 3000 and 3999
                if(x < 3000 || x > 3999){
                    alert("Customer ID must be numbers between 3000 and 3999");
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
            <form action="CreateAccountServlet" method="post" id="create-account-form" name="create-account-form" onsubmit="return validateForn()">
                <h1 style="text-align: center; font-weight: bolder; font-size: 25px">Create Account</h1>
                
                <label for="firstname">First Name:</label>
                <input type="text" id="firstname" name="firstname" placeholder="First Name"><br>
                
                <label for="lastname">Last Name:</label>
                <input type="text" id="lastname" name="lastname" placeholder="Last Name"><br>
                
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Email"><br>
                
                <label for="password">Password:</label>
		<input type="password" id="password" name="password" placeholder="Password"><br>
                
                <input class="btn" type="submit" value="Create"><br>
		<p>Already have an account with us? <a href="login.jsp">Click here to log in!</a></p>
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
                        <a href=“tel:4041234567”>404-123-4567</a>
                        <a href="mailto:help@atlflowers.com">help@atlflowers.com</a>
                        <a href="#">Atlanta, GA 30116</a>
                        <img src="assets/pymnt-1.jpg" alt="">
                </div>
            </div>
            <div class="credit"> created by <span> Group 2 CIST 2931 </span> | all rights reserved </div>
        </section>
</body>
</html>