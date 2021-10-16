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
 * @version 09/10/2021
 */
public class EscuelaCRUD extends Conexion {
  //Atributo de clase
  public static ArrayList<Escuela> escuelaObj = new ArrayList<Escuela>();  

  //Método accesor
  public ArrayList<Escuela> getEscuelaObj() {
    return escuelaObj;
  }

  /**
   * Obtiene el id de una escuela específica.
   * 
   * @param pEscuela        lista de escuelas
   * @param pNombreEscuela  nombre de la escuela a buscar
   * @return id del curso consultado
   */
  public String obtenerEscuelaID(ArrayList<Escuela> pEscuela, String pNombreEscuela) {
    String id = null;

    for (int i = 0; i < pEscuela.size(); i++){
      if (pNombreEscuela.equals(pEscuela.get(i).getNombre()) == true){
        id = pEscuela.get(i).getCodigo();
        System.out.println("Encontré el código mae, sería este: " + id);
      } else{
        System.out.println("No se encontró el codigo de la escuela ");
      }
    }
    return id;
  }

  /**
   * Registra una escuela en la base de datos.
   * 
   * @param pEscuela el objeto Escuela a registrar
   * @return Un booleano que indica si la operación concluyó exitosamente.
   */
  public boolean registrar(Escuela pEscuela){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_escuela(?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pEscuela.getCodigo());
      ps.setString(2, pEscuela.getNombre());
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
 
  /**
   * Consulta la información de las escuelas.
   * 
   * @return una lista con la información de todas las escuelas 
   */
  public ArrayList<String> consultar(){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Escuela escuela = new Escuela();
    ArrayList<String> escuelas = new ArrayList<>();
    int x = 0;
    
    String sql = "SELECT * FROM escuela";
    
    try{
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      
      while(rs.next()){ 
        Escuela contenedor = new Escuela(rs.getString("nombre_escuela"),rs.getString("id_escuela"));
        escuela.setCodigo(rs.getString("id_escuela"));
        escuela.setNombre(rs.getString("nombre_escuela"));
        escuelas.add(escuela.getNombre());
        escuelaObj.add(contenedor);
        x++;  
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
