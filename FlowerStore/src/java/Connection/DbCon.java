package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jose V Gomez
 */
public class DbCon {
   
    // <editor-fold defaultstate="collapsed" desc="Database Path set per user">
    
    //for Jose
//    private static final String databasePath = "E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Salena
//    private static final String databasePath = "C:\\Users\\lena\\OneDrive\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    
    //for Jacob
    private static final String databasePath = "E:\\Users\\Documents\\GitHub\\flower-store\\FlowerStore\\FlowerStoreDatabase_v4.accdb";
    
    //</editor-fold>
    private static final String databaseURL = "jdbc:ucanaccess://" + databasePath;
    
    private static final Connection connection = null;
    
    public static Connection getConnection()throws ClassNotFoundException, SQLException{
        if(connection == null){
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            DriverManager.getConnection(databaseURL);
            System.out.println("connected");
        }
        return connection;
    }
}
