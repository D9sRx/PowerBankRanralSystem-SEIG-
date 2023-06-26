import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGUI {
    JFrame jf;
    JMenuBar jmb;
    JMenu jm;
    JMenuItem jmi1,jmi2,jmi3;
    LoginGUI loginGUI;
    public UserGUI(){
        jf=new JFrame("用户界面系统");
        jf.setResizable(false);
        jf.setDefaultCloseOperation(3);
        jf.setSize(800,400);

        //获取屏幕和窗口属性，让窗口显示在屏幕中央
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int frameWidth = jf.getWidth();
        int frameHeight = jf.getHeight();
        jf.setLocation((screenWidth - frameWidth) / 2,(screenHeight - frameHeight) / 2);

        jmb=new JMenuBar();
        jm = new JMenu("设置");
        jmi1=new JMenuItem("切换账号");
        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loginGUI = new LoginGUI();
                jf.dispose();
            }
        });
        jmi2=new JMenuItem("退出程序");
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf.dispose();
            }
        });
        jmi3=new JMenuItem("修改密码");
        jmi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new PasswordModificationInterface();
                jf.dispose();
            }
        });


        JSplitPane sp=new JSplitPane();
        sp.setContinuousLayout(true);
        sp.setDividerLocation(120);
        sp.setDividerSize(6);

        DefaultMutableTreeNode root=new DefaultMutableTreeNode("系统管理");
        DefaultMutableTreeNode orderManagement=new DefaultMutableTreeNode("订单管理");
        DefaultMutableTreeNode powerBankUsage=new DefaultMutableTreeNode("充电宝使用");
        DefaultMutableTreeNode pensonalCenter=new DefaultMutableTreeNode("个人中心");

        root.add(pensonalCenter);
        root.add(orderManagement);
        root.add(powerBankUsage);

        JTree jTree=new JTree(root);
        jTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();
                if(orderManagement.equals(lastPathComponent)){
                    sp.setRightComponent(new PowerBankHistory());
                    sp.setDividerLocation(120);
                    sp.setDividerSize(6);
                }if(powerBankUsage.equals(lastPathComponent)){
                    sp.setRightComponent(new PowerBankUsage());
                    sp.setDividerLocation(120);
                    sp.setDividerSize(6);
                }if(pensonalCenter.equals(lastPathComponent)){
                    sp.setRightComponent(new PersonalCenterConponent());
                    sp.setDividerLocation(120);
                    sp.setDividerSize(6);
                }
            }
        });

        jf.setJMenuBar(jmb);
        jmb.add(jm);
        jm.add(jmi1);
        jm.add(jmi2);
        jm.add(jmi3);

        sp.setLeftComponent(jTree);
        sp.setRightComponent(new PersonalCenterConponent());
        jf.add(sp);
        jf.setSize(600,600);
        jf.setVisible(true);
    }
}

