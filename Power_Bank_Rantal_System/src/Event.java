import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event extends DBHelper implements ActionListener {

    LoginGUI lg;
    String sql1,sql2;

    public Event(LoginGUI loginGUI){
        this.lg = loginGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj instanceof JButton){
            if(e.getActionCommand().equals("提交")){
                sql1 = "SELECT username, password FROM usertable;";
                query(sql1);
            }
        }
    }


}
