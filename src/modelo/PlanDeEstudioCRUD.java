/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    
     
}
