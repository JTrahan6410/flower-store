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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" type ="text/css" href="style.css">
        <link rel="stylesheet" type ="text/css" href="productStyle.css">
    </head>
            <header>
            <input type="checkbox" name="toggler" id="toggler">
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
                <a href="checkout.jsp" class="fas fa-shopping-cart"></a>
                <a href="#" class="fas fa-user"></a>
            </div>
        </header>
    <body>
        
        <h1>Products</h1>
        <div class="collection">
            <div class="product">
                <a href=#><img class="product__image" src="./flowers/roses.png" style="width:20em; height: 20em;"></a>
                <div class="product__name">
                    <p>
                        <a>Roses</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><input type="number" id="quantity" name="quantity" min="1" max="10"></p>
                    <p><button> Add to Cart </button></p>                  
                </div>
            </div>
            <div class="product">
                <a href=#><img class="product__image" src="./flowers/tulips.png" style="width:20em; height:20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Tulips</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><input type="number" id="quantity" name="quantity" min="1" max="10"></p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href=#><img class="product__image" src="./flowers/sunflowers.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Sunflowers</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><input type="number" id="quantity" name="quantity" min="1" max="10"></p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href=#><img class="product__image" src="./flowers/lilies.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Lilies</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><input type="number" id="quantity" name="quantity" min="1" max="10"></p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href=#><img class="product__image" src="./flowers/orchids.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Orchids</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><input type="number" id="quantity" name="quantity" min="1" max="10"></p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href=#><img class="product__image" src="./flowers/iris.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Iris</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><input type="number" id="quantity" name="quantity" min="1" max="10"></p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href=#><img class="product__image" src="./flowers/daisies.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Daisies</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><input type="number" id="quantity" name="quantity" min="1" max="10"></p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href=#><img class="product__image" src="./flowers/peonies.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Peonies</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p> 
                    <p><input type="number" id="quantity" name="quantity" min="1" max="10"></p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href=#><img class="product__image" src="./flowers/daffodils.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Daffodils</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p> 
                    <p><input type="number" id="quantity" name="quantity" min="1" max="10"></p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
        </div>
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
        </section>
    </body>
</html>
