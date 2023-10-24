package Business;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;

/**************************************************************

   ADAPTED BY JACOB TRAHAN - originally created by Trent Cargle

   Adv Sys Project - Sept 30, 2023

 **************************************************************/
public class Orders {
    private int orderID;
    private int userID;
    private Date orderDateTime;
    private Date orderRequested;
    private BigDecimal orderTotal;
    private String cardNumber;
    private Date cardExpiry;
    private String cardCVV;
    private int mailingAddressID;
    private int billingAddressID;
    private final String databaseURL = "../FlowerStore/FlowerStoreDatabase.accdb";

    // Default constructor
    public Orders() {
        // Initialize variables to default values
        orderID = 0;
        userID = 0;
        orderDateTime = null;
        orderRequested = null;
        orderTotal = BigDecimal.ZERO;
        cardNumber = "";
        cardExpiry = null;
        cardCVV = "";
        mailingAddressID = 0;
        billingAddressID = 0;
    }

    // Parameterized constructor
    public Orders(int orderID, int userID, Date orderDateTime, Date orderRequested, BigDecimal orderTotal,
                  String cardNumber, Date cardExpiry, String cardCVV, int mailingAddressID, int billingAddressID) {
        // Set values based on constructor parameters
        this.orderID = orderID;
        this.userID = userID;
        this.orderDateTime = orderDateTime;
        this.orderRequested = orderRequested;
        this.orderTotal = orderTotal;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardCVV = cardCVV;
        this.mailingAddressID = mailingAddressID;
        this.billingAddressID = billingAddressID;
    }

    // Getters and Setters
    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }

    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }

    public Date getOrderDateTime() { return orderDateTime; }
    public void setOrderDateTime(Date orderDateTime) { this.orderDateTime = orderDateTime; }

    public Date getOrderRequested() { return orderRequested; }
    public void setOrderRequested(Date orderRequested) { this.orderRequested = orderRequested; }

    public BigDecimal getOrderTotal() { return orderTotal; }
    public void setOrderTotal(BigDecimal orderTotal) { this.orderTotal = orderTotal; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public Date getCardExpiry() { return cardExpiry; }
    public void setCardExpiry(Date cardExpiry) { this.cardExpiry = cardExpiry; }

    public String getCardCVV() { return cardCVV; }
    public void setCardCVV(String cardCVV) { this.cardCVV = cardCVV; }

    public int getMailingAddressID() { return mailingAddressID; }
    public void setMailingAddressID(int mailingAddressID) { this.mailingAddressID = mailingAddressID; }

    public int getBillingAddressID() { return billingAddressID; }
    public void setBillingAddressID(int billingAddressID) { this.billingAddressID = billingAddressID; }

    // display method
    
    public void display() {
        System.out.println("Order ID: " + getOrderID());
        System.out.println("User ID: " + getUserID());
        System.out.println("Order Date Time: " + getOrderDateTime());
        System.out.println("Order Requested Date: " + getOrderRequested());
        System.out.println("Order Total: $" + getOrderTotal());
        System.out.println("Card Number: " + getCardNumber());
        System.out.println("Card Expiry: " + getCardExpiry());
        System.out.println("Card CVV: " + getCardCVV());
        System.out.println("Mailing Address ID: " + getMailingAddressID());
        System.out.println("Billing Address ID: " + getBillingAddressID());
}
    
    // Database methods
    
    public void selectDB(int orderID) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                String sql = "SELECT * FROM Orders WHERE orderID = ?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setInt(1, orderID);
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        setOrderID(rs.getInt("orderID"));
                        setUserID(rs.getInt("userID"));
                        setOrderDateTime(rs.getDate("orderDateTime"));
                        setOrderRequested(rs.getDate("orderRequested"));
                        setOrderTotal(rs.getBigDecimal("orderTotal"));
                        setCardNumber(rs.getString("cardNumber"));
                        setCardExpiry(rs.getDate("cardExpiry"));
                        setCardCVV(rs.getString("cardCVV"));
                        setMailingAddressID(rs.getInt("mailingAddressID"));
                        setBillingAddressID(rs.getInt("billingAddressID"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public void insertDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                String sql = "INSERT INTO Orders (userID, orderDateTime, orderRequested, orderTotal, cardNumber, cardExpiry, cardCVV, mailingAddressID, billingAddressID) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setInt(1, getUserID());
                    statement.setDate(2, getOrderDateTime());
                    statement.setDate(3, getOrderRequested());
                    statement.setBigDecimal(4, getOrderTotal());
                    statement.setString(5, getCardNumber());
                    statement.setDate(6, getCardExpiry());
                    statement.setString(7, getCardCVV());
                    statement.setInt(8, getMailingAddressID());
                    statement.setInt(9, getBillingAddressID());

                    statement.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                String sql = "DELETE FROM Orders WHERE orderID = ?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setInt(1, getOrderID());
                    statement.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Orders o1 = new Orders();
        o1.selectDB(1);
        o1.display();
    }
}
