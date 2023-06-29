import java.sql.SQLException;

public class UserMoneyChanger {

    public void change(){
        DBHelper dbHelper = new DBHelper();
        String sql = "update usertable set money = money-'"+ PowerBankBillCounter.money+"' where username = '"+Data.userName+"'";
        int i =dbHelper.update(sql);
        if (i > 0) {
            try {
                dbHelper.stmt.close();
                dbHelper.conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
