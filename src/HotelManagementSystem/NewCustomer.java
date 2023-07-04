package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {
    JTextField id,name,country,deposite;
    JComboBox t5,t7,comboBox;
    JButton b1,b2;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton add,back;

    NewCustomer(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel label2=new JLabel("New Customer Form");
        //label1 setbound aba frame anusar set hunxa
        label2.setBounds(194,10,260,22);
        //styling font:
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setForeground(Color.white);
        panel.add(label2);

        JLabel labelID=new JLabel("ID:");
        //label1 setbound aba frame anusar set hunxa
        labelID.setBounds(54,50,160,22);
        //styling font:
        labelID.setFont(new Font("Tahoma",Font.BOLD,16));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        comboBox=new JComboBox(new String[]{"Nagarikta", "Password", "Licesence", "College ID" });
        comboBox.setBounds(204,50,160,22);
        //styling font:
        comboBox.setFont(new Font("Tahoma",Font.BOLD,16));
        comboBox.setForeground(Color.BLACK);
        panel.add(comboBox);

        JLabel label4=new JLabel("Number:");
        //label1 setbound aba frame anusar set hunxa
        label4.setBounds(54,100,200,22);
        //styling font:
        label4.setFont(new Font("Tahoma",Font.BOLD,16));
        label4.setForeground(Color.white);
        panel.add(label4);

        id=new JTextField();
        id.setBounds(204,100,160,22);
        id.setForeground(Color.BLACK);
        id.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(id);

        JLabel label5=new JLabel("Customer Name");
        //label1 setbound aba frame anusar set hunxa
        label5.setBounds(54,150,200,22);
        //styling font:
        label5.setFont(new Font("Tahoma",Font.BOLD,16));
        label5.setForeground(Color.white);
        panel.add(label5);
        name=new JTextField();
        name.setBounds(204,150,160,22);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(name);

        JLabel labelGender=new JLabel("Gender");
        //label1 setbound aba frame anusar set hunxa
        labelGender.setBounds(54,200,200,22);
        //styling font:
        labelGender.setFont(new Font("Tahoma",Font.BOLD,16));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        r1=new JRadioButton("Male");
        r1.setForeground(Color.white);
        r1.setBackground(new Color(3,45,48));
        r1.setBounds(204,200,90,22);
        r1.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(r1);

        r2=new JRadioButton("Female");
        r2.setForeground(Color.white);
        r2.setBounds(304,200,280,22);
        r2.setBackground(new Color(3,45,48));
        r2.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(r2);

        JLabel labelCountry=new JLabel("Country");
        //label1 setbound aba frame anusar set hunxa
        labelCountry.setBounds(54,250,200,22);
        //styling font:
        labelCountry.setFont(new Font("Tahoma",Font.BOLD,16));
        labelCountry.setForeground(Color.white);
        panel.add(labelCountry);
        country=new JTextField();
        country.setBounds(204,250,160,22);
        country.setForeground(Color.BLACK);
        country.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(country);


        JLabel labelRoom=new JLabel("Allocated Room");
        //label1 setbound aba frame anusar set hunxa
        labelRoom.setBounds(54,300,200,22);
        //styling font:
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,16));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);

        c1=new Choice();
        try{
            ConnectionDatabase con=new ConnectionDatabase();
            ResultSet resultSet=con.statement.executeQuery("select *from room");
            while (resultSet.next()){
                c1.add(resultSet.getString("roomnumber"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        c1.setBounds(271,300,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        JLabel labelCheckIn=new JLabel("Checked-IN");
        //label1 setbound aba frame anusar set hunxa
        labelCheckIn.setBounds(54,350,200,22);
        //styling font:
        labelCheckIn.setFont(new Font("Tahoma",Font.BOLD,16));
        labelCheckIn.setForeground(Color.white);
        panel.add(labelCheckIn);

        Date date1=new Date();//java.util bata select garne


        date=new JLabel(date1.toString());
        date.setBounds(204,350,200,22);
        //styling font:
        date.setFont(new Font("Tahoma",Font.BOLD,16));
        date.setForeground(Color.white);
        panel.add(date);


        JLabel labelDeposit=new JLabel("Deposite");
        //label1 setbound aba frame anusar set hunxa
        labelDeposit.setBounds(54,400,200,22);
        //styling font:
        labelDeposit.setFont(new Font("Tahoma",Font.BOLD,16));
        labelDeposit.setForeground(Color.white);
        panel.add(labelDeposit);
        deposite=new JTextField();
        deposite.setBounds(204,400,160,22);
        deposite.setForeground(Color.BLACK);
        deposite.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(deposite);


        add=new JButton("Add");
        add.addActionListener(this);
        add.setBounds(64,450,110,33);
        add.setFont(new Font("Tahoma",Font.BOLD,16));
        add.setForeground(Color.black);
        panel.add(add);

        back=new JButton("Back");

        back.addActionListener(this);
        back.setBounds(184,450,110,33);
        back.setFont(new Font("Tahoma",Font.BOLD,16));
        back.setForeground(Color.black);
        panel.add(back);



        ImageIcon imageIconDriver=new ImageIcon(ClassLoader.getSystemResource("icons/roomser.png"));
        Image driver=imageIconDriver.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIconDriver1=new ImageIcon(driver);
        JLabel labelDriver=new JLabel(imageIconDriver1);
        labelDriver.setBounds(500,60,400,400);
        panel.add(labelDriver);

        //always
        setUndecorated(true);
        setLayout(null);
        setLocation(500,150);
        setSize(850,550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       try {
            if (e.getSource() == add) {
                ConnectionDatabase con = new ConnectionDatabase();
                String radioBtn = null;
                if (r1.isSelected()) {
                    radioBtn = "Male";
                } else if (r2.isSelected()) {
                    radioBtn = "Female";

                }
                String s1 = (String) comboBox.getSelectedItem();
                String s2 = id.getText();
                String s3 = name.getText();
                String s4 = radioBtn;
                String s5 = country.getText();
                String s6 = c1.getSelectedItem();
                String s7 = date.getText();
                String s8 = deposite.getText();

                try {
                    String q = "insert into customer values ('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
                    String q1 = "update room set availability='Occupied' where roomnumber=" + s6;
                    con.statement.executeUpdate(q);
                    con.statement.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Added Sucessfully");

                } catch (Exception E) {
                    E.printStackTrace();
                }

            } else {
                setVisible(false);
            }
        }catch(Exception F){
            F.printStackTrace();
       }




    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
