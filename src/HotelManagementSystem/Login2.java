package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login2 extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1,b2;

    Login2(){
        JLabel label1=new JLabel("UserName");
        //label1 setbound aba frame anusar set hunxa
        label1.setBounds(40,20,100,30);
        //styling font:
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        label1.setForeground(Color.white);
        add(label1);


        textField1=new JTextField();
        textField1.setBounds(150,20,150,30);
        textField1.setForeground(Color.BLACK);
        textField1.setBackground(new Color(3,45,48));;
        textField1.setFont(new Font("Tahoma",Font.BOLD,16));
        add(textField1);
        JLabel label2=new JLabel("Password");
        //label1 setbound aba frame anusar set hunxa
        label2.setBounds(40,80,100,30);
        //styling font:
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setForeground(Color.white);
        add(label2);
        passwordField1=new JPasswordField();
        passwordField1.setBounds(150,80,150,30);
        passwordField1.setForeground(Color.white);
        passwordField1.setBackground(new Color(3,45,48));;
        passwordField1.setFont(new Font("Tahoma",Font.BOLD,16));
        add(passwordField1);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icons/login.gif"));
        Image i1=imageIcon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        JLabel label =new JLabel(imageIcon);
        label.setBounds(315,30,255,200);
        add(label);
        b1=new JButton("Login");
        b1.addActionListener(this);
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.PLAIN,15));
        add(b1);
        b2=new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(200,140,120,30);
        b2.setFont(new Font("serif",Font.PLAIN,15));
        add(b2);

        //always
        setSize(600,300);
        setLocation(400,270);
        //color of frame
        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try{
                ConnectionDatabase connection=new ConnectionDatabase();
                String user= textField1.getText();
                String password=passwordField1.getText();
                //checking whether user and password is available in our database table or not.
                String q="select * from login2 where username='"+user+"' and password= '"+password+"'";
                System.out.println(q);
                ResultSet resultSet=connection.statement.executeQuery(q);
                if(resultSet.next()){
                    new Admin();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid");

                }
            }catch( Exception E){
                E.printStackTrace();
            }
        }else{
            System.exit(102);
        }
    }
    public static void main(String[] args) {
        new Login2();
    }
}
