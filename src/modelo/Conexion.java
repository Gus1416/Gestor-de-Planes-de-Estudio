package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que permite la conexión con la base de datos MySQL.
 * 
 * @author Gustavo
 * @version 07/10/2021
 */
public class Conexion {
  //Atributos de clase
  private final String base = "db_gestor_planes_estudio";
  private final String password = "12345";
  private final String user = "root";
  private final String url = "jdbc:mysql://localhost:3306/" + base;
  private  Connection con = null;
  
    /**
     * Genera la conexión con la base de datos.
     * 
     * @return la conexión con la base de datos
     */
    public Connection getConexion(){
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(this.url, this.user, this.password);
      
    }catch(SQLException | ClassNotFoundException e){
      System.err.println(e);
    }
    return con;
  }    
}
