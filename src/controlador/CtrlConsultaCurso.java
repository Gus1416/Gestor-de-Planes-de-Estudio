package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.CursoCRUD;
import modelo.EscuelaCRUD;
import modelo.PlanDeEstudioCRUD;
import vista.ConsultarCurso;

/**
 * Clase que controla la entrada y salida de información de la consulta de cursos.
 * 
 * @author Sebastián
 * @version 17/10/2021
 */
public class CtrlConsultaCurso implements ActionListener {
  //Atributos de clase
  private PlanDeEstudioCRUD planCrud;
  private EscuelaCRUD escuelaCrud;
  private CursoCRUD cursoCrud;
  private ConsultarCurso vistaCursos;
  private ArrayList<Object[]> filas;
  
  public CtrlConsultaCurso(PlanDeEstudioCRUD pPlanCrud, EscuelaCRUD pEscuelaCrud, CursoCRUD pCursoCrud, 
          ConsultarCurso vistaCursos) {
    this.filas = new ArrayList<>();
    this.planCrud = pPlanCrud;
    this.escuelaCrud = pEscuelaCrud;
    this.cursoCrud = pCursoCrud;
    this.vistaCursos = vistaCursos;
    this.vistaCursos.btnCargarCorrequisitos.addActionListener(this);
    this.vistaCursos.btnCargarRequisitos.addActionListener(this);
    this.vistaCursos.btnCargarPlanEstudio.addActionListener(this);
    this.vistaCursos.btnLoad.addActionListener(this);
  }

  /**
   * Inicializa la ventana de consulta de plan de estudios.
   */
  public void iniciar() {
    cargarEscuelas();
    vistaCursos.setTitle("Gestor de Planes de Estudio");
    vistaCursos.setLocationRelativeTo(null);
  }

  /**
   * Carga la lista de escuelas en el combobox de la ventana.
   */
  public ArrayList cargarEscuelas() {
    ArrayList<String> escuelas = escuelaCrud.consultar();
    for (String escuela : escuelas){
      vistaCursos.cbEscuelasNombre.addItem(escuela);
    }
    return escuelas;
  }

  /**
   * Carga la lista de códigos en el combobox de la ventana.
   */
  public ArrayList cargarCodigos() {
    ArrayList<String> codigos = cursoCrud.consultar();
    for (String codigo : codigos){
      vistaCursos.cbCodigosCursos.addItem(codigo);
    }
    return codigos;
  }

  /**
   * Muestra los requisitos que tiene asignado el curso consultado.
   */
  public void mostrarRequisitos() {
    String curso = (String) this.vistaCursos.cbCodigosCursos.getSelectedItem();
    DefaultTableModel modeloR = new DefaultTableModel();
    this.vistaCursos.ReqTable.setModel(modeloR);  // Setear el modelo de la tabla de requisitos
    this.filas = cursoCrud.consultarRequisitos(curso); /// Crear este método verda 

    modeloR.addColumn("ID");
    modeloR.addColumn("Nombre");
    modeloR.addColumn("Créditos");
    modeloR.addColumn("Horas de clase");

    for (Object[] fila : filas){
      modeloR.addRow(fila);
    }
  }

  /**
   * Muestra los correquisitos que tiene asignado el curso consultado.
   */
  public void mostrarCorrequisitos() {
    String curso = (String) this.vistaCursos.cbCodigosCursos.getSelectedItem();
    DefaultTableModel modeloC = new DefaultTableModel();
    this.vistaCursos.CorrTable.setModel(modeloC);  // Setear el modelo de la tabla de requisitos
    this.filas = cursoCrud.consultarCorrequisitos(curso); /// Crear este método verda 

    modeloC.addColumn("ID");
    modeloC.addColumn("Nombre");
    modeloC.addColumn("Créditos");
    modeloC.addColumn("Horas de clase");

    for (Object[] fila : filas)
    {
      modeloC.addRow(fila);
    }
  }

  /**
   * Muestra los planes de estudio en los que se encuentra registrado el curso consultado.
   */
  public void mostrarPlanesEstudio() {
    String curso = (String) this.vistaCursos.cbCodigosCursos.getSelectedItem();
    DefaultTableModel modeloP = new DefaultTableModel();
    this.vistaCursos.PlanTable.setModel(modeloP);  // Setear el modelo de la tabla de requisitos
    this.filas = cursoCrud.consultarPlanes(curso);/// Crear este método verda 

    modeloP.addColumn("Código del Plan");
    modeloP.addColumn("Nombre del curso");
    modeloP.addColumn("Fecha Vigencia");
    modeloP.addColumn("Escuela Propietaria");

    for (Object[] fila : filas)
    {
      modeloP.addRow(fila);
    }
  }

  /**
   * Ejecuta las acciones correspondientes a cada botón de la ventana
   * 
   * @param e el evento que ejecuta un botón
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    //Botón para cargar requisitos en la tabla
    if (e.getSource() == this.vistaCursos.btnCargarRequisitos){
      mostrarRequisitos();
    }

    //Botón para cargar correquisitos en la tabla
    if (e.getSource() == this.vistaCursos.btnCargarCorrequisitos){
      mostrarCorrequisitos();
    }

    //Botón para cargar planes de estudio en la tabla
    if (e.getSource() == this.vistaCursos.btnCargarPlanEstudio){
      mostrarPlanesEstudio();
    }

    //Botón para cargar los cursos de la escuela consultada
    if (e.getSource() == vistaCursos.btnLoad) {
      vistaCursos.cbCodigosCursos.removeAllItems();
      String codigo = escuelaCrud.obtenerEscuelaID(EscuelaCRUD.escuelaObj, vistaCursos.cbEscuelasNombre.getSelectedItem().toString());
      System.out.println("Escuela que me llega de su metodo:" + codigo);
      ArrayList<String> codigos = cursoCrud.consultarCodigos(codigo);
      for (String code : codigos){
        vistaCursos.cbCodigosCursos.addItem(code);
      }
    }
  }
}
