import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
public class PowerBankUsageComponent2 extends Box{

    private JTable table;
    private Vector<String> titles;

    private Vector<Vector> tableData;

    private DefaultTableModel tableModel;
    JPanel jPanel;
    public PowerBankUsageComponent2() {

        super(BoxLayout.Y_AXIS);

        jPanel=new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jPanel.setMaximumSize(new Dimension(850,80));

        JButton jb1=new JButton("租赁");
        JButton jb2=new JButton("归还");
        jPanel.add(jb1);
        jPanel.add(jb2);
        jPanel.setVisible(true);
        this.add(jPanel);


        //组装表格
        String[] ts={"编号","类型","充电宝电量"};
        titles=new Vector<>();
        for (String title :ts) {
            titles.add(title);
        }
        tableData=new Vector<>();
        String[][] strings={
                {"1","2","3","4"},
                {"1","2","3","4"}
        };
        for (int i = 0; i < 2; i++) {
            Vector t=new Vector<>();
            for (int j = 0; j < 4; j++) {
                if(j==3){
                    continue;
                }
                t.add(strings[i][j]);
            }
            tableData.add(t);
        }
        tableModel=new DefaultTableModel(tableData,titles);

        table=new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column!=0 && column!=1&& column!=2;
            }
        };
        table.setRowHeight(30);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jScrollPane=new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(400, 200));
        this.add(jScrollPane);
    }

}

