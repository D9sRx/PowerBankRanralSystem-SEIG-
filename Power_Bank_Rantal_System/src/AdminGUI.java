import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class AdminGUI {
    JFrame jFrame;
    JLabel jLabel;
    JTable jTable;
    JScrollPane scrollPane;
    JMenuBar jMenuBar;
    JMenu jMenu;
    JMenuItem jMenuItem1,jMenuItem2;
    JButton jButton1,jButton2,jButton3;
    JPanel jPanel;
    JSplitPane jSplitPane;
    JTree jTree;

    DefaultMutableTreeNode root,personalCenter,userManagement,orderManagement,powerBankManagement;


    public AdminGUI(){
        //new个jFrame的对象
        jFrame = new JFrame("管理员界面");
        jFrame.setResizable(false);

        //获取屏幕和窗口属性，让窗口显示在屏幕中央
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int frameWidth = jFrame.getWidth();
        int frameHeight = jFrame.getHeight();
        jFrame.setLocation((screenWidth - frameWidth) / 2,(screenHeight - frameHeight) / 2);

        //new一个jPanel的对象
        jPanel = new JPanel();

        //new一个label对象
        jLabel = new JLabel("欢迎进入管理员界面");
        jLabel.setFont(new Font("得意黑", Font.BOLD, 20)); // 设置字体大小为20
        jLabel.setHorizontalAlignment(SwingConstants.CENTER); // 设置水平居中
        jLabel.setVerticalAlignment(SwingConstants.CENTER); // 设置垂直居中

        //按钮的设置
        jButton1 = new JButton("刷新");
        jButton2 = new JButton("下架");
        jButton3 = new JButton("删除");

        //添加按钮的监听器
        jButton1.addActionListener(new AdminEvent(this));
        jButton2.addActionListener(new AdminEvent(this));
        jButton3.addActionListener(new AdminEvent(this));

        //菜单栏
        jMenuBar = new JMenuBar();
        jMenu = new JMenu("设置");
        jMenuItem1 = new JMenuItem("切换账号");
        jMenuItem2 = new JMenuItem("退出程序");
        //添加菜单选项的监听器
        jMenuItem1.addActionListener(new AdminEvent(this));
        jMenuItem2.addActionListener(new AdminEvent(this));

        //new一个jSplitPane，实现界面分割
        jSplitPane = new JSplitPane();
        jSplitPane.setRightComponent(jLabel);
        jSplitPane.setOneTouchExpandable(false);
        jSplitPane.setDividerLocation(120);
        jSplitPane.setDividerSize(0);

        //new对象
        root = new DefaultMutableTreeNode("系统管理");
        userManagement = new DefaultMutableTreeNode("用户管理");
        orderManagement = new DefaultMutableTreeNode("订单管理");
        powerBankManagement = new DefaultMutableTreeNode("充电宝管理");

        //添加组件
        root.add(userManagement);
        root.add(orderManagement);
        root.add(powerBankManagement);

        //tree的对象
        jTree = new JTree(root);

        //tree的事件
        jTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();
                if (userManagement.equals(lastPathComponent)) {
                    jSplitPane.setRightComponent(new Label("1"));
                    jSplitPane.setDividerLocation(120);
                    jSplitPane.setDividerSize(0);
                }
                if (orderManagement.equals(lastPathComponent)) {
                    jSplitPane.setRightComponent(new OrderManagement());
                    jSplitPane.setDividerLocation(120);
                    jSplitPane.setDividerSize(0);
                }
                if (powerBankManagement.equals(lastPathComponent)) {
                    jSplitPane.setRightComponent(new Label("3"));
                    jSplitPane.setDividerLocation(120);
                    jSplitPane.setDividerSize(0);
                }
            }
        });

        jFrame.setJMenuBar(jMenuBar);
        jMenuBar.add(jMenu);
        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);

        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);

        jFrame.add(jPanel,"North");
        jSplitPane.setLeftComponent(jTree);

        jFrame.add(jSplitPane);
        jFrame.setSize(800,600);
        jFrame.setVisible(true);

    }
}
