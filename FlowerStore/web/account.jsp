

<%-- 
    Document   : account
    Created on : Sep 9, 2023, 10:20:31 AM
    Author     : cargle
    Adapted    : JTrahan 11/5/23, 10:18PM
--%>
<%@page import="Business.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- Fixed typos -->
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="accountStyle.css">
        <title>User Account</title>
    </head>
    <body>
        <header>
            <a href="index.html" class="logo">Atlanta flowers<span>.</span></a>
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <a href="catalog.jsp">products</a>
        <% 
            HttpSession session = request.getSession(false);
            if(session == null || session.getAttribute("u1") == null){
        %>
                <a href="login.jsp" class="nav-right">login</a> <!-- Use CSS class for styling -->
        <%
            }else{
        %>
                <a href="account.jsp">account</a> |
                <a href="LogoutServlet" class="nav-right">logout</a> <!-- Use CSS class for styling -->
        <%}%>
            </nav>
	</header>
        
        <% 
            User u1 = (User)session.getAttribute("u1");
        %>
        <div id="accounts-box">
            <h2>Welcome back, <%=u1.getFirstName()%></h2>
            <table id="accounts-table" style="width:100%">
            <caption><%=u1.getFirstName()%>'s Account</caption>
                <tr>
                    <th>Email</th>
                    <th>Password</th> <!-- Consider removing this for security reasons -->
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>
                <tr>
                    <td><%=u1.getEmail()%></td>
                    <td>********</td> <!-- Removed password display -->
                    <td><%=u1.getFirstName()%></td>
                    <td><%=u1.getLastName()%></td>
                </tr>
            </table>
            <a class="btn" href="editAccount.jsp"> edit account info </a>
        </div>
        <!-- Other sections remain unchanged -->
    </body>
</html>
