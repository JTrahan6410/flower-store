package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**************************************************************

   JACOB TRAHAN - adapted from Jose Gomez (9/18/23)

   Adv Sys Project - Oct 5, 2023

 **************************************************************/

public class User extends GuestUser {

    private static String vardatabaseURL;
    private String userPassword;
    private Boolean admin;

    // Default constructor
    public User(String databaseURL) {
        super(); // Call the constructor of the superclass (GuestUser)
        userPassword = "";
        admin = false;
    }

    // Parameterized constructor
    public User(int userID, String email, String userPassword, String firstName, String lastName, Boolean admin, String databaseURL) {
        super(userID, email, firstName, lastName, databaseURL);
        this.userPassword = userPassword;
        this.admin = admin;
    }



    // Getter and setter methods for all fields

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean getAdminStatus() {
        return admin;
    }

    public void setAdminStatus(Boolean admin) {
        this.admin = admin;
    }

    // Display method to print user information
    @Override
    public void display() {
        System.out.println("User ID = " + getUserID());
        System.out.println("User Email = " + getEMail());
        System.out.println("User Password = " + getUserPassword());
        System.out.println("First Name = " + getFirstName());
        System.out.println("Last Name = " + getLastName());
        System.out.println("Admin Status = " + getAdminStatus());
    }

    /**
     * Selects user information from the database based on email.
     *
     * @param eMail Email of the user to retrieve.
     */
    @Override
    public void selectDB(String eMail) {
        this.eMail = eMail;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                String sql = "SELECT * FROM Users WHERE email = ?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setString(1, getEMail());
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        setUserPassword(rs.getString("userPassword"));
                        setFirstName(rs.getString("firstName"));
                        setLastName(rs.getString("lastName"));
                        setAdminStatus(rs.getBoolean("admin"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    // Inserts user information into the database.
    public void insertDB(String eMail, String userPassword, String firstName, String lastName) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                String sql = "INSERT INTO Users (email, userPassword, firstName, lastName) VALUES (?, ?, ?, ?)";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setString(1, eMail);
                    statement.setString(2, userPassword);
                    statement.setString(3, firstName);
                    statement.setString(4, lastName);
                    statement.executeUpdate();
                    System.out.println(sql);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    // Updates user information in the database.
    @Override
    public void updateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                String sql = "UPDATE Users SET email = ?, password = ?, firstName = ?, lastName = ?, admin = ? WHERE email = ?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    // Set values for the placeholders in the prepared statement
                    statement.setString(1, eMail);
                    statement.setString(2, userPassword);
                    statement.setString(3, getFirstName());
                    statement.setString(4, getLastName());
                    statement.setBoolean(5, admin);
                    statement.setString(6, eMail);

                    // Execute the UPDATE statement to modify user information
                    statement.executeUpdate();

                    // Print the generated SQL query (for debugging)
                    System.out.println(sql);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        User u1 = new User(vardatabaseURL);
        u1.selectDB("jtrahan@students.chattahoocheetech.edu");
        u1.display();
    }
}
