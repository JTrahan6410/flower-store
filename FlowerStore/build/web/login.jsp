<%-- 
    Document   : login
    Created on : Oct 4, 2023, 4:21:25 PM
    Author     : Nick Boudreaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login</title>
        <link rel="stylesheet" href="style.css">
        <script>
            //Function to validate customer id and password
            function validateForm(){
                let x = document.forms["login-form"]["email"].value;
                let x2 = document.forms["login-form"]["userpw"].value;
            //Pop-up a message if customerid or password is empty 
                if(x === "" || x2 === ""){
                    alert("Please enter a valid Email and password.");
                    return false;
                }    
            }
        </script>
    </head>
    <body>
        <header>
            <a href="index.jsp" class="logo">Atlanta flowers<span>.</span></a>
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <a href="catalog.jsp">products</a>
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
                        <a href="index.html">home</a>
			<a href="#">about</a>
			<a href="product.jsp">products</a>
			<a href="#">review</a>
			<a href="#">contact</a>
		</div>
		<div class="box">
                    <h3>extra links</h3>
			<a href="account.jsp">my account</a>
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