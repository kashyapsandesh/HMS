package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Rooms extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Rooms(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIconBoss=new ImageIcon(ClassLoader.getSystemResource("icons/roomm.png"));
        Image boss=imageIconBoss.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon imageIconBoss1=new ImageIcon(boss);
        JLabel labelBoss=new JLabel(imageIconBoss1);
        labelBoss.setBounds(550,250,200,200);
        panel.add(labelBoss);
        table=new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);

        try{
            ConnectionDatabase con=new ConnectionDatabase();
            String RoomInfo="select *from room";
            ResultSet resultSet= con.statement.executeQuery(RoomInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception E){
            E.printStackTrace();
        }

        back=new JButton("Back");
        back.setBounds(200,500,120,30);


        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);

        JLabel roomNo=new JLabel("Room No.");
        roomNo.setBounds(35,5,80,40);
        roomNo.setForeground(Color.white);
        panel.add(roomNo);

        JLabel availability=new JLabel("Availability");
        availability.setBounds(115,5,80,40);
        availability.setForeground(Color.white);
        panel.add(availability);

        JLabel cleanstatus=new JLabel("Clean Status");
        cleanstatus.setBounds(225,5,80,40);
        cleanstatus.setForeground(Color.white);
        panel.add(cleanstatus);

        JLabel price=new JLabel("Price");
        price.setBounds(315,5,80,40);
        price.setForeground(Color.white);
        panel.add(price);

        JLabel type=new JLabel("Room Type");
        type.setBounds(415,5,80,40);
        type.setForeground(Color.white);
        panel.add(type);


        //always
        setLayout(null);
        setLocation(500,100);
        setSize(900,600);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Rooms();
    }
}
