package business;

import java.sql.*;

/**
 *
 * @author lena
 */
public class Order {
    private int orderID;
    private String email;
    private String productCode;
    private String orderPlaced;
    private String requestedDelivery;
    private String mailName, mailStreetAddress, mailCity, mailState;
    private int mailZip;
    private String billName, billStreetAddress, billCity, billState;
    private int billZip;
    // <editor-fold defaultstate="collapsed" desc="Database Path set per user">
    
    //for Jose
    final String databasePath = "E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase_v4.accdb";
    
    //for Salena
//    final String databasePath = "C:\\Users\\lena\\OneDrive\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Jacob
    //final String databasePath = "E:\\Users\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase_v4.accdb";
    
    //</editor-fold>
    
    final String databaseURL = "jdbc:ucanaccess://" + databasePath;
    
    public Order() {
        orderID = 0;
        email = "";
        productCode = "";
        orderPlaced = "";
        requestedDelivery = "";
        mailName = "";
        mailStreetAddress = "";
        mailCity = "";
        mailState = "";
        mailZip = 0;
        billName = "";
        billStreetAddress = "";
        billCity = "";
        billState = "";
        billZip = 0;
        
    }

    public Order(int orderID, String email, String productCode, String orderPlaced, String requestedDelivery, String mailName, String mailStreetAddress, String mailCity, String mailState, int mailZip, String billName, String billStreetAddress, String billCity, String billState, int billZip) {
        this.orderID = orderID;
        this.email = email;
        this.productCode = productCode;
        this.orderPlaced = orderPlaced;
        this.requestedDelivery = requestedDelivery;
        this.mailName = mailName;
        this.mailStreetAddress = mailStreetAddress;
        this.mailCity = mailCity;
        this.mailState = mailState;
        this.mailZip = mailZip;
        this.billName = billName;
        this.billStreetAddress = billStreetAddress;
        this.billCity = billCity;
        this.billState = billState;
        this.billZip = billZip;
    }
    
    public int getorderID() { return orderID; }
    public void setoderID(int orderID) { this.orderID = orderID; }
    
    public String getemail() { return email; }
    public void setemail(String email) { this.email = email; }
    
    public String getproductCode() { return productCode; }
    public void setproductCode(String productCode) { this.productCode = productCode; }
    
    public String getorderPlaced() { return orderPlaced; }
    public void setorderPlaced(String orderPlaced) { this.orderPlaced = orderPlaced; }
    
    public String getrequestedDelivery() { return requestedDelivery; }
    public void setrequestedDelivery(String requestedDelivery) { this.requestedDelivery = requestedDelivery; }
    
    public String getmailName() { return mailName; }
    public void setmailName(String mailName) { this.mailName = mailName; }

    public String getmailStreetAddress() { return mailStreetAddress; }
    public void setmailStreetAddress(String mailStreetAddress) { this.mailStreetAddress = mailStreetAddress; }
    
    public String getmailCity() { return mailCity; }
    public void setmailCity(String mailCity) { this.mailCity = mailCity; }
    
    public String getmailState() { return mailState; }
    public void setmailState(String mailState) { this.mailState = mailState; }

    public int getmailZip() { return mailZip; }
    public void setmailZip(int mailZip) { this.mailZip = mailZip; }
    
    public String getbillName() { return billName; }
    public void setbillName(String billName) { this.billName = billName; }

    public String getbillStreetAddress() { return billStreetAddress; }
    public void setbillStreetAddress(String billStreetAddress) { this.billStreetAddress = billStreetAddress; }
    
    public String getbillCity() { return billCity; }
    public void setbillCity(String billCity) { this.billCity = billCity; }
    
    public String getbillState() { return billState; }
    public void setbillState(String billState) { this.billState = billState; }

    public int getbillZip() { return billZip; }
    public void setbillZip(int billZip) { this.billZip = billZip; }
    
    public void display() {
        System.out.println("Order ID = " + getorderID());
        System.out.println("Email = " + getemail());
        System.out.println("Product Code = " + getproductCode());
        System.out.println("Order Placed = " + getorderPlaced());
        System.out.println("Requested Delivery = " + getrequestedDelivery());
        System.out.println("Mailing Name = " + getmailName());
        System.out.println("Mailing Street Address= " + getmailStreetAddress());
        System.out.println("Mailing City = " + getmailCity());
        System.out.println("Mailing State = " + getmailState());
        System.out.println("Mailing Zip= " + getmailZip());
        System.out.println("Billing Name = " + getbillName());
        System.out.println("Billing Street Address= " + getbillStreetAddress());
        System.out.println("Billing City = " + getbillCity());
        System.out.println("Billing State = " + getbillState());
        System.out.println("Billing Zip= " + getbillZip());
    }
    
    public void selectDB(int orderID) {
        this.orderID = orderID;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = (Connection) DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM Orders WHERE orderID = '" + orderID + "'" );
            rs.next();
                    this.orderID = rs.getInt(1);
                    email = rs.getString(2);
                    productCode = rs.getString(3);
                    orderPlaced = rs.getString(4);
                    requestedDelivery = rs.getString(5);
                    mailName = rs.getString(6);
                    mailStreetAddress = rs.getString(7);
                    mailCity = rs.getString(8);
                    mailState = rs.getString(9);
                    mailZip = rs.getInt(10);
                    billName = rs.getString(11);
                    billStreetAddress = rs.getString(12);
                    billCity = rs.getString(13);
                    billState = rs.getString(14);
                    billZip = rs.getInt(15);
            con.close();
   
        }
        catch(Exception e){
            
            System.out.println(e);   
        }
    }
    
    public void insertDB(int orderID, String email, String productCode, String orderPlaced, String requestedDelivery, String mailName, String mailStreetAddress, String mailCity, String mailState, int mailZip, String billName, String billStreetAddress, String billCity, String billState, int billZip){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("Database connected...");
            
            Statement stmt = con.createStatement();
            
            String sql = "INSERT INTO Orders VALUES ('"+orderID+"','" +email+"','" +productCode+"','" +orderPlaced+"','"+requestedDelivery+"','"+mailName+"','"+mailStreetAddress+"','"+mailCity+"','"+mailState+"','"+mailZip+"','"+billName+"','"+billStreetAddress+"','"+billCity+"','"+billState+"','"+billZip+"')";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
            con.close();
            				
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public void updateDB() {
     try {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("Database connected...");
            
            Statement stmt = con.createStatement();
            String sql = "UPDATE Orders SET orderID = '"+orderID+"', email = '"+email+"', productCode = '"+productCode+"', orderPlaced = '"+orderPlaced+"', requestedDelivery = '"+requestedDelivery+"', mailName = '"+mailName+"', mailStreetAddress = '"+mailStreetAddress+"', mailCity = '"+mailCity+"', mailState = '"+mailState+"', mailZip = '"+mailZip+"', billName = '"+billName+"', billStreetAddress = '"+billStreetAddress+"', billCity = '"+billCity+"', billState = '"+billState+"', billZip = '"+billZip+"'WHERE orderID =" + getorderID();
            
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
            con.close();
        
    }catch (ClassNotFoundException | SQLException e) {
        System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        //Order o1 = new Order();
        //o1.selectDB(1);
        //o1.display();
        
        //Order o2 = new Order();
        //o2.insertDB(4, "6", "P800", "10/18/23 12:35:00 pm", "", "Samuel Smith", "306 Turner St", "Flushing", "NY", 10034, "Elma Clarissa", "600 Mayfair St", "Brooklyn", "NY", 11218);

        //Order o3 = new Order();
        //o3.selectDB(3);
        //o3.setbillStreetAddress("648 Eiffle St");
        //o3.updateDB();
    }
}
