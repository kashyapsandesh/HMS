package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {
    JTextField id1,name,checkin,amtpaid,pendAmt;
    JButton check,back,checkOut;
    JLabel labelCheckintime,labelRoomNumber,labelCheckouttime;
    Choice c1;
    Date date;
    Checkout(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);
        JLabel labelCheck=new JLabel("Check Out ");
        //label1 setbound aba frame anusar set hunxa
        labelCheck.setBounds(194,10,260,22);
        //styling font:
        labelCheck.setFont(new Font("Tahoma",Font.BOLD,16));
        labelCheck.setForeground(Color.white);
        panel.add(labelCheck);


        JLabel labelID=new JLabel("ID");
        //label1 setbound aba frame anusar set hunxa
        labelID.setBounds(24,70,120,22);
        //styling font:
        labelID.setFont(new Font("Tahoma",Font.BOLD,11));
        labelID.setForeground(Color.white);
        panel.add(labelID);



        c1=new Choice();
        try{
            ConnectionDatabase con=new ConnectionDatabase();
            ResultSet resultSet=con.statement.executeQuery("select *from customer");
            while (resultSet.next()){
                c1.add(resultSet.getString("number"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }
//        c1.add("Single");
//        c1.add("Double");
        c1.setBounds(153,70,120,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);




        JLabel label4=new JLabel("Room No:");
        //label1 setbound aba frame anusar set hunxa
        label4.setBounds(24,140,200,22);
        //styling font:
        label4.setFont(new Font("Tahoma",Font.BOLD,16));
        label4.setForeground(Color.white);
        panel.add(label4);

         labelRoomNumber=new JLabel();
        //label1 setbound aba frame anusar set hunxa
        labelRoomNumber.setBounds(164,140,200,22);
        //styling font:
        labelRoomNumber.setFont(new Font("Tahoma",Font.BOLD,16));
        labelRoomNumber.setForeground(Color.white);
        panel.add(labelRoomNumber);



        Date date1=new Date();//java.util bata select garne




        JLabel labelCheckin=new JLabel("Check In:");
        //label1 setbound aba frame anusar set hunxa
        labelCheckin.setBounds(24,230,200,22);
        //styling font:
        labelCheckin.setFont(new Font("Tahoma",Font.BOLD,16));
        labelCheckin.setForeground(Color.white);
        panel.add(labelCheckin);

         labelCheckintime=new JLabel("Check In:");
        //label1 setbound aba frame anusar set hunxa
        labelCheckintime.setBounds(164,230,200,22);
        //styling font:
        labelCheckintime.setFont(new Font("Tahoma",Font.BOLD,16));
        labelCheckintime.setForeground(Color.white);
        panel.add(labelCheckintime);




        JLabel labelCheckout=new JLabel("Check Out:");
        //label1 setbound aba frame anusar set hunxa
        labelCheckout.setBounds(24,270,200,22);
        //styling font:
        labelCheckout.setFont(new Font("Tahoma",Font.BOLD,16));
        labelCheckout.setForeground(Color.white);
        panel.add(labelCheckout);

         labelCheckouttime=new JLabel(""+date1);
        //label1 setbound aba frame anusar set hunxa
        labelCheckouttime.setBounds(154,270,200,22);
        //styling font:
        labelCheckouttime.setFont(new Font("Tahoma",Font.BOLD,16));
        labelCheckouttime.setForeground(Color.white);
        panel.add(labelCheckouttime);

        check=new JButton("Check");
        check.addActionListener(this);
        check.setBounds(64,320,110,33);
        check.setFont(new Font("Tahoma",Font.BOLD,16));
        check.setForeground(Color.black);
        panel.add(check);

        checkOut=new JButton("Update");
        checkOut.addActionListener(this);
        checkOut.setBounds(184,320,110,33);
        checkOut.setFont(new Font("Tahoma",Font.BOLD,16));
        checkOut.setForeground(Color.black);
        panel.add(checkOut);

        back=new JButton("Back");

        back.addActionListener(this);
        back.setBounds(304,320,110,33);
        back.setFont(new Font("Tahoma",Font.BOLD,16));
        back.setForeground(Color.black);
        panel.add(back);



        //always
        setUndecorated(true);
        setLayout(null);
        setSize(800,400);
        setLocation(500,210);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check){
            ConnectionDatabase con=new ConnectionDatabase();
            try{
                ResultSet resultSet= con.statement.executeQuery("select *from customer where number='"+c1.getSelectedItem()+"'");
                while (resultSet.next()){
                    labelRoomNumber.setText(resultSet.getString("room"));
                    labelCheckintime.setText(resultSet.getString("checkintime"));

                }
            }catch (Exception E){
                E.printStackTrace();
            }

        }else if(e.getSource()==checkOut){

            try{
                ConnectionDatabase con=new ConnectionDatabase();
                con.statement.executeUpdate("delete from customer where number='"+c1.getSelectedItem()+"'");
                con.statement.executeUpdate("update room set availability= 'Available' where roomnumber='"+labelRoomNumber+"'");
                JOptionPane.showMessageDialog(null,"Done");

            }catch(Exception E){
                E.printStackTrace();

            }

        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Checkout();

    }
}
