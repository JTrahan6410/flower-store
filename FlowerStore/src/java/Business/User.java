package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JACOB TRAHAN - adapted from Jose Gomez (9/18/23)
 * Adv Sys Project - Oct 5, 2023
 * This class extends the GuestUser class and adds authentication and admin status functionality.
 * THE DATABASE URL IS EXTENDED FROM GUESTUSER.JAVA
 */

public class User extends GuestUser {
    private String userPassword;
    private boolean admin;

    // Default constructor
    public User() {
        super(); // Invoke superclass (GuestUser) constructor
        this.userPassword = "";
        this.admin = false;
    }

    // Parameterized constructor
    public User(int userID, String email, String userPassword, String firstName, String lastName) {
        super(userID, email, firstName, lastName);
        this.userPassword = userPassword;
        this.admin = false;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters for class properties. Click on the + sign on the left to edit the code.">
    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
    public Boolean getAdmin() { return admin; }
    public void setAdmin(Boolean admin) { this.admin = admin; }

    // </editor-fold>
    
    // Display method overriding the superclass method to include admin status
    @Override
    public void display() {
        super.display(); // Call the display method of the superclass
        System.out.println("Admin Status = " + getAdmin());
    }

    // Method for selecting a user from the database
    @Override
       public void selectDB(String email) {
           String sql = "SELECT * FROM Users WHERE email = ?";
           try (Connection conn = DriverManager.getConnection(databaseURL);
                PreparedStatement statement = conn.prepareStatement(sql)) {

               statement.setString(1, email);
               try (ResultSet rs = statement.executeQuery()) {
                   if (rs.next()) {
                       // Assuming that 'userID' and other column names match the field names
                       setUserID(rs.getInt("userID"));
                       setUserPassword(rs.getString("userPassword"));
                       setFirstName(rs.getString("firstName"));
                       setLastName(rs.getString("lastName"));
                       setAdmin(rs.getBoolean("admin"));
                   }
               }
           } catch (SQLException e) {
               throw new RuntimeException("Error accessing database", e);
           }
       }

    // Method for inserting a new user into the database
    public void insertDB(String emailInput, String passwordInput, String firstNameInput, String lastNameInput, boolean par) {
        String sql = "INSERT INTO Users (email, userPassword, firstName, lastName, admin) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setString(1, getEmail());
            statement.setString(2, getUserPassword());
            statement.setString(3, getFirstName());
            statement.setString(4, getLastName());
            statement.setBoolean(5, getAdmin());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting data into database", e);
        }
    }

    // Method for updating an existing user's details in the database
    @Override
    public void updateDB() {
        String sql = "UPDATE Users SET email = ?, userPassword = ?, firstName = ?, lastName = ?, admin = ? WHERE userID = ?";
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setString(1, getEmail());
            statement.setString(2, userPassword);
            statement.setString(3, getFirstName());
            statement.setString(4, getLastName());
            statement.setBoolean(5, admin);
            statement.setInt(6, getUserID());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating database", e);
        }
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        User u1 = new User();
        u1.selectDB("jake@yahoo.com");
        u1.display();
    }
}
