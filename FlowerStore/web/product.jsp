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
    <body>
        <h1> The Flower Market </h1>
        <div class="navbar">
            <a href="#home">Home</a>
            <a href="#about">About</a>
            <div class ="dropdown">
                <button class="dropbtn">Occasions
                    <i class="fa fa-caret-down"></i>
                </button>
                    <div class="dropdown-content">
                        <a href="#">Anniversary</a>
                        <a href="#">Birthday</a>
                        <a href="#">Condolences</a>
                        <a href="#">Congratulation</a>
                    </div>
            </div>    
            <a href="#product">Product</a>
            <a href="#review">Review</a>
            <a href="#contact">Contact</a>
            <a href="#login">Login</a>
            <input type="text" placeholder="Search..">
        </div>
        <h2> Flowers </h2>
        <div class="collection">
            <div class="product">
                <a href="Roses.html"><img class="product__image" src="roses.png" style="width:20em; height: 20em;"></a>
                <div class="product__name">
                    <p>
                        <a>Roses</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href="Tulips.html"><img class="product__image" src="tulips.png" style="width:20em; height:20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Tulips</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href="Sunflowers.html"><img class="product__image" src="sunflowers.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Sunflowers</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href="Lilies.html"><img class="product__image" src="lilies.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Lilies</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href="Orchids.html"><img class="product__image" src="orchids.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Orchids</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href="Iris.html"><img class="product__image" src="iris.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Iris</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href="Daisies.html"><img class="product__image" src="daisies.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Daisies</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p>
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href="Peonies.html"><img class="product__image" src="peonies.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Peonies</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p> 
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
            <div class="product">
                <a href="Daffodils.html"><img class="product__image" src="daffodils.png" style="width:20em; height: 20em;"> </a>
                <div class="product__name">
                    <p>
                        <a>Daffodils</a>
                    </p>
                </div>
                <div class="product__price">
                    <p>$35.00</p> 
                    <p><button> Add to Cart </button></p>
                </div>
            </div>
        </div>
    </body>
</html>
