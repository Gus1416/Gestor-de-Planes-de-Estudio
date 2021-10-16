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
 * Clase que controla la entrada y salida de información correspondiente a los planes de estudio.
 * 
 * @author Sebastián
 * @version 13/10/2021
 */
public class CtrlPlanesEstudio implements ActionListener {   
  //Atributos de clase
  private  PlanDeEstudio plan;
  private final PlanDeEstudioCRUD planCrud;
  private final registrarPlan regPlan;
  private EscuelaCRUD consultarEscuelas;
  private CursoCRUD consultarCursos;
  public static ArrayList<PlanDeEstudio> planes = new ArrayList<>();
   
  /**
   * Constructor de la clase.
   * 
   * @param pPlanDeEstudio  objeto que contiene la información de los planes de estudio
   * @param pPlanCRUD       objeto con las funciones CRUD de los planes de estudio
   * @param pRegPlan        ventana de registro de planes de estudio
   * @param pEscuelaCRUD    objeto con las funciones CRUD de las escuelas
   * @param pCursoCRUD      objeto con las funciones CRUD de los cursos
   */
  public CtrlPlanesEstudio(PlanDeEstudio pPlanDeEstudio, PlanDeEstudioCRUD pPlanCRUD, registrarPlan pRegPlan, 
          EscuelaCRUD pEscuelaCRUD, CursoCRUD pCursoCRUD ){
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
  
  /**
   * Incializa la ventana de registro de planes de estudio.
   */
  public void iniciar(){
    cargarEscuelas();
    regPlan.setTitle("Gestor de Planes de Estudio");  
    regPlan.setLocationRelativeTo(null);
  }
  
  /**
   * Carga la lista de escuelas en el combobox de la ventana.
   */
  public ArrayList cargarEscuelas(){
    ArrayList<String> escuelas = consultarEscuelas.consultar();
    for (String escuela : escuelas){
      regPlan.cbEscuelaPlan.addItem(escuela);
    }
    return escuelas;
  }
  
  /**
   * Carga la lista de codigos de cursos en el combobox de la ventana.
   */
  public ArrayList cargarCodigos(){
    ArrayList<String> codigos = consultarCursos.consultar();
    for (String codigo : codigos){
      regPlan.cbCodigosCurso.addItem(codigo);
    }
    return codigos;
  }
  
  /**
   * Ejecuta las funciones correspondientes a cada botón.
   * 
   * @param e el evento que realiza un botón
   */
  @Override
  public void actionPerformed(ActionEvent e){
    //Botón de regisrar plan
    if (e.getSource() == regPlan.btnRegistrarPlan){
      plan.setiD(Integer.valueOf(regPlan.tfPlanCode.getText()));
      plan.setEscuelaPropietaria(regPlan.cbEscuelaPlan.getSelectedItem().toString(),EscuelaCRUD.escuelaObj);
      plan.setFechaVigencia(regPlan.DateChooser.getCalendar().getTime());
      
      //Registra el plan
      if (planCrud.registrar(plan)){ 
        JOptionPane.showMessageDialog(null, "Plan Registrado");
        limpiarPlan();
      } else {
        JOptionPane.showMessageDialog(null, "Error al registrar el plan");
        limpiarPlan();
      }
    }
    
    //Asigna cursos al plan
    if (e.getSource() == regPlan.btnAsignarCurso){       
      for(int i=0 ; i< planes.size(); i++){        
        if(regPlan.tfPlanCode.equals(planes.get(i).getiD()) == true){           
          plan= planes.get(i);  // Validar que el plan se encuentra registrado;        
        }    
      }
      
      plan.setCodigoCurso(regPlan.cbCodigosCurso.getSelectedItem().toString());  
      plan.setBloques(regPlan.cbBloques.getSelectedItem().toString());
      
      //Registra el curso en el plan de estudios
      if (planCrud.asignarcurso(plan)){
        JOptionPane.showMessageDialog(null, "Curso Asignado"); 
        limpiarPlan();
      } else {
        JOptionPane.showMessageDialog(null, "Error al registrar el plan");
        limpiarPlan();
      } 
    }
    
    //Carga la lista de cursos
    if (e.getSource() == regPlan.btnLoad){   
      regPlan.cbCodigosCurso.removeAllItems();
      String codigo = consultarEscuelas.obtenerEscuelaID(EscuelaCRUD.escuelaObj,regPlan.cbEscuelaPlan.getSelectedItem().toString());      
      System.out.println("Mae este es el codigo que mellega de su metodo:" + codigo);
      ArrayList<String> codigos = consultarCursos.consultarCodigos(codigo);    
      for (String code : codigos){       
        regPlan.cbCodigosCurso.addItem(code);         
      } 
    }
    
    //Limpia los campos de texto
    if (e.getSource() == regPlan.btnLimpiarCampos){
      limpiarPlan();  
    }
    
    if (e.getSource() == regPlan.btnVolver){         
      regPlan.setVisible(false);      
    }   
  }
  
  /**
   * Limpia los campos de texto
   */
  public void limpiarPlan(){
   // regPlan.tfCodigoCursoPlan.setText(null);
   //   regPlan.tfPlanCode.setText(null);
  }
}
    
    
    
    
    

