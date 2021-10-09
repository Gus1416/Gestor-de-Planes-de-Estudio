/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sebcor
 */

public class PlanDeEstudio {
    
    private int iD;
    private Escuela EscuelaPropietaria;
    private LocalDate fechaVigencia;
    private String bloques;
    private String CodigoCurso;

    public PlanDeEstudio() {
   
    }

    public PlanDeEstudio(int iD, Escuela EscuelaPropietaria, LocalDate fechaVigencia, String bloques, String CodigoCurso) {
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
    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * @param fechaVigencia the fechaVigencia to set
     */
    public void setFechaVigencia(LocalDate fechaVigencia) {
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
        System.out.println("");
        System.out.println("");
        System.out.println("Este es el nombre de la escuela que me llega bro: " + EscuelaPropietaria);
        
       // System.out.println("Este es el size del array que me llegó " + Escuelas.size());
        
        for(int i=0 ; i< Escuelas.size(); i++){
            
            System.out.println("Nombre de las escuelas que me llegan:" + Escuelas.get(i).getNombre());
            
            if(EscuelaPropietaria.equals(Escuelas.get(i).getNombre()) == true){
                this.setEscuelaPropietaria(Escuelas.get(i));
                System.out.println("MAE ENCONTRÉ LA ESCUELA :) ");
            }   
            else{
                
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
