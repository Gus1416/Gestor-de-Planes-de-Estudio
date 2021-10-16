package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase que realiza las funciones de base de datos respectivas a los cursos.
 *
 * @author María Laura
 * @version 09/10/2021
 */
public class CursoCRUD extends Conexion {
  //Atributos de clase
  public static ArrayList<Curso> cursosObj = new ArrayList<Curso>();

  /**
   * Registra un curso en la base de datos.
   * 
   * @param curso objeto con la información del curso
   * @return Un booleano que indica si la operación concluyó exitosamente.
   */
  public boolean registrar(Curso curso) {
    PreparedStatement ps = null;
    Connection con = getConexion();

    String sql = "CALL registrar_curso(?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, curso.getEscuela());
      ps.setString(2, curso.getNombreCurso());
      ps.setString(3, curso.getIdCurso());
      ps.setString(4, curso.getCreditos());
      ps.setString(5, curso.getHorasLectivas());
      ps.execute();
      return true;

    } catch (SQLException e){
      System.err.println(e);
      return false;

    } finally {
      try{
        con.close();
      } catch (SQLException e) {
        System.err.println(e);
      }
    }
  }

  /**
   * Registra un correquisito a un curso.
   * 
   * @param pCorrequisito objeto con la información del curso correquisito
   * @return Un booleano que indica si la operación concluyó exitosamente.
   */
  public boolean registrarCorrequisito(Curso pCorrequisito) {
    PreparedStatement ps = null;
    Connection con = getConexion();

    String sql = "CALL asignar_correquisito(?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCorrequisito.getIdCurso());
      ps.setString(2, pCorrequisito.getAuxCorrequisitos());
      ps.execute();
      return true;

    } catch (SQLException e) {
      System.err.println(e);
      return false;

    } finally {
      try {
        con.close();
      } catch (SQLException e) {
        System.err.println(e);
      }
    }
  }

  /**
   * Registra un requisito a un curso.
   * 
   * @param pRequisito un objeto con la información del curso requisito
   * @return Un booleano que indica si la operación concluyó exitosamente.
   */
  public boolean registrarRequisito(Curso pRequisito) {
    PreparedStatement ps = null;
    Connection con = getConexion();

    String sql = "CALL asignar_requisito(?,?)";
    
    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, pRequisito.getIdCurso());
      ps.setString(2, pRequisito.getAuxRrequisitos());
      ps.execute();
      return true;

    } catch (SQLException e) {
      System.err.println(e);
      return false;

    } finally {
      try{
        con.close();
      } catch (SQLException e){
        System.err.println(e);
      }
    }
  }

  /**
   * Consulta la información de todos los cursos.
   * 
   * @return un ArrayList con la información de todos los cursos
   */
  public ArrayList<String> consultar() {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Curso curso = new Curso();
    ArrayList<String> codigos = new ArrayList<>();
    int x = 0;

    String sql = "SELECT * FROM curso";

    try  {
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()){
        Curso contenedor = new Curso(rs.getString("id_curso"));
        curso.setCreditos(rs.getString("creditos"));
        curso.setHorasLectivas(rs.getString("nombre_curso"));
        curso.setIdCurso(rs.getString("id_curso"));
        curso.setNombreCurso(rs.getString("horas_lectivas"));
        codigos.add(curso.getIdCurso());
        cursosObj.add(contenedor);
        x++;
      }
      return codigos;

    } catch (SQLException e) {
      System.err.println(e);
      return codigos;

    } finally{
      try {
        con.close();
      } catch (SQLException e) {
        System.err.println(e);
      }
    }
  }

  /**
   * Consulta los cursos pertenencientes a una escuela específica.
   * 
   * @param pCodigo
   * @return 
   */
  public ArrayList<String> consultarCodigos(String pCodigo) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Curso curso = new Curso();
    ArrayList<String> codigosCursos = new ArrayList<>();
    int x = 0;

    String sql = "SELECT * FROM escuela_curso WHERE id_escuela=?";

    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, pCodigo);
      rs = ps.executeQuery();

      while (rs.next()) {
        curso.setIdCurso(rs.getString("id_curso"));
        codigosCursos.add(curso.getIdCurso());
        x++;
      }
      return codigosCursos;

    } catch (SQLException e){
      System.err.println(e);
      return codigosCursos;

    } finally{
      try {
        con.close();
      } catch (SQLException e) {
        System.err.println(e);
      }
    }
  }

  /**
   * Elimina un curso de la base de datos.
   * 
   * @param pCurso objeto con el curso a eliminar
   * @return Un booleano que indica si la operación concluyó exitosamente.
   */
  public boolean eliminar(Curso pCurso) {
    PreparedStatement ps = null;
    Connection con = getConexion();

    String sql = "DELETE FROM curso WHERE id_curso=?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCurso.getIdCurso());
      ps.execute();
      return true;

    } catch (SQLException e) {
      System.err.println(e);
      return false;

    } finally {
      try{
        con.close();
      } catch (SQLException e){
        System.err.println(e);
      }
    }
  }
}

    
    

