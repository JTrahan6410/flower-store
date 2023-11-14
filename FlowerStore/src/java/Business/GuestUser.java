package Business;

<<<<<<< Updated upstream
import java.sql.*;
/**************************************************************
=======
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
>>>>>>> Stashed changes

   Trent Cargle

   Adv Sys Project - Sept 18, 2023

 **************************************************************/
public class GuestUser {
<<<<<<< Updated upstream
    String userID;
    String fName;
    String lName;
    String eMail;
    String address;
    String city;
    String state;
    int zip;
    String nameOnCard;
    String cardNum;
    String expMonth;
    int expYear;
    int cvv;
    
    public GuestUser(){
        userID = "";
        fName = "";
        lName = "";
        eMail = "";
        address = "";
=======
    // Field members of the class
    protected int userID;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String streetAddress;
    protected String city;
    protected String state;
    protected String ZIP;
    
    // <editor-fold defaultstate="collapsed" desc="Database Path set per user">
    
    //for Jose
//    protected final String databasePath = "E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Salena
//    protected final String databasePath = "C:\\Users\\lena\\OneDrive\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Jacob
    protected final String databasePath = "E:\\Users\\Documents\\GitHub\\flower-store\\FlowerStore\\web\\WEB-INF\\FlowerStoreDatabase.accdb";
    
    //</editor-fold>
    protected final String databaseURL = "jdbc:ucanaccess://" + databasePath;

    // Default constructor initializing fields to default values
    public GuestUser() {
        userID = 0;
        email = "";
        firstName = "";
        lastName = "";
        streetAddress = "";
>>>>>>> Stashed changes
        city = "";
        state = "";
        zip = 0;
        nameOnCard = "";
        cardNum = "";
        expMonth = "";
        expYear = 0;
        cvv = 0;
    }
<<<<<<< Updated upstream
=======

    // Parameterized constructor for setting user properties during instantiation
    public GuestUser(int userID, String email, String firstName, String lastName, String streetAddress, String city, String state, String ZIP) {
        this.userID = userID;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.ZIP = ZIP;
    }
 
    // <editor-fold desc="Getters and setters">
    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getStreetAddress() { return streetAddress; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public String getCity() { return city; }
    public void setCity (String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getZIP() { return ZIP; }
    public void setZIP(String ZIP) { this.ZIP = ZIP; }
// </editor-fold>
>>>>>>> Stashed changes
    
    public GuestUser(String uid, String fn, String ln, String em, String add, String ci, String st, int z, String noc, String cn, String exm, int exy, int cv){
        userID = uid;
        fName = fn;
        lName = ln;
        eMail = em;
        address = add;
        city = ci;
        state = st;
        zip = z;
        nameOnCard = noc;
        cardNum = cn;
        expMonth = exm;
        expYear = exy;
        cvv = cv;
    }
<<<<<<< Updated upstream
    
    public String getUserID() { return userID; }
    public void setUserID(String uid) { userID = uid; }
    public String getFName() { return fName; }
    public void setFName(String fn) { fName = fn; }
    public String getLName() { return lName; }
    public void setLName(String ln) { lName = ln; }
    public String getEMail() { return eMail; }
    public void setEMail(String em) { eMail = em; }
    public String getAddress() { return address; }
    public void setAddress(String add) { address = add; }
    public String getCity() { return city; }
    public void setCity(String ci) { city = ci; }
    public String getState() { return state; }
    public void setState(String st) { state = st; }
    public int getZip() { return zip; }
    public void setZip(int z) { zip = z; }
    public String getNameOnCard() { return nameOnCard; }
    public void setNameOnCard(String noc) { nameOnCard = noc; }
    public String getCardNum() { return cardNum; }
    public void setCardNum(String cn) { cardNum = cn; }
    public String getExpMonth() { return expMonth; }
    public void setExpMonth(String exm) { expMonth = exm; }
    public int getExpYear() { return expYear; }
    public void setExpYear(int exy) { expYear = exy; }
    public int getCvv() { return cvv; }
    public void setCvv(int cv) { cvv = cv; }
    
    public void display(){
        System.out.println("Guest ID = "+ getUserID());
        System.out.println("Guest First Name = "+ getFName());
        System.out.println("Guest last Name = "+ getLName());
        System.out.println("Guest Email = "+ getEMail());
        System.out.println("Guest Address = "+ getAddress());
        System.out.println("Guest City = "+ getCity());
        System.out.println("Guest State = "+ getState());
        System.out.println("Guest Zip = "+ getZip());
        System.out.println("Guest Card Name = "+ getNameOnCard());
        System.out.println("Guest Card Number = "+ getCardNum());
        System.out.println("Card Expiration Month = "+ getExpMonth());
        System.out.println("Card Expiration Year= "+ getExpYear());
        System.out.println("Guest cvv = "+ getCvv());
=======

     // Method to retrieve a user from the database based on their email
    public void selectDB(String email) {
        // Setting the instance email to the provided email
        this.email = email;
        // SQL query to select a user from the Users table by email
        String sql = "SELECT * FROM Users WHERE email = ?";
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    setUserID(rs.getInt("userID"));
                    setFirstName(rs.getString("firstName"));
                    setLastName(rs.getString("lastName"));
                    setStreetAddress(rs.getString("streetAddress"));
                    setCity(rs.getString("city"));
                    setState(rs.getString("state"));
                    setZIP(rs.getString("ZIP"));
                }
            }
        } catch (SQLException e) {
            // Throwing a runtime exception if there is an SQL exception
            throw new RuntimeException("Error accessing database", e);
        }
>>>>>>> Stashed changes
    }
    
    public void selectDB(String uid) {
        userID = uid;
	try { 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + 
                "FlowerStore//FlowerStoreMDB.mdb");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Users WHERE userID = "+getUserID()+"";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            setFName(rs.getString(2));
            setLName(rs.getString(3));
            setEMail(rs.getString(4));
            setAddress(rs.getString(5));
            setCity(rs.getString(6));
            setState(rs.getString(7));
            setZip(rs.getInt(8));
            setNameOnCard(rs.getString(9));
            setCardNum(rs.getString(10));
            setExpMonth(rs.getString(11));
            setExpYear(rs.getInt(12));
            setCvv(rs.getInt(13));
            conn.close();            
	}
        catch(Exception e) {
            System.out.println(e);
	}
    }
        
<<<<<<< Updated upstream
        public void insertDB(int uid, String fn, String ln, String em, String add, String ci, String st, int z, String noc, String cn, String exm, int exy, int cv){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + 
            "FlowerStore/FlowerStoreMDB.mdb");
            
            Statement sta = conn.createStatement();
            String sql;
            sql = "INSERT into Users(userID, firstName, lastName, userMailAddress, email) VALUES("+uid+","+fn+","+ln+""+ci+","+em+")";
            System.out.println(sql);
            sta.executeUpdate(sql);
            conn.close();				
	}
	catch(Exception e){
            System.out.println( e);
	}
=======
        // Try-with-resources to handle the database connection and statement
        try (Connection conn = DriverManager.getConnection(databaseURL);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Setting the email, firstName, and lastName parameters in the prepared statement
            stmt.setString(1, getEmail());
            stmt.setString(2, getFirstName());
            stmt.setString(3, getLastName());
            stmt.setString(4, getStreetAddress());
            stmt.setString(5, getCity());
            stmt.setString(6, getState());
            stmt.setString(7, getZIP());
            // Executing the update to insert the user
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            // Throwing a runtime exception if there is an SQL exception
            throw new RuntimeException("Error inserting data into database", e);
        }
    }

    // Method to update existing user information in the database
    public void updateDB() {
        // SQL command for updating a user's details in the Users table
        String sql = "UPDATE Users SET email = ?, firstName = ?, lastName = ?, streetAddress = ?, city = ?, state = ?, ZIP = ? WHERE userID = ?";
        
        // Try-with-resources to handle the database connection and statement
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Setting the email, firstName, and lastName parameters in the prepared statement
            stmt.setString(1, getEmail());
            stmt.setString(2, getFirstName());
            stmt.setString(3, getLastName());
            stmt.setString(4, getStreetAddress());
            stmt.setString(5, getCity());
            stmt.setString(6, getState());
            stmt.setString(7, getZIP());
            // Setting the userID parameter in the prepared statement
            stmt.setInt(8, getUserID());
            
            // Executing the update to modify the user details
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            // Throwing a runtime exception if there is an SQL exception
            throw new RuntimeException("Error updating database", e);
        }
>>>>>>> Stashed changes
    }
      
    public void deleteDB(){
       try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

<<<<<<< Updated upstream
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + 
                "FlowerStore/FlowerStoreMDB.mdb");
            
            Statement st = conn.createStatement();
            String sql;
            sql = "DELETE from Users Where userID = "+getUserID()+"";
            System.out.println(sql);
            st.executeUpdate(sql);
            conn.close();				
	}
	catch(Exception e){
            System.out.println( e);
	}
=======
    // Method to delete a user from the database
    public void deleteDB() {
        // SQL command for deleting a user from the Users table based on userID
        String sql = "DELETE FROM Users WHERE userID = ?";
        
        // Try-with-resources to handle the database connection and statement
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Setting the userID parameter in the prepared statement
            stmt.setInt(1, getUserID());
            
            // Executing the update to delete the user
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            // Throwing a runtime exception if there is an SQL exception
            throw new RuntimeException("Error deleting from database", e);
        }
>>>>>>> Stashed changes
    }
    
      public static void main(String[] args) {
          GuestUser gu1 = new GuestUser();
		gu1.selectDB("A900");
		gu1.display();
    }
}