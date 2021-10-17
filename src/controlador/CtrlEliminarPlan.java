/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.CursoCRUD;
import modelo.PlanDeEstudio;
import modelo.PlanDeEstudioCRUD;
import vista.EliminarPlanEstudio;

/**
 *
 * @author Maria Laura
 */
public class CtrlEliminarPlan implements ActionListener{
    
    private PlanDeEstudio plan;
    private Curso curso;
    private PlanDeEstudioCRUD planCrud;
    private EliminarPlanEstudio eliminar;
    private CursoCRUD cursoCrud;
    
    public CtrlEliminarPlan(PlanDeEstudio pPlan, PlanDeEstudioCRUD pCrud,EliminarPlanEstudio pEliminar, CursoCRUD pCursoCrud, Curso pCurso){
        this.plan=pPlan;
        this.planCrud=pCrud;
        this.eliminar=pEliminar;
        this.cursoCrud=pCursoCrud;
        this.curso=pCurso;
        this.eliminar.btnEliminarCursoPlan.addActionListener(this);
        this.eliminar.btnCargar.addActionListener(this);
    }
    public void iniciar(){
    cargarCodigos();
    
    eliminar.setTitle("Eliminar plan de estudios");
    eliminar.setLocationRelativeTo(null);
  }
    
    public ArrayList cargarCodigos(){
    ArrayList<String> codigos =planCrud.consultar();
    for (String codigo : codigos){
      
      eliminar.cbPlan.addItem(codigo);
    }
    return codigos;
    
   
  }
     public ArrayList cargarCodigosCurso(String id){ //Carga los cursos que están relacionados con ese plan de estudios
    
         
    ArrayList<String> cursos = cursoCrud.consultarCursosPlan(id);
    
    for (String curso : cursos){
      
      eliminar.cbCurso.addItem(curso);
    }
    return cursos;
  }
    
    
    
    public void actionPerformed(ActionEvent e) {
        cargarCodigos();
        if(e.getSource() == eliminar.btnEliminarCursoPlan){
            curso.setIdCurso((eliminar.cbCurso.getSelectedItem().toString()));
            System.out.println(plan.getiD());
            
            if (planCrud.eliminarCurso(curso)){
                JOptionPane.showMessageDialog(null, "Curso eliminado");
        }else{
              JOptionPane.showMessageDialog(null, "Error al eliminar");  
            }
         cargarCodigos();
         eliminar.cbCurso.removeAllItems();
         }       
        if (e.getSource() == eliminar.btnCargar){
            cargarCodigosCurso(eliminar.cbPlan.getSelectedItem().toString());
                    
        }
        
    }
  
}

    


