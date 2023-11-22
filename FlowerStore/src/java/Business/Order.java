package Business;

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
public class Order {
    private int orderID;
    private int userID;
    private Date orderDateTime;
    private Date orderRequested;
    private double orderTotal;
    private String cardNumber;
    private Date cardExpiry;
    private String cardCVV;
    private boolean hasGreetingCard;
    private String greetingCardType;
    private String greetingCardMessage;
    // <editor-fold defaultstate="collapsed" desc="Database Path set per user">
    
    //for Jose
//    final String databasePath = "E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Salena
//    final String databasePath = "C:\\Users\\lena\\OneDrive\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Jacob
    final String databasePath = "E:\\Users\\Documents\\GitHub\\flower-store\\FlowerStore\\web\\WEB-INF\\FlowerStoreDatabase.accdb";
    
    //</editor-fold>
    final String databaseURL = "jdbc:ucanaccess://" + databasePath;
    
    

    // Default constructor
    public Order() {
        // Initialize variables to default values
        orderID = 0;
        userID = 0;
        orderDateTime = null;
        orderRequested = null;
        orderTotal = 0;
        cardNumber = "";
        cardExpiry = null;
        cardCVV = "";
        hasGreetingCard= false;
        greetingCardType= "";
        greetingCardMessage= "";
    }

    // Parameterized constructor

    /**
     *
     * @param orderID
     * @param userID
     * @param orderDateTime
     * @param orderRequested
     * @param orderTotal
     * @param cardNumber
     * @param cardExpiry
     * @param cardCVV
     * @param hasGreetingCard
     * @param greetingCardType
     * @param greetingCardMessage
     */
    public Order(int orderID, int userID, Date orderDateTime, Date orderRequested, double orderTotal,
                  String cardNumber, Date cardExpiry, String cardCVV, boolean hasGreetingCard, String greetingCardType, String greetingCardMessage) {
        // Set values based on constructor parameters
        this.orderID = orderID;
        this.userID = userID;
        this.orderDateTime = orderDateTime;
        this.orderRequested = orderRequested;
        this.orderTotal = orderTotal;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardCVV = cardCVV;
        this.hasGreetingCard = hasGreetingCard;
        this.greetingCardType = greetingCardType;
        this.greetingCardMessage = greetingCardMessage;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters for class properties. Click on the + sign on the left to edit the code.">
    // Getters and Setters

    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }

    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }

    public Date getOrderDateTime() { return orderDateTime; }
    public void setOrderDateTime(Date orderDateTime) { this.orderDateTime = orderDateTime; }

    public Date getOrderRequested() { return orderRequested; }
    public void setOrderRequested(Date orderRequested) { this.orderRequested = orderRequested; }

    public double getOrderTotal() { return orderTotal; }
    public void setOrderTotal(double orderTotal) { this.orderTotal = orderTotal; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public Date getCardExpiry() { return cardExpiry; }
    public void setCardExpiry(Date cardExpiry) { this.cardExpiry = cardExpiry; }

    public String getCardCVV() { return cardCVV; }
    public void setCardCVV(String cardCVV) { this.cardCVV = cardCVV; }
    
    public boolean getHasGreetingCard() { return hasGreetingCard; }
    public void setHasGreetingCard(boolean hasGreetingCard) { this.hasGreetingCard = hasGreetingCard; }
    
    public String getGreetingCardType() { return greetingCardType; }
    public void setGreetingCardType(String greetingCardType) {  this.greetingCardType = greetingCardType; }
    
    public String getGreetingCardMessage() { return greetingCardMessage; }
    public void setGreetingCardMessage(String greetingCardMessage) { this.greetingCardMessage = greetingCardMessage; }

    //</editor-fold>
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
        System.out.println("Greeting Card?: " + getHasGreetingCard());
        System.out.println("Greeting Card Type: " + getGreetingCardType());
        System.out.println("Greeting Card Message: " + getGreetingCardMessage());
}
    
    // Database methods
    
    public void selectDB(int orderID) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(databaseURL)) {
                String sql = "SELECT * FROM Orders WHERE orderID = ?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setInt(1, orderID);
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        setOrderID(rs.getInt("orderID"));
                        setUserID(rs.getInt("userID"));
                        setOrderDateTime(rs.getDate("orderDateTime"));
                        setOrderRequested(rs.getDate("orderRequested"));
                        setOrderTotal(rs.getDouble("orderTotal"));
                        setCardNumber(rs.getString("cardNumber"));
                        setCardExpiry(rs.getDate("cardExpiry"));
                        setCardCVV(rs.getString("cardCVV"));
                        setHasGreetingCard(rs.getBoolean("hasGreetingCard"));
                        setGreetingCardType(rs.getString("greetingCardType"));
                        setGreetingCardMessage(rs.getString("greetingCardMessage"));
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
            try (Connection conn = DriverManager.getConnection(databaseURL)) {
                String sql = "INSERT INTO Orders (userID, orderDateTime, orderRequested, orderTotal, cardNumber, cardExpiry, cardCVV, hasGreetingCard, greetingCardType, greetingCardMessage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setInt(1, getUserID());
                    statement.setDate(2, getOrderDateTime());
                    statement.setDate(3, getOrderRequested());
                    statement.setDouble(4, getOrderTotal());
                    statement.setString(5, getCardNumber());
                    statement.setDate(6, getCardExpiry());
                    statement.setString(7, getCardCVV());
                    statement.setBoolean(8, getHasGreetingCard());
                    statement.setString(9, getGreetingCardType());
                    statement.setString(10, getGreetingCardMessage());
                    statement.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public void updateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(databaseURL)) {
                String sql = "UPDATE Orders SET userID = ?, orderDateTime = ?, orderRequested = ?, orderTotal = ?, cardNumber = ?, cardExpiry = ?, cardCVV = ?, hasGreetingCard = ?, greetingCardType = ?, greetingCardMessage = ? WHERE orderID = ?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setInt(1, getUserID());
                    statement.setDate(2, getOrderDateTime());
                    statement.setDate(3, getOrderRequested());
                    statement.setDouble(4, getOrderTotal());
                    statement.setString(5, getCardNumber());
                    statement.setDate(6, getCardExpiry());
                    statement.setString(7, getCardCVV());
                    statement.setBoolean(8, getHasGreetingCard());
                    statement.setString(9, getGreetingCardType());
                    statement.setString(10, getGreetingCardMessage());
                    statement.setInt(11, getOrderID());
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
            try (Connection conn = DriverManager.getConnection(databaseURL)) {
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
        Order o1 = new Order();
        o1.selectDB(1);
        o1.display();
    }
}
