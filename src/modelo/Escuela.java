package modelo;

/**
 * Clase con la información de las escuelas.
 * 
 * @author Gustavo
 * @version 05/10/2021
 */
public class Escuela {
  //Atributos de clase
  private String nombre;
  private String codigo;
    
  /**
   * Constructor por defecto.
   */
  public Escuela(){
  }

  /**
   * Constructor con parámetros.
   * 
   * @param pNombre el nombre de la escuela
   * @param pCodigo el código de la escuela
   */
  public Escuela(String pNombre, String pCodigo) {
    this.nombre = pNombre;
    this.codigo = pCodigo;
  }
  
  //Métodos accesores
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
