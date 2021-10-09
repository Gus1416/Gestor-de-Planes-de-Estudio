package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.EscuelaCRUD;
import modelo.PlanDeEstudioCRUD;
import vista.ConsultarPlan;

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

  @Override
  public void actionPerformed(ActionEvent e) {throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
