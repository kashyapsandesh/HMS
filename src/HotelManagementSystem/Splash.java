package HotelManagementSystem;

import javax.swing.*;

public class Splash extends JFrame {

    //creting constructor of class
    Splash(){
        //setting images in anydirection
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icons/splash.gif"));
        JLabel label=new JLabel(imageIcon);
        label.setBounds(0,0,858,688);
        add(label);

        //By default in java layout is boarder layout
        setLayout(null);
        setLocation(300,88);

    setSize(858,680);
    setVisible(true);
    //try catch sabai yo bhanda tala rakhne
        //moving after 5 sec
        try{
            //for frame closing
            //1000millis=1sec
            Thread.sleep(5000);

            Login login=new Login();

            setVisible(false);
            login.setVisible(true);



        }catch(Exception e){
            e.printStackTrace();

        }
    }
    public static void main(String[] args) {
    //creating constructor object
        new Splash();
    }
}
