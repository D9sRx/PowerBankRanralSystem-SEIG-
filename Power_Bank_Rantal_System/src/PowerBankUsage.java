import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PowerBankUsage extends Box{

    JPanel jPanel1,jPanel2;

    JButton jButton;
    public  static  JComboBox<String> comboBox;
    Box typeBox;
    public PowerBankUsage() throws SQLException {

        super(BoxLayout.Y_AXIS);

        //查询数据表里的充电宝
        DBHelper dbHelper = new DBHelper();
        String sql = "select type from powerbanktable";
        ResultSet rs = dbHelper.query(sql);

        //做一个下拉菜单用于选择充电宝
        typeBox=Box.createHorizontalBox();

        //做一个数组存放数据
        String[] powerBankArray = new String[4];
        int index = 0;

        while(rs.next()){
            String powerBankType = rs.getString("type");
            powerBankArray[index] = powerBankType;
            index++;
        }


        JLabel type=new JLabel("充电宝类型:");
        comboBox = new JComboBox(powerBankArray);



        //调整下拉菜单的参数
        typeBox.add(Box.createHorizontalStrut(50));
        typeBox.add(type);
        typeBox.add(Box.createHorizontalStrut(5));
        typeBox.add(comboBox);//组装
        typeBox.add(Box.createHorizontalStrut(100));
        typeBox.setPreferredSize(new Dimension(400,50));

        comboBox.addItemListener(new PowerbankSelected());//添加监听器


        jButton = new JButton("租借");
        jButton.setPreferredSize(new Dimension(200,50));
        jButton.addActionListener(new RentalEvent());//添加监听器

        jPanel1 =new JPanel();
        jPanel2 =new JPanel();

        jPanel2.add(jButton,"South");
        jPanel1.add(typeBox);
        add(jPanel1);
        add(jPanel2);

    }

}

