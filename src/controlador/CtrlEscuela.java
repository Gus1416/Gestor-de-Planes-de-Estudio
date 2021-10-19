package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Escuela;
import modelo.EscuelaCRUD;
import vista.RegistrarEscuela;

/**
 * Clase que controla la entreda y salida de información correspondiente a las escuelas.
 * 
 * @author Gustavo
 * @version 09/10/2021
 */
public class CtrlEscuela implements ActionListener {
  //Atributos de clase
  private Escuela escuela;
  private EscuelaCRUD escuelaCrud;
  private RegistrarEscuela regEscuela;
  public static ArrayList<Escuela> escuelas = new ArrayList<>();
  
  /**
   * Constructor por defecto.
   */
  public CtrlEscuela() {
  }  
  
  /**
   * Constructor con parámetros.
   * 
   * @param pEscuela      objeto con información de la escuela
   * @param pEscuelaCrud  objeto con las funciones CRUD de las escuelas
   * @param pRegEscuela   ventana de registro de escuelas
   * @param pEscuelas     lista escuelas
   */
  public CtrlEscuela(Escuela pEscuela, EscuelaCRUD pEscuelaCrud, RegistrarEscuela pRegEscuela, ArrayList<Escuela> pEscuelas){
    this.escuela = pEscuela;
    this.escuelaCrud = pEscuelaCrud;
    this.regEscuela = pRegEscuela;
    this.escuelas= pEscuelas;
    this.regEscuela.btnRegistrarEscuela.addActionListener(this);
    this.regEscuela.btnLimpiarCampos.addActionListener(this);
    this.regEscuela.btnVolver.addActionListener(this);
  }
  
  /**
   * Constructor con parámetros.
   * 
   * @param pEscuela      objeto con información de la escuela
   * @param pEscuelaCrud  objeto con las funciones CRUD de las escuelas
   * @param pRegEscuela   ventana de registro de escuelas
   */
  public CtrlEscuela(Escuela pEscuela, EscuelaCRUD pEscuelaCrud, RegistrarEscuela pRegEscuela){
    this.escuela = pEscuela;
    this.escuelaCrud = pEscuelaCrud;
    this.regEscuela = pRegEscuela;
    this.regEscuela.btnRegistrarEscuela.addActionListener(this);
    this.regEscuela.btnLimpiarCampos.addActionListener(this);
    this.regEscuela.btnVolver.addActionListener(this);
  }
  
  //Método accesor
  public ArrayList<Escuela> getEscuelas() {
    return escuelas;
  }
  
  /**
   * Inicializa la ventana de registro de escuelas.
   */
  public void iniciar(){
    regEscuela.setTitle("Gestor de Planes de Estudio");
    regEscuela.setLocationRelativeTo(null);
  }
  
  /**
   * Ejecuta las acciones correspondientes a cada botón.
   * 
   * @param e el evento que ejecuta un botón
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    //Botón de registrar escuela
    if (e.getSource() == regEscuela.btnRegistrarEscuela){

      //Valida la entrada de información
      if (!regEscuela.tfCodigoEscuela.getText().isEmpty() && !regEscuela.tfNombreEscuela.getText().isEmpty()){
        escuela.setCodigo(regEscuela.tfCodigoEscuela.getText().toUpperCase());
        escuela.setNombre(regEscuela.tfNombreEscuela.getText());
        
        //Registra la escuela
        if (escuelaCrud.registrar(escuela)){
          JOptionPane.showMessageDialog(null, "Escuela Registrada");
          limpiar();
        } else{ 
          JOptionPane.showMessageDialog(null, "Error: el código está repetido o incorrecto");
          limpiar();
        }

      } else {
        JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        limpiar();
      }
    }
    
    //Botón de limpiar campos
    if (e.getSource() == regEscuela.btnLimpiarCampos) {
      limpiar();
    }

    //Botón de volver
    if (e.getSource() == regEscuela.btnVolver) {
      regEscuela.setVisible(false);
    }
  }
  
  /**
   * Limpia todos los campos de texto de la ventana de registro de escuelas.
   */
  public void limpiar(){
    regEscuela.tfCodigoEscuela.setText(null);
    regEscuela.tfNombreEscuela.setText(null);
  }
}
