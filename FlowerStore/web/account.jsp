<%-- 
    Document   : account
    Created on : Sep 9, 2023, 10:20:31 AM
    Author     : cargle
--%>

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
            <input type="checkbox" name="" id="toggler">
            <label for="toggler" class="fas fa-bars"></label>
            <a href="#" class="logo">flower<span>.</span></a>
            <nav class="navbar">
		<a href="index.html">home</a>
		<a href="#about">about</a>
		<a href="#products">products</a>
		<a href="#review">review</a>
		<a href="#contact">contact</a>
            </nav>
            <div class="icons">
		<a href="#" class="fas fa-heart"></a>
		<a href="#" class="fas fa-shopping-cart"></a>
		<a href="account.jsp" class="fas fa-user"></a>
            </div>
	</header>
        
        <section class="orderSec">
        <h1>Hello, User</h1>
        <h2>Account Details</h2>
        <form action="#editaccount">
            <div class="account_info">  
                <ul>User ID: </ul>
                <ul>Full Name: </ul>
                <ul>Email: </ul>
                <ul>Address: </ul>
                <ul>Payment Method: </ul>
            </div>
            <br>
            <button class="btn btn-secondary">Edit Information</button>
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
