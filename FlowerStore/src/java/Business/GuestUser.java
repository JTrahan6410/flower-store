package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**************************************************************

   JACOB TRAHAN - adapted from Trent Cargle (9/18/23)

   Adv Sys Project - Oct 5, 2023

 **************************************************************/

// Class definition
public class GuestUser {
    // Fields (attributes) of the class
    protected int userID;
    protected String firstName, lastName, eMail;
    protected final String databaseURL = "../FlowerStore/FlowerStoreDatabase.accdb";
    
    // Default constructor
    public GuestUser() {
        userID = 0;
        eMail = "";
        firstName = "";
        lastName = "";
    }
    
    // Parameterized constructor
    public GuestUser(int userID, String eMail, String firstName, String lastName) {
        this.userID = userID;
        this.eMail = eMail;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    // Getter and setter methods for all fields
    public int getUserID() { return userID; }
    //setUserID is not valid, field is immutable

    public String getEMail() { return eMail; }
    public void setEMail(String eMail) { this.eMail = eMail; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    // Display method to print guest information to the console
    public void display() {
        System.out.println("Guest ID = " + getUserID());
        System.out.println("Guest Email = " + getEMail());
        System.out.println("Guest First Name = " + getFirstName());
        System.out.println("Guest Last Name = " + getLastName());
    }
    
    // Method to retrieve user data from the database based on the email using PreparedStatement
    public void selectDB(String eMail) {
        // Set the email for which data needs to be retrieved
        this.eMail = eMail;
        try { 
            // Load JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            // Establish a connection to the database
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                // SQL query to retrieve user data based on email
                String sql = "SELECT * FROM Users WHERE email = ?";
                
                // Create a PreparedStatement with the SQL query
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    // Set the email value for the prepared statement
                    stmt.setString(1, eMail);
                    
                    // Execute the query and retrieve the result set
                    ResultSet rs = stmt.executeQuery();
                    
                    // If a record is found, update the object's fields
                    if (rs.next()) {
                        setFirstName(rs.getString("firstName"));
                        setLastName(rs.getString("lastName"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Print any exceptions that occur
            System.out.println(e);
        }
    }

    // Method to insert user data into the database using PreparedStatement
    public void insertDB(int userID, String eMail, String firstName, String lastName) {
         try {
            // Load JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            // Establish a connection to the database
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                // SQL query to insert user data into the Users table
                String sql = "INSERT INTO Users (email, firstName, lastName) VALUES (?, ?, ?)";
                
                // Create a PreparedStatement with the SQL query
                PreparedStatement statement = conn.prepareStatement(sql);
                
                // Set values for the placeholders in the prepared statement
                statement.setString(1, eMail);
                statement.setString(2, firstName);
                statement.setString(3, lastName);
                
                // Execute the INSERT statement to add a new user
                statement.executeUpdate();
                
                // Print the generated SQL query (for debugging)
                System.out.println(sql);
                
                // Execute the statement again (this is redundant and unnecessary)
                statement.executeUpdate(sql);
            }				
        } catch (ClassNotFoundException | SQLException e) {
            // Print any exceptions that occur
            System.out.println(e);
        }
    }
      
    // Method to update user data in the database using PreparedStatement
    public void updateDB() {
         try {
            // Load JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            // Establish a connection to the database
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                // SQL query to update user data in the Users table
                String sql = "UPDATE Users SET email = ?, firstName = ?, lastName = ? WHERE email = ?";
                
                // Create a PreparedStatement with the SQL query
                PreparedStatement statement = conn.prepareStatement(sql);
                
                // Set values for the placeholders in the prepared statement
                statement.setString(1, eMail);
                statement.setString(2, firstName);
                statement.setString(3, lastName);
                statement.setString(4, eMail);

                // Execute the UPDATE statement to modify user information
                statement.executeUpdate();

                // Print the generated SQL query (for debugging)
                System.out.println(sql);
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Print any exceptions that occur
            System.out.println(e);
        }
    }

    // Method to delete user data from the database using PreparedStatement
    public void deleteDB() {
        try {
            // Load JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            // Establish a connection to the database
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                // SQL query to delete user data from the Users table based on userID
                String sql = "DELETE FROM Orders WHERE userID = ?";
                
                // Create a PreparedStatement with the SQL query
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    // Set the userID value for the prepared statement
                    statement.setInt(1, getUserID());
                    
                    // Execute the DELETE statement to remove the user
                    statement.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Print any exceptions that occur
            System.out.println(e);
        }
    }
    
    // Test method
    public static void main(String[] args) {
        // Create an instance of GuestUser
        GuestUser gu1 = new GuestUser();
        
        // Call the selectDB method to retrieve user data from the database
        gu1.selectDB("guest@test.net");
        
        // Display the user information
        gu1.display();
    }
}
