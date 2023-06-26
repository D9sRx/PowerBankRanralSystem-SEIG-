import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class PasswordModificationInterface extends Frame{
    JFrame jf;
    JPanel jp1,jp2,jp3,jp4;
    JLabel jl1,jl2,jl3;
    JButton jb,jb1;
    JPasswordField jpf1,jpf2,jpf3;
    public PasswordModificationInterface(){
        jf=new JFrame();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(new GridLayout(4,1));
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();
        jl1=new JLabel("原密码");
        jl2=new JLabel("新密码");
        jl3=new JLabel("确认密码");
        jb=new JButton("确认");
        jb1=new JButton("返回");
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf.dispose();
                new UserGUI();
            }
        });
        jpf1=new JPasswordField(16);
        jpf2=new JPasswordField(16);
        jpf3=new JPasswordField(16);

        jf.add(jp1);
        jf.add(jp2);
        jf.add(jp3);
        jf.add(jp4);

        jp1.add(jl1);
        jp1.add(jpf1);

        jp2.add(jl2);
        jp2.add(jpf2);

        jp3.add(jl3);
        jp3.add(jpf3);

        jp4.add(jb);
        jp4.add(jb1);

        jf.setSize(400,200);
        jf.setVisible(true);
    }
}