package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase para las operaciones CRUD de la escuela en la base de datos
 * 
 * @author Gustavo
 * @version 30/09/2021
 */
public class EscuelaCRUD extends Conexion {
  
  /**
   * Método para registrar la escuela
   * @param escuela objeto de tipo Escuela
   * @return true si se realiza la operación, false en caso contrario
   */
  public boolean registrar(Escuela escuela){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_escuela(?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, escuela.getCodigo());
      ps.setString(2, escuela.getNombre());
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
 
  public ArrayList<String> consultar(){
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Escuela escuela = new Escuela();
    ArrayList<String> escuelas = new ArrayList<>();
    
    String sql = "SELECT * FROM escuela";
    
    try{
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      
      while(rs.next()){ 
        escuela.setCodigo(rs.getString("id_escuela"));
        escuela.setNombre(rs.getString("nombre_escuela"));
        escuelas.add(escuela.getNombre());
      }
     
      return escuelas;
      
    } catch (SQLException e){
      System.err.println(e);
      return escuelas;
      
    } finally {
      try {
        con.close();
      } catch (SQLException e){
        System.err.println(e);
      }
    }
  }
  
}
