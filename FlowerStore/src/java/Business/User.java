package Business;

import java.sql.*;


/**
 *
 * @author Jose V Gomez
 */
public class User {
    //Properties
    String userID, userPassword, firstName,
           lastName, userMailAddress, email, Field1;
    
    String databaseURL = "jdbc:ucanaccess://E:\\School Doc\\cist 2931\\FlowerStoreMDB.mdb";
    
    //Constructors
    public User(){
        super();
        userID = "";
        userPassword = "";
        firstName = "";
        lastName = "";
        userMailAddress = "";
        email = "";
        Field1 = "";
    }
    
    public User(String userID, String userPassword, String firstName, String lastName, String userMailAddress, String email, String Field1){
        this.userID = userID;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userMailAddress = userMailAddress;
        this.email = email;
        this.Field1 = Field1;
    }
    
    //Behaviors
    
/*************************************************************
* selectDB() gets one patient from the DB
     * @param userID
**************************************************************/
    public void selectDB(String userID){
        this.userID = userID;
        
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = (Connection) DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM Users WHERE userID = '"+ userID +"'");
            rs.next();
            
            userPassword = rs.getString(2);
            firstName = rs.getString(3);
            lastName = rs.getString(4);
            userMailAddress = rs.getString(5);
            email = rs.getString(6);
            Field1 = rs.getString(7);
            
            
            con.close();
            
            
            
            
        }catch(Exception e){
            
            System.out.println(e);
            
        }
        
    }
    
/*************************************************************
* insertDB() inserts one patient from the DB
     * @param userID
     * @param userPassword
     * @param firstName
     * @param lastName
     * @param userMailAddress
     * @param email
     * @param Field1
**************************************************************/
    public void insertDB(String userID, String userPassword,String firstName, String lastName, String userMailAddress, String email, String Field1){
        try{
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("Database connected...");
            
            Statement stmt = con.createStatement();
            
            String sql = "INSERT INTO Users VALUES ('"+userID+"','"+userPassword+"','"+firstName+"','"+lastName+"','"+userMailAddress+"','"+email+"','"+Field1+"')";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
            con.close();
        
        }catch(Exception e){
            
            System.out.println(e);
            
        }
    }
    
/*************************************************************
* updateDB() updates one patient from the DB
**************************************************************/
    public void updateDB(){
        try{
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("Database connected...");
            
            Statement stmt = con.createStatement();
            
            String sql = "UPDATE Users SET userID = '"+userID+"',userPassword = '"+userPassword+"',firstName = '"+firstName+"',lastName = '"+lastName+"',userMailAddress = '"+userMailAddress+"',email = '"+email+"',Field1 = '"+Field1+"' WHERE userID='"+userID+"'";
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
    public void deleteDB(){
        try{
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("DatabaseConnected...");
            
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM Users WHERE userID='"+userID+"'";
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
    
    public String getUserID(){
        return userID;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }
    
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
    
    public String getUserMailAddress(){
        return userMailAddress;
    }
    public void setUserMailAddress(String userMailAddress){
        this.userMailAddress = userMailAddress;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    
    
    
    
    //Display Method
    public void display(){
        System.out.println("userID = " + userID);
        System.out.println("Password = " + userPassword);
        System.out.println("First Name = " + firstName);
        System.out.println("Last Name = " + lastName);
        System.out.println("Address = " + userMailAddress);
        System.out.println("Email = " + email);
    }
    
/*****************************************************************
*  Testing Business Object
     * @param args
******************************************************************/
    public static void main(String[] args) {
        //User u1 = new User();
        //u1.selectDB("A912");
        //u1.display();
        
        //User u2 = new User();
        //u2.insertDB("A912", "1111", "Jose", "Gomez", "Atlanta", "J@J.com"," ");
        
        
        
        //User u3 = new User();
        //u3.selectDB("A912");
        //u3.setFirstName("Bob");
        //u3.setLastName("Joe");
        //u3.setUserMailAddress("Kennesaw");
        //u3.updateDB();
        
        //User u4 = new User();
        //u4.selectDB("A912");
        //u4.deleteDB();
    }
}
