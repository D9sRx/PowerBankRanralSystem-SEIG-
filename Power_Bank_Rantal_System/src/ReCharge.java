import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ReCharge extends JFrame {
    JFrame jf;
    JButton jb1,jb2;
    JLabel jl;
    JTextField jtf;
    JPanel jp1,jp2,jp3;
    public ReCharge(){

        jf=new JFrame("充值中心");
        jf.setLayout(new GridLayout(3,1));

        //获取屏幕和窗口属性，让窗口显示在屏幕中央
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int frameWidth = jf.getWidth();
        int frameHeight = jf.getHeight();
        jf.setLocation((screenWidth - frameWidth) / 2,(screenHeight - frameHeight) / 2);


        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();

        jl=new JLabel("请输入你要充值的金额");

        jtf=new JTextField(12);

        KeyBoardEvent keyBoardEvent =new KeyBoardEvent();

        jtf.addKeyListener(keyBoardEvent);

        jb1=new JButton("充值");

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();
                if(e.getActionCommand().equals("充值")){
                    DBHelper dbHelper = new DBHelper();
                    String values = jtf.getText();
                    System.out.println(values);
                    Double money = Double.parseDouble(values);
                    String sql = "update usertable set money = money+'"+money+"' where username = '"+Data.userName+"'";
                    int i =dbHelper.update(sql);
                    if (i > 0) {

                        JOptionPane.showMessageDialog(null, "充值成功", "Success", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            dbHelper.stmt.close();
                            dbHelper.conn.close();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                }

            }
        });



        jb2=new JButton("退出");
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf.dispose();
            }
        });

        jf.add(jp1);
        jf.add(jp2);
        jf.add(jp3);

        jp1.add(jl);

        jp2.add(jtf);

        jp3.add(jb1);
        jp3.add(jb2);

        jf.setVisible(true);
        jf.setSize(200,200);
    }
}