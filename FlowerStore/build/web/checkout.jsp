<%-- 
    Document   : checkout
    Created on : Oct 4, 2023, 12:38:25 PM
    Author     : lena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="checkout.css">
    </head>
    <header>
        <input type="checkbox" name="" id="toggler">
        <label for="toggler" class="fas fa-bars"></label>
		<a href="#" class="logo">flower<span>.</span></a>
		<nav class="navbar">
			<a href="index.jsp">home</a>
			<a href="#about">about</a>
			<a href="#products">products</a>
			<a href="#review">review</a>
			<a href="#contact">contact</a>
		</nav>
		<div class="icons">
			<a href="#" class="fas fa-heart"></a>
			<a href="#" class="fas fa-shopping-cart"></a>
			<a href="#" class="fas fa-user"></a>
		</div>
    </header>
    <body>
        <h1> Complete Your Purchase </h1>
<div class="row">
  <div class="col-100">
    <div class="container">

        <div class="row">
          <div class="col-75">
            <h2>Billing Address</h2>
            <label for="fname">Full Name</label>
            <input type="text" id="fname" name="firstname" placeholder="John M. Doe">
            <label for="email">Email</label>
            <input type="text" id="email" name="email" placeholder="john@example.com">
            <label for="adr">Address</label>
            <input type="text" id="adr" name="address" placeholder="542 W. 15th Street">
            <label for="city">City</label>
            <input type="text" id="city" name="city" placeholder="New York">

            <div class="row">
              <div class="col-75">
                <label for="state">State</label>
                <input type="text" id="state" name="state" placeholder="NY">
              </div>
              <div class="col-75">
                <label for="zip">Zip</label>
                <input type="text" id="zip" name="zip" placeholder="10001">
              </div>
            </div>
            <h2>Shipping Address</h2>
            <label for="fname">Full Name</label>
            <input type="text" id="fname" name="firstname" placeholder="John M. Doe">
            <label for="email">Email</label>
            <input type="text" id="email" name="email" placeholder="john@example.com">
            <label for="adr">Address</label>
            <input type="text" id="adr" name="address" placeholder="542 W. 15th Street">
            <label for="city">City</label>
            <input type="text" id="city" name="city" placeholder="New York">

            <div class="row">
              <div class="col-75">
                <label for="state">State</label>
                <input type="text" id="state" name="state" placeholder="NY">
              </div>
              <div class="col-75">
                <label for="zip">Zip</label>
                <input type="text" id="zip" name="zip" placeholder="10001">
              </div>
            </div>
          </div>

          <div class="col-75">
            <h2>Payment</h2>
            <label for="cname">Name on Card</label>
            <input type="text" id="cname" name="cardname" placeholder="John More Doe">
            <label for="ccnum">Credit card number</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
            <label for="expmonth">Exp Month</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="September">

            <div class="row">
              <div class="col-75">
                <label for="expyear">Exp Year</label>
                <input type="text" id="expyear" name="expyear" placeholder="2018">
              </div>
              <div class="col-75">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="352">
              </div>
             
             <div class="col-75">   
              <h2>Order Detail</h2>
              <div class="prices">
	
      <p><a href="#">Peony Mother's Day</a> <span class="price">$30</span></p>
      <p><a href="#">Roses Daffodil Princess Theme</a> <span class="price">$15</span></p>
      <p><a href="#">Variety Mix Summer</a> <span class="price">$25</span></p>
      <p>Total <span class="price" style="color:black"><b>$70</b></span></p>  
        </div>
              
      <a href="success.jsp" class="button">Place your Order</a>
             </div>
            </div>
          </div>

        </div>
    </div>
  </div>

</body>
</html>