<%-- 
    Document   : product
    Created on : Sep 2, 2023, 9:29:59 PM
    Author     : lena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <link rel="stylesheet" type ="text/css" href="style.css">
    </head>
        <header>
            <a href="index.jsp" class="logo">Atlanta flowers<span>.</span></a>
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <a href="catalog.jsp">products</a>
                <a href="login.jsp" style="float: right">login</a>
            </nav>
        </header>
    <body> 

        <h1 style="font-size: 40px; font-family: Arial, Helvetica, sans-serif;">Products</h1>

        <div class="table">
            <div>
                <a href=#><img src="assets/flowers/roses.png" style="width:20em; height: 20em; border: 3px solid #000000;"></a>
                <div>
                    <p><a style="text-align: center; font-size: 30px; font-family: Arial, Helvetica, sans-serif;">Roses</a></p>
                </div>
                <div>
                    <p style="font-size: 20px; font-family: Arial, Helvetica, sans-serif;">$45.00</p>
                    <p><button> Add to Cart </button></p>                  
                </div>
            </div>
            <div>
                <a href=#><img src="assets/flowers/tulips.png" style="width:20em; height:20em; border: 3px solid #000000;"> </a>
                <div>
                    <p><a style="text-align: center; font-size: 30px; font-family: Arial, Helvetica, sans-serif;">Tulips</a></p>
                </div>
                <div>
                    <p style="font-size: 20px; font-family: Arial, Helvetica, sans-serif;">$35.00</p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div>
                <a href=#><img src="assets/flowers/sunflowers.png" style="width:20em; height: 20em; border: 3px solid #000000;"> </a>
                <div>
                    <p><a style="text-align: center; font-size: 30px; font-family: Arial, Helvetica, sans-serif;">Sunflowers</a></p>
                </div>
                <div>
                    <p style="font-size: 20px; font-family: Arial, Helvetica, sans-serif;">$25.00</p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div>
                <a href=#><img src="assets/flowers/lilies.png" style="width:20em; height: 20em; border: 3px solid #000000;"> </a>
                <div>
                    <p><a style="text-align: center; font-size: 30px; font-family: Arial, Helvetica, sans-serif;">Lilies</a></p>
                </div>
                <div>
                    <p style="font-size: 20px; font-family: Arial, Helvetica, sans-serif;">$20.00</p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div>
                <a href=#><img rc="assets/flowers/orchids.png" style="width:20em; height: 20em; border: 3px solid #000000;"> </a>
                <div>
                    <p><a style="text-align: center; font-size: 30px; font-family: Arial, Helvetica, sans-serif;">Orchids</a></p>
                </div>
                <div>
                    <p style="font-size: 20px; font-family: Arial, Helvetica, sans-serif;">$30.00</p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div>
                <a href=#><img src="assets/flowers/iris.png" style="width:20em; height: 20em; border: 3px solid #000000;"> </a>
                <div>
                    <p><a style="text-align: center; font-size: 30px; font-family: Arial, Helvetica, sans-serif;">Iris</a></p>
                </div>
                <div>
                    <p style="font-size: 20px; font-family: Arial, Helvetica, sans-serif;">$35.00</p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div>
                <a href=#><img src="assets/flowers/daisies.png" style="width:20em; height: 20em; border: 3px solid #000000;"> </a>
                <div>
                    <p><a style="text-align: center; font-size: 30px; font-family: Arial, Helvetica, sans-serif;">Daisies</a></p>
                </div>
                <div>
                    <p style="font-size: 20px; font-family: Arial, Helvetica, sans-serif;">$15.00</p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div>
                <a href=#><img src="assets/flowers/peonies.png" style="width:20em; height: 20em; border: 3px solid #000000;"> </a>
                <div>
                    <p><a style="text-align: center; font-size: 30px; font-family: Arial, Helvetica, sans-serif;">Peonies</a></p>
                </div>
                <div>
                    <p style="font-size: 20px; font-family: Arial, Helvetica, sans-serif;">$40.00</p> 
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div>
                <a href=#><img src="assets/flowers/daffodils.png" style="width:20em; height: 20em; border: 3px solid #000000;"> </a>
                <div>
                    <p><a style="text-align: center; font-size: 30px; font-family: Arial, Helvetica, sans-serif;">Daffodils</a></p>
                </div>
                <div>
                    <p style="font-size: 20px; font-family: Arial, Helvetica, sans-serif;">$25.00</p> 
                    <p><button> Add to Cart </button></p>
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
                    <a href="#">mumbai,india -400104</a>
                    <img src="assets/pymnt-1.jpg" alt="">
                </div>
            </div>
            <div class="credit"> created by <span> Group 2 CIST 2931 </span> | all rights reserved </div>
    </body>
</html>
