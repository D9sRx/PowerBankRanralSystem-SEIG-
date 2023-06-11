import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Vector;

public class PowerBankHistory extends Box{
    private JTable table;
    private Vector<String> titles;

    private Vector<Vector> tableData;

    private TableModel tableModel;
    JPanel jPanel;
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
        JScrollPane jScrollPane=new JScrollPane(table);

        this.add(jScrollPane);
    }

}
