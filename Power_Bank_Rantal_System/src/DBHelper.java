import java.sql.*;

public class DBHelper implements DBConfig{

    public static Connection conn = null;
    public Statement stmt = null;
    public ResultSet rs = null;



    public int update(String sql){
        int i = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();

            i = stmt.executeUpdate(sql);
            //stmt.close();
            //conn.close();

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    public ResultSet query(String sql){
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
            //rs.close();
            //stmt.close();
            //conn.close();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    public static Connection getConn() throws ClassNotFoundException{
        Class.forName(JDBC_DRIVER);
        try{
            conn = DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return conn;

    }
}
