<%-- 
    Document   : createAccount
    Created on : Oct 4, 2023, 4:23:35 PM
    Author     : Nick Boudreaux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Create Account</title>
        <link rel="stylesheet" href="style.css">
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
            <a href="index.jsp" class="logo">Atlanta flowers<span>.</span></a>
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <a href="product.jsp">products</a>
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