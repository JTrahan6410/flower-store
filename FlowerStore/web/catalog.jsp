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
        <link rel="stylesheet" type ="text/css" href="catalogStyle.css">
    </head>
    <body>
        <header>
            <a href="index.jsp" class="logo">Atlanta flowers<span>.</span></a>
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <a href="catalog.jsp">products</a>
                <a href="catalog.jsp">cart</a>
        <% 
            HttpSession session1 = request.getSession(false);
            if(session1 == null || session1.getAttribute("u1") == null){
        %>
                <a href="login.jsp" style="float: right">login</a>
        <%
            }else{
        %>
                <a href="account.jsp">account</a> |
                <a href="LogoutServlet" style="float: right">logout</a>
        <%}%>
            </nav>
        </header>
        <h1>Products</h1>
        <div class="collection">
            <div class="product">
                <a href=#><img class="product__image" src="assets/flowers/roses.png" style="width:20em; height: 20em;"></a>
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
                <a href=#><img class="product__image" src="assets/flowers/tulips.png" style="width:20em; height:20em;"> </a>
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
                <a href=#><img class="product__image" src="assets/flowers/sunflowers.png" style="width:20em; height: 20em;"> </a>
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
                <a href=#><img class="product__image" src="assets/flowers/lilies.png" style="width:20em; height: 20em;"> </a>
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
                <a href=#><img class="product__image" src="assets/flowers/orchids.png" style="width:20em; height: 20em;"> </a>
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
                <a href=#><img class="product__image" src="assets/flowers/iris.png" style="width:20em; height: 20em;"> </a>
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
                <a href=#><img class="product__image" src="assets/flowers/daisies.png" style="width:20em; height: 20em;"> </a>
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
                <a href=#><img class="product__image" src="assets/flowers/peonies.png" style="width:20em; height: 20em;"> </a>
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
                <a href=#><img class="product__image" src="assets/flowers/daffodils.png" style="width:20em; height: 20em;"> </a>
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
