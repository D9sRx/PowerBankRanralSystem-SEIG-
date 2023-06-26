import javax.swing.*;
import java.awt.*;

public class PowerBankUsage extends Box{

    //private JTable table;
    //private Vector<String> titles;

    //private Vector<Vector> tableData;

    //private DefaultTableModel tableModel;
    JPanel jPanel1,jPanel2;

    JButton jButton;
    JComboBox comboBox;
    Box typeBox;
    public PowerBankUsage() {

        super(BoxLayout.Y_AXIS);


        //做一个下拉菜单用于选择充电宝
        typeBox=Box.createHorizontalBox();
        String[] powerBank={"普通充电宝","快充充电宝"};
        JLabel type=new JLabel("充电宝类型:");
        comboBox=new JComboBox(new DefaultComboBoxModel(powerBank));
        typeBox.add(Box.createHorizontalStrut(50));
        typeBox.add(type);
        typeBox.add(Box.createHorizontalStrut(5));
        typeBox.add(comboBox);
        typeBox.add(Box.createHorizontalStrut(100));
        typeBox.setPreferredSize(new Dimension(400,50));

        comboBox.addActionListener(new RentalEvent());


        jButton = new JButton("租借");
        jButton.setPreferredSize(new Dimension(200,50));
        jButton.addActionListener(new RentalEvent());

        jPanel1 =new JPanel();
        jPanel2 =new JPanel();

        jPanel2.add(jButton,"South");
        jPanel1.add(typeBox);
        add(jPanel1);
        add(jPanel2);
    }


//
//        jPanel=new JPanel();
//        jPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
//        jPanel.setMaximumSize(new Dimension(850,80));
//
//        JButton jb1=new JButton("租赁");
//        JButton jb2=new JButton("归还");
//        jPanel.add(jb1);
//        jPanel.add(jb2);
//        jPanel.setVisible(true);
//        this.add(jPanel);
//
//
//        //组装表格
//        String[] ts={"编号","类型","充电宝电量"};
//        titles=new Vector<>();
//        for (String title :ts) {
//            titles.add(title);
//        }
//        tableData=new Vector<>();
//        String[][] strings={
//                {"1","2","3","4"},
//                {"1","2","3","4"},
//                {"1","2","3","4"}
//        };
//        for (int i = 0; i < 3; i++) {
//            Vector t=new Vector<>();
//            for (int j = 0; j < 4; j++) {
////                if(j==3){
////                    continue;
////                }
//                t.add(strings[i][j]);
//            }
//            tableData.add(t);
//        }
//        tableModel=new DefaultTableModel(tableData,titles);
//
//        table=new JTable(tableModel){
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return column!=0 && column!=1&& column!=2;
//            }
//        };
//        table.setRowHeight(30);
//
//        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        table.getTableHeader().setReorderingAllowed(false);
//        JScrollPane jScrollPane=new JScrollPane(table);
//        jScrollPane.setPreferredSize(new Dimension(400, 200));
//        this.add(jScrollPane);
//    }

}

