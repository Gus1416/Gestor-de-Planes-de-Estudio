package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Escuela;
import modelo.EscuelaCRUD;
import vista.registrarEscuela;

/**
 *
 * @author Gustavo
 */
public class CtrlEscuela implements ActionListener {
  private Escuela escuela;
  private EscuelaCRUD escuelaCrud;
  private registrarEscuela regEscuela;
  
  public CtrlEscuela(Escuela pEscuela, EscuelaCRUD pEscuelaCrud, registrarEscuela pRegEscuela){
    this.escuela = pEscuela;
    this.escuelaCrud = pEscuelaCrud;
    this.regEscuela = pRegEscuela;
    this.regEscuela.btnRegistrarEscuela.addActionListener(this);
  }
  
  public void iniciar(){
    regEscuela.setTitle("Gestor de Planes de Estudio");
    regEscuela.setLocationRelativeTo(null);
  }
  
  @Override
  public void actionPerformed(ActionEvent e){
    if (e.getSource() == regEscuela.btnRegistrarEscuela){
      
      if (!regEscuela.tfCodigoEscuela.getText().isEmpty() && !regEscuela.tfNombreEscuela.getText().isEmpty()){
        
        escuela.setCodigo(regEscuela.tfCodigoEscuela.getText());
        escuela.setNombre(regEscuela.tfNombreEscuela.getText());
        
        if (escuelaCrud.registrar(escuela)){
          JOptionPane.showMessageDialog(null, "Escuela Registrada");
          limpiar();
        } else {
          JOptionPane.showMessageDialog(null, "Error: Código repetido");
          limpiar();
        } 
        
      } else {
      JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
      limpiar();
      }
    } 
    
    if (e.getSource() == regEscuela.btnLimpiarCampos){
      limpiar();
    }
  }
  
  public void limpiar(){
    regEscuela.tfCodigoEscuela.setText(null);
    regEscuela.tfNombreEscuela.setText(null);
  }
}
