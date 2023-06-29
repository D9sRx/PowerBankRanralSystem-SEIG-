import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class OrderManagement extends Box {
    private JTable table;

    public JTextField jTextField;

    private JLabel jLabel1;

    private JPanel jPanel1,jPanel2;
    private JButton jButton;
    private Vector<String> titles;

    private Vector<Vector> tableData;

    private TableModel tableModel;
    DBHelper dbHelper;
    public OrderManagement() {

        super(BoxLayout.Y_AXIS);
        //新建一些需要的组件的对象
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jButton = new JButton("删除");
        jLabel1 = new JLabel("编号为：");
        jTextField = new JTextField(20);

        //组装表格
        String[] ts={"编号","账号","开始时间","结束时间","费用"};
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

        //组装组件
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField);
        jPanel2.add(jButton);
        jButton.addActionListener(new DeleteHistory());
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.getSelectedRow();
                jTextField.setText(table.getValueAt(row,0)+"");
                Data.setHid((Integer) table.getValueAt(row,0));
            }
        });

        this.add(jPanel1);
        this.add(jPanel2);

        //加载数据
        loadData();
    }

    private void loadData(){
        String sql = "SELECT * FROM billcount";
        dbHelper = new DBHelper();
        ResultSet rs = dbHelper.query(sql);
        try {

            // 遍历结果集并将数据插入到表格模型中
            while (rs.next()) {

                Vector<Object> rowData = new Vector<>();
                rowData.add(rs.getInt("id"));
                rowData.add(rs.getString("username"));
                rowData.add(rs.getString("startTime"));
                rowData.add(rs.getString("overTime"));
                rowData.add(rs.getDouble("bill"));
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
