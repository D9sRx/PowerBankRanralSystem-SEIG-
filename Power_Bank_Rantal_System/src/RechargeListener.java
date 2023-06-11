import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RechargeListener implements ActionListener {
    ReCharge rc;
    public RechargeListener(ReCharge rc){
        this.rc=rc;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object o=actionEvent.getSource();
        if (o.equals(rc.jb1)){
            if(rc.jtf.getText().equals("")){
                rc.jtf.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "充值成功", "Success", JOptionPane.INFORMATION_MESSAGE);
                rc.jtf.setText("");
            }
        }
    }
}
