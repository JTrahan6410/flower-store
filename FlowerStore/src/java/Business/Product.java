package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * ************************************************************
 *
 * JACOB TRAHAN - in tandem with Jose Gomez
 *
 * Adv Sys Project - Oct 23, 2023
 *
 *************************************************************
 */
public class Product {

    private String productCode;
    private String productName;
    private String productDescription;
    private double productCost;
    private String productOccasion;
    private String productImage;
    private Connection con;
    // <editor-fold defaultstate="collapsed" desc="Database Path set per user">

    //for Jose
//    final String databasePath = "E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";

    //for Salena
//    final String databasePath = "C:\\Users\\lena\\OneDrive\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    //for Jacob
    final String databasePath = "E:\\Users\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase_v4.accdb";
    //</editor-fold>
    final String databaseURL = "jdbc:ucanaccess://" + databasePath;

    /********************************************
    *                                           *
    *               Constructors                *
    *                                           *
     * @param con
    *********************************************/
    public Product(Connection con) {
        this.con = con; // Initialize with external connection

    }

    // Default constructor
    public Product() {
        this(null); // Default constructor uses null connection
    }
;
    //Parameterized constructor
    public Product(String productCode, String productName, String productDescription, double productCost, String productOccasion, String productImage) {
        this();
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCost = productCost;
        this.productOccasion = productOccasion;
        this.productImage = productImage;
    }

    
    // <editor-fold defaultstate="collapsed" desc="Getters and setters for class properties. Click on the + sign on the left to edit the code.">
    // Getters and Setters
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

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
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
    //</editor-fold>    
    
    // Display method
    public void display() {
        System.out.println("Product Code: " + getProductCode());
        System.out.println("Product Name: " + getProductName());
        System.out.println("Product Description: " + getProductDescription());
        System.out.println("Product Cost: $" + getProductCost());
        System.out.println("Product Occasion: " + getProductOccasion());
        System.out.println("Product Image: " + getProductImage());
    }

    // Database methods
    // Method to retrieve product data from the database based on the product code
    public void selectDB(String productCode) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(databaseURL)) {
                // SQL query to select product data based on the product code
                String sql = "SELECT * FROM Product WHERE productCode = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, productCode);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        // Set product data based on the result set
                        setProductCode(rs.getString("productCode"));
                        setProductName(rs.getString("productName"));
                        setProductDescription(rs.getString("productDescription"));
                        setProductCost(rs.getDouble("productCost"));
                        setProductOccasion(rs.getString("productOccasion"));
                        setProductImage(rs.getString("productImage"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            System.out.println(e);
        }
    }

    // Method to insert product data into the database
    public void insertDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(databaseURL)) {
                // SQL query to insert product data into the database
                String sql = "INSERT INTO Product (productCode, productName, productDescription, productCost, productOccasion, productImage) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    // Set values for placeholders in the prepared stmt
                    stmt.setString(1, getProductCode());
                    stmt.setString(2, getProductName());
                    stmt.setString(3, getProductDescription());
                    stmt.setDouble(4, getProductCost());
                    stmt.setString(5, getProductOccasion());
                    stmt.setString(6, getProductImage());
                    // Execute the insert query
                    stmt.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            System.out.println(e);
        }
    }

    // Method to update product data in the database
    public void updateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(databaseURL)) {
                // SQL query to update product data in the database
                String sql = "UPDATE Product SET productName = ?, productDescription = ?, productCost = ?, "
                        + "productOccasion = ?, productImage = ? WHERE productCode = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    // Set values for placeholders in the prepared stmt
                    stmt.setString(1, getProductName());
                    stmt.setString(2, getProductDescription());
                    stmt.setDouble(3, getProductCost());
                    stmt.setString(4, getProductOccasion());
                    stmt.setString(5, getProductImage());
                    stmt.setString(6, getProductCode());
                    // Execute the update query
                    stmt.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            System.out.println(e);
        }
    }

    // Method to delete product data from the database
    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(databaseURL)) {
                // SQL query to delete product data from the database
                String sql = "DELETE FROM Product WHERE productCode = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    // Set values for placeholders in the prepared stmt
                    stmt.setString(1, getProductCode());
                    // Execute the delete query
                    stmt.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            System.out.println(e);
        }
    }
    
       /********************************************
    *                                           *
    *          GetAllProducts Method            *
    *           created by Jose                 *
    *           adapted by Jacob                *
    *                                           *
    * @return                                   *
    *********************************************/
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            System.out.println("Launching Get All Products..."); //debug
            // Load JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            // Use try-with-resources for automatic resource management
            System.out.println("Establishing connection..."); //debug
            try (Connection conn = DriverManager.getConnection(databaseURL);
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Products");
                 ResultSet rs = stmt.executeQuery()) {
                // Iterate through the result set
                System.out.println("Iterating through RS");
                while (rs.next()) {
                    Product row = new Product();
                    row.setProductCode(rs.getString("productCode"));
                    row.setProductName(rs.getString("productName"));
                    row.setProductDescription(rs.getString("productDescription"));
                    row.setProductCost(rs.getDouble("productCost"));
                    row.setProductOccasion(rs.getString("productOccasion"));
                    row.setProductImage(rs.getString("productImage"));
                    // Add each product to the list
                    products.add(row);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            System.err.println("Error in getAllProducts: " + e.getMessage());
        }
        return products;
    }

    /********************************************
    *                                           *
    *        GetCartProducts Method             *
    *           created by Jose                 *
    *           adapted by Jacob                *
    * @param cartList
    * @return 
    *********************************************/
    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> products = new ArrayList<>();
        try {
            // Load JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // Use try-with-resources for automatic resource management
            try (Connection conn = DriverManager.getConnection(databaseURL)) {
                if (!cartList.isEmpty()) {
                    for (Cart item : cartList) {
                        String query = "SELECT * FROM Products WHERE productCode = ?";
                        try (PreparedStatement pst = conn.prepareStatement(query)) {
                            pst.setString(1, item.getProductCode());

                            try (ResultSet rs = pst.executeQuery()) {
                                while (rs.next()) {
                                    Cart row = new Cart();
                                    row.setProductCode(rs.getString("productCode"));
                                    row.setProductName(rs.getString("productName"));
                                    row.setProductImage(rs.getString("productImage"));
                                    row.setProductDescription(rs.getString("productDescription"));
                                    row.setProductCost(rs.getDouble("productCost") * item.getQuantity());
                                    row.setQuantity(item.getQuantity());

                                    products.add(row);
                                }
                            }
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    return products;
}

    /********************************************
    *                                           *
    *        GetTotalCartPrice Method           *
    *           created by Jose                 *
    *           adapted by Jacob                *
     * @param cartList                          *
     * @return                                  *
    *********************************************/
    public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;

        try {
            // Load JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // Use try-with-resources for automatic resource management
            try (Connection conn = DriverManager.getConnection(databaseURL)) {
                if (!cartList.isEmpty()) {
                    for (Cart item : cartList) {
                        String query = "SELECT productCost FROM Products WHERE productCode = ?";
                        try (PreparedStatement pst = conn.prepareStatement(query)) {
                            pst.setString(1, item.getProductCode());
                            try (ResultSet rs = pst.executeQuery()) {
                                while (rs.next()) {
                                    sum += rs.getDouble("productCost") * item.getQuantity();
                                }
                            }
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            System.out.println("Error calculating total cart price: " + e.getMessage());
            e.printStackTrace();
        }

        return sum;
    }
}