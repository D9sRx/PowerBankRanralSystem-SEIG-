import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReCharge extends JFrame {
    JFrame jf;
    JButton jb1,jb2;
    JLabel jl;
    JTextField jtf;
    JPanel jp1,jp2,jp3;
    public ReCharge(){
        jf=new JFrame("充值中心");
        jf.setLayout(new GridLayout(3,1));
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jl=new JLabel("请输入你要充值的金额");
        jtf=new JTextField(9);
        Key key=new Key();
        jtf.addKeyListener(key);
        jb1=new JButton("充值");
        RechargeListener actionListener=new RechargeListener(this);
        jb1.addActionListener(actionListener);
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