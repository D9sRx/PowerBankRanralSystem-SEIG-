import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class RentalEvent implements ActionListener{


    Data data;
    public static String type;

    public static String selectedPowerBank;

    @Override
    public void actionPerformed(ActionEvent e) {


        try {
            PowerBankUsage powerBankUsage = new PowerBankUsage();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        data = new Data();

        Date currentTime = new Date();


        // 定义日期时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 格式化当前系统时间
        String formattedTime = dateFormat.format(currentTime);


        Object obj = e.getSource();
        CheckPower cp = new CheckPower();
        CheckStatus cs = new CheckStatus();


        if(e.getActionCommand().equals("租借")){

            try {
                cp.check();
                System.out.println(CheckPower.power);
                cs.checkStatus();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            if(CheckPower.power > 20 && PersoalCenterAdapter.money > 0 && CheckStatus.status.equals("未被租借")){

                TimeCalculator timeCalculator = new TimeCalculator();
                data.setStartTime(formattedTime);

            }else{
                JOptionPane.showMessageDialog(null, "租借失败,已被租借或电宝没电或欠费", "Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
