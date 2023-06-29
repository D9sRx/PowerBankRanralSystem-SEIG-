import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteHistory implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JButton) {

            if (e.getActionCommand().equals("删除")) {
                DBHelper dbHelper = new DBHelper();
                String sql = "DELETE FROM billcount WHERE id = '"+Data.hId +"'";
                try {

                    int rowsAffected = dbHelper.update(sql);
                    //判断是否成功
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "删除成功", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "删除失败", "Failed", JOptionPane.ERROR_MESSAGE);
                    }
                    dbHelper.stmt.close();
                    dbHelper.conn.close();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
