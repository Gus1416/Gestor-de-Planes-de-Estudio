package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

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
}
