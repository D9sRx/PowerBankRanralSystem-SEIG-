import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends Frame {
    JFrame jf;
    JPanel jp1, jp2, jp3, jp4,jp5;
    JButton jb1, jb2;
    JLabel jl1, jl2, jl3;
    JTextField jtf;
    JPasswordField jpwf, jpwf1;

    public RegisterFrame() {

        jf = new JFrame();
        jf.setLayout(new GridLayout(5, 1));

        //获取屏幕和窗口属性，让窗口显示在屏幕中央
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int frameWidth = jf.getWidth();
        int frameHeight = jf.getHeight();
        jf.setLocation((screenWidth - frameWidth) / 2,(screenHeight - frameHeight) / 2);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jl1 = new JLabel("账号");
        jl2 = new JLabel("密码");
        jl3 = new JLabel("再次输入密码");

        jtf = new JTextField(20);
        jpwf = new JPasswordField(20);
        jpwf1 = new JPasswordField(20);

        jb1 = new JButton("注册");
        jb1.addActionListener(new RegisterFrameListener(this));
        jb2 = new JButton("返回登录");
        jb2.addActionListener(new RegisterFrameListener(this));


        jf.add(jp1);
        jf.add(jp2);
        jf.add(jp3);
        jf.add(jp5);
        jf.add(jp4);

        jp1.add(jl1);
        jp1.add(jtf);

        jp2.add(jl2);
        jp2.add(jpwf);

        jp3.add(jl3);
        jp3.add(jpwf1);


        jp4.add(jb1);
        jp4.add(jb2);


        jf.setVisible(true);
        jf.setLocation(300, 500);
        jf.setSize(500, 300);
    }
}