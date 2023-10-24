package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

    /********************************************
    *                                           *
    *               Jose Gomez                  *
    *               10/24/23                    *
    *        Product Business Object            *
    *                                           *
    *********************************************/
public class Product {


    /********************************************
    *                                           *
    *               Properties                  *
    *                                           *
    *********************************************/
    private String productCode;
    private String productName;
    private String productDescription;
    private String productCost;
    private String productOccasion;
    String databaseURL = "jdbc:ucanaccess://E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";

    /********************************************
    *                                           *
    *               Constructors                *
    *                                           *
    *********************************************/
    public Product() {
    }

    public Product(String productCode, String productName, String productDescription, String productCost, String productOccasion) {
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCost = productCost;
        this.productOccasion = productOccasion;
    }

    /********************************************
    *                                           *
    *               Behaviors                   *
    *                                           *
    *********************************************/
    
    public void selectDB(String productCode){
        
        this.productCode = productCode;
        
        try{
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = (Connection) DriverManager.getConnection(databaseURL);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM Products WHERE productCode ='" + productCode + "'" );
            rs.next();
            
            this.productCode = rs.getString(1);
            productName = rs.getString(2);
            productDescription = rs.getString(3);
            productCost = rs.getString(4);
            productOccasion = rs.getString(5);

            con.close();
        
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void insertDB(String productCode, String productName, String productDescription, String productCost, String productOccasion){
    
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("Database connected...");
            
            Statement stmt = con.createStatement();
            
            String sql = "INSERT INTO Products VALUES ('"+productCode+"','"+productName+"','"+productDescription+"','"+productCost+"','"+productOccasion+"')";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
            con.close();
        
        }catch(Exception e){
            
            System.out.println(e);
            
        }
    }
    
    public void updateDB(){
        try{
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("Database connected...");
            
            Statement stmt = con.createStatement();
            
            String sql = "UPDATE Products SET productCode = '"+productCode+"',productName = '"+productName+"',productDescription = '"+productDescription+"',productCost = '"+productCost+"',productOccasion = '"+productOccasion+"'WHERE productCode ='"+productCode+"'";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
            con.close();
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void deleteDB(){
        try{
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("DatabaseConnected...");
            
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM Products WHERE productCode='"+productCode+"'";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
            con.close();
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    /********************************************
    *                                           *
    *           Getters and Setters             *
    *                                           *
    *********************************************/
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCost() {
        return productCost;
    }

    public void setProductCost(String productCost) {
        this.productCost = productCost;
    }

    public String getProductOccation() {
        return productOccasion;
    }

    public void setProductOccation(String productOccasion) {
        this.productOccasion = productOccasion;
    }

    @Override
    public String toString() {
        return "Product{" + "productCode=" + productCode + ", productName=" + productName + ", productDescription=" + productDescription + ", productCost=" + productCost + ", productOccasion=" + productOccasion + '}';
    }

    
    //Display Method
    public void display(){
        
        System.out.println("Code = " + productCode);
        System.out.println("Name = " + productName);
        System.out.println("Description = " + productDescription);
        System.out.println("Cost = " + productCost);
        System.out.println("Occasion = " + productOccasion);
    }

    
    /*****************************************************************
*  Testing Business Object
     * @param args
******************************************************************/
    public static void main(String[] args) {
        //Product p1 = new Product();
        //p1.selectDB("P114");
        //p1.display();
        
        //Product p2 = new Product();
        //p2.insertDB("P024", "Braves Bouquet", "Go Braves!", "100.00","gameday");
        

        //Product p3 = new Product();
        //p3.selectDB("P024");
        //p3.setProductCost("75.00");
        //p3.setProductDescription("Braves Themed assortments of flowers for GameDAY!!!");
        //p3.updateDB();
        
        Product p4 = new Product();
        p4.selectDB("P024");
        p4.deleteDB();
    }
    
    
        
}
