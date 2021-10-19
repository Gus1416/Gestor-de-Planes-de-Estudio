package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.CursoCRUD;
import modelo.PlanDeEstudio;
import modelo.PlanDeEstudioCRUD;
import vista.EliminarPlanEstudio;

/**
 * Clase que controla la entrada y salida de información de la eliminación decurso de un plan.
 *
 * @author Maria Laura
 * @version 17/10/2021
 */
public class CtrlEliminarPlan implements ActionListener {
  //Atributos de clase
  private PlanDeEstudio plan;
  private Curso curso;
  private PlanDeEstudioCRUD planCrud;
  private EliminarPlanEstudio eliminar;
  private CursoCRUD cursoCrud;

  /**
   * Constructor de la clase.
   * 
   * @param pPlan       objeto que contiene la información de los planes de estudio
   * @param pCrud       objeto con las funciones CRUD de los planes de estudio
   * @param pEliminar   ventana de eliminación de cursos
   * @param pCursoCrud  objeto con las funciones CRUD de los cursos
   * @param pCurso      objeto con la información de los cursos
   */
  public CtrlEliminarPlan(PlanDeEstudio pPlan, PlanDeEstudioCRUD pCrud, EliminarPlanEstudio pEliminar,
          CursoCRUD pCursoCrud, Curso pCurso) {
    this.plan = pPlan;
    this.planCrud = pCrud;
    this.eliminar = pEliminar;
    this.cursoCrud = pCursoCrud;
    this.curso = pCurso;
    this.eliminar.btnEliminarCursoPlan.addActionListener(this);
    this.eliminar.btnCargar.addActionListener(this);
  }

  /**
   * Inicializa la ventana de consulta de plan de estudios.
   */
  public void iniciar() {
    cargarCodigos();
    eliminar.setTitle("Eliminar plan de estudios");
    eliminar.setLocationRelativeTo(null);
  }

  /**
   * Carga la lista de códigos en el combobox de la ventana.
   */
  public ArrayList cargarCodigos() {
    ArrayList<String> codigos = planCrud.consultar();
    for (String codigo : codigos) {
      eliminar.cbPlan.addItem(codigo);
    }
    return codigos;
  }

  /**
   * Carga la lista de códigos de los cursos en el combobox de la ventana.
   */
  public ArrayList cargarCodigosCurso(String pId) { 
    ArrayList<String> cursos = cursoCrud.consultarCursosPlan(pId);
    for (String curso : cursos){
      eliminar.cbCurso.addItem(curso);
    }
    return cursos;
  }

  /**
   * Ejecuta las acciones correspondientes a cada botón de la ventana
   * 
   * @param e el evento que ejecuta un botón
   */
  public void actionPerformed(ActionEvent e) {
    cargarCodigos();
    //Botón de eliminar curso de plan
    if (e.getSource() == eliminar.btnEliminarCursoPlan){
      curso.setIdCurso((eliminar.cbCurso.getSelectedItem().toString()));
      if (planCrud.eliminarCurso(curso)){
        JOptionPane.showMessageDialog(null, "Curso eliminado");
      } else{
        JOptionPane.showMessageDialog(null, "Error al eliminar");
      }
      cargarCodigos();
      eliminar.cbCurso.removeAllItems();
    }
    if (e.getSource() == eliminar.btnCargar){
      cargarCodigosCurso(eliminar.cbPlan.getSelectedItem().toString());
    }
  }
}

    


