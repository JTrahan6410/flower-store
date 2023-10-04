<%-- 
    Document   : login
    Created on : Oct 4, 2023, 4:21:25 PM
    Author     : Nick Boudreaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UFT-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="style.css">
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
			<a href="#" class="fas fa-user"></a>
		</div>
    </header>
	
    <section class="home" id="home">
        <div class="login-form">
            <div class="heading">
		<h2>Login</h2>
            </div>
            <form>
                <table>
                    <tr>
                        <td><label for="username">Username:</label></td>
                        <td><input type="text" id="username" placeholder="Enter your username"></td>
                    </tr>
                    <tr>
                        <td><label for="password">Password:</label></td>
                        <td><input type="password" id="password" placeholder="Enter your password"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><button class="btn" type="submit">Login</button></td>
                    </tr>
                </table>
                <br>
                <a href="#forgotPassword">Forgot Password?</a>
                <p>Don't have an account with us? <a href="createAccount.html">Create one!</a></p>
            </form>
        </div>
    </section>
	
	<section class="footer">
		<div class="box-container">
			<div class="box">
				<h3>quick links</h3>
				<a href="index.html">home</a>
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
				<a href="#">india</a>
				<a href="#">USA</a>
				<a href="#">japan</a>
				<a href="#">france</a>
			</div>
			<div class="box">
				<h3>contact info</h3>
				<a href="#">+123-456-7890</a>
				<a href="#">example@email.com</a>
				<a href="#">mumbai,india -400104</a>
				<img src="pymnt-1.jpg" alt="">
			</div>
		</div>
	</section>
</body>
</html>
