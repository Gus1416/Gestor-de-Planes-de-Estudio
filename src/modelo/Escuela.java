package modelo;

import java.util.ArrayList;

/**
 * Abstracción de clase escuela
 * 
 * @author Gustavo
 * @version 1.0 26/09/2021
 */
public class Escuela {
  private String nombre;
  private String codigo;
  //private ArrayList<PlanesEstudio> planesEstudio;
    
  public Escuela(){
    
  }

    public Escuela(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

  
  
  
  /**
   * Métodos accesores
   */
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String pCodigo) {
    this.codigo = pCodigo;
  }
}
