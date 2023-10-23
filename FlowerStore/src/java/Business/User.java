package Business;

import java.sql.*;

/**************************************************************

   JACOB TRAHAN - adapted from Jose Gomez (9/18/23)

   Adv Sys Project - Oct 5, 2023

 **************************************************************/

public class User extends GuestUser{
    private String userPassword;
    private Boolean admin;
    
    public User() {
        super();
        userPassword = "";
        admin = false;
    }

    public User(int userID, String email, String userPassword, String firstName, String lastName, Boolean admin) {
        this.userPassword = userPassword;
        this.admin = admin;
    }

    // Getter and setter methods for all fields
 
    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
    
    public Boolean getAdminStatus() { return admin; }
    public void setAdminStatus(Boolean admin) { this.admin = admin; }
    
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
     *
     * @param eMail
     */
    @Override
    public void selectDB(String eMail) {
        this.eMail = eMail;
        try { 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM Users WHERE email = " + getEMail();
                System.out.println(sql);
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    setUserPassword(rs.getString("userPassword"));
                    setFirstName(rs.getString("firstName"));
                    setLastName(rs.getString("lastName"));
                    setAdminStatus(rs.getBoolean("admin"));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public void insertDB(String eMail, String userPassword, String firstName, String lastName) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                Statement sta = conn.createStatement();
                String sql = "INSERT INTO Users (email, userPassword, firstName, lastName) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, eMail);
                statement.setString(2, userPassword);
                statement.setString(3, firstName);
                statement.setString(4, lastName);
                statement.executeUpdate();
                System.out.println(sql);
                sta.executeUpdate(sql);
            }				
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void updateDB() {
     try {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
            String sql = "UPDATE Users SET email = ?, password = ?, firstName = ?, lastName = ?, admin = ? WHERE email = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            // Set values for the placeholders in the prepared statement
            statement.setString(1, eMail);
            statement.setString(2, userPassword);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setBoolean(5, admin);
            statement.setString(6, eMail);

            // Execute the UPDATE statement to modify user information
            statement.executeUpdate();

            // Print the generated SQL query (for debugging)
            System.out.println(sql);
        }
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println(e);
        }
    }
    
    
    public static void main(String[] args) {
        User u1 = new User();
        u1.selectDB("jtrahan@students.chattahoocheetech.edu");
        u1.display();
    }
}
