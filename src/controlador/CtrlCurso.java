package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.CursoCRUD;
import modelo.EscuelaCRUD;
import vista.RegistroCurso;

/**
 *
 * @author María Laura
 */
public class CtrlCurso implements ActionListener {
  private Curso curso;
  private CursoCRUD cursoCrud;
  private RegistroCurso regCurso;
  private EscuelaCRUD consultarEscuelas;
 
  public CtrlCurso(Curso pCurso, CursoCRUD pCursoCrud, RegistroCurso pRegCurso, EscuelaCRUD pEscuelaCrud){
    this.curso = pCurso;
    this.cursoCrud = pCursoCrud;
    this.regCurso = pRegCurso;
    this.consultarEscuelas = pEscuelaCrud;
    this.regCurso.RegistrarBt.addActionListener(this);
  }
  
  public void iniciar(){
    cargarEscuelas();
    regCurso.setTitle("Gestor de Planes de Estudio");
    regCurso.setLocationRelativeTo(null);
  }
  
  public void cargarEscuelas(){
    ArrayList<String> escuelas = consultarEscuelas.consultar();
    for (String escuela : escuelas){
      regCurso.EscuelaCb.addItem(escuela);
    }
  }
    
  @Override
  public void actionPerformed(ActionEvent e){
    if (e.getSource() == regCurso.RegistrarBt){
      curso.setIdCurso(regCurso.txtCodigo.getText());
      curso.setNombreCurso(regCurso.txtNombre.getText());
      curso.setHorasLectivas((String)((regCurso.HorasCb.getSelectedItem())));
      curso.setCreditos(((String) regCurso.CreditosCb.getSelectedItem()));
      
      if (cursoCrud.registrar(curso)){
        JOptionPane.showMessageDialog(null, "Curso Registrado");
        limpiar();
      } else {
        JOptionPane.showMessageDialog(null, "Error al registrar el curso");
        limpiar();
      }
    }
    if (e.getSource() == regCurso.LimpiarBt){
      limpiar();
    }
  }
  
  public void limpiar(){
    regCurso.txtCodigo.setText(null);
    regCurso.txtNombre.setText(null);
    regCurso.CreditosCb.setSelectedItem(0);
    regCurso.HorasCb.setSelectedItem(1);
  }
}
