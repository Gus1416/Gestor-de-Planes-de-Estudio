package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Curso;
import modelo.CursoCRUD;
import modelo.Escuela;
import modelo.EscuelaCRUD;
import modelo.PlanDeEstudio;
import modelo.PlanDeEstudioCRUD;
import vista.ConsultarCurso;
import vista.Menu;
import vista.RegistrarEscuela;
import vista.RegistroCurso;
import vista.registrarPlan;
import vista.ConsultarPlan;
import vista.registrarRequisitos;

/**
 * Clase que controla las acciones que se realizan en el menú principal.
 * 
 * @author Gustavo, María Laura, Sebastían
 * @version 09/10/2021
 */
public class CtrlMenu implements ActionListener {
  //Atributo de clase
  private Menu menu;
  
  /**
   * Constructor de la clase
   * 
   * @param pMenu ventana de menú principal
   */
  public CtrlMenu(Menu pMenu){
    this.menu = pMenu;
    this.menu.btnRegistrarEscuela.addActionListener(this);
    this.menu.btnRegistrarCurso.addActionListener(this);
    this.menu.btnRegistrarPlan1.addActionListener(this);
    this.menu.btnConsultarPlan.addActionListener(this);
    this.menu.btnRegistrarRequisitos.addActionListener(this);
    this.menu.btnConsultarCursos.addActionListener(this);
  }
  
  /**
   * Inicializa la ventana del menú principal.
   */
  public void iniciar(){
    menu.setTitle("Gestor de Planes de Estudio");
    menu.setLocationRelativeTo(null);
  }

  /**
   * Ejecuta las funciones correspondientes a cada botón.
   * 
   * @param e el evento que realiza un botón
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    //Botón de ventana para registrar escuelas
    if (e.getSource() == menu.btnRegistrarEscuela){
      Escuela escuela = new Escuela();
      EscuelaCRUD escuelaCrud = new EscuelaCRUD();
      RegistrarEscuela regEscuela = new RegistrarEscuela();
        
      CtrlEscuela ctrlEscuela = new CtrlEscuela(escuela, escuelaCrud, regEscuela);
      ctrlEscuela.iniciar();
      regEscuela.setVisible(true);
    }
    
    //Botón de ventana para registrar cursos
    if (e.getSource() == menu.btnRegistrarCurso){
      Curso curso = new Curso();
      CursoCRUD cursoCrud = new CursoCRUD();
      EscuelaCRUD escuelaCrud = new EscuelaCRUD();
      RegistroCurso regCurso = new RegistroCurso();
      
      CtrlCurso ctrlCurso = new CtrlCurso(curso, cursoCrud, regCurso,escuelaCrud);
      ctrlCurso.iniciar();
      regCurso.setVisible(true);
    }
    
    //Botón de ventana para registrar plan
    if (e.getSource() == menu.btnRegistrarPlan1){
      PlanDeEstudio plan = new PlanDeEstudio();
      PlanDeEstudioCRUD planCrud= new PlanDeEstudioCRUD();
      registrarPlan regPlan = new registrarPlan();
      EscuelaCRUD consultarEscuelas = new EscuelaCRUD();
      CursoCRUD consultarCursos = new CursoCRUD();
        
      CtrlPlanesEstudio ctrlPlan= new CtrlPlanesEstudio(plan,planCrud,regPlan,consultarEscuelas,consultarCursos);
      ctrlPlan.iniciar();
      regPlan.setVisible(true);
    }
    
    //Botón de ventana para consultar planes de estudio
    if (e.getSource() == menu.btnConsultarPlan){
      PlanDeEstudioCRUD planCrud = new PlanDeEstudioCRUD();
      EscuelaCRUD escuelaCrud = new EscuelaCRUD();
      ConsultarPlan consultaPlan = new ConsultarPlan();
      
      CtrlConsultaPlanes ctrlConsultaPlanes = new CtrlConsultaPlanes(planCrud, escuelaCrud, consultaPlan);
      ctrlConsultaPlanes.iniciar();
      consultaPlan.setVisible(true);
    }
  
    //Botón de ventana para registrar requisitos de un curso
    if (e.getSource() == menu.btnRegistrarRequisitos){
      Curso curso = new Curso();
      CursoCRUD cursoCrud = new CursoCRUD();
      EscuelaCRUD escuelaCrud = new EscuelaCRUD();
      registrarRequisitos regRequisitos = new registrarRequisitos();
      
      CtrlRequisitos ctrlRequisitos = new CtrlRequisitos(curso, cursoCrud, regRequisitos,escuelaCrud);
      ctrlRequisitos.iniciar();
      regRequisitos.setVisible(true);
    }
  
  if (e.getSource() == menu.btnConsultarCursos){
      PlanDeEstudioCRUD plan = new PlanDeEstudioCRUD();
      EscuelaCRUD escuela = new EscuelaCRUD();
      CursoCRUD   curso = new CursoCRUD();
      ConsultarCurso consulta = new  ConsultarCurso();

                      
      CtrlConsultaCurso ctrlconsultaCursos = new CtrlConsultaCurso(plan,escuela,curso,consulta);
      ctrlconsultaCursos.iniciar();
      consulta.setVisible(true);
    }
  }
  
  
  
  
  
  
  
  
  
  
}
