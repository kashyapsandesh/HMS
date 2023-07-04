package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception(){
        JPanel jPanel1=new JPanel();
        jPanel1.setLayout(null);
        jPanel1.setBounds(280,5,1238,820);
        jPanel1.setBackground(new Color(3,45,48));
        add(jPanel1);

        JPanel jpanel2=new JPanel();
        jpanel2.setLayout(null);
        jpanel2.setBounds(5,5,270,820);
        jpanel2.setBackground(new Color(3,45,48));

        add(jpanel2);

        JButton btnNCF=new JButton("New Customer Form");
        btnNCF.setBounds(30,30,200,30);
        jpanel2.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:
                    new NewCustomer();


                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton btnRoom=new JButton("Rooms");
        btnRoom.setBounds(30,70,200,30);
        jpanel2.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:
                    new Rooms();


                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        //Department
        JButton btnDepartment=new JButton("Department");
        btnDepartment.setBounds(30,110,200,30);
        jpanel2.add(btnDepartment);
        btnDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        //All employee
        JButton btnAEI=new JButton("ALL EMPLOYEE INFO");
        btnAEI.setBounds(30,150,200,30);
        jpanel2.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        //customer info button
        JButton btnCI=new JButton("Customer Info");
        btnCI.setBounds(30,200,200,30);
        jpanel2.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        //manager info button
        JButton btnMI=new JButton("Manager Info");
        btnMI.setBounds(30,250,200,30);
        jpanel2.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
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
        JButton btnCO=new JButton("Check Out");
        btnCO.setBounds(30,300,200,30);
        jpanel2.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:
                    new Checkout();

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        //update coustomer
        JButton btnUC=new JButton("UpDate Customer");
        btnUC.setBounds(30,350,200,30);
        jpanel2.add(btnUC);
        btnUC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:
                    new UpdateCheck();

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        //update Room status
        JButton btnURS=new JButton("Update Room Status");
        btnURS.setBounds(30,400,200,30);
        jpanel2.add(btnURS);
        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        //pickup services
        JButton btnPUS=new JButton("PickUP services");
        btnPUS.setBounds(30,450,200,30);
        jpanel2.add(btnPUS);
        btnPUS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        //Search Room
        JButton btnSR=new JButton("Search Room");
        btnSR.setBounds(30,500,200,30);
        jpanel2.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //TODO:
                    new SearchRoom();
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        //sign Out
        JButton btnLO=new JButton("Log Out");
        btnLO.setBounds(30,550,200,30);
        jpanel2.add(btnLO);
        btnLO.addActionListener(new ActionListener() {
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

//
        //always
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Reception();
    }
}
