package Business;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * OrderLine class represents a line item in an order.
 * 
 * @author Jake
 */
public class OrderLine {
    private int lineItemID;
    private int orderID;
    private String productCode;
    private BigDecimal productCost;
    private short productQuantity;
    private final String databaseURL = "../FlowerStoreDatabase.accdb";

    // Constructors
    // Default constructor for OrderLine class
    public OrderLine() {
        lineItemID = 0;
        orderID = 0;
        productCode = "";
        productCost = BigDecimal.ZERO;
        productQuantity = 0;
    }

    // Parameterized constructor for OrderLine class
    public OrderLine(int lineItemID, int orderID, String productCode, BigDecimal productCost, short productQuantity) {
        this.lineItemID = lineItemID;
        this.orderID = orderID;
        this.productCode = productCode;
        this.productCost = productCost;
        this.productQuantity = productQuantity;
    }

    // Setters and getters (one line each)
    public void setLineItemID(int lineItemID) { this.lineItemID = lineItemID; }
    public int getLineItemID() { return lineItemID; }
    
    public void setOrderID(int orderID) { this.orderID = orderID; }
    public int getOrderID() { return orderID; }
    
    public void setProductCode(String productCode) { this.productCode = productCode; }
    public String getProductCode() { return productCode; }
    
    public void setProductCost(BigDecimal productCost) { this.productCost = productCost; }
    public BigDecimal getProductCost() { return productCost; }
    
    public void setProductQuantity(short productQuantity) { this.productQuantity = productQuantity; }
    public short getProductQuantity() { return productQuantity; }

    // Display method
    public void display() {
        System.out.println("Line Item ID = " + getLineItemID());
        System.out.println("Order ID = " + getOrderID());
        System.out.println("Product Code = " + getProductCode());
        System.out.println("Product Cost = " + getProductCost());
        System.out.println("Product Quantity = " + getProductQuantity());
    }

    // Database methods

    public void selectDB(int lineItemID) {
    try {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
            String sql = "SELECT * FROM OrderLine WHERE lineItemID = " + lineItemID;
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    setOrderID(rs.getInt("orderID"));
                    setProductCode(rs.getString("productCode"));
                    setProductCost(rs.getBigDecimal("productCost"));
                    setProductQuantity(rs.getShort("productQuantity"));
                }
            }
        }
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println(e);
    }
}


    public void insertDB() {
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
            String sql = "INSERT INTO OrderLine (orderID, productCode, productCost, productQuantity) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, getOrderID());
                pstmt.setString(2, getProductCode());
                pstmt.setBigDecimal(3, getProductCost());
                pstmt.setShort(4, getProductQuantity());
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateDB() {
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
            String sql = "UPDATE OrderLine SET orderID = ?, productCode = ?, productCost = ?, productQuantity = ? WHERE lineItemID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, getOrderID());
                pstmt.setString(2, getProductCode());
                pstmt.setBigDecimal(3, getProductCost());
                pstmt.setShort(4, getProductQuantity());
                pstmt.setInt(5, getLineItemID());
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteDB() {
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
            String sql = "DELETE FROM OrderLine WHERE lineItemID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, getLineItemID());
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
