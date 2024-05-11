package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Saiko
 */
public class Databaseconnection {
    
   public static Connection conn; 
    
        public static Connection openConnection(){
        try{
            String url = "jdbc:mysql://localhost:3306/car-purchasing-app";
            String username = "root";
            String password = ""; // Provide your MySQL password here
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url, username, password);
            return conn; // Return the connection object
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
        
        public static void closeConnection(){
        
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        }
        
        
}
