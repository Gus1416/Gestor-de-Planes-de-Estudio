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
import vista.RegistrarPlan;
import vista.ConsultarPlan;
import vista.RegistrarRequisitos;
import vista.EliminarCurso;
import vista.EliminarPlanEstudio;
import vista.EliminarReq;

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
    this.menu.btnEliminarCurso.addActionListener(this);
    this.menu.btnEliminarPlan1.addActionListener(this);
    this.menu.btnEliminarReq.addActionListener(this);
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
      RegistrarPlan regPlan = new RegistrarPlan();
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
      RegistrarRequisitos regRequisitos = new RegistrarRequisitos();
      
      CtrlRequisitos ctrlRequisitos = new CtrlRequisitos(curso, cursoCrud, regRequisitos,escuelaCrud);
      ctrlRequisitos.iniciar();
      regRequisitos.setVisible(true);
    }
  
    //Botón de ventana para consultar cursos
    if (e.getSource() == menu.btnConsultarCursos){
      PlanDeEstudioCRUD plan = new PlanDeEstudioCRUD();
      EscuelaCRUD escuela = new EscuelaCRUD();
      CursoCRUD   curso = new CursoCRUD();
      ConsultarCurso consulta = new  ConsultarCurso();

                      
      CtrlConsultaCurso ctrlconsultaCursos = new CtrlConsultaCurso(plan,escuela,curso,consulta);
      ctrlconsultaCursos.iniciar();
      consulta.setVisible(true);
    }
  
    //Botón para ventana de eliminar cursos
    if (e.getSource() == menu.btnEliminarCurso){
      Curso curso = new Curso();
      CursoCRUD consultarCursos = new CursoCRUD();
      EliminarReq eliminarReq= new EliminarReq();
      
      EliminarCurso eliminar = new EliminarCurso();
      CtrlEliminar ctrlEliminar= new CtrlEliminar(curso, consultarCursos, eliminar, eliminarReq);
      ctrlEliminar.iniciar();
  
      eliminar.setVisible(true);
    }

    //Botón para ventana de eliminar un curso de un plan de estudios
    if (e.getSource() == menu.btnEliminarPlan1){
      PlanDeEstudio plan = new PlanDeEstudio();
      PlanDeEstudioCRUD consultarPlan = new PlanDeEstudioCRUD();
      EliminarPlanEstudio eliminar= new EliminarPlanEstudio();
      CursoCRUD consultarCursos = new CursoCRUD();
      Curso curso = new Curso();
     
      CtrlEliminarPlan ctrlEliminar= new CtrlEliminarPlan (plan, consultarPlan, eliminar,consultarCursos,curso);
      ctrlEliminar.iniciar();
  
      eliminar.setVisible(true);
    }
    
    //Botón para ventana de eliminar requisitos
    if (e.getSource() == menu.btnEliminarReq){
      Curso curso = new Curso();
      CursoCRUD consultarCursos = new CursoCRUD();
      EliminarReq eliminarReq= new EliminarReq();
      
      EliminarCurso eliminar = new EliminarCurso();
      CtrlEliminar ctrlEliminar= new CtrlEliminar(curso, consultarCursos, eliminar, eliminarReq);
      ctrlEliminar.iniciar();
  
      eliminarReq.setVisible(true);
    }    
  }
}
