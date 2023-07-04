package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame {
    Admin(){


        JPanel jpanel2=new JPanel();
        jpanel2.setLayout(null);
        jpanel2.setBounds(5,5,1950,1090);
        jpanel2.setBackground(new Color(3,45,48));

        add(jpanel2);


        ImageIcon imageIconEmployees=new ImageIcon(ClassLoader.getSystemResource("icons/employees.png"));
        Image employees=imageIconEmployees.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon imageIconEmployees1=new ImageIcon(employees);
        JLabel labelEmployees=new JLabel(imageIconEmployees1);
        labelEmployees.setBounds(120,100,150,150);
        jpanel2.add(labelEmployees);

        JButton btnRoom=new JButton("ADD EMPLOYEE");
        btnRoom.setBounds(300,150,200,30);
        jpanel2.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });


        ImageIcon imageIconRooms=new ImageIcon(ClassLoader.getSystemResource("icons/room.png"));
        Image rooms=imageIconRooms.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon imageIconRooms1=new ImageIcon(rooms);
        JLabel labelRooms=new JLabel(imageIconRooms1);
        labelRooms.setBounds(120,300,100,100);
        jpanel2.add(labelRooms);
        //customer info button
        JButton btnCI=new JButton("ADD ROOM");
        btnCI.setBounds(300,300,200,30);
        jpanel2.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:
                    new AddRoom();
                    setVisible(false);

                }catch(Exception E){
                    E.printStackTrace();

                }
            }
        });

        ImageIcon imageIconDriver=new ImageIcon(ClassLoader.getSystemResource("icons/driver.png"));
        Image driver=imageIconDriver.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon imageIconDriver1=new ImageIcon(driver);
        JLabel labelDriver=new JLabel(imageIconDriver1);
        labelDriver.setBounds(120,450,100,100);
        jpanel2.add(labelDriver);
        //checkout
        JButton btnCO=new JButton("ADD DRIVER");
        btnCO.setBounds(300,450,200,30);
        jpanel2.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        //checkout
        JButton btnLO=new JButton("Logout");
        btnLO.setBounds(10,600,100,30);
        jpanel2.add(btnLO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:
                    System.exit(102);

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        //checkout
        JButton btnBack=new JButton("Back");
        btnBack.setBounds(140,600,100,30);
        jpanel2.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:
                    new Dashboard();
                    setVisible(false);

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });




//
        //always
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Admin();
    }
}
