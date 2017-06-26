package com.grupo06sa.emailweb.modelos;
// Generated 25-06-2017 07:52:36 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Sppersonal generated by hbm2java
 */
public class Sppersonal  implements java.io.Serializable {


     private int pkpersonal;
     private Spcargo spcargo;
     private Spordentrabajo spordentrabajo;
     private Date fechaingreso;
     private String nombrecomp;
     private String apellidos;
     private String direccion;
     private String telefono;
     private String email;
     private String ci;
     private Date fechanac;
     private Set sppartediariosForFkoperador = new HashSet(0);
     private Set sppartediariosForFkayudante = new HashSet(0);
     private Set spdettransfpersonals = new HashSet(0);

    public Sppersonal() {
    }

	
    public Sppersonal(int pkpersonal) {
        this.pkpersonal = pkpersonal;
    }
    public Sppersonal(int pkpersonal, Spcargo spcargo, Spordentrabajo spordentrabajo, Date fechaingreso, String nombrecomp, String apellidos, String direccion, String telefono, String email, String ci, Date fechanac, Set sppartediariosForFkoperador, Set sppartediariosForFkayudante, Set spdettransfpersonals) {
       this.pkpersonal = pkpersonal;
       this.spcargo = spcargo;
       this.spordentrabajo = spordentrabajo;
       this.fechaingreso = fechaingreso;
       this.nombrecomp = nombrecomp;
       this.apellidos = apellidos;
       this.direccion = direccion;
       this.telefono = telefono;
       this.email = email;
       this.ci = ci;
       this.fechanac = fechanac;
       this.sppartediariosForFkoperador = sppartediariosForFkoperador;
       this.sppartediariosForFkayudante = sppartediariosForFkayudante;
       this.spdettransfpersonals = spdettransfpersonals;
    }
   
    public int getPkpersonal() {
        return this.pkpersonal;
    }
    
    public void setPkpersonal(int pkpersonal) {
        this.pkpersonal = pkpersonal;
    }
    public Spcargo getSpcargo() {
        return this.spcargo;
    }
    
    public void setSpcargo(Spcargo spcargo) {
        this.spcargo = spcargo;
    }
    public Spordentrabajo getSpordentrabajo() {
        return this.spordentrabajo;
    }
    
    public void setSpordentrabajo(Spordentrabajo spordentrabajo) {
        this.spordentrabajo = spordentrabajo;
    }
    public Date getFechaingreso() {
        return this.fechaingreso;
    }
    
    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    public String getNombrecomp() {
        return this.nombrecomp;
    }
    
    public void setNombrecomp(String nombrecomp) {
        this.nombrecomp = nombrecomp;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCi() {
        return this.ci;
    }
    
    public void setCi(String ci) {
        this.ci = ci;
    }
    public Date getFechanac() {
        return this.fechanac;
    }
    
    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }
    public Set getSppartediariosForFkoperador() {
        return this.sppartediariosForFkoperador;
    }
    
    public void setSppartediariosForFkoperador(Set sppartediariosForFkoperador) {
        this.sppartediariosForFkoperador = sppartediariosForFkoperador;
    }
    public Set getSppartediariosForFkayudante() {
        return this.sppartediariosForFkayudante;
    }
    
    public void setSppartediariosForFkayudante(Set sppartediariosForFkayudante) {
        this.sppartediariosForFkayudante = sppartediariosForFkayudante;
    }
    public Set getSpdettransfpersonals() {
        return this.spdettransfpersonals;
    }
    
    public void setSpdettransfpersonals(Set spdettransfpersonals) {
        this.spdettransfpersonals = spdettransfpersonals;
    }




}


