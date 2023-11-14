package Business;

import java.sql.*;


/**
 *
 * @author Jose V Gomez
 */
public class User {
    //Properties
    String userPassword, firstName,
           lastName, email;
    
    
    // <editor-fold defaultstate="collapsed" desc="Database Path set per user">
    
    //for Jose
    final String databasePath = "E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Salena
//    final String databasePath = "C:\\Users\\lena\\OneDrive\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Jacob
    //final String databasePath = "E:\\Users\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
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