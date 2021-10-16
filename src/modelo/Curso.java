package modelo;

import java.util.ArrayList;

/**
 * Clase que contiene la información de los cursos.
 *
 * @author Maria Laura
 * @version 07/10/2021
 */
public class Curso {
//Atributos de clase
  private String idCurso;
  private String nombreCurso;
  private String creditos;
  private String horasLectivas;
  private String escuela;
  private String auxCorrequisitos;
  private String auxRrequisitos;
  private ArrayList<Curso> correquisitos = new ArrayList<>();
  private ArrayList<Curso> requisitos = new ArrayList<>();

  /**
   * Constructor por defecto
   */
  public Curso(){
    
  }

  /**
   * Constructor con parámetros.
   * 
   * @param pIdCurso           identificador del curso
   * @param pNombreCurso       nombre del curso
   * @param pCreditos          cantidad de créditos del curso
   * @param pHorasLectivas     cantidad de horas lectivas del curso
   * @param pEscuela           nombre de la escuela propietaria del curso
   * @param pAuxCorrequisitos  nombre del curso correquisito del curso
   * @param pAuxRrequisitos    nombre del curso requisito del curso
   * @param pCorrequisitos     lista de correquisitos del curso
   * @param pRequisitos        lista de requisitos del curso
   */
  public Curso(String pIdCurso, String pNombreCurso, String pCreditos, String pHorasLectivas, 
          String pEscuela, String pAuxCorrequisitos, String pAuxRrequisitos, ArrayList<Curso> pCorrequisitos, 
          ArrayList<Curso> pRequisitos) {
    this.idCurso = pIdCurso;
    this.nombreCurso = pNombreCurso;
    this.creditos = pCreditos;
    this.horasLectivas = pHorasLectivas;
    this.escuela = pEscuela;
    this.auxCorrequisitos = pAuxCorrequisitos;
    this.auxRrequisitos = pAuxRrequisitos;
    this.correquisitos = pCorrequisitos;
    this.requisitos = pRequisitos;
  }

  //Métodos accesores
  public String getEscuela() {
    return escuela;
  }

  public void setEscuela(String pEscuela) {
    this.escuela = pEscuela;
  }

  public String getIdCurso() {
    return idCurso;
  }

  public void setIdCurso(String pIdCurso) {
    this.idCurso = pIdCurso;
  }

  public String getNombreCurso() {
    return nombreCurso;
  }

  public void setNombreCurso(String pNombreCurso) {
    this.nombreCurso = pNombreCurso;
  }

  public String getCreditos() {
    return creditos;
  }

  public void setCreditos(String pCreditos) {
    this.creditos = pCreditos;
  }

  public String getHorasLectivas() {
    return horasLectivas;
  }

  public void setHorasLectivas(String pHorasLectivas) {
    this.horasLectivas = pHorasLectivas;
  }

  public ArrayList<Curso> getCorrequisitos() {
    return correquisitos;
  }

  public void setCorrequisitos(ArrayList<Curso> pCorrequisitos) {
    this.correquisitos = pCorrequisitos;
  }

  public ArrayList<Curso> getRequisitos() {
    return requisitos;
  }

  public void setRequisitos(ArrayList<Curso> pRequisitos) {
    this.requisitos = pRequisitos;
  }

  public Curso(String pIdCurso) {
    this.idCurso = pIdCurso;
  }

  public String getAuxCorrequisitos() {
    return auxCorrequisitos;
  }

  public void setAuxCorrequisitos(String pAuxCorrequisitos) {
    this.auxCorrequisitos = pAuxCorrequisitos;
  }

  public String getAuxRrequisitos() {
    return auxRrequisitos;
  }

  public void setAuxRrequisitos(String pAuxRrequisitos) {
    this.auxRrequisitos = pAuxRrequisitos;
  }
}
