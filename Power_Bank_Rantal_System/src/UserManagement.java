import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class UserManagement extends Box {
    private JTable table;

    public JTextField jTextField;
    private JLabel jLabel;
    private JButton jButton;
    private Vector<String> titles;

    private Vector<Vector> tableData;

    private TableModel tableModel;
    JPanel jPanel1,jPanel2;
    DBHelper dbHelper;
    public UserManagement() {
        super(BoxLayout.Y_AXIS);

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel = new JLabel("用户为：");
        jButton = new JButton("删除");
        jTextField = new JTextField(20);

        //组装表格
        String[] ts={"账号","密码","余额"};
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

        jPanel1.add(jLabel);
        jPanel1.add(jTextField);
        jPanel2.add(jButton);

        jButton.addActionListener(new DeleteUser());
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.getSelectedRow();
                jTextField.setText(table.getValueAt(row,0)+"");
                Data.setSelectedUser((String) table.getValueAt(row,0));
            }
        });



        this.add(jPanel1);
        this.add(jPanel2);


        loadData();
    }

    private void loadData(){
        String sql = "SELECT * FROM usertable";
        dbHelper = new DBHelper();
        ResultSet rs = dbHelper.query(sql);
        try {

            // 遍历结果集并将数据插入到表格模型中
            while (rs.next()) {

                Vector<Object> rowData = new Vector<>();
                rowData.add(rs.getString("username"));
                rowData.add(rs.getString("password"));
                rowData.add(rs.getDouble("money"));
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
