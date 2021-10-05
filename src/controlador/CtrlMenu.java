/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Escuela;
import modelo.EscuelaCRUD;
import vista.Menu;
import vista.RegistrarEscuela;

/**
 *
 * @author Gustavo
 */
public class CtrlMenu implements ActionListener {
  private Menu menu;
  
  public CtrlMenu(Menu pMenu){
    this.menu = pMenu;
    this.menu.btnRegistrarEscuela.addActionListener(this);
  }
  
  public void iniciar(){
    menu.setTitle("Gestor de Planes de Estudio");
    menu.setLocationRelativeTo(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == menu.btnRegistrarEscuela){
      Escuela escuela = new Escuela();
      EscuelaCRUD escuelaCrud = new EscuelaCRUD();
      RegistrarEscuela regEscuela = new RegistrarEscuela();
        
      CtrlEscuela ctrlEscuela = new CtrlEscuela(escuela, escuelaCrud, regEscuela);
      ctrlEscuela.iniciar();
      regEscuela.setVisible(true);
    }
  }
  
}
