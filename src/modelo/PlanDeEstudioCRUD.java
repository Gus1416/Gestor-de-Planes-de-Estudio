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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import static modelo.EscuelaCRUD.ESCUELAOBJ;

/**
 *
 * @author sebcor
 */
public class PlanDeEstudioCRUD extends Conexion {
    
   
  public boolean registrar(PlanDeEstudio plan){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_plan(?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, plan.getiD());
      ps.setString(2, plan.getEscuelaPropietaria().getNombre());
      ps.setDate(3,java.sql.Date.valueOf(plan.getFechaVigencia()));
      ps.setString(4,plan.getBloques());
      ps.setString(5,plan.getCodigoCurso());
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
    PlanDeEstudio plan = new PlanDeEstudio();
    ArrayList<String> planes = new ArrayList<>();
    
    
    String sql = "SELECT * FROM plan_estudio";
     
    try{
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
        
      while(rs.next()){ 
     
      plan.setiD(Integer.parseInt((rs.getString("id_plan_estudio"))));
   
      planes.add(Integer.toString((plan.getiD())));
    

      }
      return planes;
      
      
    }catch (SQLException e){
      System.err.println(e);
      return planes;
      
    } finally {
      try {
        con.close();
      } catch (SQLException e){
        System.err.println(e);
      }
    }
  }
    public boolean eliminarCurso(Curso curso){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "DELETE FROM plan_estudio_curso WHERE id_curso=?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1,curso.getIdCurso());
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
  
    
  

  

    
     

