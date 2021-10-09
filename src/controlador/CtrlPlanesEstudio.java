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
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import modelo.EscuelaCRUD;
import modelo.CursoCRUD;
import modelo.Escuela;

/**
 *
 * @author sebcor
 */
public class CtrlPlanesEstudio implements ActionListener {   
  private final PlanDeEstudio plan;
  private final PlanDeEstudioCRUD planCrud;
  private final registrarPlan regPlan;
  private EscuelaCRUD consultarEscuelas;
  private CursoCRUD consultarCursos;
   
  
  public CtrlPlanesEstudio(PlanDeEstudio pPlanDeEstudio, PlanDeEstudioCRUD pPlanCRUD, registrarPlan pRegPlan, EscuelaCRUD pEscuelaCRUD, CursoCRUD pCursoCRUD ){
    this.plan = pPlanDeEstudio;
    this.planCrud = pPlanCRUD;
    this.regPlan = pRegPlan;
    this.regPlan.btnRegistrarPlan.addActionListener(this);
    this.regPlan.btnLimpiarCampos.addActionListener(this);
    this.consultarEscuelas= pEscuelaCRUD;
    this.consultarCursos= pCursoCRUD;       
  }
  
  public void iniciar(){
    cargarEscuelas();
    cargarCodigos();
    regPlan.setTitle("Gestor de Planes de Estudio");  
    regPlan.setLocationRelativeTo(null);
  }
  
  public ArrayList cargarEscuelas(){
    ArrayList<String> escuelas = consultarEscuelas.consultar();
    for (String escuela : escuelas){
      regPlan.cbEscuelaPlan.addItem(escuela);
    }
    return escuelas;
  }
  
  public ArrayList cargarCodigos(){
    ArrayList<String> codigos = consultarCursos.consultar();
    for (String codigo : codigos){
      regPlan.cbCodigosCurso.addItem(codigo);
    }
    return codigos;
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
    if (e.getSource() == regPlan.btnRegistrarPlan){
            
     // System.out.println("Se supone que esto me tiene que traer la lista: " + CtrlEscuela.escuelas.get(0).getNombre());
     // System.out.println("Codigo de curso asociado al plan: " + regPlan.cbCodigosCurso.getSelectedItem().toString() );  

      plan.setiD(Integer.valueOf(regPlan.tfPlanCode.getText()));
      plan.setEscuelaPropietaria(regPlan.cbEscuelaPlan.getSelectedItem().toString(),EscuelaCRUD.ESCUELAOBJ);
      plan.setCodigoCurso(regPlan.cbCodigosCurso.getSelectedItem().toString());
      Date input = regPlan.DateChooser.getCalendar().getTime();  // Obtener la fecha directa desde JDateChooser
      plan.setFechaVigencia(input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
      plan.setBloques(regPlan.cbBloques.getSelectedItem().toString());

      if (planCrud.registrar(plan)){
        JOptionPane.showMessageDialog(null, "Plan Registrado");
        limpiarPlan();
      } else {
        JOptionPane.showMessageDialog(null, "Error al registrar el plan");
        limpiarPlan();
      }
    }
    
    if (e.getSource() == regPlan.btnLimpiarCampos){
      limpiarPlan();  
    }
  }
  
  public void limpiarPlan(){
   // regPlan.tfCodigoCursoPlan.setText(null);
   //   regPlan.tfPlanCode.setText(null);
  }
}
    
    
    
    
    

