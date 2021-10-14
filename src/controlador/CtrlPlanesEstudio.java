package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.PlanDeEstudio;
import modelo.PlanDeEstudioCRUD;
import vista.registrarPlan;
import java.util.ArrayList;
import modelo.EscuelaCRUD;
import modelo.CursoCRUD;

/**
 *
 * @author sebcor
 */
public class CtrlPlanesEstudio implements ActionListener {   
  private  PlanDeEstudio plan;
  private final PlanDeEstudioCRUD planCrud;
  private final registrarPlan regPlan;
  private EscuelaCRUD consultarEscuelas;
  private CursoCRUD consultarCursos;
  
  public static ArrayList<PlanDeEstudio> planes = new ArrayList<>();
   
  
  public CtrlPlanesEstudio(PlanDeEstudio pPlanDeEstudio, PlanDeEstudioCRUD pPlanCRUD, registrarPlan pRegPlan, EscuelaCRUD pEscuelaCRUD, CursoCRUD pCursoCRUD ){
    this.plan = pPlanDeEstudio;
    this.planCrud = pPlanCRUD;
    this.regPlan = pRegPlan;
    this.regPlan.btnRegistrarPlan.addActionListener(this);
    this.regPlan.btnLimpiarCampos.addActionListener(this);
    this.regPlan.btnLoad.addActionListener(this);
    this.regPlan.btnAsignarCurso.addActionListener(this);
    this.regPlan.btnVolver.addActionListener(this);
    this.consultarEscuelas= pEscuelaCRUD;
    this.consultarCursos= pCursoCRUD;       
  }
  
  public void iniciar(){
    cargarEscuelas();
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
      plan.setiD(Integer.valueOf(regPlan.tfPlanCode.getText()));
      plan.setEscuelaPropietaria(regPlan.cbEscuelaPlan.getSelectedItem().toString(),EscuelaCRUD.ESCUELAOBJ);
      plan.setFechaVigencia(regPlan.DateChooser.getCalendar().getTime());
      
      if (planCrud.registrar(plan)){ 
        JOptionPane.showMessageDialog(null, "Plan Registrado");
        limpiarPlan();
      } else {
        JOptionPane.showMessageDialog(null, "Error al registrar el plan");
        limpiarPlan();
      }
    }
    
    if (e.getSource() == regPlan.btnAsignarCurso){       
      for(int i=0 ; i< planes.size(); i++){        
        if(regPlan.tfPlanCode.equals(planes.get(i).getiD()) == true){           
          plan= planes.get(i);  // Validar que el plan se encuentra registrado;        
        }    
      }
      
      plan.setCodigoCurso(regPlan.cbCodigosCurso.getSelectedItem().toString());  
      plan.setBloques(regPlan.cbBloques.getSelectedItem().toString());
      
      if (planCrud.asignarcurso(plan)){
        JOptionPane.showMessageDialog(null, "Curso Asignado"); 
        limpiarPlan();
      } else {
        JOptionPane.showMessageDialog(null, "Error al registrar el plan");
        limpiarPlan();
      } 
    }
    
    if (e.getSource() == regPlan.btnLoad){   
      regPlan.cbCodigosCurso.removeAllItems();
      String codigo = consultarEscuelas.obtenerEscuelaID(EscuelaCRUD.ESCUELAOBJ,regPlan.cbEscuelaPlan.getSelectedItem().toString());      
      System.out.println("Mae este es el codigo que mellega de su metodo:" + codigo);
      ArrayList<String> codigos = consultarCursos.consultarCodigos(codigo);    
      for (String code : codigos){       
        regPlan.cbCodigosCurso.addItem(code);         
      } 
    }
    
    if (e.getSource() == regPlan.btnLimpiarCampos){
      limpiarPlan();  
    }
    
    if (e.getSource() == regPlan.btnVolver){         
      regPlan.setVisible(false);      
    }   
  }
  
  public void limpiarPlan(){
   // regPlan.tfCodigoCursoPlan.setText(null);
   //   regPlan.tfPlanCode.setText(null);
  }
}
    
    
    
    
    

