package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jake
 */
public class Address {
    private int addressID;
    private int orderID;
    private Boolean isMailing;
    private Boolean isBilling;
    private String mailingName;
    private String billingName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private final String databaseURL = "../FlowerStore/FlowerStoreDatabase.accdb";

    // Constructors
    public Address() {
        // Default constructor
    }

    public Address(int addressID, int orderID, Boolean isMailing, Boolean isBilling,
                   String mailingName, String billingName, String streetAddress,
                   String city, String state, String zipCode) {
        this.addressID = addressID;
        this.orderID = orderID;
        this.isMailing = isMailing;
        this.isBilling = isBilling;
        this.mailingName = mailingName;
        this.billingName = billingName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Setters and Getters
    public int getAddressID() { return addressID; }
    public void setAddressID(int addressID) { this.addressID = addressID; }

    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }

    public Boolean getIsMailing() { return isMailing; }
    public void setIsMailing(Boolean isMailing) { this.isMailing = isMailing; }

    public Boolean getIsBilling() { return isBilling; }
    public void setIsBilling(Boolean isBilling) { this.isBilling = isBilling; }

    public String getMailingName() { return mailingName; }
    public void setMailingName(String mailingName) { this.mailingName = mailingName; }

    public String getBillingName() { return billingName; }
    public void setBillingName(String billingName) { this.billingName = billingName; }

    public String getStreetAddress() { return streetAddress; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    // Display method
    public void display() {
        System.out.println("Address ID: " + getAddressID());
        System.out.println("Order ID: " + getOrderID());
        System.out.println("Is Mailing: " + getIsMailing());
        System.out.println("Is Billing: " + getIsBilling());
        System.out.println("Mailing Name: " + getMailingName());
        System.out.println("Billing Name: " + getBillingName());
        System.out.println("Street Address: " + getStreetAddress());
        System.out.println("City: " + getCity());
        System.out.println("State: " + getState());
        System.out.println("Zip Code: " + getZipCode());
    }

    // Database methods
    public void selectDB(int addressID) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM Address WHERE addressID = " + addressID;
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    setAddressID(rs.getInt("addressID"));
                    setOrderID(rs.getInt("orderID"));
                    setIsMailing(rs.getBoolean("isMailing"));
                    setIsBilling(rs.getBoolean("isBilling"));
                    setMailingName(rs.getString("mailingName"));
                    setBillingName(rs.getString("billingName"));
                    setStreetAddress(rs.getString("streetAddress"));
                    setCity(rs.getString("city"));
                    setState(rs.getString("state"));
                    setZipCode(rs.getString("zipCode"));
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
                String sql = "INSERT INTO Address (orderID, isMailing, isBilling, mailingName, billingName, streetAddress, city, state, zipCode) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, getOrderID());
                statement.setBoolean(2, getIsMailing());
                statement.setBoolean(3, getIsBilling());
                statement.setString(4, getMailingName());
                statement.setString(5, getBillingName());
                statement.setString(6, getStreetAddress());
                statement.setString(7, getCity());
                statement.setString(8, getState());
                statement.setString(9, getZipCode());
                statement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public void updateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                String sql = "UPDATE Address SET orderID = ?, isMailing = ?, isBilling = ?, mailingName = ?, " +
                        "billingName = ?, streetAddress = ?, city = ?, state = ?, zipCode = ? WHERE addressID = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, getOrderID());
                statement.setBoolean(2, getIsMailing());
                statement.setBoolean(3, getIsBilling());
                statement.setString(4, getMailingName());
                statement.setString(5, getBillingName());
                statement.setString(6, getStreetAddress());
                statement.setString(7, getCity());
                statement.setString(8, getState());
                statement.setString(9, getZipCode());
                statement.setInt(10, getAddressID());
                statement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                String sql = "DELETE FROM Address WHERE addressID = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, getAddressID());
                statement.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Address address = new Address();
        address.selectDB(1);
        address.display();
    }
}
