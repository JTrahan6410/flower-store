package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents a guest user with basic functionalities for database operations.
 * Provides methods to select, insert, update, and delete guest user records in the database.
 * Adapted from original work by Trent Cargle.
 * 
 * @author Jacob Trahan
 * @version 1.8
 * @since 2023-10-05
 */
public class GuestUser {
    // Field members of the class
    protected int userID;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String streetAddress, city, state, ZIP;
        // <editor-fold defaultstate="collapsed" desc="Database Path set per user">
    
    //for Jose
//    protected static final String DATABASE_PATH = "E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Salena
//    protected static final String DATABASE_PATH = "C:\\Users\\lena\\OneDrive\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Jacob
    protected static final String DATABASE_PATH = "E:/Users/Documents/GitHub/flower-store/FlowerStore/FlowerStoreDatabase_v4.accdb";
    
    //</editor-fold>
    protected static String databaseURL = "jdbc:ucanaccess://" + DATABASE_PATH;

    // Default constructor initializing fields to default values
    public GuestUser() {
        userID = 0;
        email = "";
        firstName = "";
        lastName = "";
        streetAddress = "";
        city = "";
        state = "";
        ZIP = "";
    }

    /**
    * Parameterized constructor for setting user properties during instantiation, excluding userID.
    *
    * @param email The user's email.
    * @param firstName The user's first name.
    * @param lastName The user's last name.
    * @param streetAddress The user's street address
    * @param city The user's city of residence
    * @param state The user's state of residence
    * @param ZIP The user's ZIP code of residence
    */
    public GuestUser(String email, String firstName, String lastName, String streetAddress, String city, String state, String ZIP) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.ZIP = ZIP;
    }
    // <editor-fold defaultstate="collapsed" desc="Getters and setters for class properties. Click on the + sign on the left to edit the code.">
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
    public void setCity(String city) { this.city = city; }
    public String getState() {return state; }
    public void setState(String state) { this.state = state; }
    public String getZIP() { return ZIP; }
    public void setZIP(String ZIP) { this.ZIP = ZIP; }
// </editor-fold>
    
    /**
     * Method to display user information in the console.
     */
    public void display() {
        System.out.println("ID = " + getUserID());
        System.out.println("Email = " + getEmail());
        System.out.println("First Name = " + getFirstName());
        System.out.println("Last Name = " + getLastName());
        System.out.println("Street Address = " + getStreetAddress());
        System.out.println("City = " + getCity());
        System.out.println("State = " + getState());
        System.out.println("ZIP = " + getZIP());
    }

    /**
     * Method to retrieve a user from the database based on their email.
     *
     * @param email The email of the user to retrieve.
     */
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
                }
            }
        } catch (SQLException e) {
            // Throwing a runtime exception if there is an SQL exception
            throw new RuntimeException("Error accessing database", e);
        }
    }

    /**
     * Method to insert a new user into the database.
     */
    public void insertDB() {
        String sql = "INSERT INTO Users (email, firstName, lastName, streetAddress, city, state, ZIP) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, getEmail());
            statement.setString(2, getFirstName());
            statement.setString(3, getLastName());
            statement.setString(4, getStreetAddress());
            statement.setString(5, getCity());
            statement.setString(6, getState());
            statement.setString(7, getZIP());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting data into database", e);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Outmoded insertDB method">
    /*
    /**
     * Inserts a new user into the database and retrieves the generated userID.
     *
     * @param email The user's email.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param streetAddress  The user's street address.
     * @param city           The user's city of residence.
     * @param state          The user's state of residence.
     * @param ZIP            The user's ZIP code of residence.
     */
    
    /*
    public void insertDB(String email, String firstName, String lastName, String streetAddress, String city, String state, String ZIP) {
        String sql = "INSERT INTO Users (email, firstName, lastName, streetAddress, city, state, ZIP) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, email);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, streetAddress);
            statement.setString(5, city);
            statement.setString(6, state);
            statement.setString(7, ZIP);
            statement.executeUpdate();

            // Retrieving the generated userID
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    this.userID = generatedKeys.getInt(1); // Assuming userID is the first column
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting data into database", e);
        }
    }
    */
    // </editor-fold>

    /**
     * Method to update existing user information in the database.
     */
    public void updateDB() {
        // SQL command for updating a user's details in the Users table
        String sql = "UPDATE Users SET email = ?, firstName = ?, lastName = ?, streetAddress = ?, city = ?, state = ?, ZIP = ? WHERE userID = ?";
        
        // Try-with-resources to handle the database connection and statement
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement statement = conn.prepareStatement(sql)) {
    
            statement.setString(1, email);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, streetAddress);
            statement.setString(5, city);
            statement.setString(6, state);
            statement.setString(7, ZIP);
            statement.setInt(4, userID);
            
            // Executing the update to modify the user details
            statement.executeUpdate();
            
        } catch (SQLException e) {
            // Throwing a runtime exception if there is an SQL exception
            throw new RuntimeException("Error updating database", e);
        }
    }

     /**
     * Method to delete a user from the database.
     */
    public void deleteDB() {
        // SQL command for deleting a user from the Users table based on userID
        String sql = "DELETE FROM Users WHERE userID = ?";
        
        // Try-with-resources to handle the database connection and statement
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Setting the userID parameter in the prepared statement
            stmt.setInt(1, userID);
            
            // Executing the update to delete the user
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            // Throwing a runtime exception if there is an SQL exception
            throw new RuntimeException("Error deleting from database", e);
        }
    }

    // Main method for testing the functionality of the GuestUser class
    public static void main(String[] args) {
        GuestUser gu1 = new GuestUser();
        gu1.selectDB("guest@test.net");
        gu1.display();
    }
}