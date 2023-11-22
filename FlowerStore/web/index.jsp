<%-- 
    Document   : index
    Created on : Oct 11, 2023, 1:46:56 PM
    Author     : Destiny / Jose
--%>
<%@page import="Business.*"%>
<%@page import="Connection.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if(cart_list != null){
        Product prod1 = new Product(DbCon.getConnection());
        cartProduct = prod1.getCartProducts(cart_list);
        request.setAttribute("cart_list", cart_list);

    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Atlanta Flowers.</title>
        <link rel="stylesheet" href="style.css">
        <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <header>
            <a href="index.jsp" class="logo">Atlanta Flowers<span>.</span></a>
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <a href="ViewOrders.jsp">orders</a>
                <a href="catalog.jsp">products</a>
        <% if(cart_list!=null){%>
                <a href="cart.jsp">cart<i class="fa badge fa-shopping-cart" value=${ cart_list.size() }></i></a>
        <% }else{%>
                <a href="cart.jsp">cart<i class="fa fa-shopping-cart" value=${ cart_list.size() }></i></a>
         <%} %>    
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
        <section class="home" id="home">
            <div class="content">
                <h3>fresh flowers</h3>
                <span>natural and beautiful flowers</span>
                <a href="catalog.jsp" class="btn">shop now</a>
            </div>
        </section>
        <section class="about" id="about">
            <h1 class="heading"> <span> about </span> us </h1>
            <div class="row">
                <div class="video-container">
                    <video src="assets/vid-1.mp4" loop autoplay muted></video>
                    <h3>best flower sellers</h3>
                </div>
                <div class="content">
                    <h3>Why choose us?</h3>
                    <p>Atlanta Flowers offers beautiful, fresh flower arrangements in Atlanta, GA. Our expert florists create the perfect floral gifts to suit any special occasion and offer quick and easy floral delivery throughout the nation for your convenience. Need flowers delivered across the country? Atlanta Flowers’s trusted network of florists deliver nationwide! Ordering beautiful, fresh flowers with Atlanta Flowers is easy and convenient. Browse our website to find the perfect floral gift. You can trust our professional florists to arrange a beautiful bouquet for your special occasion.</p>
                    <a href="#" class="btn">Learn More</a>
                </div>
            </div>
        </section>
        <section class="icons-container">
            <div class="icons">
                <img src="assets/message.png" alt="message">
                <div class="info"></div>
                <h3>free delivery</h3>
                <span>on all orders</span>
            </div>
            <div class="icons">
                <img src="assets/money-bag.png" alt="money-bag">
                <div class="info"></div>
                <h3>10 day returns</h3>
                <span>money back guarantee</span>
            </div>
            <div class="icons">
                <img src="assets/credit-card.png" alt="credit-card">
                <div class="info"></div>
                <h3>secure payments</h3>
                <span>protected by paypal</span>
            </div>
        </section>
        <section class="products" id="products">
            <h1 class="heading"> latest <span>products</span></h1>
            <div class="box-container">
                <div class="box">
                    <span class="discount"> -10%</span>
                    <div class="image">
                        <img src="assets/img-flwr-3.jpg" alt="">
                        <div class="icons">
                            <a href="#" class="fas fa-heart"></a>
                            <a href="#" class="cart-btn">add to cart</a>
                            <a href="#" class="fas fa-share"></a>
                        </div>
                    </div>
                    <div class="content">
                        <h3>flower pot</h3>
                        <div class="price"> $12.00 <span>$15.99</span></div>
                    </div>
                </div>
                <div class="box">
                    <span class="discount"> -5%</span>
                    <div class="image">
                        <img src="assets/img-flwr-2.jpg" alt="">
                        <div class="icons">
                            <a href="#" class="fas fa-heart"></a>
                            <a href="#" class="cart-btn">add to cart</a>
                            <a href="#" class="fas fa-share"></a>
                        </div>
                    </div>
                    <div class="content">
                        <h3>flower pot</h3>
                        <div class="price"> $12.00 <span>$15.99</span></div>
                    </div>
                </div>
                <div class="box">
                    <span class="discount"> -20%</span>
                    <div class="image">
                        <img src="assets/img-flwr-4.jpg" alt="">
                        <div class="icons">
                            <a href="#" class="fas fa-heart"></a>
                            <a href="#" class="cart-btn">add to cart</a>
                            <a href="#" class="fas fa-share"></a>
                        </div>
                    </div>
                    <div class="content">
                        <h3>flower pot</h3>
                        <div class="price"> $12.00 <span>$15.99</span></div>
                    </div>
                </div>
            </div>
        </section>
        <section class="review" id="review">
            <h1 class="heading"> customer's <span>review</span></h1>
            <div class="box-container">
                <div class="box">
                    <div class="starts">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <p>These flowers are beautiful and just as vibrant as the picture. One of the most beautiful bouquets I have ever seen!</p>
                    <div class="user">
                        <img src="assets/smiling-lady.jpg" alt="">
                        <div class="user-info">
                            <h3>Lilly Jones</h3>
                            <span>happy customer</span>
                        </div>
                    </div>
                    <span class="fas fa-quote-right"></span>
                </div>
                <div class="box">
                    <div class="starts">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <p>Spectacular arrangement that lasted forever! The flowers were beautiful, super fresh and arrived right on time. You may think it pricey but when you realize the flowers last for weeks, it’s not at all pricey. I will surely use them for all my future orders.</p>
                    <div class="user">
                        <img src="assets/smiling-man.jpg" alt="">
                        <div class="user-info">
                            <h3>Thomas Anderson</h3>
                            <span>happy customer</span>
                        </div>
                    </div>
                    <span class="fas fa-quote-right"></span>
                </div>
            </div>
        </section>
        <!--<section class="contact" id="contact">
            <h1 class="heading"> <span> contact  </span> us</h1>
            <div class="row">
                 <form action="">
                    <input type="text" placeholder="name" class="box">
                    <input type="email" placeholder="email" class="box">
                    <input type="number" placeholder="number" class="box">
                    <textarea name="" class="box" placeholder="message"  id=""  cols="30" rows="10"></textarea>
                    <input type="submit" value="send message" class="btn">
                </form>
                <div class="image">
                    <img src="img-grl-flwr-2.jpg" alt="">
                </div>
            </div>
        </section>-->
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
                        <a href=“tel:404-123-4567”>404-123-4567</a>
                        <a href="mailto:help@atlflowers.com">help@atlflowers.com</a>
                        <a href="#">Atlanta, GA 30116</a>
                        <img src="assets/pymnt-1.jpg" alt="">
                </div>
            </div>
            <div class="credit"> created by <span> Group 2 CIST 2931 </span> | all rights reserved </div>
        </section>
    </body>
</html>