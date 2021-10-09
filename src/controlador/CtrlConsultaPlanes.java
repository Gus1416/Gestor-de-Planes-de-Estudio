package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.EscuelaCRUD;
import modelo.PlanDeEstudioCRUD;
import modelo.PlantillaPDF;
import vista.ConsultarPlan;

/**
 *
 * @author Gustavo
 */
public class CtrlConsultaPlanes implements ActionListener {
  private PlanDeEstudioCRUD planCrud;
  private ConsultarPlan consultaPlan;
  private EscuelaCRUD consultarEscuelas;
  private int cursosTotales;
  private int creditosTotales;
  private ArrayList<Object[]> filas;
  
  public CtrlConsultaPlanes(PlanDeEstudioCRUD pPlanCrud, EscuelaCRUD pConsultarEscuelas, ConsultarPlan pConsultaPlan){
    this.filas = new ArrayList<>();
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
    consultaPlan.btnPDFCorreo.setEnabled(false);
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
    this.cursosTotales = 0;
    this.creditosTotales = 0;
    this.filas = planCrud.consultarCursosPlan(escuela);
    
    modelo.addColumn("Código del curso");
    modelo.addColumn("Nombre del curso");
    modelo.addColumn("Bloque");
    modelo.addColumn("Horas de clase");
    modelo.addColumn("Créditos");
    
    for (Object[] fila : filas){
      modelo.addRow(fila);
      this.cursosTotales++;
      this.creditosTotales += Integer.parseInt(fila[4].toString());
    }
  }

  @Override
  public void actionPerformed(ActionEvent e){
    if (e.getSource() == this.consultaPlan.btnConsultar){
      mostrarInfoPlan();
      mostrarCursos();
      this.consultaPlan.tfTotalCursos.setText(Integer.toString(this.cursosTotales));
      this.consultaPlan.tfTotalCreditos.setText(Integer.toString(this.creditosTotales));
      this.consultaPlan.btnPDFCorreo.setEnabled(true);
    }
    
    if (e.getSource() == this.consultaPlan.btnPDFCorreo){
      String email = JOptionPane.showInputDialog(null, "Indique su correo electrónico");
      
      if (!email.equals("")){
        PlantillaPDF pdf = new PlantillaPDF((String)this.consultaPlan.cbEscuelas.getSelectedItem(), 
                this.consultaPlan.tfCodigoPlan.getText(), this.consultaPlan.tfVigencia.getText(), 
                this.filas, this.cursosTotales, this.creditosTotales);

        if (pdf.crearPlantilla()){
          System.out.println("Plantilla creada");
        } else {
          JOptionPane.showMessageDialog(null, "No se pudo crear el PDF");
        }  
      } else {
        JOptionPane.showMessageDialog(null, "Debe indicar un correo electrónico");
      }
    }
    
    if (e.getSource() == this.consultaPlan.btnRegresar){
      this.consultaPlan.setVisible(false);
    }
  }
}
