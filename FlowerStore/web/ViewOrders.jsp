<%-- 
    Document   : ViewOrders
    Created on : Oct 29, 2023
    Author     : Trent cargl
--%>
<%@page import="Business.Product"%>
<%@page import="Business.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewpart" content="width=device-width, intital-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <title>Orders Page</title>
    </head>
    <body>
        <header>
            <a href="index.html" class="logo">Atlanta flowers<span>.</span></a>
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <a href="catalog.jsp">products</a>
                <a href="catalog.jsp">cart</a>
            </nav>
	</header>
            <% 
            Order o1;
            o1 = (Order)session.getAttribute("o1");
            %>
            <div id="orders-box">
                <h2>Pending Orders</h2>
                <table id="orders-table">
                   <tr>

                        <th>Order ID</th>
                        <th>User ID</th>
                        <th>Product Code</th>
                        <th>Order Date</th>
                        <th>Mail Name</th>
                        <th>Street Address</th>
                        <th>Mail City</th>
                        <th>Mail State</th>
                        <th>Mail Zip</th>
                        <th>Billing Name</th>
                        <th>Billing Street Addr.</th>
                        <th>Billing City</th>
                        <th>Billing State</th>
                        <th>billing Zip</th>
                    </tr>
                    <%for(Order o:Orders){%>
                    <tr>

                        <td><%=o1.getorderID()%></td>
                        <td><%=p1.getProductName()%></td>
                        <td><%=p1.getProductCost()%></td>
                        <td><%=o1.getorderPlaced()%></td>
                    </tr> 
                    <%}%>
                </table>
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
                    <a href="#">Mumbai,India -400104</a>
                    <img src="assets/pymnt-1.jpg" alt="">
                </div>
            </div>
            <div class="credit"> created by <span> Group 2 CIST 2931 </span> | all rights reserved </div>
        </section>
    </body>
</html>
