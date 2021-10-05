package gestorplanesestudio;

import controlador.CtrlEscuela;
import controlador.CtrlPlanesEstudio;
import java.util.ArrayList;
import modelo.Escuela;
import modelo.EscuelaCRUD;
import modelo.PlanDeEstudio;
import modelo.PlanDeEstudioCRUD;
import vista.registrarEscuela;
import vista.registrarPlan;

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
        ArrayList<Escuela> escuelas = new ArrayList<Escuela>();
        
        CtrlEscuela ctrlEscuela = new CtrlEscuela(escuela, escuelaCrud, regEscuela,escuelas);
        ctrlEscuela.iniciar();
        regEscuela.setVisible(true);
        
        
        
       PlanDeEstudio plan = new PlanDeEstudio();
       PlanDeEstudioCRUD planCrud= new PlanDeEstudioCRUD();
       registrarPlan regPlan = new registrarPlan();
        
       CtrlPlanesEstudio ctrlPlan= new CtrlPlanesEstudio(plan,planCrud,regPlan);
        
       ctrlPlan.iniciar();
       regPlan.setVisible(true);
        
        
        
        
        
    }
    
}
