/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sebcor
 */
public class PlanDeEstudioCRUD extends Conexion {
    
  public boolean registrar(PlanDeEstudio plan){
    PreparedStatement ps = null;
    Connection con = getConexion();
    
    String sql = "CALL registrar_plan(?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, plan.getiD());
      ps.setString(2, plan.getEscuelaPropietaria().getNombre());
      ps.setDate(3,java.sql.Date.valueOf(plan.getFechaVigencia()));
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
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public String[] consultarInfoPlan(String pEscuela){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    PlanDeEstudio plan = new PlanDeEstudio();
    String[] infoPlan = new String[1];
    
    String sql = "SELECT id_plan_estudio, fecha_vigencia FROM plan_estudio WHERE escuela_propietaria = ?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1,pEscuela);
      rs = ps.executeQuery();
      
      while(rs.next()){
        plan.setiD(rs.getInt("id_plan_estudio"));
        //LocalDate fechaNueva = rs.getDate("fecha_vigencia").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //plan.setFechaVigencia(fechaNueva);
      }
      
      infoPlan[0] = Integer.toString(plan.getiD());
      //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
      //String formattedString = plan.getFechaVigencia().format(formatter);
      //infoPlan[1] = (formattedString);
      
      return infoPlan;
      
    } catch (SQLException ex) {
      System.err.println(ex);
      return infoPlan;
      
    }finally {
      try {
        con.close();
      } catch (SQLException e){
        System.err.println(e);
      }
    }
  }

  public ArrayList<Object[]> consultarCursosPlan(String pEscuela){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<Object[]> objFilas = new ArrayList<>();
    
    String sql = "CALL consultar_plan(?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, pEscuela);
      rs = ps.executeQuery();
      ResultSetMetaData rsMd = rs.getMetaData();  
      int cantidadColumnas = rsMd.getColumnCount();
      
      while (rs.next()){
        Object[] filas = new Object[cantidadColumnas];
        
        for (int i = 0; i < cantidadColumnas; i++){
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
  
  public boolean asignarcurso(PlanDeEstudio plan){
    PreparedStatement ps = null;
    Connection con = getConexion();

    String sql = "CALL asignar_curso_plan(?,?,?)";

    try{

      ps = con.prepareStatement(sql);
      ps.setString(1,Integer.toString(plan.getiD()));
      ps.setString(2, plan.getCodigoCurso());
      ps.setString(3, plan.getBloques());
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
