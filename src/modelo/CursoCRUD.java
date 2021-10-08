package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.RegistroCurso;

/**
 *
 * @author María Laura
 */
public class CursoCRUD  extends Conexion{
    private RegistroCurso regCurso;

    public boolean registrar(Curso curso){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_curso(?,?,?,?,?)";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1,curso.getEscuela());
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
    
    public ArrayList<String> consultar(){
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Curso curso = new Curso();
    ArrayList<String> codigos = new ArrayList<>();
    
    String sql = "SELECT * FROM curso";
    
    try{
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      
      while(rs.next()){ 
        curso.setCreditos(rs.getString("creditos"));
        curso.setHorasLectivas(rs.getString("nombre_curso"));
        curso.setIdCurso(rs.getString("id_curso"));
        curso.setNombreCurso(rs.getString("horas_lectivas"));
        codigos.add(curso.getIdCurso());
      }
     
      return codigos;
      
    } catch (SQLException e){
      System.err.println(e);
      return codigos;
      
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

    
    

