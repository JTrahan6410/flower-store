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
    public User(int userID, String email, String userPassword, String firstName, String lastName) {
        super(userID, email, firstName, lastName);
        this.userPassword = userPassword;
        this.admin = false;
    }

    // Getter for user password
    public String getUserPassword() { return userPassword; }

    // Setter for user password
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    // Getter for admin status
    public Boolean getAdminStatus() { return admin; }

    // Setter for admin status
    public void setAdminStatus(Boolean admin) { this.admin = admin; }

    // Display method overriding the superclass method to include admin status
    @Override
    public void display() {
        super.display(); // Call the display method of the superclass
        System.out.println("Admin Status = " + getAdminStatus());
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
                       setUserPassword(rs.getString("userPassword"));
                       setFirstName(rs.getString("firstName"));
                       setLastName(rs.getString("lastName"));
                       setAdminStatus(rs.getBoolean("admin"));
                   }
               }
           } catch (SQLException e) {
               throw new RuntimeException("Error accessing database", e);
           }
       }

    // Method for inserting a new user into the database
    public void insertDB() {
        String sql = "INSERT INTO Users (email, userPassword, firstName, lastName, admin) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseHook.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setString(1, getEmail());
            statement.setString(2, userPassword);
            statement.setString(3, getFirstName());
            statement.setString(4, getLastName());
            statement.setBoolean(5, admin);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting data into database", e);
        }
    }

    // Method for updating an existing user's details in the database
    @Override
    public void updateDB() {
        String sql = "UPDATE Users SET email = ?, userPassword = ?, firstName = ?, lastName = ?, admin = ? WHERE userID = ?";
        try (Connection conn = DatabaseHook.getConnection();
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
        u1.selectDB("jtrahan@students.chattahoocheetech.edu");
        u1.display();
    }
}
