package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.CursoCRUD;
import modelo.EscuelaCRUD;
import vista.registrarRequisitos;

/**
 * Clase que controla la entrada y salida de los requisitos de los cursos.
 * 
 * @author Sebastián
 */
public class CtrlRequisitos implements ActionListener {
  //Atributos de clase
  private Curso curso;
  private CursoCRUD consultarCodigos;
  private registrarRequisitos regRequisitos;
  private EscuelaCRUD consultarEscuelas;
  public static Curso root = new Curso();

  /**
   * Constructor de la clase.
   * 
   * @param pCurso          objeto con la información del curso
   * @param pCursoCrud      objeto con las funciones CRUD de los cursos
   * @param pRegRequisitos  ventana de registro de requisitos 
   * @param pEscuelaCrud    objeto con las funciones CRUD de las escuelas
   */
  public CtrlRequisitos(Curso pCurso, CursoCRUD pCursoCrud, registrarRequisitos pRegRequisitos, EscuelaCRUD pEscuelaCrud) {
    this.curso = pCurso;
    this.regRequisitos = pRegRequisitos;
    this.consultarEscuelas = pEscuelaCrud;
    this.consultarCodigos = pCursoCrud;
    this.regRequisitos.btnCargarCursos.addActionListener(this);
    this.regRequisitos.btnRegistrarCorrequisito.addActionListener(this);
    this.regRequisitos.btnRegistrarRequisito.addActionListener(this);
    this.regRequisitos.btnVolver.addActionListener(this);
  }

  /**
   * Inicializa la ventana de registro de requisitos.
   */
  public void iniciar() {
    cargarEscuelas();  // 
    regRequisitos.setTitle("Gestor de Planes de Estudio");
    regRequisitos.setLocationRelativeTo(null);
  }

  /**
   * Carga la lista de escuelas en el combobox de la ventana.
   */
  public void cargarEscuelas() {
    ArrayList<String> escuelas = consultarEscuelas.consultar();
    ArrayList<String> codigos = consultarCodigos.consultar();  //Esto es para inicializar la lista global de curso registrados en el sistema
    for (String escuela : escuelas)
    {
      regRequisitos.CBEscuelas_Cursos.addItem(escuela);
    }
  }

  /**
   * Ejecuta las funciones correspondientes a cada botón.
   * 
   * @param e el evento que realiza un botón
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    //Botón de registrar correquisito
    if (e.getSource() == regRequisitos.btnRegistrarCorrequisito){
      consultarCodigos.consultar();
      String CodigoCURSO = regRequisitos.CBcodigos_cursos.getSelectedItem().toString();
      String CodigoCORREQUISITO = regRequisitos.CBcorrequisitos.getSelectedItem().toString();
      for (int i = 0; i < CursoCRUD.cursosObj.size(); i++)
        if (CodigoCURSO.equals(CursoCRUD.cursosObj.get(i).getIdCurso()) == true){  
          System.out.println("Este es el código del root que me llega: " + CursoCRUD.cursosObj.get(i).getIdCurso());
          curso = CursoCRUD.cursosObj.get(i);  //Definir el curso especifico al cual se le registra el corequisito 
          
          for (int z = 0; z < CursoCRUD.cursosObj.size(); z++){
            
            if (CodigoCORREQUISITO.equals(CursoCRUD.cursosObj.get(z).getIdCurso()) == true){   // Validar curso co-rrequisito
              System.out.println("Este es el código del correquisito que me llega: " + CursoCRUD.cursosObj.get(z).getIdCurso());
              curso.getCorrequisitos().add(CursoCRUD.cursosObj.get(z)); //Agregar el correquisito a la lista de correquisitos del curso 
              curso.setAuxCorrequisitos(CursoCRUD.cursosObj.get(z).getIdCurso()); //Agregar el ID del correquisito al curso (REF)
            }
          }
        } else {
          System.out.println("No se encontró el codigo de la escuela ");
        }
      
      //Registra el correquisito
      if (consultarCodigos.registrarCorrequisito(curso)){ //Llamar el método de registro de Correquisito en Mysql
        JOptionPane.showMessageDialog(null, "Correquisito Registrado");
      } else {
        JOptionPane.showMessageDialog(null, "Error al registrar el correquisito");
      }
    }
    
    //Botón de registrar requisto
    if (e.getSource() == regRequisitos.btnRegistrarRequisito) {
      String CodigoCURSO = regRequisitos.CBcodigos_cursos.getSelectedItem().toString();
      String CodigoRREQUISITO = regRequisitos.CBrequisitos.getSelectedItem().toString();
      for (int i = 0; i < CursoCRUD.cursosObj.size(); i++) {

        if (CodigoCURSO.equals(CursoCRUD.cursosObj.get(i).getIdCurso()) == true){       // Validar curso root
          curso = CursoCRUD.cursosObj.get(i);  //Definir el curso especifico al cual se le registra el requisito
          for (int z = 0; z < CursoCRUD.cursosObj.size(); z++){
            if (CodigoRREQUISITO.equals(CursoCRUD.cursosObj.get(z).getIdCurso()) == true) { 
              curso.setAuxRrequisitos(CursoCRUD.cursosObj.get(z).getIdCurso()); 
            }
          }
        } else{
          System.out.println("No se encontró el codigo de la escuela ");
        }
      }

      //Registra el requisito
      if (consultarCodigos.registrarRequisito(curso))
        JOptionPane.showMessageDialog(null, "Requisito Registrado");
      } else{
        JOptionPane.showMessageDialog(null, "Error al registrar el correquisito");  
    }
    
    //Botón de cargar cursos
    if (e.getSource() == regRequisitos.btnCargarCursos){
      regRequisitos.CBcodigos_cursos.removeAllItems();
      regRequisitos.CBcorrequisitos.removeAllItems();
      regRequisitos.CBrequisitos.removeAllItems();

      String codigo = consultarEscuelas.obtenerEscuelaID(EscuelaCRUD.escuelaObj, regRequisitos.CBEscuelas_Cursos.getSelectedItem().toString());
      System.out.println("Mae este es el codigo que mellega de su metodo:" + codigo);
      ArrayList<String> codigos = consultarCodigos.consultarCodigos(codigo);
      for (String code : codigos) {
        regRequisitos.CBcodigos_cursos.addItem(code);
        regRequisitos.CBcorrequisitos.addItem(code);
        regRequisitos.CBrequisitos.addItem(code);
      }
    }

    //Botón de volver
    if (e.getSource() == regRequisitos.btnVolver){
      regRequisitos.setVisible(false);
    }
  }
}
