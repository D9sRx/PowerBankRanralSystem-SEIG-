import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckPower {
    static public int power;


    public void check() throws SQLException {
        DBHelper dbHelper = new DBHelper();
        String sql = "select power from powerbanktable where type = '"+RentalEvent.selectedPowerBank+"'";
        ResultSet rs = dbHelper.query(sql);

        if(rs.next()) {
            power = rs.getInt("power");
        }

        System.out.println(power);

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
