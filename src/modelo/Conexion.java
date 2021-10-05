package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class Conexion {
  private final String base = "db_gestor_planes_estudio";
  private final String password = "1234";
  private final String user = "root";
  private final String url = "jdbc:mysql://localhost:3306/" + base;
  private  Connection con = null;
  
    /**
     *
     * @return
     */
    public Connection getConexion(){
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(this.url, this.user, this.password);
      
    }catch(SQLException e){
      System.err.println(e);
    } catch (ClassNotFoundException ex){
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return con;
  }
  
  
      
}
