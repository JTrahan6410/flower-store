import java.sql.*;
/**************************************************************

   Trent Cargle

   Adv Sys Project - Oct 3, 2023

 **************************************************************/
public class GuestUser {
    int userID;
    String eMail;
    String userPass;
    String fName;
    String lName;
    
    public GuestUser(){
        userID = 0;
        eMail = "";
        userPass = "";
        fName = "";
        lName = "";
    }
    
    public GuestUser(int uid, String em, String pw, String fn, String ln){
        userID = uid;
        eMail = em;
        userPass = pw;
        fName = fn;
        lName = ln;
    }
    
    public int getUserID() { return userID; }
    public void setUserID(int uid) { userID = uid; }
    public String getEMail() { return eMail; }
    public void setEMail(String em) { eMail = em; }
    public String getUserPass() { return userPass; }
    public void setUserPass(String pw) { userPass = pw; }
    public String getFName() { return fName; }
    public void setFName(String fn) { fName = fn; }
    public String getLName() { return lName; }
    public void setLName(String ln) { lName = ln; }
    
    public void display(){
        System.out.println("Guest ID = "+ getUserID());
         System.out.println("Guest Email = "+ getEMail());
          System.out.println("User Password = "+ getUserPass());
        System.out.println("Guest First Name = "+ getFName());
        System.out.println("Guest last Name = "+ getLName());
    }
    
    public void selectDB(int uid) {
        userID = uid;
	try { 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + 
                "FlowerStore/FlowerStoreDatabase.accdb");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Users WHERE userID = "+getUserID()+"";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            setEMail(rs.getString(2));
            setUserPass(rs.getString(3));
            setFName(rs.getString(4));
            setLName(rs.getString(5));
            setEMail(rs.getString(6));
            conn.close();            
	}
        catch(Exception e) {
            System.out.println(e);
	}
    }
        
        public void insertDB(int uid, String em, String pw, String fn, String ln){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + 
            "FlowerStore/FlowerStoreDatabase.accdb");
            
            Statement sta = conn.createStatement();
            String sql;
            sql = "INSERT into Users(userID, firstName, lastName, userMailAddress, email) VALUES("+uid+","+em+","+pw+","+fn+","+ln+")";
            System.out.println(sql);
            sta.executeUpdate(sql);
            conn.close();				
	}
	catch(Exception e){
            System.out.println( e);
	}
    }
        
    public void updateDB(){
        try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + 
            "FlowerStore/FlowerStoreDatabase.accdb");
            
        Statement sta = conn.createStatement();
        String sql;
        sql = "Update Users set userID = '" + getUserID() + "'," + "email = '" + getEMail() + "', " + "userPassword = '" + getUserPass() + "', " + "firstName = '" + getFName() + "', " +
            "lastName = '" + getLName();
        System.out.println(sql);
        sta.executeUpdate(sql);
        conn.close();
        }
        catch(Exception e){
        System.out.println( e);
	}
       }
      
    public void deleteDB(){
       try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + 
                "FlowerStore/FlowerStoreDatabase.accdb");
            
            Statement st = conn.createStatement();
            String sql;
            sql = "DELETE from Users Where userID = "+getUserID()+"";
            System.out.println(sql);
            st.executeUpdate(sql);
            conn.close();				
	}
	catch(Exception e){
            System.out.println( e);
	}
    }
    
      public static void main(String[] args) {
          GuestUser gu1 = new GuestUser();
		gu1.selectDB(1);
		gu1.display();
    }
}
