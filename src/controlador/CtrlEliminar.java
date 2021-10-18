/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Maria Laura
 */
public class CtrlEliminar  implements ActionListener  {
  private Curso curso;
  private CursoCRUD cursoCrud;
  private EliminarCurso eliminar;
  private EliminarReq eliminarReq;
          
  
 
  public CtrlEliminar(Curso pCurso, CursoCRUD pCursoCrud, EliminarCurso pEliminar, EliminarReq eliminarReq){
    this.curso = pCurso;
    this.cursoCrud = pCursoCrud;
    this.eliminar= pEliminar;
    this.eliminarReq= eliminarReq;
    this.eliminar.btnEliminarCurso.addActionListener(this);
    this.eliminarReq.btnCargar.addActionListener(this);
    this.eliminarReq.btnEliminarReq.addActionListener(this);
     }
  
  public void iniciar(){
    cargarCodigos1();
    cargarCodigos2();
    
    
    eliminar.setTitle("Eliminar curso");
    eliminar.setLocationRelativeTo(null);
  }
  public ArrayList cargarCodigos1(){//carga los cursos para eliminar cursos
    ArrayList<String> codigos = cursoCrud.consultar();
    for (String codigo : codigos){
      
      eliminar.cbCurso.addItem(codigo);
    }
    return codigos;
  }
  public ArrayList cargarCodigos2(){ //carga los cursos para eliminar requisitos
    ArrayList<String> codigos = cursoCrud.consultar();
    for (String codigo : codigos){
      
      eliminarReq.cbCurso.addItem(codigo);
    }
    return codigos;
  }

   public ArrayList cargarCodigosRe(String id){ //Carga los cursos que están relacionados con ese plan de estudios
    
         
    ArrayList<String> cursos = cursoCrud.consultarIdRequisitos(id);
   
    for (String curso : cursos){
      
      eliminarReq.cbReq.addItem(curso);
    }
    return cursos;
  }

   @Override
    public void actionPerformed(ActionEvent e) {
        cargarCodigos1(); 
       
        if(e.getSource() == eliminar.btnEliminarCurso){
            curso.setIdCurso((eliminar.cbCurso.getSelectedItem().toString()));
            
            if (cursoCrud.eliminar(curso)){
                JOptionPane.showMessageDialog(null, "Curso eliminado");
        }else{
              JOptionPane.showMessageDialog(null, "Error al eliminar");  
            }
            eliminar.cbCurso.removeAllItems();
            cargarCodigos1();   
           
        }
        System.out.println("Prueba");
        if (e.getSource() == eliminarReq.btnCargar){
            cargarCodigosRe(eliminarReq.cbCurso.getSelectedItem().toString());
                   
        }
        if(e.getSource() == eliminarReq.btnEliminarReq){
            curso.setIdCurso((eliminarReq.cbCurso.getSelectedItem().toString()));
            
            if (cursoCrud.eliminarRequisito(curso)){
                JOptionPane.showMessageDialog(null, "Curso eliminado");
                 eliminarReq.cbReq.removeAllItems();
        }else{
              JOptionPane.showMessageDialog(null, "Error al eliminar");  
            }
        
  
}
    
    }
}

    

    