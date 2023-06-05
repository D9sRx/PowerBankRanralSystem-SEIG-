import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminEvent extends DBHelper implements ActionListener{

    AdminGUI adminGUI;
    public AdminEvent(AdminGUI adminGUI) {
        this.adminGUI=adminGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj =e.getSource();
        if(obj instanceof JMenuItem){
            if(e.getActionCommand().equals("切换账号")){
                LoginGUI loginGUI = new LoginGUI();
                adminGUI.jFrame.dispose();

            }
        }
        if(obj instanceof  JMenuItem){
            if(e.getActionCommand().equals("退出程序")){
                adminGUI.jFrame.dispose();
            }
        }


    }
}
