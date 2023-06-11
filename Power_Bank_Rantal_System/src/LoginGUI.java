import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;


public class LoginGUI {

    static JFrame jf;
    JPanel jp1,jp2,jp3,jp4;
    JButton jb1,jb2,jb3;
    JLabel jl1,jl2;
    JTextField jt1;
    JPasswordField jpw2;
    JRadioButton jr1,jr2;
    ButtonGroup buttonGroup;

    public LoginGUI() {

        //设置JFrame及其参数
        jf = new JFrame("登录界面");
        jf.pack();
        jf.setResizable(false);
        jf.setLayout(new GridLayout(4, 1));
        jf.setSize(400, 200);

        //获取屏幕和窗口属性，让窗口显示在屏幕中央
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int frameWidth = jf.getWidth();
        int frameHeight = jf.getHeight();
        jf.setLocation((screenWidth - frameWidth) / 2,(screenHeight - frameHeight) / 2);


        //new 一些JPanel
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        //设置背景
        ImageIcon background = new ImageIcon("D://rant.JPG");
        JLabel jl = new JLabel(background);
        jl.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
        jf.getLayeredPane().add(jl,new Integer(Integer.MIN_VALUE));
        JPanel j = (JPanel) jf.getContentPane();
        j.setOpaque(false);

        //new一些需要的标签和按钮
        jl1 = new JLabel("用户名");
        jl2 = new JLabel("密    码");

        jt1 = new JTextField(20);
        jpw2 = new JPasswordField(20);

        jb1 = new JButton("提交");
        jb2 = new JButton("重置");
        jb3 = new JButton("注册");

        buttonGroup = new ButtonGroup();

        jr1 = new JRadioButton("用户",true);
        jr2 = new JRadioButton("管理员",false);

        jr1.isSelected();

        //设置透明度使背景可见
        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);
        jp4.setOpaque(false);
        //RadioButton设置为透明
        jr1.setOpaque(false);
        jr2.setOpaque(false);

        //把RadioButton放入buttonGroup,使其变成单选
        buttonGroup.add(jr1);
        buttonGroup.add(jr2);

        //把组件都添加到JFrame上
        jf.add(jp1);
        jf.add(jp2);
        jf.add(jp3);
        jf.add(jp4);

        jp1.add(jl1);
        jp1.add(jt1);

        jp2.add(jl2);
        jp2.add(jpw2);

        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);

        jp4.add(jr1);
        jp4.add(jr2);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //添加监听器
        jb1.addActionListener(new Event(this));
        jb2.addActionListener(new Event(this));
        jb3.addActionListener(new Event(this));
    }


}