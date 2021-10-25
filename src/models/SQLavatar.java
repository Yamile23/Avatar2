/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.Reg_Avatar;

/**
 *
 * @author yamil
 */
public class SQLavatar extends Conexion {

    PreparedStatement ps = null;
    Connection con = getConexion();

    public SQLavatar() {

    }

    public ArrayList<Genero> CargarGenero() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT nombre from Genero");
            ArrayList<Genero> listGenero = new ArrayList<Genero>();
            while (rs.next()) {
                Genero g = new Genero();
                g.setNombre(rs.getString("nombre"));
                listGenero.add(g);
            }
            rs.close();
            con.close();

            return listGenero;
        } catch (SQLException ex) {
            Logger.getLogger(SQLavatar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean RegistroAvatar(Personajes avatar) {
        try {
            String sql = "INSERT INTO personaje(Nombre,genero,id_user,fecha,direccion,estado)values(?,?,?,now(),?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, avatar.getNombre());
            ps.setInt(2, avatar.getGenero());
            ps.setInt(3, avatar.getUser().getId());
            ps.setString(4, avatar.getDireccion());
            ps.setBoolean(5,avatar.isEstado());
            ps.execute();

            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SQLavatar.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
