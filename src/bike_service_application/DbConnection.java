package bike_service_application;
import java.sql.*;
public class DbConnection {
    private static final String username = "root";
    private static final String url = "jdbc:mysql://localhost:3306/BikeService";
    private static final String password = "mynewpassword";
    public static Connection getConnection()throws Exception{
        return DriverManager.getConnection(url, username, password);
    }
    
}
