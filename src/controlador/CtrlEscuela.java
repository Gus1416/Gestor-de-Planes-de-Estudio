package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
  public static ArrayList<Escuela> escuelas;
  
  public CtrlEscuela() {
  }

  public ArrayList<Escuela> getEscuelas() {
    return escuelas;
  }
     
  public CtrlEscuela(Escuela pEscuela, EscuelaCRUD pEscuelaCrud, RegistrarEscuela pRegEscuela, ArrayList<Escuela> pEscuelas){
    this.escuela = pEscuela;
    this.escuelaCrud = pEscuelaCrud;
    this.regEscuela = pRegEscuela;
    this.escuelas= pEscuelas;
    this.regEscuela.btnRegistrarEscuela.addActionListener(this);
    this.regEscuela.btnLimpiarCampos.addActionListener(this);
    this.regEscuela.btnVolver.addActionListener(this);
  }
  
  public CtrlEscuela(Escuela pEscuela, EscuelaCRUD pEscuelaCrud, RegistrarEscuela pRegEscuela){
    this.escuela = pEscuela;
    this.escuelaCrud = pEscuelaCrud;
    this.regEscuela = pRegEscuela;
    this.regEscuela.btnRegistrarEscuela.addActionListener(this);
    this.regEscuela.btnLimpiarCampos.addActionListener(this);
    this.regEscuela.btnVolver.addActionListener(this);
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
        
        Escuela nueva = new Escuela(regEscuela.tfNombreEscuela.getText(),regEscuela.tfCodigoEscuela.getText());
        
        for (int i = 0; i < escuelas.size(); i++) {
  
            // accessing each element of array
            Escuela x = escuelas.get(i);
            System.out.print("Elemento de lista: " + i + x.getNombre() );
        }
        
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
    
    if (e.getSource() == regEscuela.btnVolver){
      regEscuela.setVisible(false);
    }
  }
  
  public void limpiar(){
    regEscuela.tfCodigoEscuela.setText(null);
    regEscuela.tfNombreEscuela.setText(null);
  }
}
