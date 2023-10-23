<%-- 
    Document   : dynamic-catalog
    Created on : Oct 16, 2023, 2:17:36 PM
    Author     : Jake
--%>

<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Catalog</title>
</head>
<body>

<%
    try {
        // Load the UCanAccess JDBC driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        // Replace the following with your Access database connection details
        String databasePath = "../FlowerStore/FlowerStoreDatabase.accdb";
        String jdbcUrl = "jdbc:ucanaccess://" + databasePath;

        // Establish the database connection
        Connection connection = DriverManager.getConnection(jdbcUrl);

        // Execute a query to retrieve product information
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT productName, productCost, productDescription, productAsset FROM Products");

        // Iterate through the result set and display product information
        while (resultSet.next()) {
            String productName = resultSet.getString("productName");
            double productCost = resultSet.getDouble("productCost");
            String productDescription = resultSet.getString("productDescription");
            String productAsset = resultSet.getString("productAsset");

            // Display product information
%>
            <div>
                <h2><%= productName %></h2>
                <p>Price: $<%= productCost %></p>
                <p>Description: <%= productDescription %></p>
                <img src="<%= productAsset %>" alt="<%= productName %> Image">
            </div>
<%
        }

        // Close the resources
        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
%>
        <div>
            <p>Error fetching product information. Please try again later.</p>
        </div>
<%
    }
%>

</body>
</html>
