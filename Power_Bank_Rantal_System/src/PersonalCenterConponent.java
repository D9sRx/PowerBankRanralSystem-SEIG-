import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class PersonalCenterConponent extends Box{

    JLabel jl1,jl2,jl3,jl4;
    public PersonalCenterConponent() {
        super(BoxLayout.Y_AXIS);
        JPanel jp=new JPanel();
        jp.setLayout(new GridLayout(3,1,0,20));
        jl1=new JLabel("余额");
        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        jl1.setBorder(border);
        jl2=new JLabel("充值中心");
        Border border1 = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        jl2.setBorder(border1);
        jl3=new JLabel("关于");
        Border border2 = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        jl3.setBorder(border2);
        PersoalCenterAdapter persoalCenterAdapter1=new PersoalCenterAdapter(this);
        jl1.addMouseListener(persoalCenterAdapter1);
        PersoalCenterAdapter persoalCenterAdapter2=new PersoalCenterAdapter(this);
        jl2.addMouseListener(persoalCenterAdapter2);
        PersoalCenterAdapter persoalCenterAdapter3=new PersoalCenterAdapter(this);
        jl3.addMouseListener(persoalCenterAdapter3);

        jp.add(jl1);
        jp.add(jl2);
        jp.add(jl3);

        this.add(jp);

    }
}
