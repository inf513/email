/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Sppersonal;

/**
 *
 * @author gabriel
 */
public class Personal {
    
    public  String validarPersonal(Sppersonal per){
        String data="";
        
        if (per.getSpcargo()==null) {
            data += "Gestion es necesaria ";
        } 
        if (per.getSpordentrabajo()==null) {
            
            
        }
         if (per.getFechaingreso()==null) {
            
            
        }
          if (per.getNombrecomp()==null) {
            
            
        } if (per.getApellidos()==null) {
            
            
        } if (per.getDireccion()==null) {
            
            
        } if (per.getTelefono()==null) {
            
            
        } if (per.getEmail()==null) {
            
            
        } if (per.getCi()==null) {
            
            
        }
        
         if (per.getFechanac()==null) {
            
            
        }
         
        return data;
        /*
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
        */
        
    
}
    
    public  Sppersonal getParser(String data){
        Sppersonal per =null;
        
        data = data.replace("[", "");
        data = data.replace("]", "");
        String[] datos = data.split(",");
  
        if(datos.length != 10) return per;
        
        if(FuncionesComunes.esNumero(datos[0])){
            per = new Sppersonal();
            per.setPkpersonal(Integer.valueOf(datos[0]));
            if(FuncionesComunes.esNumero(datos[1])){
                
                per.setSpcargo(spcargo);;
                if (FuncionesComunes.esNumero(datos[2])) {
                    per.setSpordentrabajo(spordentrabajo);
                }
                
            }
        }
    }
}
  /*                    
            if(FuncionesComunes.esNumero(datos[1])){
                Spgestion g = Gestion.consultarPorId(Integer.parseInt(datos[1]));
                ot.setSpgestion(g);
                if(datos[2].length()>0){ // codigo
                    ot.setCodigo(datos[2]);
                    if(datos[3].length()>0){ // nombre
                        ot.setNombre(datos[3]);
                        if(datos[4].length()>0){//supervisor
                            ot.setSupervisor(datos[4]);
                            if(FuncionesComunes.esNumero(datos[5])){
                                ot.setAreaestimada( new BigDecimal(datos[5]));
                                ot.setEstado('T');
                                ot.setData(ot.getCodigo()+"-"+g.getCodigo());
                            }
                        }
                    }
                }
            }
        }
    }

    
    
}


