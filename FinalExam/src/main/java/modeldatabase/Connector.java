/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeldatabase;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Win7
 */
public class Connector {
    String DBurl = "jdbc:mysql://localhost:3306/my_movie";
    String DBusername = "root";
    String DBpassword = "";
    
    
    String data[] = new String[2];
    public static Connection koneksi;
    Statement statement;
    static String [] username;

    public Connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Connection Successful");
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Connection Failed " + ex.getMessage() );
        }
}
}
