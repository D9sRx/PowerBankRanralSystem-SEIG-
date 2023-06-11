
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.spec.RSAOtherPrimeInfo;

public class PersoalCenterAdapter extends MouseAdapter {
    PersonalCenterConponent pc;
    public PersoalCenterAdapter(PersonalCenterConponent pc){
        this.pc=pc;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        Object o=  e.getSource();
        if(((JLabel)o).getText().equals("余额")){
            if (e.getButton() == e.BUTTON1) {
                System.out.println("1");
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