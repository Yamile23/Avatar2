/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author yamil
 */
public class SQLuser extends Conexion{
        PreparedStatement ps=null;
        Connection con = getConexion();
    public  boolean registrar(Usuario user){
        
        String sql="INSERT INTO usuario(Nombre,Correo,pass) values(?,?,?)";
        try{
            ps= con.prepareStatement(sql);
            ps.setString(1,user.getNombre());
            ps.setString(2,user.getCorreo());
            ps.setString(3,user.getPassword());
            ps.execute();

      
            con.close();
            return true;
        }
        catch(SQLException ex){
            Logger.getLogger(SQLuser.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
        
    }
    
    public  int existeUsuario(String usuario){
        ResultSet rs=null;
        String sql="SELECT COUNT(Nombre) FROM `usuario` WHERE Nombre = ?;";
        try{
            ps= con.prepareStatement(sql);
            ps.setString(1,usuario);
            rs=ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            }
            return 1;
        }
        catch(SQLException ex){
            Logger.getLogger(SQLuser.class.getName()).log(Level.SEVERE,null,ex);
            
        }
        return 1;
    }
    
    public boolean esEmail(String correo){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        
        return mather.find();
    }
    
    /*public  boolean login(Usuario usuario){
        ResultSet rs=null;
        String sql=
        "SELECT * from usuario WHERE Nombre=?";
        try{
            ps= con.prepareStatement(sql);
            ps.setString(1,usuario.getNombre());
            rs=ps.executeQuery();
            
            if(rs.next()){
                if(usuario.getPassword().equals(rs.getString(4))){
                usuario.setId(rs.getInt("Id_user"));
                usuario.setNombre(rs.getString(2));
                usuario.setCorreo(rs.getString(3));
                return true;}
                else{
                    return false;
                }
            }
            return false;
        }
        catch(SQLException ex){
            Logger.getLogger(SQLuser.class.getName()).log(Level.SEVERE,null,ex);
            
        }
        return false;
    }*/
    
        public  Usuario login(Usuario usuario){
        ResultSet rs=null;
        String sql=
        "SELECT * from usuario WHERE Nombre=?";
        try{
            ps= con.prepareStatement(sql);
            ps.setString(1,usuario.getNombre());
            rs=ps.executeQuery();
            
            if(rs.next()){
                if(usuario.getPassword().equals(rs.getString(4))){
                usuario.setId(rs.getInt("Id_user"));
                usuario.setNombre(rs.getString(2));
                usuario.setCorreo(rs.getString(3));
                return usuario;}
                else{
                    return null;
                }
            }
            return null;
        }
        catch(SQLException ex){
            Logger.getLogger(SQLuser.class.getName()).log(Level.SEVERE,null,ex);
            
        }
        return null;
    }
}
