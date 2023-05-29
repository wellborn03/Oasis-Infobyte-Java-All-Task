/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class javaconnect {
    
   Connection conn;
   
  public static Connection ConnectDb(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/signup","root","");
                return conn;
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        return null;
    }
    
} 
    
}
