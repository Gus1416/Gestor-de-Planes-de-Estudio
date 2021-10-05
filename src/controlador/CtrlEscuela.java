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
  public static ArrayList<Escuela> escuelas;
  
  
    public CtrlEscuela() {
    }

    public ArrayList<Escuela> getEscuelas() {
        return escuelas;
    }
     
  public CtrlEscuela(Escuela pEscuela, EscuelaCRUD pEscuelaCrud, registrarEscuela pRegEscuela, ArrayList<Escuela> pEscuelas){
    this.escuela = pEscuela;
    this.escuelaCrud = pEscuelaCrud;
    this.regEscuela = pRegEscuela;
    this.escuelas= pEscuelas;
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
      
      System.out.println("ACA DEBERÍA DE IMPRIMIR ALGO VERDAD ");
      
      Escuela nueva = new Escuela(regEscuela.tfNombreEscuela.getText(),regEscuela.tfCodigoEscuela.getText());
      
      
      escuelas.add(nueva); // AGREGAR LA ESCUELA CREADA A UN ARRAY LIST PARA OBTENER SUS DATOS EN OTROS MODULOS
      
      
      for (int i = 0; i < escuelas.size(); i++) {
  
            // accessing each element of array
            Escuela x = escuelas.get(i);
            System.out.print("Elemento de lista: " + i + x.getNombre() );
        }
      
      
      if (escuelaCrud.registrar(escuela)){
          System.out.println("Se supone que esto es el tamaño del array " + escuelas.size());
          System.out.println("Esto el nombre de la primera escuela agregada al array: " + escuelas.get(0).getNombre());
          System.out.println("Esto el código de la primera escuela agregada al array: " + escuelas.get(0).getCodigo());
          
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
      System.out.println("ACA SI SIRVE JEJE ");
    regEscuela.tfCodigoEscuela.setText(null);
    regEscuela.tfNombreEscuela.setText(null);
  }
}
