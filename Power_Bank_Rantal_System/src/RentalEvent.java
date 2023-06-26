import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

public class RentalEvent implements ActionListener {

    PowerBankUsage powerBankUsage;
    Data data;

    @Override
    public void actionPerformed(ActionEvent e) {
        powerBankUsage = new PowerBankUsage();
        data = new Data();
        String selectedPowerBank = (String) powerBankUsage.comboBox.getSelectedItem();
        // 获取当前系统时间
        Date currentTime = new Date();

        // 定义日期时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 格式化当前系统时间
        String formattedTime = dateFormat.format(currentTime);


        Object obj = e.getSource();
        if(e.getActionCommand().equals("租借")&& selectedPowerBank.equals("普通充电宝")){
            TimeCalculator timeCalculator = new TimeCalculator();
            data.setStartTime(formattedTime);
        } else if (e.getActionCommand().equals("租借")&& selectedPowerBank.equals("快充充电宝")) {
            TimeCalculator timeCalculator = new TimeCalculator();
            data.setStartTime(formattedTime);
        }
    }
}
