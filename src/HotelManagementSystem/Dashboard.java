package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JButton add,rec;
    Dashboard(){
        //super
        super("Hotel Management System");
        ImageIcon imageIconRec=new ImageIcon(ClassLoader.getSystemResource("icons/reception.png"));
        Image recption=imageIconRec.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon imageIconRec1=new ImageIcon(recption);
        JLabel labelRec=new JLabel(imageIconRec1);
        labelRec.setBounds(400,250,200,200);
        add(labelRec);
        rec=new JButton("RECEPTION");
        rec.addActionListener( this);
        rec.setBounds(425,510,140,30);

        rec.setFont(new Font("Tahoma",Font.BOLD,15));
        rec.setBackground(new Color(255,98,0));
        rec.setForeground(Color.white);

        add(rec);
        ImageIcon imageIconBoss=new ImageIcon(ClassLoader.getSystemResource("icons/boss.png"));
        Image boss=imageIconBoss.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon imageIconBoss1=new ImageIcon(boss);
        JLabel labelBoss=new JLabel(imageIconBoss1);
        labelBoss.setBounds(850,250,200,200);
        add(labelBoss);

        add=new JButton("ADMIN");
        add.addActionListener(this);
        add.setBounds(880,510,140,30);
        add.setFont(new Font("Tahoma",Font.BOLD,15));
        add.setBackground(new Color(255,98,0));
        add.setForeground(Color.white);
        add(add);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.gif"));
        Image i1=imageIcon.getImage().getScaledInstance(1950,1090,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(0,0,1950,1090);
        add(label);

        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rec){
            //TODO:
            new Reception();
            setVisible(false);

        }else{
            //TODO:
            new Login2();
        }

    }

    public static void main(String[] args) {
        new Dashboard();

    }
}
