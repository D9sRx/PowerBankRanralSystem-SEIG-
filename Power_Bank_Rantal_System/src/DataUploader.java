import java.sql.SQLException;
public class DataUploader {
        DBHelper dbHelper;
        Data data;

        public void upload(){


            data = new Data();
            dbHelper = new DBHelper();
            data.print();
            String sql = "INSERT INTO billcount(username,startTime,overTime,bill) VALUES ('"+data.userName+"','"+data.startTime+"','"+data.overTime+"','"+data.bill+"')";
            int i = dbHelper.update(sql);
            if (i>1){
                try {
                    dbHelper.stmt.close();
                    dbHelper.conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }

        }


}
