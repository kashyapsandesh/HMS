package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {
    JTextField t2,t4;
    JComboBox t3,t5,t7;
    JButton b1,b2;

    AddRoom(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label2=new JLabel("Add Rooms");
        //label1 setbound aba frame anusar set hunxa
        label2.setBounds(194,10,160,22);
        //styling font:
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setForeground(Color.white);
        panel.add(label2);

        JLabel label3=new JLabel("Room Number");
        //label1 setbound aba frame anusar set hunxa
        label3.setBounds(54,50,160,22);
        //styling font:
        label3.setFont(new Font("Tahoma",Font.BOLD,16));
        label3.setForeground(Color.white);
        panel.add(label3);

        t2=new JTextField();
        t2.setBounds(204,50,160,22);
        //styling font:
        t2.setFont(new Font("Tahoma",Font.BOLD,16));
        t2.setForeground(Color.BLACK);
        panel.add(t2);

        JLabel label4=new JLabel("Cleaning Status");
        //label1 setbound aba frame anusar set hunxa
        label4.setBounds(54,250,160,22);
        //styling font:
        label4.setFont(new Font("Tahoma",Font.BOLD,16));
        label4.setForeground(Color.white);
        panel.add(label4);

        t3=new JComboBox(new String[]{"Cleaned","Dirty"});
        t3.setBounds(204,250,160,22);
        //styling font:
        t3.setFont(new Font("Tahoma",Font.BOLD,16));
        t3.setForeground(Color.black);
        panel.add(t3);

        JLabel label5=new JLabel("Price");
        //label1 setbound aba frame anusar set hunxa
        label5.setBounds(54,200,160,22);
        //styling font:
        label5.setFont(new Font("Tahoma",Font.BOLD,16));
        label5.setForeground(Color.white);
        panel.add(label5);

        t4=new JTextField();
        t4.setBounds(204,200,160,22);
        //styling font:
        t4.setFont(new Font("Tahoma",Font.BOLD,16));
        t4.setForeground(Color.black);
        panel.add(t4);


        JLabel label6=new JLabel("Availability");
        //label1 setbound aba frame anusar set hunxa
        label6.setBounds(54,100,160,22);
        //styling font:
        label6.setFont(new Font("Tahoma",Font.BOLD,16));
        label6.setForeground(Color.white);
        panel.add(label6);

        t5=new JComboBox(new String[]{"Available","Occupied"});
        t5.setBounds(204,100,160,22);
        //styling font:
        t5.setFont(new Font("Tahoma",Font.BOLD,16));
        t5.setForeground(Color.black);
        panel.add(t5);


        JLabel label7=new JLabel("Bed Type");
        //label1 setbound aba frame anusar set hunxa
        label7.setBounds(54,300,160,22);
        //styling font:
        label7.setFont(new Font("Tahoma",Font.BOLD,16));
        label7.setForeground(Color.white);
        panel.add(label7);

        t7=new JComboBox(new String[]{"Single","Double"});
        t7.setBounds(204,300,160,22);
        //styling font:
        t7.setFont(new Font("Tahoma",Font.BOLD,16));
        t7.setForeground(Color.black);
        panel.add(t7);

        b1=new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(64,351,110,33);
        b1.setFont(new Font("Tahoma",Font.BOLD,16));
        b1.setForeground(Color.black);
        panel.add(b1);

        b2=new JButton("Back");

        b2.addActionListener(this);
        b2.setBounds(184,351,110,33);
        b2.setFont(new Font("Tahoma",Font.BOLD,16));
        b2.setForeground(Color.black);
        panel.add(b2);

        ImageIcon imageIconDriver=new ImageIcon(ClassLoader.getSystemResource("icons/roomser.png"));
        Image driver=imageIconDriver.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIconDriver1=new ImageIcon(driver);
        JLabel labelDriver=new JLabel(imageIconDriver1);
        labelDriver.setBounds(500,60,400,400);
        panel.add(labelDriver);

        //always
        setUndecorated(false);
        setLocation(20,200);
        setLayout(null);
        setSize(885,500);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

            if(e.getSource()==b1){
                try{
                    //creating connection with database;
                    ConnectionDatabase con=new ConnectionDatabase();
                    String room=t2.getText();
                    String ava=(String)t5.getSelectedItem();
                    String status=(String)t3.getSelectedItem();
                    String price=t4.getText();
                    String type=(String)t7.getSelectedItem();
                    String q="insert into room values('"+room+"','"+ava+"','"+status+"','"+price+"','"+type+"')";
                    System.out.println(q);
                    con.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Room Sucessfully Added");
                    this.setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }

            }else{
               new Admin();
               setVisible(false);
            }



    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
