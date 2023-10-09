package Business;

import java.sql.*;

/**************************************************************

   JACOB TRAHAN - adapted from Trent Cargle (9/18/23)

   Adv Sys Project - Oct 5, 2023

 **************************************************************/

public class GuestUser {
    protected int userID;
    protected String firstName, lastName, eMail;
    protected final String databaseURL = "../FlowerStore/FlowerStoreDatabase.accdb";
    
    public GuestUser() {
        userID = 0;
        eMail = "";
        firstName = "";
        lastName = "";
       
    }
    
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
    
    
    public void display() {
        System.out.println("Guest ID = " + getUserID());
        System.out.println("Guest Email = " + getEMail());
        System.out.println("Guest First Name = " + getFirstName());
        System.out.println("Guest Last Name = " + getLastName());
    }
    
// Method to retrieve user data from the database based on the email
public void selectDB(String eMail) {
    // Set the email for which data needs to be retrieved
    this.eMail = eMail;
        try { 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM Users WHERE userID = " + getEMail();
                System.out.println(sql);
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    setFirstName(rs.getString("firstName"));
                    setLastName(rs.getString("lastName"));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

public void insertDB(int userID, String eMail, String firstName, String lastName) {
     try {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
            String sql = "INSERT INTO Users (email, firstName, lastName) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, eMail);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.executeUpdate();
            System.out.println(sql);
            statement.executeUpdate(sql);
        }				
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println(e);
        }
    }
      
public void updateDB() {
     try {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
            String sql = "UPDATE Users SET email = ?, firstName = ?, lastName = ? WHERE email = ?";
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
        System.out.println(e);
        }
    }

public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + databaseURL)) {
                Statement st = conn.createStatement();
                String sql = "DELETE from Users Where userID = " + getUserID();
                System.out.println(sql);
                st.executeUpdate(sql);
            }				
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
//Test
public static void main(String[] args) {
        GuestUser gu1 = new GuestUser();
        gu1.selectDB("guest@test.net");
        gu1.display();
    }
}
