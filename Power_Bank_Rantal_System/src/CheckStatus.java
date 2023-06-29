import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckStatus {
    static public String status;

    public void checkStatus() throws SQLException {
        DBHelper dbHelper = new DBHelper();
        String sql = "select status from powerbanktable where type = '"+RentalEvent.selectedPowerBank+"'";
        ResultSet rs = dbHelper.query(sql);
        if(rs.next()) {
            status = rs.getString("status");
        }
        System.out.println(status);

        try{
            // 关闭结果集
            rs.close();
            dbHelper.rs.close();
            dbHelper.stmt.close();
            dbHelper.conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
