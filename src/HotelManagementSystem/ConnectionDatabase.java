package HotelManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionDatabase {
    Connection connection;
    Statement statement;
    public ConnectionDatabase(){
        //by default mysql workbench port is 3306;
        try{
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelMS","root","Kashyap@000");
        statement=connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
