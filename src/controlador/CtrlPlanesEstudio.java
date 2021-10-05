/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.PlanDeEstudio;
import modelo.PlanDeEstudioCRUD;
import vista.registrarPlan;
import controlador.CtrlEscuela;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author sebcor
 */
public class CtrlPlanesEstudio implements ActionListener {
  
  CtrlEscuela aux = new CtrlEscuela();  
    
  private PlanDeEstudio plan;
  private PlanDeEstudioCRUD planCrud;
  private registrarPlan regPlan;
  
  
  
  public CtrlPlanesEstudio(PlanDeEstudio pPlanDeEstudio, PlanDeEstudioCRUD pPlanCRUD, registrarPlan pRegPlan){
    this.plan = pPlanDeEstudio;
    this.planCrud = pPlanCRUD;
    this.regPlan = pRegPlan;
    this.regPlan.btnRegistrarPlan.addActionListener(this);
  }
  
  public void iniciar(){
    regPlan.setTitle("Gestor de Planes de Estudio");
    regPlan.setLocationRelativeTo(null);
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
    if (e.getSource() == regPlan.btnRegistrarPlan){
      plan.setiD(regPlan.tfCodigoPlan.getText());
      plan.setEscuelaPropietaria(regPlan.cbEscuelaPlan.getName(), aux.getEscuelas());
      plan.setCodigoCurso(regPlan.cbCodigosCurso.getName());
      Date input = regPlan.DateChooser.getCalendar().getTime();  // Obtener la fecha directa desde JDateChooser
      plan.setFechaVigencia(input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
      
     
      plan.setBloques(regPlan.cbBloques.getName()); // Hay que buscar cómo crear la matriz de bloques, consultar al equipo
      
      
      
      if (planCrud.registrar(plan)){
        JOptionPane.showMessageDialog(null, "Plan Registrado");
        limpiar();
      } else {
        JOptionPane.showMessageDialog(null, "Error al registrar el plan");
        limpiar();
      }
    }
    
    if (e.getSource() == regPlan.btnLimpiarCampos){
      limpiar();
    }
  }
  
  public void limpiar(){
   // regPlan.tfCodigoCursoPlan.setText(null);
    regPlan.tfCodigoPlan.setText(null);
  
  }



}
    
    
    
    
    

