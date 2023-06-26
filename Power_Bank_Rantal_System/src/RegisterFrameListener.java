import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterFrameListener implements ActionListener {
    RegisterFrame registerFrame;
    DBHelper dbHelper;

    LoginGUI loginGUI;

    Data data;

    public RegisterFrameListener(RegisterFrame registerFrame) {
        this.registerFrame = registerFrame;
        this.dbHelper = new DBHelper();
        this.data = new Data();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object o = actionEvent.getSource();
        String userName = registerFrame.jtf.getText();
        String passWord1 = new String(registerFrame.jpwf.getPassword());
        String passWord2 = new String(registerFrame.jpwf1.getPassword());


        if (o instanceof JButton) {
            if (userName.equals("") && ((JButton) o).getActionCommand().equals("注册")) {
                registerFrame.jtf.requestFocus();
            } else if (passWord1.equals("") && ((JButton) o).getActionCommand().equals("注册")) {
                registerFrame.jpwf.requestFocus();
            } else if (passWord2.equals("") && ((JButton) o).getActionCommand().equals("注册")) {
                registerFrame.jpwf1.requestFocus();
            } else if (!passWord1.equals(passWord2) && ((JButton) o).getActionCommand().equals("注册")) {

                JOptionPane.showMessageDialog(null,"密码不一致,请重新输入","Warning",JOptionPane.WARNING_MESSAGE);

            } else if (((JButton) o).getActionCommand().equals("注册") && passWord1.equals(passWord2) && loginGUI.jr1.isSelected()) {

                String sql = "INSERT INTO usertable(username,password) VALUES ('"+userName+"','"+passWord1+"')";

                int i = dbHelper.update(sql);
                if(i>0){
                    JOptionPane.showMessageDialog(null,"注册成功","Success",JOptionPane.INFORMATION_MESSAGE);
                    data.setUserName(userName);//保存当前账户名到data类
                    registerFrame.jf.dispose();
                    new UserGUI();
                    loginGUI.jf.dispose();
                    try {
                        dbHelper.stmt.close();
                        dbHelper.conn.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                }else{
                    JOptionPane.showMessageDialog(null,"注册失败","Failed",JOptionPane.ERROR_MESSAGE);
                }
            } else if (((JButton) o).getActionCommand().equals("注册") && passWord1.equals(passWord2) && loginGUI.jr2.isSelected()) {
                String sql = "INSERT INTO admintable(username,password) VALUES ('" + userName + "','" + passWord1 + "')";

                int i = dbHelper.update(sql);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "注册成功", "Success", JOptionPane.INFORMATION_MESSAGE);
                    data.setUserName(userName);//保存当前账户名到data类
                    registerFrame.jf.dispose();
                    new AdminGUI();
                    loginGUI.jf.dispose();

                    try {
                        dbHelper.stmt.close();
                        dbHelper.conn.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "注册失败", "Failed", JOptionPane.ERROR_MESSAGE);
                }
                if (((JButton) o).getActionCommand().equals("返回登录")) {
                    LoginGUI loginGUI = new LoginGUI();
                    registerFrame.jf.dispose();
                }
            }
        }
    }

}