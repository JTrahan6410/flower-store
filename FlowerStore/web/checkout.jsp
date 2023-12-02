<%--
    Document   : checkout
    Created on : Oct 4, 2023, 12:38:25 PM
    Author     : lena
--%>

<%@page import="Business.*"%>
<%@page import="Connection.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if(cart_list != null){
        Product prod1 = new Product(DbCon.getConnection());
        cartProduct = prod1.getCartProducts(cart_list);
        double total = prod1.getTotalCartPrice(cart_list);
        request.setAttribute("total", total);
        request.setAttribute("cart_list", cart_list);

    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="checkoutStyle.css">
        <script>
            function toggleGreetingCardTextbox() {
            var checkbox = document.getElementById("greetingCardCheckbox");
            var textbox = document.getElementById("greetingCardMessage");

            textbox.disabled = !checkbox.checked; // Disable if checkbox is not checked
            if(!checkbox.checked) {
                textbox.value = ''; // Clear the text box if checkbox is unchecked
            }
        }
        </script>
    </head>
    <header>
            <a href="index.jsp" class="logo">Atlanta Flowers<span>.</span></a>
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <a href="catalog.jsp">products</a>
                <% if(cart_list != null && !cart_list.isEmpty()){ %>
                    <a href="cart.jsp">cart<i class="fa badge fa-shopping-cart">${ cart_list.size() }</i></a>
                <% } else { %>
                    <a href="cart.jsp">cart<i class="fa fa-shopping-cart"></i></a>
                <% } %>
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
<body>
<div class="row">
  <div class="col-75">
    <div class="container1">
      <form action="CheckoutServlet" method="post">
        <div class="row">
          <!-- Billing Address Section -->
            <div class="col-50">
            <h3>Billing Address</h3>
            <br>
            <label for="fname"><i class="fa fa-user"></i> First Name</label>
            <input type="text" id="fname" name="firstname" placeholder="John">
            <label for="lname"><i class="fa fa-user"></i> Last Name</label>
            <input type="text" id="lname" name="lasttname" placeholder="Doe">
            <label for="email"><i class="fa fa-envelope"></i> Email</label>
            <input type="text" id="email" name="email" placeholder="john@example.com">
            <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
            <input type="text" id="adr" name="address" placeholder="542 W. 15th Street">
            <label for="city"><i class="fa fa-institution"></i> City</label>
            <input type="text" id="city" name="city" placeholder="New York">
            <div class="row">
              <div class="col-50">
                <label for="state">State</label>
                <select class="select-box" id="state" name="state" required>
                <option value="" disabled selected>State</option>
                <option value="GA">Georgia</option>
                <option value="FL">Florida</option>
                <option value="TN">Tennessee</option>
                <option value="AL">Alabama</option>
            </select>
              </div>
              <div class="col-50">
                <label for="zip">Zip</label>
                <input type="text" id="zip" name="zip" placeholder="10001">
              </div>
            </div>
          </div>

          <!-- Payment Section -->
          <div class="col-50">
            <h3>Payment</h3>
            <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
            <!-- Name on card not used, pulls from userID -->
            <label for="cardName">Name on Card</label>
            <input type="text" id="cardName" name="cardName" placeholder="John More Doe">
            <label for="cardNumber">Credit Card Number</label>
            <input type="text" id="cardNumber" name="cardNumber" placeholder="1111-2222-3333-4444">
            <label for="cardCVV">CVV</label>
            <input type="text" id="cardCVV" name="cardCVV" placeholder="352">
            <label for="expiry">Card Expiry</label>
            <div class="select-box-container">
            <select class="select-box" id="month" name="month">
                <option value="" disabled selected>Month</option>
                <option value="1">01</option>
                <option value="2">02</option>
                <option value="3">03</option>
                <option value="4">04</option>
                <option value="5">05</option>
                <option value="6">06</option>
                <option value="7">07</option>
                <option value="8">08</option>
                <option value="9">09</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </select>
            <span class="date-separator">/</span>
            <select class="select-box" id="year" name="year">
                <option value="" disabled selected>Year</option>
                <option value="2023">23</option>
                <option value="2024">24</option>
                <option value="2025">25</option>
                <option value="2026">26</option>
                <option value="2027">27</option>
                <option value="2028">28</option>
            </select>
            </div>
          </div>
        </div>
        <label>
          <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
        </label>
        <input type="submit" value="Continue to checkout" class="btn">
      </form>
    </div>
  </div>
  <div class="col-25">
    <div class="container1">
      <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>${ cart_list.size() }</b></span></h4>
      <% if(cart_list != null){
      for(Cart c:cartProduct){%>
      <p><a href="#"><%= c.getProductName() %></a> <span class="price">$<%= dcf.format(c.getProductCost()) %></span></p>
       <%}
         }%>
      <hr>
      <p>Total <span class="price" style="color:black"><b>$ ${ (total>0)?dcf.format(total):0 }</b></span></p>

      <br>
      <form>
          <div class="checkbox-container">
            <!-- Checkbox for adding a greeting card -->
            <input type="checkbox" id="greetingCardCheckbox" onclick="toggleGreetingCardTextbox()">
            <label for="greetingCardCheckbox">Add a custom greeting card for $1?</label>
            </div>
            <!-- Text box for greeting card message -->
            <!--<textarea class="resize-y rounded-md" id="greetingCardMessage" placeholder="Your greeting card message" disabled> </textarea>-->
            <input type="text" id="greetingCardMessage" placeholder="Your greeting card message" disabled>

      </form>
      
      <label for="deliveryDate">Requested Delivery Date:</label>
      <input type="date" id="deliveryDate" name="deliveryDate"> 
      
    </div>

  </div>
</div>
<section class="footer">
            <div class="box-container">
                <div class="box">
                    <h3>quick links</h3>
                        <a href="index.jsp">home</a>
                        <a href="product.jsp">products</a>
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
