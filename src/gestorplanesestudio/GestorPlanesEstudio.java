package gestorplanesestudio;

import controlador.CtrlEscuela;
import modelo.Escuela;
import modelo.EscuelaCRUD;
import vista.RegistrarEscuela;

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
        RegistrarEscuela regEscuela = new RegistrarEscuela();
        
        CtrlEscuela ctrlEscuela = new CtrlEscuela(escuela, escuelaCrud, regEscuela);
        ctrlEscuela.iniciar();
        regEscuela.setVisible(true);
    }
    
}
