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
    
    if (buscarPlanCurso(curso)){
        System.out.println("Error al eliminar");
        return false;
        
    }else{
  
        String sql = "DELETE FROM curso WHERE id_curso=?";
        try{
          ps= con.prepareStatement(sql);
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
    
     public boolean buscarPlanCurso(Curso curso){
    PreparedStatement ps = null;
    Connection con = getConexion();
    ResultSet rs= null;
    
    
    
    String sql = "SELECT * FROM plan_estudio_curso WHERE id_curso=?";  //busca si un curso está relacionada un plan de estudio
    try{
     ps=con.prepareStatement(sql);
     ps.setString(1, curso.getIdCurso());
       
     rs=ps.executeQuery();
     
       if (rs.next()){
           System.out.println("Lo encontró");
           return true;
        }else{
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
     
     
  public ArrayList<String> consultarCursosPlan(String id){ //seleciona los cursos que estén asociados a un plan
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Curso curso = new Curso();
    ArrayList<String> cursos = new ArrayList<>();
    
    String sql = "SELECT * FROM plan_estudio_curso WHERE id_plan_estudio=?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, id);
      rs = ps.executeQuery();
   
      while(rs.next()){ 
        curso.setIdCurso((rs.getString("id_curso")));
        
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
    public ArrayList<String> consultarRequisitos(String id){ //seleciona los cursos que estén asociados a un plan
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    Curso curso = new Curso();
    ArrayList<String> cursos = new ArrayList<>();
    
    String sql = "SELECT * FROM curso_requisito WHERE id_curso=?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, id);
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
    
    public boolean eliminarRequisito(Curso curso){
    PreparedStatement ps = null;
    Connection con = getConexion();
   
  
        String sql = "DELETE FROM curso WHERE id_curso=?";
        try{
          ps= con.prepareStatement(sql);
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

    
    

