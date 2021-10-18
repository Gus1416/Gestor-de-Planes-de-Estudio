package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.CursoCRUD;
import modelo.EscuelaCRUD;
import vista.RegistroCurso;

/**
 * Clase que controla la entrada y salida de información correspondiente a los cursos.
 * 
 * @author María Laura
 * @version 09/10/2021
 */
public class CtrlCurso implements ActionListener {
  //Atributos de clase
  private Curso curso;
  private CursoCRUD cursoCrud;
  private RegistroCurso regCurso;
  private EscuelaCRUD consultarEscuelas;
  
  /**
   * Constructor de la clase.
   * 
   * @param pCurso        objeto con la información del curso
   * @param pCursoCrud    objeto con las funciones CRUD de los cursos
   * @param pRegCurso     ventana de registro de cursos
   * @param pEscuelaCrud  objetoc con las funciones CRUD de las escuelas
   */
  public CtrlCurso(Curso pCurso, CursoCRUD pCursoCrud, RegistroCurso pRegCurso, EscuelaCRUD pEscuelaCrud){
    this.curso = pCurso;
    this.cursoCrud = pCursoCrud;
    this.regCurso = pRegCurso;
    this.consultarEscuelas = pEscuelaCrud;
    this.regCurso.RegistrarBt.addActionListener(this);
    this.regCurso.LimpiarBt.addActionListener(this);
    this.regCurso.btnVolver.addActionListener(this);
  }
  
  /**
   * Inicializa la ventana de registro de cursos.
   */
  public void iniciar(){
    cargarEscuelas();  
    regCurso.setTitle("Gestor de Planes de Estudio");
    regCurso.setLocationRelativeTo(null);    
  }
  
  /**
   * Carga la lista de escuelas en el combobox de la ventana de registro de escuelas.
   */
  public void cargarEscuelas(){
    ArrayList<String> escuelas = consultarEscuelas.consultar();
    for (String escuela : escuelas){
      regCurso.EscuelaCb.addItem(escuela);
    }
  }
    
  /**
   * Ejecuta las funciones correspondientes a cada botón.
   * 
   * @param e el evento que ejecuta un botón
   */
  @Override
  public void actionPerformed(ActionEvent e){
    //Botón de registrar escuela
    if (e.getSource() == regCurso.RegistrarBt){
      curso.setEscuela((String)regCurso.EscuelaCb.getSelectedItem());
      curso.setIdCurso(regCurso.txtCodigo.getText());
      curso.setNombreCurso(regCurso.txtNombre.getText());
      curso.setHorasLectivas((String)((regCurso.HorasCb.getSelectedItem())));
      curso.setCreditos(((String) regCurso.CreditosCb.getSelectedItem()));
      
      //Registra el curso
      if (cursoCrud.registrar(curso)){
        JOptionPane.showMessageDialog(null, "Curso Registrado");
        limpiar();
      } else {
        JOptionPane.showMessageDialog(null, "Error al registrar el curso");
        limpiar();
      }
    }
    
    //Botón de limpiar campos
    if (e.getSource() == regCurso.LimpiarBt){
      limpiar();
    }
    
    //Botón de regresar
    if (e.getSource() == regCurso.btnVolver){
      regCurso.setVisible(false);
    }
  }
  
  /**
   * Limpia todos los campos de texto de la ventana de registro de cursos.
   */
  public void limpiar(){
    regCurso.txtCodigo.setText(null);
    regCurso.txtNombre.setText(null);
    regCurso.CreditosCb.setSelectedItem(0);
    regCurso.HorasCb.setSelectedItem(1);
  }
}

