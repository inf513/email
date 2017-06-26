package com.grupo06sa.emailweb.modelos;
// Generated 25-06-2017 07:52:36 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Sppartediario generated by hbm2java
 */
public class Sppartediario  implements java.io.Serializable {


     private int pkpartediario;
     private Spequipo spequipo;
     private Spordentrabajo spordentrabajo;
     private Sppersonal sppersonalByFkoperador;
     private Sppersonal sppersonalByFkayudante;
     private Spturno spturno;
     private Date fecha;
     private String observacion;
     private Set spdetproductivas = new HashSet(0);
     private Set spdetimproductivas = new HashSet(0);

    public Sppartediario() {
    }

	
    public Sppartediario(int pkpartediario, Spequipo spequipo, Spordentrabajo spordentrabajo, Sppersonal sppersonalByFkoperador, Sppersonal sppersonalByFkayudante, Spturno spturno, Date fecha) {
        this.pkpartediario = pkpartediario;
        this.spequipo = spequipo;
        this.spordentrabajo = spordentrabajo;
        this.sppersonalByFkoperador = sppersonalByFkoperador;
        this.sppersonalByFkayudante = sppersonalByFkayudante;
        this.spturno = spturno;
        this.fecha = fecha;
    }
    public Sppartediario(int pkpartediario, Spequipo spequipo, Spordentrabajo spordentrabajo, Sppersonal sppersonalByFkoperador, Sppersonal sppersonalByFkayudante, Spturno spturno, Date fecha, String observacion, Set spdetproductivas, Set spdetimproductivas) {
       this.pkpartediario = pkpartediario;
       this.spequipo = spequipo;
       this.spordentrabajo = spordentrabajo;
       this.sppersonalByFkoperador = sppersonalByFkoperador;
       this.sppersonalByFkayudante = sppersonalByFkayudante;
       this.spturno = spturno;
       this.fecha = fecha;
       this.observacion = observacion;
       this.spdetproductivas = spdetproductivas;
       this.spdetimproductivas = spdetimproductivas;
    }
   
    public int getPkpartediario() {
        return this.pkpartediario;
    }
    
    public void setPkpartediario(int pkpartediario) {
        this.pkpartediario = pkpartediario;
    }
    public Spequipo getSpequipo() {
        return this.spequipo;
    }
    
    public void setSpequipo(Spequipo spequipo) {
        this.spequipo = spequipo;
    }
    public Spordentrabajo getSpordentrabajo() {
        return this.spordentrabajo;
    }
    
    public void setSpordentrabajo(Spordentrabajo spordentrabajo) {
        this.spordentrabajo = spordentrabajo;
    }
    public Sppersonal getSppersonalByFkoperador() {
        return this.sppersonalByFkoperador;
    }
    
    public void setSppersonalByFkoperador(Sppersonal sppersonalByFkoperador) {
        this.sppersonalByFkoperador = sppersonalByFkoperador;
    }
    public Sppersonal getSppersonalByFkayudante() {
        return this.sppersonalByFkayudante;
    }
    
    public void setSppersonalByFkayudante(Sppersonal sppersonalByFkayudante) {
        this.sppersonalByFkayudante = sppersonalByFkayudante;
    }
    public Spturno getSpturno() {
        return this.spturno;
    }
    
    public void setSpturno(Spturno spturno) {
        this.spturno = spturno;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Set getSpdetproductivas() {
        return this.spdetproductivas;
    }
    
    public void setSpdetproductivas(Set spdetproductivas) {
        this.spdetproductivas = spdetproductivas;
    }
    public Set getSpdetimproductivas() {
        return this.spdetimproductivas;
    }
    
    public void setSpdetimproductivas(Set spdetimproductivas) {
        this.spdetimproductivas = spdetimproductivas;
    }




}


