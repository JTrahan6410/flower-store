<%-- 
    Document   : ViewOrders
    Created on : Nov 12, 2023
    Author     : Trent cargle
--%>

<%@page import="java.util.List"%>
<%@page import="Business.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewpart" content="width=device-width, intital-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="accountStyle.css">
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
            
            o1.getAllOrders();
            %>
             <div id="orders-box">
                <h2 id="pending-Orders">Pending Orders</h2>
                <table id="orders-table">
                    <%-- Instantiate object and call method to get all orders --%>
                    <% 
                        Order o1 = new Order();
                        List<Order> Orders = o1.getAllOrders();
                    %>
                   <tr>
                        <th>Order ID</th>
                        <th>Email</th>
                        <th>Product Code</th>
                        <th>Order Date</th>
                        <th>Requested Delivery</th>
                        <th>Mail Name</th>
                        <th>Mail Street Addr.</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Zip</th>
                        <th>Billing Name</th>
                        <th>Billing Street Addr.</th>
                        <th>Billing City</th>
                        <th>Billing State</th>
                        <th>billing Zip</th>
                        <th>Status</th>
                    </tr>
                    <%-- Table to display all orders in the database --%>
                    <%for(Order o:Orders){%>
                    <tr>
                       <td><%=o1.getorderID()%></td>
                        <td><%=o1.getemail()%></td>
                        <td><%=o1.getproductCode()%></td>
                        <td><%=o1.getorderPlaced()%></td>
                        <td><%=o1.getrequestedDelivery()%></td>
                        <td><%=o1.getmailName()%></td>
                        <td><%=o1.getmailStreetAddress()%></td>
                        <td><%=o1.getmailCity()%></td>
                        <td><%=o1.getmailState()%></td>
                        <td><%=o1.getmailZip()%></td>
                        <td><%=o1.getbillName()%></td>
                        <td><%=o1.getbillStreetAddress()%></td>
                        <td><%=o1.getbillCity()%></td>
                        <td><%=o1.getbillState()%></td>
                        <td><%=o1.getbillZip()%></td>
                        <%-- Status drop down menu  open/ready/delivered --%>
                        <td><select style="width:101%" name="status" id="status-menu">
                        <option value="Open">Open</option> 
                        <option value="Ready">Ready</option> 
                        <option value="Delivered">Delivered</option> 
                    </select<%--=o1.getStatus()--%></td> 
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
