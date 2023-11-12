package Database;

import jakarta.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHook {

    private static final String JDBC_DRIVER_NAME = "net.ucanaccess.jdbc.UcanaccessDriver";
    private static String databasePath;
    private static String databaseURL;
    private static Connection connection = null;

    // Static initializer to load the JDBC driver
    static {
        try {
            // Attempt to load the driver class
            Class.forName(JDBC_DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            // If the driver class isn't found, throw an exception to halt the application startup
            throw new RuntimeException("JDBC Driver not found", e);
        }
    }

    // Method to initialize the database path using ServletContext
    public static void initialize(ServletContext context) {
        if (context == null) {
            throw new IllegalArgumentException("ServletContext cannot be null");
        }
        // Set the database path based on the real path obtained from the ServletContext
        databasePath = context.getRealPath("/WEB-INF/FlowerStoreDatabase.accdb");
        // Normalize the path to use forward slashes
        databasePath = databasePath.replace("\\", "/");
        // Construct the database URL for the JDBC connection
        databaseURL = "jdbc:ucanaccess://" + databasePath;
    }

    // Method to get a connection to the database
    public static Connection getConnection() throws SQLException {
        if (databaseURL == null) {
            throw new IllegalStateException("Database path is not set. Ensure 'initialize' is called first.");
        }
        // Create a new connection only if it does not exist or is closed
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(databaseURL);
            System.out.println("Database connection established.");
        }
        return connection;
    }

    // Getter for database path
    public static String getDatabasePath() {
        if (databasePath == null) {
            throw new IllegalStateException("Database path has not been initialized.");
        }
        return databasePath;
    }
}
