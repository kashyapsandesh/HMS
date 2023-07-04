package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JCheckBox checkBox;
    Choice c1;
    JTable table;
    JButton add,back;
    SearchRoom(){
        JPanel panel=new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        add(panel);


        JLabel labelSearchRooms=new JLabel("Search Rooms");
        //label1 setbound aba frame anusar set hunxa
        labelSearchRooms.setBounds(194,10,260,22);
        //styling font:
        labelSearchRooms.setFont(new Font("Tahoma",Font.BOLD,16));
        labelSearchRooms.setForeground(Color.white);
        panel.add(labelSearchRooms);

        JLabel labelType=new JLabel("Search Rooms");
        //label1 setbound aba frame anusar set hunxa
        labelType.setBounds(24,70,120,22);
        //styling font:
        labelType.setFont(new Font("Tahoma",Font.BOLD,11));
        labelType.setForeground(Color.white);
        panel.add(labelType);

        checkBox=new JCheckBox("Only Display Available");
        checkBox.setBounds(400,69,205,23);
        checkBox.setForeground(Color.white);
        checkBox.setBackground(new Color(3,45,48));
        panel.add(checkBox);

        c1=new Choice();
//        try{
//            ConnectionDatabase con=new ConnectionDatabase();
//            ResultSet resultSet=con.statement.executeQuery("select *from room");
//            while (resultSet.next()){
//                c1.add(resultSet.getString("roomnumber"));
//            }
//        }catch (Exception E){
//            E.printStackTrace();
//        }
        c1.add("Single");
        c1.add("Double");
        c1.setBounds(153,70,120,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        table=new JTable();
        table.setBounds(0,187,700,100);
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

        JLabel roomNo=new JLabel("Room No.");
        roomNo.setBounds(35,105,80,40);
        roomNo.setForeground(Color.white);
        panel.add(roomNo);

        JLabel availability=new JLabel("Availability");
        availability.setBounds(135,105,80,40);
        availability.setForeground(Color.white);
        panel.add(availability);

        JLabel cleanstatus=new JLabel("Clean Status");
        cleanstatus.setBounds(275,105,80,40);
        cleanstatus.setForeground(Color.white);
        panel.add(cleanstatus);

        JLabel price=new JLabel("Price");
        price.setBounds(455,105,80,40);
        price.setForeground(Color.white);
        panel.add(price);

        JLabel type=new JLabel("Room Type");
        type.setBounds(590,105,80,40);
        type.setForeground(Color.white);
        panel.add(type);

        add=new JButton("Add");
        add.addActionListener(this);
        add.setBounds(64,290,110,33);
        add.setFont(new Font("Tahoma",Font.BOLD,16));
        add.setForeground(Color.black);
        panel.add(add);

        back=new JButton("Back");

        back.addActionListener(this);
        back.setBounds(184,290,110,33);
        back.setFont(new Font("Tahoma",Font.BOLD,16));
        back.setForeground(Color.black);
        panel.add(back);

        //always
        setLocation(500,200);
        setLayout(null);
        setSize(700,500);
        setVisible(true);

    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){

            String q="select * from room where bed_type='"+c1.getSelectedItem()+"'";
            String q1="select * from room where availability='Available'";
            System.out.println(q1);
            System.out.println(q);
            try{
                ConnectionDatabase con=new ConnectionDatabase();
                ResultSet resultSet=con.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
                if(checkBox.isSelected()){
                    ResultSet resultSet1=con.statement.executeQuery(q1);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }

}
