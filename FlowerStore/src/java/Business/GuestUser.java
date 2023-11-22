package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    // <editor-fold defaultstate="collapsed" desc="Database Path set per user">
    
    //for Jose
//    protected static final String databasePath = "E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Salena
//    protected static final String databasePath = "C:\\Users\\lena\\OneDrive\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Jacob
    protected static final String databasePath = "E:\\Users\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase_v4.accdb";
    
    //</editor-fold>
    protected static final String databaseURL = "jdbc:ucanaccess://" + databasePath;

    // Default constructor initializing fields to default values
    public GuestUser() {
        userID = 0;
        email = "";
        firstName = "";
        lastName = "";
    }

    /**
    * Parameterized constructor for setting user properties during instantiation, excluding userID.
    *
    * @param email The user's email.
    * @param firstName The user's first name.
    * @param lastName The user's last name.
    */
    public GuestUser(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
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
// </editor-fold>
    
    // Method to display user information in the console
    public void display() {
        System.out.println("ID = " + getUserID());
        System.out.println("Email = " + getEmail());
        System.out.println("First Name = " + getFirstName());
        System.out.println("Last Name = " + getLastName());
    }

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
                }
            }
        } catch (SQLException e) {
            // Throwing a runtime exception if there is an SQL exception
            throw new RuntimeException("Error accessing database", e);
        }
    }

    /**
     * Inserts a new user into the database and retrieves the generated userID.
     *
     * @param email The user's email.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     */
    public void insertDB(String email, String firstName, String lastName) {
        String sql = "INSERT INTO Users (email, firstName, lastName) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, email);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.executeUpdate();

            // Retrieving the generated userID
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
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

    // Method to update existing user information in the database
    public void updateDB() {
        // SQL command for updating a user's details in the Users table
        String sql = "UPDATE Users SET email = ?, firstName = ?, lastName = ? WHERE userID = ?";
        
        // Try-with-resources to handle the database connection and statement
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Setting the email, firstName, and lastName parameters in the prepared statement
            stmt.setString(1, email);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            // Setting the userID parameter in the prepared statement
            stmt.setInt(4, userID);
            
            // Executing the update to modify the user details
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            // Throwing a runtime exception if there is an SQL exception
            throw new RuntimeException("Error updating database", e);
        }
    }

    // Method to delete a user from the database
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