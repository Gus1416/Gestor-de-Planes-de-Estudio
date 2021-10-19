package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
   * Registra un pCurso en la base de datos.
   * 
   * @param pCurso objeto con la información del pCurso
   * @return Un booleano que indica si la operación concluyó exitosamente.
   */
  public boolean registrar(Curso pCurso) {
    PreparedStatement ps = null;
    Connection con = getConexion();

    String sql = "CALL registrar_curso(?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCurso.getEscuela());
      ps.setString(2, pCurso.getNombreCurso());
      ps.setString(3, pCurso.getIdCurso());
      ps.setString(4, pCurso.getCreditos());
      ps.setString(5, pCurso.getHorasLectivas());
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
   * Elimina un pCurso específico de la base de datos.
   * 
   * @param pCurso el objeto curso que a eliminar
   * @return Un booleano que indica si la operación se realizó exitosamente.
   */
  public boolean eliminar(Curso pCurso) {
    PreparedStatement ps = null;
    Connection con = getConexion();

    if (buscarPlanCurso(pCurso)){
      return false;

    } else {
      String sql = "DELETE FROM curso WHERE id_curso=?";
      
      try {
        ps = con.prepareStatement(sql);
        ps.setString(1, pCurso.getIdCurso());
        ps.execute();
        return true;

      } catch (SQLException e){
        System.err.println(e);
        return false;

      } finally{
        try{
          con.close();
        } catch (SQLException e){
          System.err.println(e);
        }
      }
    }
  }
    
  /**
   * Busca un plan relacionado con el curso consultado.
   * 
   * @param pCurso curso perteneciente al plan de estudios
   * @return Un booleano que indica si la operación se realizó exitosamente.
   */
  public boolean buscarPlanCurso(Curso pCurso) {
    PreparedStatement ps = null;
    Connection con = getConexion();
    ResultSet rs = null;

    String sql = "SELECT * FROM plan_estudio_curso WHERE id_curso=?";  //busca si un pCurso está relacionada un plan de estudio
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCurso.getIdCurso());

      rs = ps.executeQuery();

      if (rs.next())
      {
        System.out.println("Lo encontró");
        return true;
      } else
      {
        System.out.println("Se puede eliminar porque no está asociado con plan de estudios");
        return false;
      }

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
   * Consulta los cursos de un plan de estudios específico.
   * 
   * @param pId identificador del plan de estudios consultado
   * @return una lista con los cursos del plan de estudios
   */
  public ArrayList<String> consultarCursosPlan(String pId) { 
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Curso curso = new Curso();
    ArrayList<String> cursos = new ArrayList<>();

    String sql = "SELECT * FROM plan_estudio_curso WHERE id_plan_estudio=?";

    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, pId);
      rs = ps.executeQuery();

      while (rs.next()) {
        curso.setIdCurso((rs.getString("id_curso")));
        cursos.add(curso.getIdCurso());
      }
      return cursos;

    } catch (SQLException e) {
      System.err.println(e);
      return cursos;

    } finally {
      try {
        con.close();
      } catch (SQLException e){
        System.err.println(e);
      }
    }
  }

  /**
   * Consulta los requisitos de un curso específico.
   * 
   * @param pCurso  curso consultado
   * @return una lista con los requisitos del curso
   */
  public ArrayList<Object[]> consultarRequisitos(String pCurso) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();

    String sql = "CALL obtener_requisitos(?)";

    try {
      ps = con.prepareStatement(sql);
      ps.setString(1, pCurso);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();
      int cantidadColumnas = rsMd.getColumnCount();

      while (rs.next()) {
        Object[] filas = new Object[cantidadColumnas];

        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;

    } catch (SQLException ex) {
      System.err.println(ex);
      return objFilas;
    }
  }

  /**
   * Consulta los correquisitos de un curso específico.
   * 
   * @param pCurso  curso consultado
   * @return una lista con los correquisitos del curso
   */
  public ArrayList<Object[]> consultarCorrequisitos(String pCurso) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();

    String sql = "CALL obtener_correquisitos(?)";

    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCurso);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();
      int cantidadColumnas = rsMd.getColumnCount();

      while (rs.next()) {
        Object[] filas = new Object[cantidadColumnas];

        for (int i = 0; i < cantidadColumnas; i++) {
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;

    } catch (SQLException ex){
      System.err.println(ex);
      return objFilas;
    }
  }
  
  /**
   * Consulta los identificadores de los requisitos de un curso específico.
   * 
   * @param pId el identificador del curso consultado
   * @return una lista con los identificadores de los requisitos del curso
   */
  public ArrayList<String> consultarIdRequisitos(String pId){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Curso curso = new Curso();
    ArrayList<String> cursos = new ArrayList<>();
    
    String sql = "SELECT * FROM curso_requisito WHERE id_curso=?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pId);
      rs = ps.executeQuery();
   
      while(rs.next()){ 
        curso.setIdCurso((rs.getString("requisito")));
        cursos.add(curso.getIdCurso());
      }
      return cursos;
      
    } catch (SQLException e){
      System.err.println(e);
      return cursos;
      
    } finally {
      try {
        con.close();
      } catch (SQLException e){
        System.err.println(e);
      }
    }
  }

  /**
   * Consulta los planes de estudios en los que se encuentra un curso específico.
   * 
   * @param pCurso el curso consultado
   * @return una lista con los planes a los que pertenece el curso consultado
   */
  public ArrayList<Object[]> consultarPlanes(String pCurso) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();

    String sql = "CALL obtener_plan_estudio(?)";

    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCurso);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();
      int cantidadColumnas = rsMd.getColumnCount();

      while (rs.next()) {
        Object[] filas = new Object[cantidadColumnas];

        for (int i = 0; i < cantidadColumnas; i++){
          filas[i] = rs.getObject(i + 1);
        }
        objFilas.add(filas);
      }
      return objFilas;

    } catch (SQLException ex) {
      System.err.println(ex);
      return objFilas;
    }
  }
  
  /**
   * Elimina el requisito de un pCurso específico.
   * 
   * @param pCurso El curso al que se le elimina el requisito.
   * @return Un booleano que indica si la operación se realizó con éxito.
   */
  public boolean eliminarRequisito(Curso pCurso) {
    PreparedStatement ps = null;
    Connection con = getConexion();

    String sql = "DELETE FROM curso WHERE id_curso=?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pCurso.getIdCurso());
      ps.execute();
      return true;

    } catch (SQLException e){
      System.err.println(e);
      return false;

    } finally{
      try{
        con.close();
      } catch (SQLException e)
      {
        System.err.println(e);
      }
    }
  }
}
    
    

