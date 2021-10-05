package gestorplanesestudio;

import controlador.CtrlEscuela;
import modelo.Escuela;
import modelo.EscuelaCRUD;
import vista.registrarEscuela;
import modelo.Curso;
import modelo.CursoCRUD;
import vista.RegistroCurso;
import controlador.CtrlCurso;


/**
 * Main class
 * 
 * @author Gustavo
 * @version 1.0 26/09/2021 
 */
public class GestorPlanesEstudio {

    /**
     * Main method
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Escuela escuela = new Escuela();
        EscuelaCRUD escuelaCrud = new EscuelaCRUD();
        registrarEscuela regEscuela = new registrarEscuela();
        
        CtrlEscuela ctrlEscuela = new CtrlEscuela(escuela, escuelaCrud, regEscuela);
        ctrlEscuela.iniciar();
        regEscuela.setVisible(true);
        
        Curso curso= new Curso();
        CursoCRUD cursoCrud= new CursoCRUD();
        RegistroCurso regCurso= new RegistroCurso();
        
        CtrlCurso ctrlCurso = new CtrlCurso(curso,cursoCrud, regCurso);
        ctrlCurso.iniciar();
        regCurso.setVisible(true);
    }
    
}
