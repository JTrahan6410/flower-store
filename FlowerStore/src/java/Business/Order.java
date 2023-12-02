package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order with various properties and database operations.
 * Adapted from the original work by Trent Cargle.
 *
 * @author Jacob Trahan
 * @version 1.7
 * @since 2023-09-30
 */
public class Order {
    private int orderID;
    private int userID;
    private Date orderDateTime;
    private Date orderRequested;
    private double orderTotal;
    private String cardNumber;
    private Date cardExpiry;
    private String cardCVV;
    private String orderStatus;
    private boolean hasGreetingCard;
    private String greetingCardType;
    private String greetingCardMessage;
    // <editor-fold defaultstate="collapsed" desc="Database Path set per user">

    //for Jose
//   private static final String DATABASE_PATH = "E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";

    //for Salena
//    private static final String DATABASE_PATH = "C:\\Users\\lena\\OneDrive\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";

    //for Jacob
    private static final String DATABASE_PATH = "E:/Users/Documents/GitHub/flower-store/FlowerStore/FlowerStoreDatabase_v4.accdb";

    //</editor-fold>
    private static String databaseURL = "jdbc:ucanaccess://" + DATABASE_PATH;



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
        orderStatus = "";
        hasGreetingCard= false;
        greetingCardType= "";
        greetingCardMessage= "";
    }

    // Parameterized constructor

    /**
     * Parameterized constructor for creating an order.
     *
     * @param orderID           The unique identifier for the order.
     * @param userID            The ID of the user who placed the order.
     * @param orderDateTime     The date and time when the order was created.
     * @param orderRequested    The date when the order is requested to be delivered.
     * @param orderTotal        The total cost of the order.
     * @param cardNumber        The credit card number used for payment.
     * @param cardExpiry        The expiry date of the credit card.
     * @param cardCVV           The CVV (Card Verification Value) of the credit card.
     * @param orderStatus       Flag for the current status the order is in
     * @param hasGreetingCard   A flag indicating whether the order includes a greeting card.
     * @param greetingCardType  The type of greeting card included in the order.
     * @param greetingCardMessage The message inside the greeting card.
     */
    public Order(int orderID, int userID, Date orderDateTime, Date orderRequested, double orderTotal, String cardNumber,
            Date cardExpiry, String cardCVV, String orderStatus, boolean hasGreetingCard, String greetingCardType, String greetingCardMessage) {
        // Set values based on constructor parameters
        this.orderID = orderID;
        this.userID = userID;
        this.orderDateTime = orderDateTime;
        this.orderRequested = orderRequested;
        this.orderTotal = orderTotal;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardCVV = cardCVV;
        this.orderStatus = orderStatus;
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
    
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

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
        System.out.println("Order Status: " + getOrderStatus());
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
                        setOrderStatus(rs.getString("orderStatus"));
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
                String sql = "INSERT INTO Orders (userID, orderRequested, orderTotal, cardNumber, cardExpiry,"
                        + " cardCVV, orderStatus, hasGreetingCard, greetingCardType, greetingCardMessage) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    statement.setInt(1, getUserID());
                    statement.setDate(2, getOrderRequested());
                    statement.setDouble(3, getOrderTotal());
                    statement.setString(4, getCardNumber());
                    statement.setDate(5, getCardExpiry());
                    statement.setString(6, getCardCVV());
                    statement.setString(7, getOrderStatus());
                    statement.setBoolean(8, getHasGreetingCard());
                    statement.setString(9, getGreetingCardType());
                    statement.setString(10, getGreetingCardMessage());

                    // Execute the insert statement
                    int affectedRows = statement.executeUpdate();

                    if (affectedRows == 0) {
                        throw new SQLException("Inserting order failed, no rows affected.");
                    }

                    // Retrieve the generated keys (OrderID)
                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            setOrderID(generatedKeys.getInt(1)); // Assuming OrderID is an integer
                        } else {
                            throw new SQLException("Inserting order failed, no ID obtained.");
                        }
                    }
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
                String sql = "UPDATE Orders SET userID = ?, orderDateTime = ?, orderRequested = ?, orderTotal = ?, cardNumber = ?, cardExpiry = ?,"
                        + " cardCVV = ?, orderStatus = ?, hasGreetingCard = ?, greetingCardType = ?, greetingCardMessage = ? WHERE orderID = ?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setInt(1, getUserID());
                    statement.setDate(2, getOrderDateTime());
                    statement.setDate(3, getOrderRequested());
                    statement.setDouble(4, getOrderTotal());
                    statement.setString(5, getCardNumber());
                    statement.setDate(6, getCardExpiry());
                    statement.setString(7, getCardCVV());
                    statement.setString(8, getOrderStatus());
                    statement.setBoolean(9, getHasGreetingCard());
                    statement.setString(10, getGreetingCardType());
                    statement.setString(11, getGreetingCardMessage());
                    statement.setInt(12, getOrderID());
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

        public static List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(databaseURL)) {
                String sql = "SELECT * FROM Orders";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    ResultSet rs = statement.executeQuery();
                    while (rs.next()) {
                        Order order = new Order(
                            rs.getInt("orderID"),
                            rs.getInt("userID"),
                            rs.getDate("orderDateTime"),
                            rs.getDate("orderRequested"),
                            rs.getDouble("orderTotal"),
                            rs.getString("cardNumber"),
                            rs.getDate("cardExpiry"),
                            rs.getString("cardCVV"),
                            rs.getString("orderStatus"),
                            rs.getBoolean("hasGreetingCard"),
                            rs.getString("greetingCardType"),
                            rs.getString("greetingCardMessage")
                        );
                        orders.add(order);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return orders;
    }
    
    public static void main(String[] args) {
        Order o1 = new Order();
        o1.selectDB(1);
        o1.display();
    }
}
