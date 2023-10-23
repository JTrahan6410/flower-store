<%-- 
    Trent Cargle

   Adv Sys Project - Oct 23, 2023
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.User"%>
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
        
        <jsp:useBean id="u1" scope="session" class="Business.User"/>
        <section class="editingSec">
        <h1>Edit Account Information</h1>
         <form action="." class="editing_form">
        <table>
            <tr>
                <td>User ID: </td>
                <td class="input"><input type="text" name="uidtb"/></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td class="input"><input type="text" name="nametb" /></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td class="input"><input type="text" name="emailtb" /></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td class="input"><input type="text" name="addrtb" /></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td class="input"><input type="text" name="passtb" /></td>
            </tr>
            <tr class="button">
                <td><button class="btn btn-secondary">Submit Changes</button></td>
            </tr>
            </table>
    </form>
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
