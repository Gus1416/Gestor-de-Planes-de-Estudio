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
import vista.registrarRequisitos;

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
    this.menu.btnRegistrarRequisitos.addActionListener(this);
    this.menu.btnRegistrarPlan1.addActionListener(this);
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
      
      CtrlCurso ctrlCurso = new CtrlCurso(curso, cursoCrud, regCurso,escuelaCrud);
      ctrlCurso.iniciar();
      regCurso.setVisible(true);
    }
    
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
    
    
    if (e.getSource() == menu.btnRegistrarRequisitos){
      Curso curso = new Curso();
      CursoCRUD cursoCrud = new CursoCRUD();
      EscuelaCRUD escuelaCrud = new EscuelaCRUD();
      RegistroCurso regCurso = new RegistroCurso();
      registrarRequisitos regRequisitos = new registrarRequisitos();
      
      CtrlRequisitos ctrlRequisitos = new CtrlRequisitos(curso, cursoCrud, regRequisitos,escuelaCrud);
      ctrlRequisitos.iniciar();
      regRequisitos.setVisible(true);
    }
    
    
    
    
    
    
    
    }
  
}
