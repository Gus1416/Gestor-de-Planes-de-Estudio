package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
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
  
  public ArrayList<Escuela> escuelas;
  

    public CtrlEscuela() {
    }

    public ArrayList<Escuela> getEscuelas() {
        return escuelas;
    }
     
  public CtrlEscuela(Escuela pEscuela, EscuelaCRUD pEscuelaCrud, registrarEscuela pRegEscuela){
    this.escuela = pEscuela;
    this.escuelaCrud = pEscuelaCrud;
    this.regEscuela = pRegEscuela;
    this.regEscuela.btnRegistrarEscuela.addActionListener(this);
    this.escuelas= new ArrayList<Escuela>();
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
      
      Escuela auxESC = new Escuela(escuela.getNombre(),escuela.getCodigo());
      escuelas.add(auxESC); // AGREGAR LA ESCUELA CREADA A UN ARRAY LIST PARA OBTENER SUS DATOS EN OTROS MODULOS
      
       
      if (escuelaCrud.registrar(escuela)){
          System.out.println(escuelas.size());
          System.out.println(escuela.getCodigo());
          System.out.println(escuela.getNombre());
          
       
        
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
