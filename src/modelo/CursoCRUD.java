package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static modelo.EscuelaCRUD.ESCUELAOBJ;
import vista.RegistroCurso;

/**
 *
 * @author María Laura
 */
public class CursoCRUD  extends Conexion{
    
   
    public static ArrayList<Curso> cursosObj = new ArrayList<Curso>();
    
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
    
    
    public boolean registrarCorrequisito(Curso Correquisito){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL asignar_correquisito(?,?)";
    try{
        
      System.out.println("Obtengo estos valores de Correquisito:" + Correquisito.getIdCurso() );  
      System.out.println("Obtengo estos valores de Correquisito:" + Correquisito.getAuxRrequisitos() );  
        
      ps = con.prepareStatement(sql);
      ps.setString(1, Correquisito.getIdCurso());
      ps.setString(2, Correquisito.getAuxCorrequisitos());
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
    
   
    public boolean registrarRequisito(Curso requisito){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    
    String sql = "CALL asignar_requisito(?,?)";
    
    try{
        
        System.out.println("Obtengo estos valores de requisito:" + requisito.getIdCurso() );  
        System.out.println("Obtengo estos valores de requisito:" + requisito.getAuxRrequisitos() );
        
      ps = con.prepareStatement(sql);
      ps.setString(1, requisito.getIdCurso());
      ps.setString(2, requisito.getAuxRrequisitos());
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
    
    int x=0;
    
    String sql = "SELECT * FROM curso";
    
    try{
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      
      while(rs.next()){ 
          
        Curso contenedor = new Curso(rs.getString("id_curso"));  
          
        curso.setCreditos(rs.getString("creditos"));
        curso.setHorasLectivas(rs.getString("nombre_curso"));
        curso.setIdCurso(rs.getString("id_curso"));
        curso.setNombreCurso(rs.getString("horas_lectivas"));
        codigos.add(curso.getIdCurso());
        
        System.out.println("X");
        System.out.println("X");
        System.out.println("X");
        cursosObj.add(contenedor); 
        System.out.println("Estos son los códigos del array:" +  cursosObj.get(x).getIdCurso());
        x++;
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
   
    
    
   public ArrayList<String> consultarCodigos(String CODIGO){
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    
    Curso curso= new Curso();
    ArrayList<String> codigosCursos = new ArrayList<>();
    
    int x = 0;
    
    String sql = "SELECT * FROM escuela_curso WHERE id_escuela=?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, CODIGO);
      rs = ps.executeQuery();
      
      while(rs.next()){ 
          
      //  Escuela contenedor = new Escuela(rs.getString("nombre_escuela"),rs.getString("id_escuela")); 
        curso.setIdCurso(rs.getString("id_curso"));
        codigosCursos.add(curso.getIdCurso());
  //      System.out.println("Estos son las escuelas del array:" +  ESCUELAOBJ.get(x).getNombre());
          
        x++;  
        
      }
      return codigosCursos;
 
    } catch (SQLException e){
      System.err.println(e);
      return codigosCursos;
      
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

    
    

