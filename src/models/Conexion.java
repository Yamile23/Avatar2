/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yamil
 */
public class Conexion {
    private Connection con=null;
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/avatar","root","");    
            System.out.println("conectada");
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
        return con;
    }
}
