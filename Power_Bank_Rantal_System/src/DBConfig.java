import java.sql.Connection;
import java.sql.DriverManager;

public interface DBConfig {
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/power bank rental system?useSSL=false";
    String user = "root";
    String password = "4825550100";

}
