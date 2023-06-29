import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PowerBankStatusChanger implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JButton) {
            if (e.getActionCommand().equals("修改")) {
                DBHelper dbHelper = new DBHelper();

                //获取文本框里的数据
                Data.setpId(Integer.parseInt(PowerBankManagement.jTextField1.getText()));
                Data.setType(PowerBankManagement.jTextField2.getText());
                Data.setPower(Integer.parseInt(PowerBankManagement.jTextField3.getText()));
                Data.setStatus(PowerBankManagement.jTextField4.getText());

                String sql = "update powerbanktable set type = '"+Data.type+"',power = '"+Data.power+"',status = '"+Data.status+"'WHERE id = '"+Data.pId+"'";
                try {

                    int rowsAffected = dbHelper.update(sql);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "修改成功", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "修改失败", "Failed", JOptionPane.ERROR_MESSAGE);
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
