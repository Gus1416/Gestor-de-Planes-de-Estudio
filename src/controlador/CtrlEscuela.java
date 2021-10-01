package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Escuela;
import modelo.EscuelaCRUD;
import vista.RegistrarEscuela;

/**
 *
 * @author Gustavo
 */
public class CtrlEscuela implements ActionListener {
  private Escuela escuela;
  private EscuelaCRUD escuelaCrud;
  private RegistrarEscuela regEscuela;
  
  public CtrlEscuela(Escuela pEscuela, EscuelaCRUD pEscuelaCrud, RegistrarEscuela pRegEscuela){
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
      escuela.setCodigo(regEscuela.tfCodigoEscuela.getText());
      escuela.setNombre(regEscuela.tfNombreEscuela.getText());
      if (escuelaCrud.registrar(escuela)){
        JOptionPane.showMessageDialog(null, "Escuela Registrada");
        limpiar();
      } else {
        JOptionPane.showMessageDialog(null, "Error al registrar la escuela");
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
