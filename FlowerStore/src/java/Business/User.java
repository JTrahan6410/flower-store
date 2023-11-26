package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JACOB TRAHAN - adapted from Jose Gomez (9/18/23)
 * Adv Sys Project - Oct 5, 2023
 * This class extends the GuestUser class and adds authentication and admin status functionality.
 * THE DATABASE URL IS EXTENDED FROM GUESTUSER.JAVA
 */

public class User extends GuestUser {
    private String userPassword;

    // Default constructor
    public User() {
        super(); // Invoke superclass (GuestUser) constructor
        this.userPassword = "";
    }

    // Parameterized constructor
    public User(int userID, String email, String userPassword, String firstName, String lastName, String streetAddress, String city, String state, String ZIP) {
        super(userID, email, firstName, lastName, streetAddress, city, state, ZIP);
        this.userPassword = userPassword;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters for class properties. Click on the + sign on the left to edit the code.">
    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    // </editor-fold>
    
    // Display method overriding the superclass method to include admin status
    @Override
    public void display() {
        System.out.println("User Password: " + userPassword);
        super.display(); // Call the display method of the superclass
    }

    /*************************************************************
    * selectDB() gets one patient from the DB
     * @param email used to select user from database
    **************************************************************/
    @Override
       public void selectDB(String email) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
           String sql = "SELECT * FROM Users WHERE email = ?";
           
           try (Connection conn = DriverManager.getConnection(databaseURL);
                PreparedStatement statement = conn.prepareStatement(sql)) {

               statement.setString(1, email);
               try (ResultSet rs = statement.executeQuery()) {
                   if (rs.next()) {
                       // Assuming that 'userID' and other column names match the field names
                       setUserID(rs.getInt("userID"));
                       setEmail(rs.getString("email"));
                       setUserPassword(rs.getString("userPassword"));
                       setFirstName(rs.getString("firstName"));
                       setLastName(rs.getString("lastName"));
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

    /*************************************************************
    * insertDB() inserts one user into the database
     * @param emailInput used to insert user email
     * @param passwordInput used to insert user password
     * @param firstNameInput used to insert user first name
     * @param lastNameInput used to insert user last name
     * @param streetAddressInput
     * @param cityInput
     * @param stateInput
     * @param ZIPInput
    **************************************************************/
    public void insertDB(String emailInput, String passwordInput, String firstNameInput, String lastNameInput, String streetAddressInput, String cityInput, String stateInput, String ZIPInput) {
        String sql = "INSERT INTO Users (email, userPassword, firstName, lastName, streetAddress, city, state, ZIP) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setString(1, emailInput);
            statement.setString(2, passwordInput);
            statement.setString(3, firstNameInput);
            statement.setString(4, lastNameInput);
            statement.setString(5, streetAddressInput);
            statement.setString(6, cityInput);
            statement.setString(7, stateInput);
            statement.setString(8, ZIPInput);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting data into database", e);
        }
    }

    /*************************************************************
    * updateDB() update one user from the database
    **************************************************************/
    @Override
    public void updateDB() {
        String sql = "UPDATE Users SET email = ?, userPassword = ?, firstName = ?, lastName = ?, streetAddress = ?, city = ?, state = ?, ZIP = ? WHERE userID = ?";
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            
            statement.setString(1, getEmail());
            statement.setString(2, getUserPassword());
            statement.setString(3, getFirstName());
            statement.setString(4, getLastName());
            
            statement.setString(5, getStreetAddress()); //null after updating ???
            
            statement.setString(6, getCity());
            statement.setString(7, getState());
            statement.setString(8, getZIP());
            statement.setInt(9, getUserID());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating database", e);
        }
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        //User u1 = new User();
        //u1.selectDB("jose@gmail.com");
        //u1.display();
        
        //User u2 = new User();
        //u2.insertDB("rosalia@gmail.com", "1111", "rosa", "lia", "111 ST", "Atlanta", "GA", "30101");
        
        //User u3 = new User();
        //u3.selectDB("jose@gmail.com");
        //u3.setStreetAddress("111 Smith");
        //u3.updateDB();
        
        
    }
}
