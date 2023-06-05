import java.sql.*;

public class DBHelper implements DBConfig{

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;



    public int update(String sql){
        int i = -1;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();

            i = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();

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
            stmt.close();
            conn.close();
            rs.close();

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
}
