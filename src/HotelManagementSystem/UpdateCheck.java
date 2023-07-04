package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {
    JTextField id1,name,checkin,amtpaid,pendAmt;
    JButton check,back,update;
    Choice c1;
    UpdateCheck(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel labelCheck=new JLabel("Check-In Details ");
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

        id1=new JTextField();
        id1.setBounds(153,140,160,22);
        id1.setForeground(Color.BLACK);
        id1.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(id1);

        JLabel labelName=new JLabel("Name:");
        //label1 setbound aba frame anusar set hunxa
        labelName.setBounds(24,180,200,22);
        //styling font:
        labelName.setFont(new Font("Tahoma",Font.BOLD,16));
        labelName.setForeground(Color.white);
        panel.add(labelName);

        name=new JTextField();
        name.setBounds(153,180,160,22);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(name);


        JLabel labelCheckin=new JLabel("Check In:");
        //label1 setbound aba frame anusar set hunxa
        labelCheckin.setBounds(24,230,200,22);
        //styling font:
        labelCheckin.setFont(new Font("Tahoma",Font.BOLD,16));
        labelCheckin.setForeground(Color.white);
        panel.add(labelCheckin);

        checkin=new JTextField();
        checkin.setBounds(153,230,230,22);
        checkin.setForeground(Color.BLACK);
        checkin.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(checkin);


        JLabel labelAmountPaid=new JLabel("Amount Paid:");
        //label1 setbound aba frame anusar set hunxa
        labelAmountPaid.setBounds(24,270,200,22);
        //styling font:
        labelAmountPaid.setFont(new Font("Tahoma",Font.BOLD,16));
        labelAmountPaid.setForeground(Color.white);
        panel.add(labelAmountPaid);

        amtpaid=new JTextField();
        amtpaid.setBounds(153,270,160,22);
        amtpaid.setForeground(Color.BLACK);
        amtpaid.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(amtpaid);

        JLabel labelPendingAmount=new JLabel("Pending Amount:");
        //label1 setbound aba frame anusar set hunxa
        labelPendingAmount.setBounds(24,330,200,22);
        //styling font:
        labelPendingAmount.setFont(new Font("Tahoma",Font.BOLD,11));
        labelPendingAmount.setForeground(Color.white);
        panel.add(labelPendingAmount);

        pendAmt=new JTextField();
        pendAmt.setBounds(153,330,160,22);
        pendAmt.setForeground(Color.BLACK);
        pendAmt.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(pendAmt);

        check=new JButton("Check");
        check.addActionListener(this);
        check.setBounds(64,360,110,33);
        check.setFont(new Font("Tahoma",Font.BOLD,16));
        check.setForeground(Color.black);
        panel.add(check);

        update=new JButton("Update");
        update.addActionListener(this);
        update.setBounds(184,360,110,33);
        update.setFont(new Font("Tahoma",Font.BOLD,16));
        update.setForeground(Color.black);
        panel.add(update);

        back=new JButton("Back");

        back.addActionListener(this);
        back.setBounds(304,360,110,33);
        back.setFont(new Font("Tahoma",Font.BOLD,16));
        back.setForeground(Color.black);
        panel.add(back);




        //always
        setSize(950,500);
        setLocation(400,200);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check){
            String id=c1.getSelectedItem();
            String q="select *from customer where number='"+id+"'";
            try{
                ConnectionDatabase con=new ConnectionDatabase();
                ResultSet resultSet=con.statement.executeQuery(q);
                while (resultSet.next()){
                    id1.setText(resultSet.getString("room"));
                    name.setText(resultSet.getString("name"));
                    checkin.setText(resultSet.getString("checkintime"));
                    amtpaid.setText(resultSet.getString("deposite"));


                }
                ResultSet resultSet1=con.statement.executeQuery("select * from room where roomnumber= '"+id1.getText()+"'");
                while(resultSet1.next()){
                    String price=resultSet1.getString("price");
                    int amountPaid=Integer.parseInt(price)-Integer.parseInt(amtpaid.getText());
                    pendAmt.setText(""+amountPaid);
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }else if(e.getSource()==update){
            try{
                ConnectionDatabase con=new ConnectionDatabase();
                String q= c1.getSelectedItem();//ID has been Selected
                String room=id1.getText();
                String namee=name.getText();
                String  check=checkin.getText();
                String deposit=amtpaid.getText();
                con.statement.executeUpdate("update customer set room='"+room+"',name='"+namee+"',checkintime='"+check+"',deposite='"+deposit+"'");
                JOptionPane.showMessageDialog(null,"Update Sucessfully");

            }catch (Exception E){
                E.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new UpdateCheck();

    }
}
