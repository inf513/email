package com.grupo06sa.emailweb.modelos;
// Generated 25-06-2017 07:52:36 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Spdetimproductiva generated by hbm2java
 */
public class Spdetimproductiva  implements java.io.Serializable {


     private int pkdetimproductiva;
     private Spimproductiva spimproductiva;
     private Sppartediario sppartediario;
     private Integer nroitem;
     private BigDecimal hrs;

    public Spdetimproductiva() {
    }

	
    public Spdetimproductiva(int pkdetimproductiva, Spimproductiva spimproductiva, Sppartediario sppartediario) {
        this.pkdetimproductiva = pkdetimproductiva;
        this.spimproductiva = spimproductiva;
        this.sppartediario = sppartediario;
    }
    public Spdetimproductiva(int pkdetimproductiva, Spimproductiva spimproductiva, Sppartediario sppartediario, Integer nroitem, BigDecimal hrs) {
       this.pkdetimproductiva = pkdetimproductiva;
       this.spimproductiva = spimproductiva;
       this.sppartediario = sppartediario;
       this.nroitem = nroitem;
       this.hrs = hrs;
    }
   
    public int getPkdetimproductiva() {
        return this.pkdetimproductiva;
    }
    
    public void setPkdetimproductiva(int pkdetimproductiva) {
        this.pkdetimproductiva = pkdetimproductiva;
    }
    public Spimproductiva getSpimproductiva() {
        return this.spimproductiva;
    }
    
    public void setSpimproductiva(Spimproductiva spimproductiva) {
        this.spimproductiva = spimproductiva;
    }
    public Sppartediario getSppartediario() {
        return this.sppartediario;
    }
    
    public void setSppartediario(Sppartediario sppartediario) {
        this.sppartediario = sppartediario;
    }
    public Integer getNroitem() {
        return this.nroitem;
    }
    
    public void setNroitem(Integer nroitem) {
        this.nroitem = nroitem;
    }
    public BigDecimal getHrs() {
        return this.hrs;
    }
    
    public void setHrs(BigDecimal hrs) {
        this.hrs = hrs;
    }




}


