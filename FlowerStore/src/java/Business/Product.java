package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.math.BigDecimal;

/**************************************************************

   JACOB TRAHAN

   Adv Sys Project - Oct 23, 2023

 **************************************************************/


public class Product {
    private String productCode;
    private String productName;
    private String productDescription;
    private BigDecimal productCost;
    private String productOccasion;
    private String productAsset;
    private String customMessage;
    private final String databaseURL = "../FlowerStore/FlowerStoreDatabase.accdb";

    // Default constructor
    public Product() {
        productCode = "";
        productName = "";
        productDescription = "";
        productCost = BigDecimal.ZERO;
        productOccasion = "";
        productAsset = "";
        customMessage = "";
    }

    // Parameterized constructor
    public Product(String productCode, String productName, String productDescription,
                   BigDecimal productCost, String productOccasion, String productAsset, String customMessage) {
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCost = productCost;
        this.productOccasion = productOccasion;
        this.productAsset = productAsset;
        this.customMessage = customMessage;
    }

    // Getters and Setters
    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getProductDescription() { return productDescription; }
    public void setProductDescription(String productDescription) { this.productDescription = productDescription; }

    public BigDecimal getProductCost() { return productCost; }
    public void setProductCost(BigDecimal productCost) { this.productCost = productCost; }

    public String getProductOccasion() { return productOccasion; }
    public void setProductOccasion(String productOccasion) { this.productOccasion = productOccasion; }

    public String getProductAsset() { return productAsset; }
    public void setProductAsset(String productAsset) { this.productAsset = productAsset; }

    public String getCustomMessage() { return customMessage; }
    public void setCustomMessage(String customMessage) { this.customMessage = customMessage; }

    // Display method
    public void display() {
        System.out.println("Product Code: " + getProductCode());
        System.out.println("Product Name: " + getProductName());
        System.out.println("Product Description: " + getProductDescription());
        System.out.println("Product Cost: " + getProductCost());
        System.out.println("Product Occasion: " + getProductOccasion());
        System.out.println("Product Asset: " + getProductAsset());
        System.out.println("Custom Message: " + getCustomMessage());
    }

    // Database methods
    // Method to retrieve product data from the database based on the product code
    public void selectDB(String productCode) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                // SQL query to select product data based on the product code
                String sql = "SELECT * FROM Product WHERE productCode = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, productCode);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        // Set product data based on the result set
                        setProductCode(rs.getString("productCode"));
                        setProductName(rs.getString("productName"));
                        setProductDescription(rs.getString("productDescription"));
                        setProductCost(rs.getBigDecimal("productCost"));
                        setProductOccasion(rs.getString("productOccasion"));
                        setProductAsset(rs.getString("productAsset"));
                        setCustomMessage(rs.getString("customMessage"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            System.out.println(e);
        }
    }

    // Method to insert product data into the database
    public void insertDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                // SQL query to insert product data into the database
                String sql = "INSERT INTO Product (productCode, productName, productDescription, productCost, productOccasion, productAsset, customMessage) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    // Set values for placeholders in the prepared statement
                    statement.setString(1, getProductCode());
                    statement.setString(2, getProductName());
                    statement.setString(3, getProductDescription());
                    statement.setBigDecimal(4, getProductCost());
                    statement.setString(5, getProductOccasion());
                    statement.setString(6, getProductAsset());
                    statement.setString(7, getCustomMessage());
                    // Execute the insert query
                    statement.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            System.out.println(e);
        }
    }

    // Method to update product data in the database
    public void updateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                // SQL query to update product data in the database
                String sql = "UPDATE Product SET productName = ?, productDescription = ?, productCost = ?, " +
                             "productOccasion = ?, productAsset = ?, customMessage = ? WHERE productCode = ?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    // Set values for placeholders in the prepared statement
                    statement.setString(1, getProductName());
                    statement.setString(2, getProductDescription());
                    statement.setBigDecimal(3, getProductCost());
                    statement.setString(4, getProductOccasion());
                    statement.setString(5, getProductAsset());
                    statement.setString(6, getCustomMessage());
                    statement.setString(7, getProductCode());
                    // Execute the update query
                    statement.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            System.out.println(e);
        }
    }

    // Method to delete product data from the database
    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                // SQL query to delete product data from the database
                String sql = "DELETE FROM Product WHERE productCode = ?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    // Set values for placeholders in the prepared statement
                    statement.setString(1, getProductCode());
                    // Execute the delete query
                    statement.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            System.out.println(e);
        }
    }
}
