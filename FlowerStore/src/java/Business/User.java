package Business;

// Utilizing the DatabaseHook class for database connections
import Database.DatabaseHook;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JACOB TRAHAN - adapted from Jose Gomez (9/18/23)
 * Adv Sys Project - Oct 5, 2023
 * This class extends the GuestUser class and adds authentication and admin status functionality.
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
    public User(int userID, String email, String firstName, String lastName, String streetAddress, String city, String state, String ZIP, String userPassword, boolean admin) {
        super(userID, email, firstName, lastName, streetAddress, city, state, ZIP);
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
           try (Connection conn = DatabaseHook.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)) {
               statement.setString(1, email);
               try (ResultSet rs = statement.executeQuery()) {
                   if (rs.next()) {
                       // Assuming that 'userID' and other column names match the field names
                       setUserID(rs.getInt("userID"));
                       setFirstName(rs.getString("firstName"));
                       setLastName(rs.getString("lastName"));
                       setUserPassword(rs.getString("userPassword"));
                       setAdmin(rs.getBoolean("admin"));
                       setStreetAddress(rs.getString("streetAddress"));
                       setCity(rs.getString("city"));
                       setState(rs.getString("state"));
                       setZIP(rs.getString("ZIP"));
                       
                   }
               }
           } catch (SQLException e) {
               throw new RuntimeException("Error accessing database", e);
           }
       }

    // Method for inserting a new user into the database
     public void insertDB(String email, String userPassword, String firstName, String lastName, String streetAddress, String city, String state, String ZIP) {
        // SQL command for inserting a new user into the Users table
        String sql = "INSERT INTO Users (email, userPassword, firstName, lastName, streetAddress, city, state, ZIP) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseHook.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getEmail());
            stmt.setString(2, getUserPassword());
            stmt.setString(3, getFirstName());
            stmt.setString(4, getLastName());
            stmt.setString(5, streetAddress);
            stmt.setString(6, city);
            stmt.setString(7, state);
            stmt.setString(8, ZIP);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting data into database", e);
        }
    }

    // Method for updating an existing user's details in the database
    @Override
    public void updateDB() {
        String sql = "UPDATE Users SET email = ?, userPassword = ?, firstName = ?, lastName = ?, streetAddress = ?, city = ?, state = ?, ZIP = ?, admin = ? WHERE userID = ?";
        try (Connection conn = DatabaseHook.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, getEmail());
            stmt.setString(2, getUserPassword());
            stmt.setString(3, getFirstName());
            stmt.setString(4, getLastName());
            stmt.setString(5, getStreetAddress());
            stmt.setString(6, getCity());
            stmt.setString(7, getState());
            stmt.setString(8, getZIP());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating database", e);
        }
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        User u1 = new User();
        u1.selectDB("jtrahan@students.chattahoocheetech.edu");
        u1.display();
    }
}
