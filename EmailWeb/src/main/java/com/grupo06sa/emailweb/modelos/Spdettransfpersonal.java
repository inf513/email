package com.grupo06sa.emailweb.modelos;
// Generated 25-06-2017 07:52:36 PM by Hibernate Tools 4.3.1



/**
 * Spdettransfpersonal generated by hbm2java
 */
public class Spdettransfpersonal  implements java.io.Serializable {


     private int pkdettransfpersonal;
     private Sppersonal sppersonal;
     private Sptransfpersonal sptransfpersonal;
     private Integer item;
     private String observacion;

    public Spdettransfpersonal() {
    }

	
    public Spdettransfpersonal(int pkdettransfpersonal, Sppersonal sppersonal, Sptransfpersonal sptransfpersonal) {
        this.pkdettransfpersonal = pkdettransfpersonal;
        this.sppersonal = sppersonal;
        this.sptransfpersonal = sptransfpersonal;
    }
    public Spdettransfpersonal(int pkdettransfpersonal, Sppersonal sppersonal, Sptransfpersonal sptransfpersonal, Integer item, String observacion) {
       this.pkdettransfpersonal = pkdettransfpersonal;
       this.sppersonal = sppersonal;
       this.sptransfpersonal = sptransfpersonal;
       this.item = item;
       this.observacion = observacion;
    }
   
    public int getPkdettransfpersonal() {
        return this.pkdettransfpersonal;
    }
    
    public void setPkdettransfpersonal(int pkdettransfpersonal) {
        this.pkdettransfpersonal = pkdettransfpersonal;
    }
    public Sppersonal getSppersonal() {
        return this.sppersonal;
    }
    
    public void setSppersonal(Sppersonal sppersonal) {
        this.sppersonal = sppersonal;
    }
    public Sptransfpersonal getSptransfpersonal() {
        return this.sptransfpersonal;
    }
    
    public void setSptransfpersonal(Sptransfpersonal sptransfpersonal) {
        this.sptransfpersonal = sptransfpersonal;
    }
    public Integer getItem() {
        return this.item;
    }
    
    public void setItem(Integer item) {
        this.item = item;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }




}

