import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalCenterConponent extends Box{

    JLabel jl1,jl2,jl3,jl4;

    double money;
    public PersonalCenterConponent() {
        super(BoxLayout.Y_AXIS);

        Font font = new Font("宋体",Font.BOLD,30);

        JPanel jp=new JPanel();
        jp.setLayout(new GridLayout(3,1,0,20));

        jl1=new JLabel("点击查询余额");

        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        jl1.setBorder(border);

        jl2=new JLabel("充值中心");

        Border border1 = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        jl2.setBorder(border1);

        jl3=new JLabel("普通充电宝一个小时收费1.5元，快充充电宝一个小时2.5");
        Border border2 = BorderFactory.createLineBorder(Color.LIGHT_GRAY);

        jl3.setBorder(border2);
        PersoalCenterAdapter persoalCenterAdapter1=new PersoalCenterAdapter(this);

        jl1.addMouseListener(persoalCenterAdapter1);
        PersoalCenterAdapter persoalCenterAdapter2=new PersoalCenterAdapter(this);

        jl2.addMouseListener(persoalCenterAdapter2);
        PersoalCenterAdapter persoalCenterAdapter3=new PersoalCenterAdapter(this);
        jl3.addMouseListener(persoalCenterAdapter3);

        jl1.setFont(font);
        jl2.setFont(font);
        //jl3.setFont(font);

        jp.add(jl1);
        jp.add(jl2);
        jp.add(jl3);

        this.add(jp);

    }
}
