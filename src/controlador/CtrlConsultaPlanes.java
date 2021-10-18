package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Correo;
import modelo.EscuelaCRUD;
import modelo.PlanDeEstudioCRUD;
import modelo.PlantillaPDF;
import vista.ConsultarPlan;

/**
 * Clase que controla la entrada y salida de información del módulo 
 * <p>de consulta de planes de estudio.
 * 
 * @author Gustavo
 * @version 13/10/2021
 */
public class CtrlConsultaPlanes implements ActionListener {
  //Atributos de la clase
  private PlanDeEstudioCRUD planCrud;
  private ConsultarPlan consultaPlan;
  private EscuelaCRUD consultarEscuelas;
  private int cursosTotales;
  private int creditosTotales;
  private ArrayList<Object[]> filas;
  
  /**
   * Constructor de la clase.
   * 
   * @param pPlanCrud           objeto que contiene las funciones CRUD del plan de estudios
   * @param pConsultarEscuelas  objeto que contiene las funciones CRUD de la escuela
   * @param pConsultaPlan       ventana de la consulta de plan de estudios
   */
  public CtrlConsultaPlanes(PlanDeEstudioCRUD pPlanCrud, EscuelaCRUD pConsultarEscuelas, ConsultarPlan pConsultaPlan){
    this.filas = new ArrayList<>();
    this.planCrud = pPlanCrud;
    this.consultarEscuelas = pConsultarEscuelas;
    this.consultaPlan = pConsultaPlan;
    this.consultaPlan.btnConsultar.addActionListener(this);
    this.consultaPlan.btnPDFCorreo.addActionListener(this);
    this.consultaPlan.btnRegresar.addActionListener(this);
  }
  
  /**
   * Inicializa la ventana de consulta de plan de estudios.
   */
  public void iniciar(){
    cargarEscuelas();
    consultaPlan.setTitle("Gestor de Planes de Estudio");
    consultaPlan.setLocationRelativeTo(null);
    consultaPlan.btnPDFCorreo.setEnabled(false);
  }
  
  /**
   * Carga la lista de escuelas en el combobox de la ventana.
   */
  public void cargarEscuelas(){
    ArrayList<String> escuelas = consultarEscuelas.consultar();
    for (String escuela : escuelas){
      consultaPlan.cbEscuelas.addItem(escuela);
    }
  }
  
  /**
   * Muestra el código y fecha de vigencia del plan de estudios.
   */
  public void mostrarInfoPlan(){
    String escuela = (String)this.consultaPlan.cbEscuelas.getSelectedItem();
    String[] info = planCrud.consultarInfoPlan(escuela);
    this.consultaPlan.tfCodigoPlan.setText(info[0]);
    this.consultaPlan.tfVigencia.setText(info[1]);
  }
  
  /**
   * Muestra los cursos del plan de estudios en la tabla.
   */
  public void mostrarCursos(){
    String escuela = (String)this.consultaPlan.cbEscuelas.getSelectedItem();
    DefaultTableModel modelo = new DefaultTableModel();
    this.consultaPlan.tConsultaPlan.setModel(modelo);
    this.cursosTotales = 0;
    this.creditosTotales = 0;
    this.filas = planCrud.consultarCursosPlan(escuela);  //este es el metodo que se trae los cursos del plan 
    
    //Agrega los encabezados de la tabla
    modelo.addColumn("Código del curso");
    modelo.addColumn("Nombre del curso");
    modelo.addColumn("Bloque");
    modelo.addColumn("Horas de clase");
    modelo.addColumn("Créditos");
    
    //Se obtienen las filas de la tabla desde la lista de arreglos
    for (Object[] fila : filas){
      modelo.addRow(fila);
      this.cursosTotales++;
      this.creditosTotales += Integer.parseInt(fila[4].toString());
    }
  }

  /**
   * Ejecuta las acciones correspondientes a cada botón de la ventana
   * 
   * @param e el evento que ejecuta un botón
   */
  @Override
  public void actionPerformed(ActionEvent e){
    //Botón de consultar plan de estudios
    if (e.getSource() == this.consultaPlan.btnConsultar){
      mostrarInfoPlan();
      mostrarCursos();
      this.consultaPlan.tfTotalCursos.setText(Integer.toString(this.cursosTotales));
      this.consultaPlan.tfTotalCreditos.setText(Integer.toString(this.creditosTotales));
      this.consultaPlan.btnPDFCorreo.setEnabled(true);
    }
    
    //Botón de enviar PDF por correo electrónico
    if (e.getSource() == this.consultaPlan.btnPDFCorreo){
      String email = JOptionPane.showInputDialog(null, "Indique su correo electrónico");
      
      //Valida que se introduzca un email
      if (!email.equals("")){
        PlantillaPDF pdf = new PlantillaPDF((String)this.consultaPlan.cbEscuelas.getSelectedItem(), 
                this.consultaPlan.tfCodigoPlan.getText(), this.consultaPlan.tfVigencia.getText(), 
                this.filas, this.cursosTotales, this.creditosTotales);

        //Crea el documento PDF
        if (pdf.crearPlantilla()){
          System.out.println("Plantilla creada");
          Correo correo = new Correo();
          
          //Envía el correo electrónico
          if (correo.EnvioMail(email, this.consultaPlan.tfCodigoPlan.getText(), 
                  (String)this.consultaPlan.cbEscuelas.getSelectedItem())){
            JOptionPane.showMessageDialog(null, "Correo enviado a " + email);
          } else {
            JOptionPane.showMessageDialog(null, "No se pudo enviar el correo");
          }
        } else {
          JOptionPane.showMessageDialog(null, "No se pudo crear el PDF");
        }  
      } else {
        JOptionPane.showMessageDialog(null, "Debe indicar un correo electrónico");
      }
    }
    
    //Botón de regresar
    if (e.getSource() == this.consultaPlan.btnRegresar){
      this.consultaPlan.setVisible(false);
    }
  }
}