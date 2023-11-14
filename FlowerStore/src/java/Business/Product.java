package Business;

<<<<<<< Updated upstream
import java.sql.*;
=======
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    private Double productCost;
    private String productOccasion;
    private String productImage;
    
        // <editor-fold defaultstate="collapsed" desc="Database Path set per user">
    
    //for Jose
//    final String databasePath = "E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Salena
//    final String databasePath = "C:\\Users\\lena\\OneDrive\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Jacob
    final String databasePath = "E:\\Users\\Documents\\GitHub\\flower-store\\FlowerStore\\web\\WEB-INF\\FlowerStoreDatabase.accdb";
    
    //</editor-fold>
    
    final String databaseURL = "jdbc:ucanaccess://" + databasePath;
    
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;
=======
    private double productCost;
    private String productOccasion;
    private String productImage;
    
    // <editor-fold defaultstate="collapsed" desc="Database Path set per user">
    
    //for Jose
//    private final String databasePath = "E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Salena
//    private final String databasePath = "C:\\Users\\lena\\OneDrive\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Jacob
    private final String databasePath = "E:\\Users\\Documents\\GitHub\\flower-store\\FlowerStore\\web\\WEB-INF\\FlowerStoreDatabase.accdb";
    
    //</editor-fold>
    private final String databaseURL = "jdbc:ucanaccess://" + databasePath;
>>>>>>> Stashed changes

    /********************************************
    *                                           *
    *               Constructors                *
    *                                           *
    *********************************************/
    public Product(Connection con){
        this.con = con;
    }
    
    public Product() {
        productCode = "";
        productName = "";
        productDescription = "";
<<<<<<< Updated upstream
        productCost = 0.00;
=======
        productCost = 0;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
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
=======
    public void selectDB(String productCode) {
        String sql = "SELECT * FROM Product WHERE productCode = ?";
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, productCode);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                setProductCode(rs.getString("productCode"));
                setProductName(rs.getString("productName"));
                setProductDescription(rs.getString("productDescription"));
                setProductCost(rs.getDouble("productCost"));
                setProductOccasion(rs.getString("productOccasion"));
                setProductImage(rs.getString("productImage"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertDB() {
        String sql = "INSERT INTO Product (productCode, productName, productDescription, productCost, productOccasion, productImage) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getProductCode());
            stmt.setString(2, getProductName());
            stmt.setString(3, getProductDescription());
            stmt.setDouble(4, getProductCost());
            stmt.setString(5, getProductOccasion());
            stmt.setString(6, getProductImage());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateDB() {
        String sql = "UPDATE Product SET productName = ?, productDescription = ?, productCost = ?, productOccasion = ?, productImage = ? WHERE productCode = ?";
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, getProductName());
            stmt.setString(2, getProductDescription());
            stmt.setDouble(3, getProductCost());
            stmt.setString(4, getProductOccasion());
            stmt.setString(5, getProductImage());
            stmt.setString(6, getProductCode());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteDB() {
        String sql = "DELETE FROM Product WHERE productCode = ?";
        try (Connection conn = DriverManager.getConnection(databaseURL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, this.productCode);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Product> getAllProducts(){
    List<Product> products = new ArrayList<>();
    String sql = "SELECT * FROM Products";
    try (Connection con = DriverManager.getConnection(databaseURL);
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        
        while(rs.next()){
            Product row = new Product();
            row.setProductCode(rs.getString("productCode"));
            row.setProductName(rs.getString("productName"));
            row.setProductDescription(rs.getString("productDescription"));
            row.setProductCost(rs.getDouble("productCost"));
            row.setProductOccasion(rs.getString("productOccasion"));
            row.setProductImage(rs.getString("productImage"));
            products.add(row);
>>>>>>> Stashed changes
        }
        //getAllProducts();
    }
    
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
    
    public List<Product> getAllProducts(){
        
        String an;
        Product p1;
        List<Product> products = new ArrayList<Product>();
        try{
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            Connection con = DriverManager.getConnection(databaseURL);
            
            Statement stmt = con.createStatement();
            
            //ResultSet rs;
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
    
    public List<Cart> getCartProducts(ArrayList<Cart> cartList){
<<<<<<< Updated upstream
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
=======
    List<Cart> products = new ArrayList<>();
    if (!cartList.isEmpty()) {
        String sql = "SELECT * FROM Products WHERE productCode = ?";
        try (Connection con = DriverManager.getConnection(databaseURL);
             PreparedStatement stmt = con.prepareStatement(sql)) {
>>>>>>> Stashed changes

                    while(rs.next()){
                        Cart row = new Cart();
                        row.setProductCode(rs.getString("productCode"));
                        row.setProductName(rs.getString("productName"));
                        row.setProductImage(rs.getString("productImage"));
                        row.setProductDescription(rs.getString("productDescription"));
<<<<<<< Updated upstream
                        row.setProductCost(rs.getDouble("productCost")*item.getQuantity());
=======
                        row.setProductCost(rs.getDouble("productCost"));
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    
    
    /********************************************
    *                                           *
    *           Getters and Setters             *
    *                                           *
    *********************************************/
=======
    return products;
}

    // <editor-fold defaultstate="collapsed" desc="Getter and setters">

>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
=======
    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
>>>>>>> Stashed changes
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

    // </editor-fold>
    
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
