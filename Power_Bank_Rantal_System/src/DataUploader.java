import java.sql.SQLException;
public class DataUploader {
        DBHelper dbHelper;
        Data data;

        //上传租借记录
        public void upload(){


            data = new Data();
            dbHelper = new DBHelper();
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
