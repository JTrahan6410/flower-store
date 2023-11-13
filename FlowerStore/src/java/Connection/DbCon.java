package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jose V Gomez
 */
public class DbCon {
    private static String databaseURL = "jdbc:ucanaccess://E:\\School Doc\\cist 2931\\flower-store\\FlowerStore\\FlowerStoreDatabase.accdb";
    private static Connection connection = null;
    
    public static Connection getConnection()throws ClassNotFoundException, SQLException{
        if(connection == null){
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            DriverManager.getConnection(databaseURL);
            System.out.println("connected");
        }
        return connection;
    }
}
