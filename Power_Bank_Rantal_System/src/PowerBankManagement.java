import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PowerBankManagement extends Box {
    private JTable table;

    public static JTextField jTextField1;
    public static JTextField jTextField2;
    public static JTextField jTextField3;
    public static JTextField jTextField4;

    private JLabel jLabel1,jLabel2,jLabel3,jLabel4;

    private JPanel jPanel1,jPanel2,jPanel3;
    private JButton jButton;
    private Vector<String> titles;

    private Vector<Vector> tableData;

    private TableModel tableModel;
    DBHelper dbHelper;
    public PowerBankManagement() {
        super(BoxLayout.Y_AXIS);

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();

        jButton = new JButton("修改");
        jLabel1 = new JLabel("编号为：");
        jLabel2 = new JLabel("类型为：");
        jLabel3 = new JLabel("电量为：");
        jLabel4 = new JLabel("状态为：");
        jTextField1 = new JTextField(20);
        jTextField2 = new JTextField(20);
        jTextField3 = new JTextField(20);
        jTextField4 = new JTextField(20);

        //组装表格
        String[] ts={"编号","类型","电量","状态"};
        titles=new Vector<>();
        for (String title :ts) {
            titles.add(title);
        }
        tableData=new Vector<>();
        tableModel=new DefaultTableModel(tableData,titles);
        table=new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        JScrollPane jScrollPane=new JScrollPane(table);

        this.add(jScrollPane);
        //添加下方的操作台
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);

        jPanel1.add(jLabel2);
        jPanel1.add(jTextField2);

        jPanel2.add(jLabel3);
        jPanel2.add(jTextField3);

        jPanel2.add(jLabel4);
        jPanel2.add(jTextField4);

        jPanel3.add(jButton,"North");


        jPanel2.add(jButton);
        jButton.addActionListener(new PowerBankStatusChanger());
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.getSelectedRow();

                Data data = new Data();
                jTextField1.setText(table.getValueAt(row,0)+"");
                jTextField2.setText(table.getValueAt(row,1)+"");
                jTextField3.setText(table.getValueAt(row,2)+"");
                jTextField4.setText(table.getValueAt(row,3)+"");

                Data.setpId((Integer) table.getValueAt(row,0));
                Data.setType((String) table.getValueAt(row,1));
                Data.setPower(Integer.parseInt((String) table.getValueAt(row,2)) );//这里要Integer.parseInt()才能转换，原因未知
                Data.setStatus((String) table.getValueAt(row,3));

            }
        });




        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);


        loadData();
    }

    private void loadData(){
        String sql = "SELECT * FROM powerbanktable";
        dbHelper = new DBHelper();
        ResultSet rs = dbHelper.query(sql);
        try {

            // 遍历结果集并将数据插入到表格模型中
            while (rs.next()) {

                Vector<Object> rowData = new Vector<>();
                rowData.add(rs.getInt("id"));
                rowData.add(rs.getString("type"));
                rowData.add(rs.getString("power"));
                rowData.add(rs.getString("status"));
                tableData.add(rowData);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            try{
                // 关闭结果集
                rs.close();
                dbHelper.rs.close();
                dbHelper.stmt.close();
                dbHelper.conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}