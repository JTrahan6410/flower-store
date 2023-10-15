/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business;

import java.sql.*;

/**
 *
 * @author lena
 */
public class Order {
    
    private int orderID;
    private int userID;
    private String productCode;
    private String orderPlaced;
    private String requestedDelivery;
    private String mailName, mailStreetAddress, mailCity, mailState;
    private int mailZip;
    private String billName, billStreetAddress, billCity, billState;
    private int billZip;
    protected final String databaseURL = "FlowerStore/FlowerStoreDatabase.accdb";

    
    public Order() {
        orderID = 0;
        userID = 0;
        productCode = "";
        orderPlaced = "";
        requestedDelivery = "";
        mailName = "";
        mailStreetAddress = "";
        mailCity = "";
        mailState = "";
        mailZip = 0;
        billName = "";
        billStreetAddress = "";
        billCity = "";
        billState = "";
        billZip = 0;
        
    }

    public Order(int orderID, int userID, String productCode, String orderPlaced, String requestedDelivery, String mailName, String mailStreetAddress, String mailCity, String mailState, int mailZip, String billName, String billStreetAddress, String billCity, String billState, int billZip) {
        this.orderID = orderID;
        this.userID = userID;
        this.productCode = productCode;
        this.orderPlaced = orderPlaced;
        this.requestedDelivery = requestedDelivery;
        this.mailName = mailName;
        this.mailStreetAddress = mailStreetAddress;
        this.mailCity = mailCity;
        this.mailState = mailState;
        this.mailZip = mailZip;
        this.billName = billName;
        this.billStreetAddress = billStreetAddress;
        this.billCity = billCity;
        this.billState = billState;
        this.billZip = billZip;
    }
    
    public int getorderID() { return orderID; }
    public void setoderID(int orderID) { this.orderID = orderID; }
    
    public int getuserID() { return userID; }
    public void setuserID(int userID) { this.userID = userID; }
    
    public String getproductCode() { return productCode; }
    public void setproductCode(String productCode) { this.productCode = productCode; }
    
    public String getorderPlaced() { return orderPlaced; }
    public void setorderPlaced(String orderPlaced) { this.orderPlaced = orderPlaced; }
    
    public String getrequestedDelivery() { return requestedDelivery; }
    public void setrequestedDelivery(String requestedDelivery) { this.requestedDelivery = requestedDelivery; }
    
    public String getmailName() { return mailName; }
    public void setmailName(String mailName) { this.mailName = mailName; }

    public String getmailStreetAddress() { return mailStreetAddress; }
    public void setmailStreetAddress(String mailStreetAddress) { this.mailStreetAddress = mailStreetAddress; }
    
    public String getmailCity() { return mailCity; }
    public void setmailCity(String mailCity) { this.mailCity = mailCity; }
    
    public String getmailState() { return mailState; }
    public void setmailState(String mailState) { this.mailState = mailState; }

    public int getmailZip() { return mailZip; }
    public void setmailZip(int mailZip) { this.mailZip = mailZip; }
    
    public String getbillName() { return billName; }
    public void setbillName(String billName) { this.billName = billName; }

    public String getbillStreetAddress() { return billStreetAddress; }
    public void setbillStreetAddress(String billStreetAddress) { this.billStreetAddress = billStreetAddress; }
    
    public String getbillCity() { return billCity; }
    public void setbillCity(String billCity) { this.billCity = billCity; }
    
    public String getbillState() { return billState; }
    public void setbillState(String billState) { this.billState = billState; }

    public int getbillZip() { return billZip; }
    public void setbillZip(int billZip) { this.billZip = billZip; }
    
    public void display() {
        System.out.println("Order ID = " + getorderID());
        System.out.println("User ID = " + getuserID());
        System.out.println("Product Code = " + getproductCode());
        System.out.println("Order Placed = " + getorderPlaced());
        System.out.println("Requested Delivery = " + getrequestedDelivery());
        System.out.println("Mailing Name = " + getmailName());
        System.out.println("Mailing Street Address= " + getmailStreetAddress());
        System.out.println("Mailing City = " + getmailCity());
        System.out.println("Mailing State = " + getmailState());
        System.out.println("Mailing Zip= " + getmailZip());
        System.out.println("Billing Name = " + getbillName());
        System.out.println("Billing Street Address= " + getbillStreetAddress());
        System.out.println("Billing City = " + getbillCity());
        System.out.println("Billing State = " + getbillState());
        System.out.println("Billing Zip= " + getbillZip());
    }
    
    public void selectDB(int orderID) {
        this.orderID = orderID;
        try { 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + "FlowerStore//FlowerStoreDatabase.accdb")) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM Orders WHERE userID = " + getuserID();
                System.out.println(sql);
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    setuserID(rs.getInt("userID"));
                    setproductCode(rs.getString("productCode"));
                    setorderPlaced(rs.getString("orderPlaced"));
                    setrequestedDelivery(rs.getString("requestedDelivery"));
                    setmailName(rs.getString("mailName"));
                    setmailStreetAddress(rs.getString("mailStreetAddress"));
                    setmailCity(rs.getString("mailCity"));
                    setmailState(rs.getString("mailState"));
                    setmailZip(rs.getInt("mailZip"));
                    setbillName(rs.getString("billName"));
                    setbillStreetAddress(rs.getString("billStreetAddress"));
                    setbillCity(rs.getString("billCity"));
                    setbillState(rs.getString("billState"));
                    setbillZip( rs.getInt("billZip"));
            }
          }
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public void insertDB(int orderID, int userID, String productCode, String orderPlaced, String requestedDelivery, String mailName, String mailStreetAddress, String mailCity, String mailState, int mailZip, String billName, String billStreetAddress, String billCity, String billState, int billZip){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + "FlowerStore/FlowerStoreDatabase.accdb")) {
                Statement sta = conn.createStatement();
                String sql = "INSERT INTO Users (orderID, userID, productCode, orderPlaced, requestedDelivery, mailName, mailStreetAddress, mailCity, mailState, mailZip, billName, illStreetAddress, billCity, billState, billZip) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, orderID);
                statement.setInt(2, userID);
                statement.setString(3, productCode);
                statement.setString(4, orderPlaced);
                statement.setString(5, requestedDelivery);
                statement.setString(6, mailName);
                statement.setString(7, mailStreetAddress);
                statement.setString(8, mailCity);
                statement.setString(9, mailState);
                statement.setInt(10, mailZip);
                statement.setString(11, billName);
                statement.setString(12, billStreetAddress);
                statement.setString(13, billCity);
                statement.setString(14, billState);
                statement.setInt(15, billZip);
                statement.executeUpdate();
                System.out.println(sql);
                sta.executeUpdate(sql);
            }				
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public void updateDB() {
     try {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
            String sql = "UPDATE Orders SET orderID = ?, userID = ?, productCode = ?, orderPlaced = ?, requestedDelivery = ?, mailName = ?, mailStreetAddress = ?, mailCity = ?, mailState = ?, mailZip = ?, billName = ?, illStreetAddress = ?, billCity, billState = ?, billZip = ? WHERE orderID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            // Set values for the placeholders in the prepared statement
            statement.setInt(1, orderID);
                statement.setInt(2, userID);
                statement.setString(3, productCode);
                statement.setString(4, orderPlaced);
                statement.setString(5, requestedDelivery);
                statement.setString(6, mailName);
                statement.setString(7, mailStreetAddress);
                statement.setString(8, mailCity);
                statement.setString(9, mailState);
                statement.setInt(10, mailZip);
                statement.setString(11, billName);
                statement.setString(12, billStreetAddress);
                statement.setString(13, billCity);
                statement.setString(14, billState);
                statement.setInt(15, billZip);

            statement.executeUpdate();

            System.out.println(sql);
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
