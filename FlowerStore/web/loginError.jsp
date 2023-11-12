<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
<!--added-->

    <meta http-equiv="X-UA-Compatable" content="IE=edge">
    <meta name="viewpart" content="width=device-width, intital-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<!--added-->

    <title>Error Page</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <a href="index.jsp" class="logo">Atlanta Flowers<span>.</span></a>
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <a href="catalog.jsp">products</a>
                <a href="cart.jsp">cart</a>
                <a href="login.jsp" style="float: right">login</a>
            </nav>
    </header>
<!--added-->
<div class="container">
        <h1 class="heading"> <span> Login </span> Error </h1>
        <div class="content">
            <!--<h1>404</h1>-->
          
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolore magnam reprehenderit suscipit blanditiis, voluptatum minima voluptatibus ex velit itaque libero, omnis doloremque explicabo natus, illum laboriosam voluptates illo adipisci saepe.</p>
            <div class="btns">
                <a href="#">return homepage</a>
                <a href="#">return to Login</a>
             </div>
        </div>
</div>
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