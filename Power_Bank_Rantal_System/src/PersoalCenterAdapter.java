
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersoalCenterAdapter extends MouseAdapter {
    PersonalCenterConponent pc;
    public double money;
    public PersoalCenterAdapter(PersonalCenterConponent pc){
        this.pc=pc;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        Object o=  e.getSource();
        if(((JLabel)o).getText().equals("余额")){
            if (e.getButton() == e.BUTTON1) {
                System.out.println(1);
                //查询并显示余额
                DBHelper dbHelper = new DBHelper();
                Data data = new Data();
                String sql = "select money from usertable where username = '"+data.userName+"'";
                ResultSet rs = dbHelper.query(sql);
                try {

                    if (rs.next()) {
                        money = rs.getDouble("money");
                        System.out.println(money);
                        pc.jl1.setText("余额："+money);
                    }else{
                        System.out.println(-8);
                    }
                }catch (Exception ex) {
                    ex.getStackTrace();
                }finally {
                    try {

                        rs.close();
                        dbHelper.rs.close();
                        dbHelper.stmt.close();
                        dbHelper.conn.close();

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }if(((JLabel)o).getText().equals("充值中心")){
            if (e.getButton() == e.BUTTON1) {
                new ReCharge();
            }
        }if(((JLabel)o).getText().equals("关于")){
            if (e.getButton() == e.BUTTON1) {
                System.out.println("3");
            }
        }
    }
}