/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author sebcor
 */

public class PlanDeEstudio {
    
    private String iD;
    private Escuela EscuelaPropietaria;
    private LocalDate fechaVigencia;
    private ArrayList bloques;
    private String CodigoCurso;

    public PlanDeEstudio() {
   
    }

       
    public PlanDeEstudio(String iD, Escuela EscuelaPropietaria, LocalDate fechaVigencia, ArrayList bloques) {
        this.iD = iD;
        this.EscuelaPropietaria = EscuelaPropietaria;
        this.fechaVigencia = fechaVigencia;
        this.bloques = bloques;
    }
 
    
    /**
     * @return the iD
     */
    public String getiD() {
        return iD;
    }

    /**
     * @param iD the iD to set
     */
    public void setiD(String iD) {
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

    /**
     * @return the bloques
     */
    public ArrayList getBloques() {
        return bloques;
    }

    /**
     * @param bloques the bloques to set
     */
    public void setBloques(String bloques) {
        this.bloques.add(bloques);
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
    
    
    
  
    

    public void setEscuelaPropietaria(String EscuelaPropietaria, ArrayList<Escuela> Escuelas ) {
        
        for(int i=0 ; i< Escuelas.size(); i++){ 
            if(EscuelaPropietaria.matches(Escuelas.get(i).getNombre())){
                this.setEscuelaPropietaria(Escuelas.get(i));
            }
            else{
                System.out.println("Escuela No Existe");
            }
            
        }    
        
    }

    /**
     * @param EscuelaPropietaria the EscuelaPropietaria to set
     */
    public void setEscuelaPropietaria(Escuela EscuelaPropietaria) {
        this.EscuelaPropietaria = EscuelaPropietaria;
    }
   
    
    
    
    
    
}
