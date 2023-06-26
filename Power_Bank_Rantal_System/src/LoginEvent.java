import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginEvent extends DBHelper implements ActionListener {

    LoginGUI lg;
    DBHelper dbHelper;
    String sql1,sql2;

    Data data;

    String currentUsername,currentPassWord;


    public LoginEvent(LoginGUI loginGUI){
        this.lg = loginGUI;
        this.dbHelper = new DBHelper();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        data = new Data();

        currentUsername = lg.jt1.getText();
        currentPassWord = new String(lg.jpw2.getPassword());

        if(obj instanceof JButton){
            //用户登录
            if(e.getActionCommand().equals("提交") && lg.jr1.isSelected()){

                //查询数据库里的数据
                sql1 = "SELECT * FROM usertable WHERE username='" + currentUsername + "' AND password='" + currentPassWord + "'";
                ResultSet rs = dbHelper.query(sql1);
                //对数据进行判断
                try {
                    if(rs.next()){

                        JOptionPane.showMessageDialog(null,"登录成功","Success",JOptionPane.INFORMATION_MESSAGE);
                        UserGUI userGUI = new UserGUI();
                        data.setUserName(currentUsername);
                        lg.jf.dispose();

                    }else{

                        JOptionPane.showMessageDialog(null,"用户不存在或账号密码错误","Warning",JOptionPane.WARNING_MESSAGE);

                    }
                }catch (Exception ex) {
                    ex.getStackTrace();
                }finally {
                    try {

                        rs.close();
                        dbHelper.rs.close();
                        dbHelper.stmt.close();
                        dbHelper.conn.close();

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            //管理员登录
            }if(e.getActionCommand().equals("提交") && lg.jr2.isSelected()){

                sql1 = "SELECT * FROM admintable WHERE username='" + currentUsername + "' AND password='" + currentPassWord + "'";
                ResultSet rs = dbHelper.query(sql1);

                try{
                    if(rs.next()){

                        JOptionPane.showMessageDialog(null,"登录成功","Success",JOptionPane.INFORMATION_MESSAGE);
                        AdminGUI adminGUI = new AdminGUI();
                        lg.jf.dispose();

                    }else{

                        JOptionPane.showMessageDialog(null,"用户不存在或账号密码错误","Warning",JOptionPane.WARNING_MESSAGE);

                    }
                } catch (Exception ex) {
                    ex.getStackTrace();
                }finally {
                    try {

                        rs.close();
                        dbHelper.rs.close();
                        dbHelper.stmt.close();
                        dbHelper.conn.close();

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }if(e.getActionCommand().equals("重置")){           //重置按钮功能
                lg.jt1.setText("");
                lg.jpw2.setText("");

            }if(e.getActionCommand().equals("注册")){           //注册功能
                RegisterFrame registerFrame = new RegisterFrame();
                registerFrame.jf.requestFocusInWindow();
            }
        }

    }

}
