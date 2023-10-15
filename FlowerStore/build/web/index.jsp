<%-- 
    Document   : index
    Created on : Oct 11, 2023, 1:46:56 PM
    Author     : Jose V Gomez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Atlanta Flowers.</title>
        <link rel="stylesheet" href="style.css">
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
            <div class="content">
                <h3>fresh flowers</h3>
                <span>natural and beautiful flowers</span>
                <a href="product.jsp" class="btn">shop now</a>
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
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores necessitatibus, alias provident libero nam deleniti soluta iste, qui numquam incidunt perferendis! Perferendis error aperiam laudantium! Sed numquam eveniet consequatur sapiente! Lorem ipsum dolor sit, amet consectetur adipisicing elit. Praesentium harum hic culpa aperiam consequatur ipsam. Sed facere animi nemo aspernatur? Quod, ex. Voluptas, amet. At labore laudantium ex optio explicabo.</p>
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
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolore voluptatibus soluta nesciunt provident odio eveniet voluptatum minus blanditiis ipsam cumque. Atque optio nam cumque fugiat minima unde voluptatibus alias adipisci. Lorem ipsum dolor sit amet consectetur adipisicing elit. Sint consequatur adipisci labore est, quidem eaque quae, nisi ad consequuntur tempore minus dolor ipsa. Corrupti facere modi ad architecto pariatur enim!</p>
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
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolore voluptatibus soluta nesciunt provident odio eveniet voluptatum minus blanditiis ipsam cumque. Atque optio nam cumque fugiat minima unde voluptatibus alias adipisci. Lorem ipsum dolor sit amet consectetur adipisicing elit. Sint consequatur adipisci labore est, quidem eaque quae, nisi ad consequuntur tempore minus dolor ipsa. Corrupti facere modi ad architecto pariatur enim!</p>
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
                        <a href="#">Georgia</a>
                        <a href="#">Florida</a>
                        <a href="#">Tennessee</a>
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