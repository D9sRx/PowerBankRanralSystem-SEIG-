import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TimeCalculator extends JFrame {
    public int seconds = 0;
    public int minutes = 0;
    public int hours = 0;


    DataUploader dataUploader;

    PowerBankBillCounter powerBankBillCounter;

    UserMoneyChanger userMoneyChanger;

    public TimeCalculator() {

        //data = new Data();
        dataUploader = new DataUploader();
        powerBankBillCounter = new PowerBankBillCounter();
        userMoneyChanger = new UserMoneyChanger();
        JFrame frame = new JFrame("Timer Demo");
        frame.setLayout(new GridLayout(3,1));//重新设置布局

        JLabel label = new JLabel("00:00:00", SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(64.0f)); // 调整字体大小



        Timer timer = new Timer(1000, new ActionListener() {//计算时间


            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                if (seconds >= 60) {
                    minutes++;
                    seconds = 0;
                }
                if (minutes >= 60) {
                    hours++;
                    minutes = 0;
                }
                label.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            }
        });
        timer.start();
        JButton button=new JButton("归还");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(label.getText());//打印时间


                JOptionPane.showMessageDialog(null, "退还成功\n"+"总使用时长为"+label.getText(), "Success", JOptionPane.INFORMATION_MESSAGE);
                Data data = new Data();//创建data对象用于存放数据
                // 获取当前系统时间
                Date currentTime = new Date();

                // 定义日期时间格式
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                // 格式化当前系统时间
                String formattedTime = dateFormat.format(currentTime);

                seconds += minutes*60+hours*3600;

                //传输数据到data
                data.setOverTime(formattedTime);
                data.setSecond(seconds);
                data.setMinutes(minutes);
                data.setHours(hours);


                powerBankBillCounter.count();//计算费用
                dataUploader.upload();//使用记录上传
                userMoneyChanger.change();//扣费


                DBHelper dbHelper = new DBHelper();
                String sql = "update powerbanktable set power = '"+ powerBankBillCounter.power+"' where type = '"+RentalEvent.type+"'";
                int i =dbHelper.update(sql);
                if (i > 0) {
                    try {
                        dbHelper.stmt.close();
                        dbHelper.conn.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }




                frame.dispose();
                hours=0;
                minutes=0;
                seconds=0;
                timer.stop();//停止并且重新设置时间


            }
        });
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel2.add(label);
        panel3.add(button);

        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel2);
        frame.getContentPane().add(panel3);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);


    }

}