<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatable" content="IE=edge">
  <meta name="viewpart" content="width=device-width, intital-scale=1.0">
  <title>Billing Page</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <header>
    <a href="index.html" class="logo">Atlanta flowers<span>.</span></a>
    <nav class="navbar">
      <a href="index.html">home</a> <a href="#about">about</a> <a href="product.jsp">products</a> <a href="#review">review</a> <a href="#contact">contact</a>
    </nav>
    <div class="icons">
      <a href="#" class="fas fa-heart"></a> <a href="billingPage.html" class="fas fa-shopping-cart"></a> <a href="login.html" class="fas fa-user"></a>
    </div>
  </header>
  <div class="container">
    <form action="">
      <div class="row">
        <div class="col">
          <h3 class="title">billing address</h3>
          <div class="inputBox">
            <span>full name :</span> <input type="text" placeholder="Billy Bob">
          </div>
          <div class="inputBox">
            <span>email :</span> <input type="email" placeholder="123@email.com">
          </div>
          <div class="inputBox">
            <span>address :</span> <input type="text" placeholder="room - street- location">
          </div>
          <div class="inputBox">
            <span>city :</span> <input type="text" placeholder="Atlanta">
          </div>
          <div class="flex">
            <div class="inputBox">
              <span>state :</span> <input type="text" placeholder="Georgia">
            </div>
            <div class="inputBox">
              <span>zip code:</span> <input type="text" placeholder="123">
            </div>
          </div>
        </div>
        <div class="col">
          <h3 class="title">payment</h3>
          <span>Cards Accepted: </span>
          <img src="assets/pymnt-1.jpg" alt="Vista, Mastercard, Discover, American Express">
          <div class="inputBox">
            <span>name on card :</span> <input type="text" placeholder="mr. Billy Bob">
          </div>
          <div class="inputBox">
            <span>credit card number :</span> <input type="number" placeholder="1111-2222-3333-4444">
          </div>
          <div class="inputBox">
            <span>exp month :</span> <input type="text" placeholder="January">
          </div>
          <div class="flex">
            <div class="inputBox">
              <span>exp year :</span> <input type="text" placeholder="2020">
            </div>
            <div class="inputBox">
              <span>CVV:</span> <input type="text" placeholder="123">
            </div>
          </div>
        </div>
      </div><input type="submit" value="proceed to checkout" class="submit-btn">
    </form>
  </div>
</body>
</html>