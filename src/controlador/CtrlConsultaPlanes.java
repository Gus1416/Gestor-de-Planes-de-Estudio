package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.EscuelaCRUD;
import modelo.PlanDeEstudioCRUD;
import vista.ConsultarPlan;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class CtrlConsultaPlanes implements ActionListener {
  private PlanDeEstudioCRUD planCrud;
  private ConsultarPlan consultaPlan;
  private EscuelaCRUD consultarEscuelas;
  
  public CtrlConsultaPlanes(PlanDeEstudioCRUD pPlanCrud, EscuelaCRUD pConsultarEscuelas, ConsultarPlan pConsultaPlan){
    this.planCrud = pPlanCrud;
    this.consultarEscuelas = pConsultarEscuelas;
    this.consultaPlan = pConsultaPlan;
    this.consultaPlan.btnConsultar.addActionListener(this);
    this.consultaPlan.btnPDFCorreo.addActionListener(this);
    this.consultaPlan.btnRegresar.addActionListener(this);
  }
  
  public void iniciar(){
    cargarEscuelas();
    consultaPlan.setTitle("Gestor de Planes de Estudio");
    consultaPlan.setLocationRelativeTo(null);
  }
  
  public void cargarEscuelas(){
    ArrayList<String> escuelas = consultarEscuelas.consultar();
    for (String escuela : escuelas){
      consultaPlan.cbEscuelas.addItem(escuela);
    }
  }
  
  public void mostrarInfoPlan(){
    String escuela = (String)this.consultaPlan.cbEscuelas.getSelectedItem();
    String[] info = planCrud.consultarInfoPlan(escuela);
    this.consultaPlan.tfCodigoPlan.setText(info[0]);
    //this.consultaPlan.tfVigencia.setText(info[1]);
  }
  
  public void mostrarCursos(){
    String escuela = (String)this.consultaPlan.cbEscuelas.getSelectedItem();
    DefaultTableModel modelo = new DefaultTableModel();
    this.consultaPlan.tConsultaPlan.setModel(modelo);
    
    modelo.addColumn("Código del curso");
    modelo.addColumn("Nombre del curso");
    modelo.addColumn("Bloque");
    modelo.addColumn("Horas de clase");
    modelo.addColumn("Créditos");
    
    for (Object[] fila : planCrud.consultarCursosPlan(escuela)){
      modelo.addRow(fila);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e){
    if (e.getSource() == this.consultaPlan.btnConsultar){
      mostrarInfoPlan();
      mostrarCursos();
    }
  }
  
}
