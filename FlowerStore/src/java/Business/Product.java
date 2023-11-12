package Business;

import Database.DatabaseHook;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

   /********************************************
    *                                           *
    *               Jose Gomez
    *               10/24/23                    *
    *        ADAPTED BY JACOB T 11/12           *
    *        Product Business Object            *
    *                                           *
    *********************************************/

public class Product {
    private String productCode;
    private String productName;
    private String productDescription;
    private BigDecimal productCost;
    private String productOccasion;
    private String productImage;

    public Product() {
        productCode = "";
        productName = "";
        productDescription = "";
        productCost = BigDecimal.ZERO;
        productOccasion = "";
        productImage = "";
    }

    public Product(String productCode, String productName, String productDescription, BigDecimal productCost, String productOccasion, String productImage) {
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCost = productCost;
        this.productOccasion = productOccasion;
        this.productImage = productImage;
    }

    public void selectDB(String productCode) {
        String sql = "SELECT * FROM Product WHERE productCode = ?";
        try (Connection conn = DatabaseHook.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, productCode);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                setProductCode(rs.getString("productCode"));
                setProductName(rs.getString("productName"));
                setProductDescription(rs.getString("productDescription"));
                setProductCost(rs.getBigDecimal("productCost"));
                setProductOccasion(rs.getString("productOccasion"));
                setProductImage(rs.getString("productImage"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertDB(String productCode, String productName, String productDescription, double productCost, String productOccasion, String productImage) {
        String sql = "INSERT INTO Products (productCode, productName, productDescription, productCost, productOccasion, productImage) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseHook.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, productCode);
            stmt.setString(2, productName);
            stmt.setString(3, productDescription);
            stmt.setDouble(4, productCost);
            stmt.setString(5, productOccasion);
            stmt.setString(6, productImage);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateDB() {
        String sql = "UPDATE Products SET productName = ?, productDescription = ?, productCost = ?, productOccasion = ?, productImage = ? WHERE productCode = ?";
        try (Connection con = DatabaseHook.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, productName);
            stmt.setString(2, productDescription);
            stmt.setBigDecimal(3, productCost);
            stmt.setString(4, productOccasion);
            stmt.setString(5, productImage);
            stmt.setString(6, productCode);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteDB() {
        String sql = "DELETE FROM Products WHERE productCode = ?";
        try (Connection con = DatabaseHook.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, productCode);
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Product> getAllProducts(){
    List<Product> products = new ArrayList<>();
    String sql = "SELECT * FROM Products";
    try (Connection con = DatabaseHook.getConnection();
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        
        while(rs.next()){
            Product row = new Product();
            row.setProductCode(rs.getString("productCode"));
            row.setProductName(rs.getString("productName"));
            row.setProductDescription(rs.getString("productDescription"));
            row.setProductCost(rs.getBigDecimal("productCost"));
            row.setProductOccasion(rs.getString("productOccasion"));
            row.setProductImage(rs.getString("productImage"));
            products.add(row);
        }
    } catch (SQLException e) {
        System.out.println(e);
    }
    return products;
}
    
    public List<Cart> getCartProducts(ArrayList<Cart> cartList){
    List<Cart> products = new ArrayList<>();
    if (!cartList.isEmpty()) {
        String sql = "SELECT * FROM Products WHERE productCode = ?";
        try (Connection con = DatabaseHook.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            for (Cart item : cartList) {
                stmt.setString(1, item.getProductCode());
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setProductCode(rs.getString("productCode"));
                        row.setProductName(rs.getString("productName"));
                        row.setProductImage(rs.getString("productImage"));
                        row.setProductDescription(rs.getString("productDescription"));
                        row.setProductCost(rs.getBigDecimal("productCost").multiply(new BigDecimal(item.getQuantity())));
                        row.setQuantity(item.getQuantity());
                        products.add(row);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    return products;
}

    // Getters and setters

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

    public BigDecimal getProductCost() {
        return productCost;
    }

    public void setProductCost(BigDecimal productCost) {
        this.productCost = productCost;
    }

    public String getProductOccasion() {
        return productOccasion;
    }

    public void setProductOccasion(String productOccasion) {
        this.productOccasion = productOccasion;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
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
