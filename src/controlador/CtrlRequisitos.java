package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.CursoCRUD;
import modelo.EscuelaCRUD;
import vista.registrarRequisitos;

/**
 *
 * @author SEBCOR
 */
public class CtrlRequisitos implements ActionListener {

  private Curso curso;
  private CursoCRUD consultarCodigos;
  private registrarRequisitos regRequisitos;
  private EscuelaCRUD consultarEscuelas;
  public static Curso root = new Curso();

  public CtrlRequisitos(Curso pCurso, CursoCRUD pCursoCrud, registrarRequisitos pRegRequisitos, EscuelaCRUD pEscuelaCrud) {

    this.curso = pCurso;
    this.regRequisitos = pRegRequisitos;
    this.consultarEscuelas = pEscuelaCrud;
    this.consultarCodigos = pCursoCrud;
    this.regRequisitos.btnCargarCursos.addActionListener(this);
    this.regRequisitos.btnRegistrarCorrequisito.addActionListener(this);
    this.regRequisitos.btnRegistrarRequisito.addActionListener(this);
    this.regRequisitos.btnVolver.addActionListener(this);
    // INICIAR BOTONES DE REQUISITOS Y CORREQUITOS
    //this.regCurso.RegistrarBt.addActionListener(this); 
  }

  public void iniciar() {
    cargarEscuelas();  // 
    regRequisitos.setTitle("Gestor de Planes de Estudio");
    regRequisitos.setLocationRelativeTo(null);

  }

  public void cargarEscuelas() {
    ArrayList<String> escuelas = consultarEscuelas.consultar();
    ArrayList<String> codigos = consultarCodigos.consultar();  //Esto es para inicializar la lista global de curso registrados en el sistema
    for (String escuela : escuelas)
    {
      regRequisitos.CBEscuelas_Cursos.addItem(escuela);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == regRequisitos.btnRegistrarCorrequisito){
      consultarCodigos.consultar();
      String CodigoCURSO = regRequisitos.CBcodigos_cursos.getSelectedItem().toString();
      String CodigoCORREQUISITO = regRequisitos.CBcorrequisitos.getSelectedItem().toString();
      for (int i = 0; i < CursoCRUD.cursosObj.size(); i++)
        if (CodigoCURSO.equals(CursoCRUD.cursosObj.get(i).getIdCurso()) == true){  
          System.out.println("Este es el código del root que me llega: " + CursoCRUD.cursosObj.get(i).getIdCurso());
          curso = CursoCRUD.cursosObj.get(i);  //Definir el curso especifico al cual se le registra el corequisito 
          
          for (int z = 0; z < CursoCRUD.cursosObj.size(); z++){
            
            if (CodigoCORREQUISITO.equals(CursoCRUD.cursosObj.get(z).getIdCurso()) == true){   // Validar curso co-rrequisito
              System.out.println("Este es el código del correquisito que me llega: " + CursoCRUD.cursosObj.get(z).getIdCurso());
              curso.getCorrequisitos().add(CursoCRUD.cursosObj.get(z)); //Agregar el correquisito a la lista de correquisitos del curso 
              curso.setAuxCorrequisitos(CursoCRUD.cursosObj.get(z).getIdCurso()); //Agregar el ID del correquisito al curso (REF)
            }
          }
        } else {
          System.out.println("No se encontró el codigo de la escuela ");
        }
      
      if (consultarCodigos.registrarCorrequisito(curso)){ //Llamar el método de registro de Correquisito en Mysql
        JOptionPane.showMessageDialog(null, "Correquisito Registrado");
      } else {
        JOptionPane.showMessageDialog(null, "Error al registrar el correquisito");
      }
    }
    if (e.getSource() == regRequisitos.btnRegistrarRequisito) {
      String CodigoCURSO = regRequisitos.CBcodigos_cursos.getSelectedItem().toString();
      String CodigoRREQUISITO = regRequisitos.CBrequisitos.getSelectedItem().toString();
      for (int i = 0; i < CursoCRUD.cursosObj.size(); i++) {

        if (CodigoCURSO.equals(CursoCRUD.cursosObj.get(i).getIdCurso()) == true){       // Validar curso root
          System.out.println("Este es el código del root que me llega: " + CursoCRUD.cursosObj.get(i).getIdCurso());

          curso = CursoCRUD.cursosObj.get(i);  //Definir el curso especifico al cual se le registra el requisito

          for (int z = 0; z < CursoCRUD.cursosObj.size(); z++)
          {

            if (CodigoRREQUISITO.equals(CursoCRUD.cursosObj.get(z).getIdCurso()) == true)
            {   // Validar curso rrequisito

              System.out.println("Este es el código del requisito que me llega: " + CursoCRUD.cursosObj.get(z).getIdCurso());

              curso.getRequisitos().add(CursoCRUD.cursosObj.get(z)); //Agregar el rrequisito a la lista de correquisitos del curso 

              curso.setAuxRrequisitos(CursoCRUD.cursosObj.get(z).getIdCurso()); //Agregar el ID del rrequisito al curso (REF)

            }

          }

        } else
        {

          System.out.println("No se encontró el codigo de la escuela ");

        }

      }

      if (consultarCodigos.registrarRequisito(curso))
      {    //Llamar el método de registro de Requisito en Mysql

        JOptionPane.showMessageDialog(null, "Requisito Registrado");

      } else
      {

        JOptionPane.showMessageDialog(null, "Error al registrar el correquisito");

      }

    }

    if (e.getSource() == regRequisitos.btnCargarCursos)
    {
      regRequisitos.CBcodigos_cursos.removeAllItems();
      regRequisitos.CBcorrequisitos.removeAllItems();
      regRequisitos.CBrequisitos.removeAllItems();

      String codigo = consultarEscuelas.obtenerEscuelaID(EscuelaCRUD.ESCUELAOBJ, regRequisitos.CBEscuelas_Cursos.getSelectedItem().toString());
      System.out.println("Mae este es el codigo que mellega de su metodo:" + codigo);
      ArrayList<String> codigos = consultarCodigos.consultarCodigos(codigo);
      for (String code : codigos)
      {
        regRequisitos.CBcodigos_cursos.addItem(code);
        regRequisitos.CBcorrequisitos.addItem(code);
        regRequisitos.CBrequisitos.addItem(code);
      }
    }

    if (e.getSource() == regRequisitos.btnVolver)
    {
      regRequisitos.setVisible(false);
    }

  }

}
