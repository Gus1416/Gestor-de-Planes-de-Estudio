/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.RegistroCurso;

/**
 *
 * @author María Laura
 */
public class CursoCRUD  extends Conexion{
    private RegistroCurso regCurso;
     
    
    /**public void llenar_escuelas(){
        try{
            PreparedStatement ps;
            ResultSet rs;
    
            Connection con = getConexion();
            ps = con.prepareStatement("SELECT nombre_escuela FROM escuela");

            rs = ps.executeQuery();
            regCurso.EscuelaCb.addItem("Escuela");
            while (rs.next()) {
                regCurso.EscuelaCb.addItem(rs.getString("nombre_escuela"));
            }
        }
  
         catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
   **/
    public boolean registrar(Curso curso){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_curso(?,?,?,?,?)";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, "Diseño Industrial");
      ps.setString(2, curso.getNombreCurso());
      ps.setString(3,curso.getIdCurso());
      ps.setString(4, curso.getCreditos());
      ps.setString(5, curso.getHorasLectivas());
      ps.execute();
      return true;
      
    } catch (SQLException e){
      System.err.println(e);
      return false;
      
    } finally {
      try {
        con.close();
      } catch (SQLException e){
        System.err.println(e);
      }
    }
  }
    
    public boolean eliminar(Curso curso){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "DELETE FROM curso WHERE id_curso=?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, curso.getIdCurso());
      ps.execute();
      return true;
      
    } catch (SQLException e){
      System.err.println(e);
      return false;
      
    } finally {
      try {
        con.close();
      } catch (SQLException e){
        System.err.println(e);
      }
    }
  }
}

    
    

