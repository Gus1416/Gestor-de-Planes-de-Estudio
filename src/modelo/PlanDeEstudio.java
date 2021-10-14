package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sebcor
 */
public class PlanDeEstudio {
  private int iD;
  private Escuela EscuelaPropietaria;
  private Date fechaVigencia;
  private String bloques;
  private String CodigoCurso;

  public PlanDeEstudio() {

  }

  public PlanDeEstudio(int iD, Escuela EscuelaPropietaria, Date fechaVigencia, String bloques, String CodigoCurso) {
    this.iD = iD;
    this.EscuelaPropietaria = EscuelaPropietaria;
    this.fechaVigencia = fechaVigencia;
    this.bloques = bloques;
    this.CodigoCurso = CodigoCurso;
  }

  /**
   * @return the iD
   */
  public int getiD() {
    return iD;
  }

  /**
   * @param iD the iD to set
   */
  public void setiD(int iD) {
    this.iD = iD;
  }

  /**
   * @return the fechaVigencia
   */
  public Date getFechaVigencia() {
    return fechaVigencia;
  }

  /**
   * @param fechaVigencia the fechaVigencia to set
   */
  public void setFechaVigencia(Date fechaVigencia) {
    this.fechaVigencia = fechaVigencia;
  }

  public Escuela getEscuelaPropietaria() {
    return EscuelaPropietaria;
  }

  public String getCodigoCurso() {
    return CodigoCurso;
  }

  public void setCodigoCurso(String CodigoCurso) {
    this.CodigoCurso = CodigoCurso;
  }

  public void setEscuelaPropietaria(String EscuelaPropietaria, ArrayList<Escuela> Escuelas) {
    for (int i = 0; i < Escuelas.size(); i++){
      if (EscuelaPropietaria.equals(Escuelas.get(i).getNombre()) == true){
        this.setEscuelaPropietaria(Escuelas.get(i));
      } 
    }
  }

  /**
   * @param EscuelaPropietaria the EscuelaPropietaria to set
   */
  public void setEscuelaPropietaria(Escuela EscuelaPropietaria) {
    this.EscuelaPropietaria = EscuelaPropietaria;
  }

  /**
   * @return the bloques
   */
  public String getBloques() {
    return bloques;
  }

  /**
   * @param bloques the bloques to set
   */
  public void setBloques(String bloques) {
    this.bloques = bloques;
  }
}
