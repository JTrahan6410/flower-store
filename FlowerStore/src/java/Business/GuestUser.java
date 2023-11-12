package Business;

import java.sql.*;
/**************************************************************

   Trent Cargle

   Adv Sys Project - Sept 18, 2023

 **************************************************************/
public class GuestUser {
    String userID;
    String fName;
    String lName;
    String eMail;
    String address;
    String city;
    String state;
    int zip;
    String nameOnCard;
    String cardNum;
    String expMonth;
    int expYear;
    int cvv;
    
    public GuestUser(){
        userID = "";
        fName = "";
        lName = "";
        eMail = "";
        address = "";
        city = "";
        state = "";
        zip = 0;
        nameOnCard = "";
        cardNum = "";
        expMonth = "";
        expYear = 0;
        cvv = 0;
    }
    
    public GuestUser(String uid, String fn, String ln, String em, String add, String ci, String st, int z, String noc, String cn, String exm, int exy, int cv){
        userID = uid;
        fName = fn;
        lName = ln;
        eMail = em;
        address = add;
        city = ci;
        state = st;
        zip = z;
        nameOnCard = noc;
        cardNum = cn;
        expMonth = exm;
        expYear = exy;
        cvv = cv;
    }
    
    public String getUserID() { return userID; }
    public void setUserID(String uid) { userID = uid; }
    public String getFName() { return fName; }
    public void setFName(String fn) { fName = fn; }
    public String getLName() { return lName; }
    public void setLName(String ln) { lName = ln; }
    public String getEMail() { return eMail; }
    public void setEMail(String em) { eMail = em; }
    public String getAddress() { return address; }
    public void setAddress(String add) { address = add; }
    public String getCity() { return city; }
    public void setCity(String ci) { city = ci; }
    public String getState() { return state; }
    public void setState(String st) { state = st; }
    public int getZip() { return zip; }
    public void setZip(int z) { zip = z; }
    public String getNameOnCard() { return nameOnCard; }
    public void setNameOnCard(String noc) { nameOnCard = noc; }
    public String getCardNum() { return cardNum; }
    public void setCardNum(String cn) { cardNum = cn; }
    public String getExpMonth() { return expMonth; }
    public void setExpMonth(String exm) { expMonth = exm; }
    public int getExpYear() { return expYear; }
    public void setExpYear(int exy) { expYear = exy; }
    public int getCvv() { return cvv; }
    public void setCvv(int cv) { cvv = cv; }
    
    public void display(){
        System.out.println("Guest ID = "+ getUserID());
        System.out.println("Guest First Name = "+ getFName());
        System.out.println("Guest last Name = "+ getLName());
        System.out.println("Guest Email = "+ getEMail());
        System.out.println("Guest Address = "+ getAddress());
        System.out.println("Guest City = "+ getCity());
        System.out.println("Guest State = "+ getState());
        System.out.println("Guest Zip = "+ getZip());
        System.out.println("Guest Card Name = "+ getNameOnCard());
        System.out.println("Guest Card Number = "+ getCardNum());
        System.out.println("Card Expiration Month = "+ getExpMonth());
        System.out.println("Card Expiration Year= "+ getExpYear());
        System.out.println("Guest cvv = "+ getCvv());
    }
    
    public void selectDB(String uid) {
        userID = uid;
	try { 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + 
                "FlowerStore//FlowerStoreMDB.mdb");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Users WHERE userID = "+getUserID()+"";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            setFName(rs.getString(2));
            setLName(rs.getString(3));
            setEMail(rs.getString(4));
            setAddress(rs.getString(5));
            setCity(rs.getString(6));
            setState(rs.getString(7));
            setZip(rs.getInt(8));
            setNameOnCard(rs.getString(9));
            setCardNum(rs.getString(10));
            setExpMonth(rs.getString(11));
            setExpYear(rs.getInt(12));
            setCvv(rs.getInt(13));
            conn.close();            
	}
        catch(Exception e) {
            System.out.println(e);
	}
    }
        
        public void insertDB(int uid, String fn, String ln, String em, String add, String ci, String st, int z, String noc, String cn, String exm, int exy, int cv){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + 
            "FlowerStore/FlowerStoreMDB.mdb");
            
            Statement sta = conn.createStatement();
            String sql;
            sql = "INSERT into Users(userID, firstName, lastName, userMailAddress, email) VALUES("+uid+","+fn+","+ln+""+ci+","+em+")";
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
                "FlowerStore/FlowerStoreMDB.mdb");
            
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
		gu1.selectDB("A900");
		gu1.display();
    }
}