import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PowerBankHistory extends Box{
    private JTable table;
    private Vector<String> titles;

    private Vector<Vector> tableData;

    private TableModel tableModel=null;
    JPanel jPanel;
    DBHelper dbHelper;
    public PowerBankHistory() {


        super(BoxLayout.Y_AXIS);
        jPanel=new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jPanel.setMaximumSize(new Dimension(850,80));
        jPanel.setVisible(true);
        this.add(jPanel);


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

        loadData();
    }

    private void loadData(){
        Data data = new Data();
        String sql = "SELECT * FROM billcount where username = '"+data.userName+"'";
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
