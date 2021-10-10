/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Maria Laura
 */
public class Curso {
    
private String idCurso; 
private String nombreCurso;
private String creditos;
private String horasLectivas;
private String escuela;

private String auxCorrequisitos;
private String auxRrequisitos;

private ArrayList<Curso> correquisitos = new ArrayList<>();
private ArrayList<Curso> requisitos = new ArrayList<>();


public Curso(){
}



    public Curso(String idCurso, String nombreCurso, String creditos, String horasLectivas, String escuela, String auxCorrequisitos, String auxRrequisitos, ArrayList<Curso> correquisitos, ArrayList<Curso> requisitos) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.creditos = creditos;
        this.horasLectivas = horasLectivas;
        this.escuela = escuela;
        this.auxCorrequisitos = auxCorrequisitos;
        this.auxRrequisitos = auxRrequisitos;
        this.correquisitos = correquisitos;
        this.requisitos = requisitos;
    }

    



/**
public Curso (String pIdCurso, String pNombre, int pCreditos, int pHorasLectivas){
    this.idCurso=pIdCurso;
    this.nombreCurso=pNombre;
    this.creditos=pCreditos;
    this.horasLectivas=pHorasLectivas;


 
 *  
* 
* 
* 
* 
    /**
     * @return the idCurso
     */

    public String getEscuela(){
        return escuela;
    }
    public void setEscuela(String pEscuela){
        this.escuela=pEscuela;
    }
    
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

    public ArrayList<Curso> getCorrequisitos() {
        return correquisitos;
    }

    public void setCorrequisitos(ArrayList<Curso> correquisitos) {
        this.correquisitos = correquisitos;
    }

    public ArrayList<Curso> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(ArrayList<Curso> requisitos) {
        this.requisitos = requisitos;
    }

   

    public Curso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getAuxCorrequisitos() {
        return auxCorrequisitos;
    }

    public void setAuxCorrequisitos(String auxCorrequisitos) {
        this.auxCorrequisitos = auxCorrequisitos;
    }

    public String getAuxRrequisitos() {
        return auxRrequisitos;
    }

    public void setAuxRrequisitos(String auxRrequisitos) {
        this.auxRrequisitos = auxRrequisitos;
    }
    
    
    
    
    
    
    
}