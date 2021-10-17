package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Curso;
import modelo.CursoCRUD;
import modelo.Escuela;
import modelo.EscuelaCRUD;
import modelo.PlanDeEstudio;
import modelo.PlanDeEstudioCRUD;
import vista.Menu;
import vista.RegistrarEscuela;
import vista.RegistroCurso;
import vista.registrarPlan;
import vista.EliminarCurso;
import vista.EliminarPlanEstudio;
import vista.EliminarReq;

/**
 *
 * @author Gustavo
 */
public class CtrlMenu implements ActionListener {
  private Menu menu;
  
  public CtrlMenu(Menu pMenu){
    this.menu = pMenu;
    this.menu.btnRegistrarEscuela.addActionListener(this);
    this.menu.btnRegistrarCurso.addActionListener(this);
    this.menu.btnRegistrarPlan.addActionListener(this);
    this.menu.btnEliminarCurso.addActionListener(this);
    this.menu.btnEliminarPlan1.addActionListener(this);
    this.menu.btnEliminarReq.addActionListener(this);
  }
  
  public void iniciar(){
    menu.setTitle("Gestor de Planes de Estudio");
    menu.setLocationRelativeTo(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == menu.btnRegistrarEscuela){
      Escuela escuela = new Escuela();
      EscuelaCRUD escuelaCrud = new EscuelaCRUD();
      RegistrarEscuela regEscuela = new RegistrarEscuela();
        
      CtrlEscuela ctrlEscuela = new CtrlEscuela(escuela, escuelaCrud, regEscuela);
      ctrlEscuela.iniciar();
      regEscuela.setVisible(true);
    }
    
    if (e.getSource() == menu.btnRegistrarCurso){
      Curso curso = new Curso();
      CursoCRUD cursoCrud = new CursoCRUD();
      EscuelaCRUD escuelaCrud = new EscuelaCRUD();
      RegistroCurso regCurso = new RegistroCurso();
      
      CtrlCurso ctrlCurso = new CtrlCurso(curso, cursoCrud, regCurso, escuelaCrud);
      ctrlCurso.iniciar();
      regCurso.setVisible(true);
    }
    
    if (e.getSource() == menu.btnRegistrarPlan){
      PlanDeEstudio plan = new PlanDeEstudio();
      PlanDeEstudioCRUD planCrud= new PlanDeEstudioCRUD();
      registrarPlan regPlan = new registrarPlan();
      EscuelaCRUD consultarEscuelas = new EscuelaCRUD();
      CursoCRUD consultarCursos = new CursoCRUD();
        
      CtrlPlanesEstudio ctrlPlan= new CtrlPlanesEstudio(plan,planCrud,regPlan,consultarEscuelas,consultarCursos);
      ctrlPlan.iniciar();
      regPlan.setVisible(true);
    }
    if (e.getSource() == menu.btnEliminarCurso){
      Curso curso = new Curso();
      CursoCRUD consultarCursos = new CursoCRUD();
      EliminarReq eliminarReq= new EliminarReq();
      
      EliminarCurso eliminar = new EliminarCurso();
      CtrlEliminar ctrlEliminar= new CtrlEliminar(curso, consultarCursos, eliminar, eliminarReq);
      ctrlEliminar.iniciar();
  
      eliminar.setVisible(true);
    }
  
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
