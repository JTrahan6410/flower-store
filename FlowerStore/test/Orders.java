import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**************************************************************

   Trent Cargle

   Adv Sys Project - Sept 30, 2023

 **************************************************************/
public class Orders {
    int orderID;
    int userID;
    String prodCode;
    String orderPlaced;
    String reqDelivery;
    String mailName;
    String mailStreet;
    String mailCity;
    String mailState;
    int mailZip;
    String billName;
    String billStreet;
    String billCity;
    String billState;
    int billZip;
    
    public Orders(){
        orderID = 0;
        userID = 0;
        prodCode = "";
        orderPlaced = "";
        reqDelivery = "";
        mailName = "";
        mailStreet = "";
        mailCity = "";
        mailState = "";
        mailZip = 0;
        billName = "";
        billStreet = "";
        billCity = "";
        billState = "";
        billZip = 0;
    }
    
    public Orders(int oid, int uid, String pc, String op, String rd, String mn, String mstr, String mc, String msta, int mz, String bn, String bstr, String bc, String bsta, int bz){
        orderID = oid;
        userID = uid;
        prodCode = pc;
        orderPlaced = op;
        reqDelivery = rd;
        mailName = mn;
        mailStreet = mstr;
        mailCity = mc;
        mailState = msta;
        mailZip = mz;
        billName = bn;
        billStreet = bstr;
        billCity = bc;
        billState = bsta;
        billZip = bz;
    }
    
    public int getOrderID() { return orderID; }
    public void setOrderID(int oid) { orderID = oid; }
    public int getUserID() { return userID; }
    public void setUserID(int uid) { userID = uid; }
    public String getProdCode() { return prodCode; }
    public void setProdCode(String pc) { prodCode = pc; }
    public String getOrderPlaced() { return orderPlaced; }
    public void setOrderPlaced(String op) { orderPlaced = op; }
    public String getReqDelivery() { return reqDelivery; }
    public void setReqDelivery(String rd) { reqDelivery = rd; }
    public String getMailName() { return mailName; }
    public void setMailName(String mn) { mailName = mn; }
    public String getMailStreet() { return mailStreet; }
    public void setMailStreet(String mstr) { mailStreet = mstr; }
    public String getMailCity() { return mailCity; }
    public void setMailCity(String mc) { mailCity = mc; }
    public String getMailState() { return mailState; }
    public void setMailState(String msta) { mailState = msta; }
    public int getMailZip() { return mailZip; }
    public void setMailZip(int mz) { mailZip = mz; }
    public String getBillName() { return billName; }
    public void setBillName(String bn) { billName = bn; }
    public String getBillStreet() { return billStreet; }
    public void setBillStreet(String bstr) { billStreet = bstr; }
    public String getBillCity() { return billCity ; }
    public void setBillCity(String bc) { billCity  = bc; }
    public String getBillState() { return billState; }
    public void setBillState(String bsta) { billState = bsta; }
    public int getBillZip() { return billZip; }
    public void setBillZip(int bz) { billZip = bz; }
    
    public void display(){
        System.out.println("Order ID = "+ getOrderID());
        System.out.println("User ID = "+ getUserID());
        System.out.println("Product Code = "+ getProdCode());
        System.out.println("Order placement date = "+ getOrderPlaced());
        System.out.println("Requested delivery = "+ getReqDelivery());
        System.out.println("Mailing name = "+ getMailName());
        System.out.println("Mailing Street = "+ getMailStreet());
        System.out.println("Mailing City = "+ getMailCity());
        System.out.println("Mailing State = "+ getMailState());
        System.out.println("Mailing Zip = "+ getMailZip());
        System.out.println("Billing Name = "+ getBillName());
        System.out.println("Billing Street = "+ getBillStreet());
        System.out.println("Billing City = "+ getBillCity());
        System.out.println("Billing State = "+ getBillState());
        System.out.println("Billing Zip = "+ getBillZip());
    }
    
    public void selectDB(int oid) {
        orderID = oid;
	try { 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + 
                "FlowerStore/FlowerStoreDatabase.accdb");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Orders WHERE orderID = "+getOrderID()+"";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            setUserID(rs.getInt(2));
            setProdCode(rs.getString(3));
            setOrderPlaced(rs.getString(4));
            setReqDelivery(rs.getString(5));
            setMailName(rs.getString(6));
            setMailStreet(rs.getString(7));
            setMailCity(rs.getString(8));
            setMailState(rs.getString(9));
            setMailZip(rs.getInt(10));
            setBillName(rs.getString(11));
            setBillStreet(rs.getString(12));
            setBillCity(rs.getString(13));
            setBillState(rs.getString(14));
            setBillZip(rs.getInt(15));
            conn.close();            
	}
        catch(Exception e) {
            System.out.println(e);
	}
    }
        
        public void insertDB(int oid, int uid, String pc, String op, String rd, String mn, String mstr, String mc, String msta, int mz, String bn, String bstr, String bc, String bsta, int bz){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + 
            "FlowerStore/FlowerStoreDatabase.accdb");
            
            Statement sta = conn.createStatement();
            String sql;
            sql = "INSERT into Orders(orderID, userID, productCode, orderPlaced, requstedDeliveryDate, mailName, mailStreetAddress, mailCity, mailState, mailZiIP, billName, billStreetAddress, billCity, billState, billZIP, email) VALUES("+oid+","+uid+","+pc+""+op+","+rd+", "+mn+", "+mstr+", "+mc+", "+msta+", "+mz+","
                    + " "+bn+", "+bstr+", "+bc+", "+bsta+", "+bz+")";
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
                sql = "Update Orders set orderID = '" + getOrderID() + "'," + "userID = '" + getUserID() + "', " + "productCode = '" + getProdCode() + "', " + "orderPlaced = '" + getOrderPlaced() + "', " +
                         "requestedDeliveryDate = '" + getReqDelivery() + "', " + "mailName = '" + getMailName() + "', " +"mailStreetAddress = '" + getMailStreet() + "', " + "mailCity = " + getMailCity() +
                        "mailState= " + getMailState() + "mailZip = " + getMailZip() + "billName = " + getBillName() + "billStreet = " + getBillStreet() + "billCity = " + getBillCity() +
                         "billState = " + getBillState() + "billZip = " + getBillZip();
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
            sql = "DELETE from Orders Where orderID = "+getOrderID()+"";
            System.out.println(sql);
            st.executeUpdate(sql);
            conn.close();				
	}
	catch(Exception e){
            System.out.println( e);
	}
    }
    
      public static void main(String[] args) {
          Orders o1 = new Orders();
		o1.selectDB(1);
		o1.display();
    }
}
