package bank.management;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem" , "root","7000487408Aa_");
            s = c.createStatement();


        }catch(Exception e){
            System.out.println(e);
        }
    }

}

