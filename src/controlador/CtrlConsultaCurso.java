/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.CursoCRUD;
import modelo.EscuelaCRUD;
import modelo.PlanDeEstudioCRUD;
import vista.ConsultarCurso;
import vista.ConsultarPlan;

/**
 *
 * @author sebcor
 */
public class CtrlConsultaCurso implements ActionListener {
  private PlanDeEstudioCRUD PLANCRUD;
  private EscuelaCRUD ESCUELACRUD;
  private CursoCRUD CURSOCRUD;
  private ConsultarCurso vistaCursos;
  private ArrayList<Object[]> filas;
  
  
    public CtrlConsultaCurso(PlanDeEstudioCRUD PLANCRUD, EscuelaCRUD ESCUELACRUD, CursoCRUD CURSOCRUD,ConsultarCurso vistaCursos) {
        this.filas = new ArrayList<>();
        this.PLANCRUD = PLANCRUD;
        this.ESCUELACRUD = ESCUELACRUD;
        this.CURSOCRUD = CURSOCRUD;
        this.vistaCursos= vistaCursos;
        this.vistaCursos.btnCargarCorrequisitos.addActionListener(this);
        this.vistaCursos.btnCargarRequisitos.addActionListener(this);
        this.vistaCursos.btnCargarPlanEstudio.addActionListener(this);
        this.vistaCursos.btnLoad.addActionListener(this);   
    }
  

    public void iniciar(){
    cargarEscuelas();
    vistaCursos.setTitle("Gestor de Planes de Estudio");
    vistaCursos.setLocationRelativeTo(null);
  }
    
    
   
    public ArrayList cargarEscuelas(){
    ArrayList<String> escuelas = ESCUELACRUD.consultar();
    for (String escuela : escuelas){
      vistaCursos.cbEscuelasNombre.addItem(escuela);
    }
    return escuelas;
  }
    
    
  public ArrayList cargarCodigos(){
    ArrayList<String> codigos = CURSOCRUD.consultar();
    for (String codigo : codigos){
      vistaCursos.cbCodigosCursos.addItem(codigo);
    }
    return codigos;
  }  
   
  
  
    public void mostrarRequisitos(){
      
        String curso = (String)this.vistaCursos.cbCodigosCursos.getSelectedItem();
        DefaultTableModel modeloR = new DefaultTableModel();
        this.vistaCursos.ReqTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
        this.filas = CURSOCRUD.consultarRequisitos(curso); /// Crear este método verda 

        modeloR.addColumn("ID");
        modeloR.addColumn("Nombre");
        modeloR.addColumn("Créditos");
        modeloR.addColumn("Horas de clase");

        for (Object[] fila : filas){
          modeloR.addRow(fila);

        }
        
    }
  
  
  
  public void mostrarCorrequisitos(){
    String curso = (String)this.vistaCursos.cbCodigosCursos.getSelectedItem();
    DefaultTableModel modeloC = new DefaultTableModel();
    this.vistaCursos.CorrTable.setModel(modeloC);  // Setear el modelo de la tabla de requisitos
    this.filas = CURSOCRUD.consultarCorrequisitos(curso); /// Crear este método verda 
    
    modeloC.addColumn("ID");
    modeloC.addColumn("Nombre");
    modeloC.addColumn("Créditos");
    modeloC.addColumn("Horas de clase");
    
    for (Object[] fila : filas){
      modeloC.addRow(fila);
    }
  }
  
  
  
  
  
  public void mostrarPlanesEstudio(){
    String curso = (String)this.vistaCursos.cbCodigosCursos.getSelectedItem();
    DefaultTableModel modeloP = new DefaultTableModel();
    this.vistaCursos.PlanTable.setModel(modeloP);  // Setear el modelo de la tabla de requisitos
    this.filas = CURSOCRUD.consultarPlanes(curso);/// Crear este método verda 
    
    modeloP.addColumn("Código del Plan");
    modeloP.addColumn("Nombre del curso");
    modeloP.addColumn("Fecha Vigencia");
    modeloP.addColumn("Escuela Propietaria");

    
    for (Object[] fila : filas){
      modeloP.addRow(fila);
    }
  }
  
  
    public void actionPerformed(ActionEvent e){
          
        if (e.getSource() == this.vistaCursos.btnCargarRequisitos){
              mostrarRequisitos();    
          }
        
        
        if (e.getSource() == this.vistaCursos.btnCargarCorrequisitos){
              mostrarCorrequisitos();    
          }
        
        
        if (e.getSource() == this.vistaCursos.btnCargarPlanEstudio){
              mostrarPlanesEstudio();    
          }
        
        
        if (e.getSource() == vistaCursos.btnLoad){   
        vistaCursos.cbCodigosCursos.removeAllItems();
         String codigo = ESCUELACRUD.obtenerEscuelaID(EscuelaCRUD.ESCUELAOBJ,vistaCursos.cbEscuelasNombre.getSelectedItem().toString());      
         System.out.println("Escuela que me llega de su metodo:" + codigo);
         ArrayList<String> codigos = CURSOCRUD.consultarCodigos(codigo);    
        for (String code : codigos){       
            vistaCursos.cbCodigosCursos.addItem(code);         
      } 
    }

      
      
      
      
      
    }



  
}
