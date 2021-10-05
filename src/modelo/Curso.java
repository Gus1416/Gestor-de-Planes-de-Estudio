/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Maria Laura
 */
public class Curso {
    
private String idCurso; 
private String nombreCurso;
private String creditos;
private String horasLectivas;

/**
private ArrayList<Correquisitos> correquisitos;
private ArrayList<Requisitos> requisitos;
*/

public Curso(){
}
/**
public Curso (String pIdCurso, String pNombre, int pCreditos, int pHorasLectivas){
    this.idCurso=pIdCurso;
    this.nombreCurso=pNombre;
    this.creditos=pCreditos;
    this.horasLectivas=pHorasLectivas;
}
*¨/
/**
 * 
 * @param Requisito 
 */
/**public void agregarRequisito(Requisito pRequisito){
    requisitos.add(pRequisito);
}
/**
 * 
 * @param Correquisito 
 */
/**public void agregarCorrequisito(Correquisito pCorrequisito){
    requisitos.add(pCorrequisito);
    * 
}
*  */

    /**
     * @return the idCurso
     */
    public String getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * @return the nombreCurso
     */
    public String getNombreCurso() {
        return nombreCurso;
    }

    /**
     * @param nombreCurso the nombreCurso to set
     */
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    /**
     * @return the creditos
     */
    public String getCreditos() {
        return creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    /**
     * @return the horasLectivas
     */
    public String getHorasLectivas() {
        return horasLectivas;
    }

    /**
     * @param horasLectivas the horasLectivas to set
     */
    public void setHorasLectivas(String horasLectivas) {
        this.horasLectivas = horasLectivas;
    }

}
