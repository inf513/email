package com.grupo06sa.emailweb.modelos;
// Generated 25-06-2017 07:52:36 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Spequipo generated by hbm2java
 */
public class Spequipo  implements java.io.Serializable {


     private int pkequipo;
     private Speqmodelo speqmodelo;
     private Speqtipo speqtipo;
     private Spordentrabajo spordentrabajo;
     private String codigo;
     private char fktipocontrato;
     private Date fechaingreso;
     private String descripcion;
     private Set sppartediarios = new HashSet(0);
     private Set spdettransfequipos = new HashSet(0);

    public Spequipo() {
    }

	
    public Spequipo(int pkequipo, Speqmodelo speqmodelo, Speqtipo speqtipo, Spordentrabajo spordentrabajo, String codigo, char fktipocontrato) {
        this.pkequipo = pkequipo;
        this.speqmodelo = speqmodelo;
        this.speqtipo = speqtipo;
        this.spordentrabajo = spordentrabajo;
        this.codigo = codigo;
        this.fktipocontrato = fktipocontrato;
    }
    public Spequipo(int pkequipo, Speqmodelo speqmodelo, Speqtipo speqtipo, Spordentrabajo spordentrabajo, String codigo, char fktipocontrato, Date fechaingreso, String descripcion, Set sppartediarios, Set spdettransfequipos) {
       this.pkequipo = pkequipo;
       this.speqmodelo = speqmodelo;
       this.speqtipo = speqtipo;
       this.spordentrabajo = spordentrabajo;
       this.codigo = codigo;
       this.fktipocontrato = fktipocontrato;
       this.fechaingreso = fechaingreso;
       this.descripcion = descripcion;
       this.sppartediarios = sppartediarios;
       this.spdettransfequipos = spdettransfequipos;
    }
   
    public int getPkequipo() {
        return this.pkequipo;
    }
    
    public void setPkequipo(int pkequipo) {
        this.pkequipo = pkequipo;
    }
    public Speqmodelo getSpeqmodelo() {
        return this.speqmodelo;
    }
    
    public void setSpeqmodelo(Speqmodelo speqmodelo) {
        this.speqmodelo = speqmodelo;
    }
    public Speqtipo getSpeqtipo() {
        return this.speqtipo;
    }
    
    public void setSpeqtipo(Speqtipo speqtipo) {
        this.speqtipo = speqtipo;
    }
    public Spordentrabajo getSpordentrabajo() {
        return this.spordentrabajo;
    }
    
    public void setSpordentrabajo(Spordentrabajo spordentrabajo) {
        this.spordentrabajo = spordentrabajo;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public char getFktipocontrato() {
        return this.fktipocontrato;
    }
    
    public void setFktipocontrato(char fktipocontrato) {
        this.fktipocontrato = fktipocontrato;
    }
    public Date getFechaingreso() {
        return this.fechaingreso;
    }
    
    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getSppartediarios() {
        return this.sppartediarios;
    }
    
    public void setSppartediarios(Set sppartediarios) {
        this.sppartediarios = sppartediarios;
    }
    public Set getSpdettransfequipos() {
        return this.spdettransfequipos;
    }
    
    public void setSpdettransfequipos(Set spdettransfequipos) {
        this.spdettransfequipos = spdettransfequipos;
    }




}


