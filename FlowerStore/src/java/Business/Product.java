package Business;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
    private Double productCost;
    private String productOccasion;
    private String productImage;
    
        // <editor-fold defaultstate="collapsed" desc="Database Path set per user">
    
    //for Jose
    private static final String databasePath = "E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase_v4.accdb";
    
    //for Salena
//    private static final String databasePath = "C:\\Users\\lena\\OneDrive\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Jacob
    //private static final String databasePath = "E:\\Users\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase_v4.accdb";
    
    //</editor-fold>
    
    private static final String databaseURL = "jdbc:ucanaccess://" + databasePath;
    
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    /********************************************
    *                                           *
    *               Constructors                *
    *                                           *
     * @param con
    *********************************************/
    public Product(Connection con){
        this.con = con;
    }
    
    public Product() {
        productCode = "";
        productName = "";
        productDescription = "";
        productCost = 0.00;
        productOccasion = "";
        productImage = "";
    }

    public Product(String productCode, String productName, String productDescription, double productCost, String productOccasion, String productImage) {
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCost = productCost;
        this.productOccasion = productOccasion;
        this.productImage = productImage;
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
            //ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM Products WHERE productCode ='" + productCode + "'" );
            rs.next();
            
            this.productCode = rs.getString(1);
            productName = rs.getString(2);
            productDescription = rs.getString(3);
            productCost = rs.getDouble(4);
            productOccasion = rs.getString(5);
            productOccasion = rs.getString(6);
            
            con.close();
        
        }catch(Exception e){
            System.out.println(e);
        }
    }
   /*********************************************
    *                                           *
    *               InsertDB Method             *
    *                                           *
    * @param productCode                        *
    * @param productName                        *
    * @param productDescription                 *
    * @param productCost                        *
    * @param productOccasion                    *
    * @param productImage                       *
    *********************************************/
    public void insertDB(String productCode, String productName, String productDescription, double productCost, String productOccasion, String productImage){
    
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("Database connected...");
            
            Statement stmt = con.createStatement();
            
            String sql = "INSERT INTO Products VALUES ('"+productCode+"','"+productName+"','"+productDescription+"','"+productCost+"','"+productOccasion+"','"+productImage+"')";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
            con.close();
        
        }catch(Exception e){
            
            System.out.println(e);
            
        }
    }
    /********************************************
    *                                           *
    *               UpdateDB Method             *
    *                                           *
    *********************************************/
    public void updateDB(){
        try{
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("Database connected...");
            
            Statement stmt = con.createStatement();
            
            String sql = "UPDATE Products SET productCode = '"+productCode+"',productName = '"+productName+"',productDescription = '"+productDescription+"',productCost = '"+productCost+"',productOccasion = '"+productOccasion+"',productImage = '"+productImage+"'WHERE productCode ='"+productCode+"'";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
            con.close();
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    /********************************************
    *                                           *
    *               DeleteDB Method             *
    *                                           *
    *********************************************/
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
    *          GetAllProducts Method            *
    *                                           *
    * @return                                   *
    *********************************************/
    public List<Product> getAllProducts(){
        
        List<Product> products = new ArrayList<Product>();
        try{
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            Connection con = DriverManager.getConnection(databaseURL);
            
            Statement stmt = con.createStatement();
            
            rs = stmt.executeQuery("SELECT * FROM Products");
            
            while(rs.next()){
                Product row = new Product();
                row.setProductCode(rs.getString("productCode"));
                row.setProductName(rs.getString("productName"));
                row.setProductDescription(rs.getString("productDescription"));
                row.setProductCost(rs.getDouble("productCost"));
                row.setProductOccasion(rs.getString("productOccasion"));
                row.setProductImage(rs.getString("productImage"));
                
                products.add(row);
            }
            
            con.close();
        
        }catch(Exception e){
            System.out.println(e);
        }
        return products;
    }
    /********************************************
    *                                           *
    *        GetCartProducts Method             *
    *                                           *
     * @param cartList
     * @return 
    *********************************************/
    public List<Cart> getCartProducts(ArrayList<Cart> cartList){
        List<Cart> products = new ArrayList<Cart>();
        
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            Connection con = DriverManager.getConnection(databaseURL);
            if(!cartList.isEmpty()){
                for(Cart item:cartList){
                    query = "SELECT * FROM Products WHERE productCode=?";
                    pst = con.prepareStatement(query);
                    pst.setString(1, item.getProductCode());
                    rs = pst.executeQuery();

                    while(rs.next()){
                        Cart row = new Cart();
                        row.setProductCode(rs.getString("productCode"));
                        row.setProductName(rs.getString("productName"));
                        row.setProductImage(rs.getString("productImage"));
                        row.setProductDescription(rs.getString("productDescription"));
                        row.setProductCost(rs.getDouble("productCost")*item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        products.add(row);
                    }                    
                }
            }
            
        
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(e);
            
        }
        
        return products;
        
    }
    /********************************************
    *                                           *
    *        GetTotalCartPrice Method           *
    *                                           *
     * @param cartList
     * @return 
    *********************************************/
    public double getTotalCartPrice(ArrayList<Cart> cartList){
        double sum = 0;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            Connection con = DriverManager.getConnection(databaseURL);
            if(!cartList.isEmpty()){
                for(Cart item:cartList){
                    query = "SELECT productCost FROM Products WHERE productCode=?";
                    pst = con.prepareStatement(query);
                    pst.setString(1, item.getProductCode());
                    rs = pst.executeQuery();
                    
                    while(rs.next()){
                        sum += rs.getDouble("productCost") * item.getQuantity();
                    }
                }
            }
        
        }catch(Exception e){
            System.out.println(e);
        }
        return sum;
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

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }

    public String getProductOccasion() {
        return productOccasion;
    }

    public void setProductOccasion(String productOccasion) {
        this.productOccasion = productOccasion;
    }
    
    public String getProductImage(){
        return productImage;
    }
    
    public void setProductImage(String productImage){
        this.productImage = productImage;
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
        System.out.println("Image = " + productImage);
    }

    
    /*****************************************************************
*  Testing Business Object
     * @param args
******************************************************************/
    public static void main(String[] args) {
        //Product p1 = new Product();
        //p1.selectDB("P114");
        //p1.getProducts();
        //p1.display();
        
        
        //Product p2 = new Product();
        //p2.insertDB("P024", "Braves Bouquet", "Go Braves!", "100.00","gameday");
        

        //Product p3 = new Product();
        //p3.selectDB("P024");
        //p3.setProductCost("75.00");
        //p3.setProductDescription("Braves Themed assortments of flowers for GameDAY!!!");
        //p3.updateDB();
        
        //Product p4 = new Product();
        //p4.selectDB("P024");
        //p4.deleteDB();
    }  
}
