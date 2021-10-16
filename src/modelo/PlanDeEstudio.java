package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase con la información de los planes de estudio.
 * 
 * @author Sebastián
 * @version 13/10/2021
 */
public class PlanDeEstudio {
  //Atributos de clase
  private int id;
  private Escuela escuelaPropietaria;
  private Date fechaVigencia;
  private String bloques;
  private String codigoCurso;

  /**
   * Constructor por defecto
   */
  public PlanDeEstudio() {
  }

  /**
   * Constructor de la clase con parámetros
   * 
   * @param pId                 el identifcador del plan de estudios
   * @param pEscuelaPropietaria objeto Escuela que es propietaria del plan de estudios
   * @param pFechaVigencia      fecha de vigencia del plan de estudios
   * @param pBloques            número de bloques del plan de estudios
   * @param pCodigoCurso        el identificador del curso
   */
  public PlanDeEstudio(int pId, Escuela pEscuelaPropietaria, Date pFechaVigencia, String pBloques, String pCodigoCurso) {
    this.id = pId;
    this.escuelaPropietaria = pEscuelaPropietaria;
    this.fechaVigencia = pFechaVigencia;
    this.bloques = pBloques;
    this.codigoCurso = pCodigoCurso;
  }

  //Métodos accesores
  public int getiD() {
    return this.id;
  }

  public void setiD(int pId) {
    this.id = pId;
  }

  public Date getFechaVigencia() {
    return fechaVigencia;
  }

  public void setFechaVigencia(Date pFechaVigencia) {
    this.fechaVigencia = pFechaVigencia;
  }

  public Escuela getEscuelaPropietaria() {
    return escuelaPropietaria;
  }

  public String getCodigoCurso() {
    return codigoCurso;
  }

  public void setCodigoCurso(String CodigoCurso) {
    this.codigoCurso = CodigoCurso;
  }

  public void setEscuelaPropietaria(String EscuelaPropietaria, ArrayList<Escuela> Escuelas) {
    for (int i = 0; i < Escuelas.size(); i++){
      if (EscuelaPropietaria.equals(Escuelas.get(i).getNombre()) == true){
        this.setEscuelaPropietaria(Escuelas.get(i));
      }
    }
  }

  public void setEscuelaPropietaria(Escuela pEscuelaPropietaria) {
    this.escuelaPropietaria = pEscuelaPropietaria;
  }

  public String getBloques() {
    return bloques;
  }

  public void setBloques(String pBloques) {
    this.bloques = pBloques;
  }
}
