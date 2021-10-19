package controlador;

import modelo.Curso;
import modelo.CursoCRUD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import vista.EliminarCurso;
import vista.EliminarReq;

/**
 * Clase que controla la entrada y salida de información de la eliminación de
 * cursos.
 *
 * @author Maria Laura
 * @version 17/10/2021
 */
public class CtrlEliminar implements ActionListener{
  //Atributos de clase
  private Curso curso;
  private CursoCRUD cursoCrud;
  private EliminarCurso eliminar;
  private EliminarReq eliminarReq;

  /**
   * Constructor de la clase.
   * 
   * @param pCurso      objeto con la información de los cursos
   * @param pCursoCrud  objeto con las funciones CRUD de los cursos
   * @param pEliminar   ventana de eliminación de cursos
   * @param eliminarReq ventana de eliminación de requisitos de un curso
   */
  public CtrlEliminar(Curso pCurso, CursoCRUD pCursoCrud, EliminarCurso pEliminar, EliminarReq eliminarReq) {
    this.curso = pCurso;
    this.cursoCrud = pCursoCrud;
    this.eliminar = pEliminar;
    this.eliminarReq = eliminarReq;
    this.eliminar.btnEliminarCurso.addActionListener(this);
    this.eliminarReq.btnCargar.addActionListener(this);
    this.eliminarReq.btnEliminarReq.addActionListener(this);
  }

  /**
   * Inicializa la ventana de consulta de plan de estudios.
   */
  public void iniciar() {
    cargarCodigos1();
    cargarCodigos2();
    eliminar.setTitle("Eliminar curso");
    eliminar.setLocationRelativeTo(null);
  }

  /**
   * Carga la lista de códigos en el combobox de la ventana de eliminación de cursos.
   */
  public ArrayList cargarCodigos1() {
    ArrayList<String> codigos = cursoCrud.consultar();
    for (String codigo : codigos){
      eliminar.cbCurso.addItem(codigo);
    }
    return codigos;
  }

  /**
   * Carga la lista de códigos en el combobox de la ventana de eliminación de requisitos.
   */
  public ArrayList cargarCodigos2() { 
    ArrayList<String> codigos = cursoCrud.consultar();
    for (String codigo : codigos) {
      eliminarReq.cbCurso.addItem(codigo);
    }
    return codigos;
  }

  /**
   * Carga la lista de códigos en el combobox de la ventana de eliminación de curso en un plan de estudios.
   */
  public ArrayList cargarCodigosRe(String pId) { 
    ArrayList<String> cursos = cursoCrud.consultarIdRequisitos(pId);
    for (String curso : cursos){
      eliminarReq.cbReq.addItem(curso);
    }
    return cursos;
  }

  /**
   * Ejecuta las acciones correspondientes a cada botón de la ventana
   * 
   * @param e el evento que ejecuta un botón
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    cargarCodigos1();

    //Botón para eliminar cursos
    if (e.getSource() == eliminar.btnEliminarCurso) {
      curso.setIdCurso((eliminar.cbCurso.getSelectedItem().toString()));

      if (cursoCrud.eliminar(curso)){
        JOptionPane.showMessageDialog(null, "Curso eliminado");
      } else {
        JOptionPane.showMessageDialog(null, "Error al eliminar");
      }
      eliminar.cbCurso.removeAllItems();
      cargarCodigos1();
    }
    
    //Botón para cargar requisitos de un curso
    if (e.getSource() == eliminarReq.btnCargar){
      cargarCodigosRe(eliminarReq.cbCurso.getSelectedItem().toString());
    }
    
    //Botón de eliminar requisitos
    if (e.getSource() == eliminarReq.btnEliminarReq){
      curso.setIdCurso((eliminarReq.cbCurso.getSelectedItem().toString()));
      if (cursoCrud.eliminarRequisito(curso)){
        JOptionPane.showMessageDialog(null, "Requisito eliminado");
        eliminarReq.cbReq.removeAllItems();
      } else {
        JOptionPane.showMessageDialog(null, "Error al eliminar");
      }
    }
  }
}

    