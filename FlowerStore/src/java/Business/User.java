package Business;

<<<<<<< Updated upstream
import java.sql.*;

=======
// Utilizing the DatabaseHook class for database connections
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
>>>>>>> Stashed changes

/**
 *
 * @author Jose V Gomez
 */
<<<<<<< Updated upstream
public class User {
    //Properties
    String userPassword, firstName,
           lastName, email;
    
    
    // <editor-fold defaultstate="collapsed" desc="Database Path set per user">
    
    //for Jose
//    final String databasePath = "E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Salena
//    final String databasePath = "C:\\Users\\lena\\OneDrive\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Jacob
    final String databasePath = "E:\\Users\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //</editor-fold>
    
    final String databaseURL = "jdbc:ucanaccess://" + databasePath;
    
    //Constructors
    public User(){
        super();
        email = "";
        userPassword = "";
        firstName = "";
        lastName = "";
    }
    
    public User(String email, String userPassword, String firstName, String lastName){
        
        this.email = email;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        
    }
    
    //Behaviors
    
/*************************************************************
* selectDB() gets one patient from the DB
     * @param email
**************************************************************/
    
    public void selectDB(String email){
        this.email = email;
        
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = (Connection) DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM Users WHERE email = '" + email + "'" );
            
            rs.next();
            
            this.email = rs.getString(1);
            userPassword = rs.getString(2);
            firstName = rs.getString(3);
            lastName = rs.getString(4);
            
            
            con.close();
            
            
            
            
        }catch(Exception e){
            
            System.out.println(e);
            
        }
        
    }
    
/*************************************************************
* insertDB() inserts one patient from the DB
     * @param userPassword
     * @param firstName
     * @param lastName
     * @param email
**************************************************************/
    public void insertDB(String email, String userPassword,String firstName, String lastName ){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("Database connected...");
            
            Statement stmt = con.createStatement();
            
            String sql = "INSERT INTO Users VALUES ('"+email+"','"+userPassword+"','"+firstName+"','"+lastName+"')";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
            con.close();
        
        }catch(Exception e){
            
            System.out.println(e);
            
=======
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

    // <editor-fold desc="Getters and setters">
    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
    public Boolean getAdmin() { return admin; }
    public void setAdmin(Boolean admin) { this.admin = admin; }

    // </editor-fold>
    
    // Display method overriding the superclass method to include admin status
    @Override
    public void display() {
        super.display(); // Call the display method of the superclass
        System.out.println("User Password: " + getUserPassword());
        System.out.println("Admin Status: " + getAdmin());
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
        try (Connection conn = DriverManager.getConnection(databaseURL);
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
        String sql = "UPDATE Users SET email = ?, userPassword = ?, firstName = ?, lastName = ?, streetAddress = ?, city = ?, state = ?, ZIP = ? WHERE userID = ?";
        try (Connection conn = DriverManager.getConnection(databaseURL);
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
>>>>>>> Stashed changes
        }
    }
    
/*************************************************************
* updateDB() updates one patient from the DB
**************************************************************/
    public void updateDB(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("Database connected...");
            
            Statement stmt = con.createStatement();
            
            String sql = "UPDATE Users SET email = '"+email+"',userPassword = '"+userPassword+"',firstName = '"+firstName+"',lastName = '"+lastName+"'WHERE email ='"+email+"'";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
/*************************************************************
* deleteDB() deletes one patient from the DB
**************************************************************/
    /*public void deleteDB(){
        try{
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("DatabaseConnected...");
            
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM Users WHERE email='"+email+"'";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
            con.close();
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
/*****************************************************************
* getOrders() gets all the patient appointments from the DB
******************************************************************/
    
/*****************************************************************
* getOrderDesciption() gets the patient procedure from the DB 
     * @return 
******************************************************************/
    
    //Get and Set Methods
    
    
    public String getUserPassword(){
        return userPassword;
    }
    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    
    
    
    
    //Display Method
    public void display(){
        
        System.out.println("Email = " + email);
        System.out.println("Password = " + userPassword);
        System.out.println("First Name = " + firstName);
        System.out.println("Last Name = " + lastName);
    }
    
/*****************************************************************
*  Testing Business Object
     * @param args
******************************************************************/
    public static void main(String[] args) {
        User u1 = new User();
        u1.selectDB("jose@gmail.com");
        u1.display();
        
        //User u2 = new User();
        //u2.insertDB("bob@bob.com", "1111", "Jose", "Gomez");
        
        
        
        //User u3 = new User();
        //u3.selectDB("jose@gmail.com");
        //u3.setFirstName("Bob");
        //u3.setLastName("Joe");
        
        //u3.updateDB();
        
        //User u4 = new User();
        //u4.selectDB("A912");
        //u4.deleteDB();
    }
}