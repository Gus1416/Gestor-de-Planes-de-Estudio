package gestorplanesestudio;

import controlador.CtrlMenu;
import vista.Menu;

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
        Menu menu = new Menu();
        CtrlMenu ctrlMenu = new CtrlMenu(menu);
        ctrlMenu.iniciar();
        menu.setVisible(true);
    }
}
