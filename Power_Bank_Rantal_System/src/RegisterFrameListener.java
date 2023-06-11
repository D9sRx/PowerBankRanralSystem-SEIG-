import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterFrameListener implements ActionListener {
    RegisterFrame rgf;
    DBHelper dbHelper;

    LoginGUI loginGUI;

    public RegisterFrameListener(RegisterFrame rgf) {
        this.rgf = rgf;
        this.dbHelper = new DBHelper();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object o = actionEvent.getSource();
        String username = rgf.jtf.getText();
        String password1 = new String(rgf.jpwf.getPassword());
        String password2 = new String(rgf.jpwf1.getPassword());
        if (o instanceof JButton) {
            if (username.equals("") && ((JButton) o).getActionCommand().equals("注册")) {
                rgf.jtf.requestFocus();
            } else if (password1.equals("") && ((JButton) o).getActionCommand().equals("注册")) {
                rgf.jpwf.requestFocus();
            } else if (password2.equals("") && ((JButton) o).getActionCommand().equals("注册")) {
                rgf.jpwf1.requestFocus();
            } else if (!password1.equals(password2) && ((JButton) o).getActionCommand().equals("注册")) {
                JOptionPane.showMessageDialog(null,"密码不一致,请重新输入","Warning",JOptionPane.WARNING_MESSAGE);
            }else if (((JButton) o).getActionCommand().equals("注册") && password1.equals(password2)) {
                String sql = "INSERT INTO usertable(username,password) VALUES ('"+username+"','"+password1+"')";
                int i = dbHelper.update(sql);
                if(i>0){
                    JOptionPane.showMessageDialog(null,"注册成功","Success",JOptionPane.INFORMATION_MESSAGE);
                    rgf.jf.dispose();
                    loginGUI.jf.dispose();
                    new AdminGUI();

                    try {
                        dbHelper.stmt.close();
                        dbHelper.conn.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                }else{
                    JOptionPane.showMessageDialog(null,"注册失败","Success",JOptionPane.ERROR_MESSAGE);
                }
            }if (((JButton) o).getActionCommand().equals("返回登录")) {
                LoginGUI loginGUI = new LoginGUI();
                rgf.jf.dispose();
            }
        }
    }

}