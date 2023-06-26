import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public  class PasswordModificationInterface extends Frame{
    JFrame jf;
    JPanel jp1, jp2, jp3;
    JLabel jl1, jl2;
    JButton jb,jb1;
    JPasswordField jpf1, jpf2;
    Data data;
    DBHelper dbHelper;
    public PasswordModificationInterface(){
        data=new Data();
        jf=new JFrame();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(new GridLayout(3,1));

        jp1 =new JPanel();
        jp2 =new JPanel();
        jp3 =new JPanel();

        jl1 =new JLabel("新密码");
        jl2 =new JLabel("确认密码");

        jb=new JButton("确认");
        jb1=new JButton("返回");

        jpf1 =new JPasswordField(16);
        jpf2 =new JPasswordField(16);

        jf.add(jp1);
        jf.add(jp2);
        jf.add(jp3);


        jp1.add(jl1);
        jp1.add(jpf1);

        jp2.add(jl2);
        jp2.add(jpf2);

        jp3.add(jb);
        jp3.add(jb1);

        jb.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();
                String password1 = new String(jpf1.getPassword());
                String password2 = new String(jpf2.getPassword());
                if(obj instanceof JButton){
                    if(e.getActionCommand().equals("确认") && password1.equals(password2) && !password1.equals("") && !password2.equals("")){

                        dbHelper = new DBHelper();
                        String sql = "update usertable set password='"+ jpf2.getText()+"' where username = '"+data.userName+"'";
                        int i =dbHelper.update(sql);

                        if(i>0){
                            JOptionPane.showMessageDialog(null,"修改成功","Success",JOptionPane.INFORMATION_MESSAGE);
                            UserGUI userGUI = new UserGUI();

                            try {
                                dbHelper.stmt.close();
                                dbHelper.conn.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                    }else{
                        JOptionPane.showMessageDialog(null,"密码不一致,请重新输入","Warning",JOptionPane.WARNING_MESSAGE);
                    }

                }

            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf.dispose();
                new UserGUI();
            }
        });

        jf.setSize(400,200);
        jf.setVisible(true);

    }
}