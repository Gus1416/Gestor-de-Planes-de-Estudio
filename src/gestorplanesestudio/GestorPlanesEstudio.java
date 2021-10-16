package gestorplanesestudio;

import controlador.CtrlMenu;
import vista.Menu;

/**
 * Clase principal que ejecuta el programa.
 * 
 * @author Gustavo, Sebastián, María Laura
 * @version 26/09/2021 
 */
public class GestorPlanesEstudio {
  
  /**
   * Método main que inicializa el menú principal
   * 
   * @param args argumentos de línea de comandos
   */
  public static void main(String[] args) {
    Menu menu = new Menu();
    CtrlMenu ctrlMenu = new CtrlMenu(menu);
    ctrlMenu.iniciar();
    menu.setVisible(true);
  }
}
