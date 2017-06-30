package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spactividad;
import com.grupo06sa.emailweb.modelos.Spcargo;
import com.grupo06sa.emailweb.modelos.Spgestion;
import com.grupo06sa.emailweb.modelos.Spitemobra;
import com.grupo06sa.emailweb.modelos.Spordentrabajo;
import com.grupo06sa.emailweb.modelos.Sppoligono;
import java.io.File;
import java.util.List;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class HtmlFormat {
    public static String getFormatoCargo(List<Spcargo> cargos){
        String data = "<thead><tr>ENCABEZADO</tr></thead><tbody>DATA</tbody>";
        String head = "";
        String row  = "";
        
        head = head + HtmlFormat.getFormatHEAD("ID");
        head = head + HtmlFormat.getFormatHEAD("CODIGO");
        head = head + HtmlFormat.getFormatHEAD("DESCRIPCION");
        
        for(Spcargo cargo : cargos){
            row = row + "<tr>";
            row = row + HtmlFormat.getFormatDATA(String.valueOf(cargo.getPkcargo()));
            row = row + HtmlFormat.getFormatDATA(cargo.getCodigo());
            row = row + HtmlFormat.getFormatDATA(cargo.getDescripcion());
            row = row + "</tr>";
        }
            
        data = data.replace("ENCABEZADO", head);
        data = data.replace("DATA", row);
        return data;
    }
    public static String getFormatoActividad(List<Spactividad> actividades){
        String data = "<thead><tr>ENCABEZADO</tr></thead><tbody>DATA</tbody>";
        String head = "";
        String row  = "";
        
        head = head + HtmlFormat.getFormatHEAD("ID");
        //head = head + HtmlFormat.getFormatHEAD("ORDEN TRABAJO");
        head = head + HtmlFormat.getFormatHEAD("CODIGO");
        head = head + HtmlFormat.getFormatHEAD("DESCRIPCION");
        
        for(Spactividad actividad : actividades){
            //Spordentrabajo o = actividad.getSpordentrabajo();
            row = row + "<tr>";
            row = row + HtmlFormat.getFormatDATA(String.valueOf(actividad.getPkactividad()));
            //row = row + HtmlFormat.getFormatDATA(actividad.getSpordentrabajo().getData());
            row = row + HtmlFormat.getFormatDATA(actividad.getCodigo());
            row = row + HtmlFormat.getFormatDATA(actividad.getDescripcion());
            row = row + "</tr>";
        }            
        data = data.replace("ENCABEZADO", head);
        data = data.replace("DATA", row);
        return data;
    }
    public static String getFormatoGestion(List<Spgestion> gestiones){
        String data = "<thead><tr>ENCABEZADO</tr></thead><tbody>DATA</tbody>";
        String head = "";
        String row  = "";
        
        head = head + HtmlFormat.getFormatHEAD("ID");
        head = head + HtmlFormat.getFormatHEAD("CODIGO");
        head = head + HtmlFormat.getFormatHEAD("FECHA INICIAL");
        head = head + HtmlFormat.getFormatHEAD("FECHA FINAL");
        
        for(Spgestion gestion : gestiones){
            row = row + "<tr>";
            row = row + HtmlFormat.getFormatDATA(String.valueOf(gestion.getPkgestion()));
            row = row + HtmlFormat.getFormatDATA(gestion.getCodigo());
            row = row + HtmlFormat.getFormatDATA(gestion.getFechaini().toString());
            row = row + HtmlFormat.getFormatDATA(gestion.getFechafin().toString());
            row = row + "</tr>";
        }            
        data = data.replace("ENCABEZADO", head);
        data = data.replace("DATA", row);
        return data;
    }
    public static String getFormatoPoligono(List<Sppoligono> poligonos){
        String data = "<thead><tr>ENCABEZADO</tr></thead><tbody>DATA</tbody>";
        String head = "";
        String row  = "";
        
        head = head + HtmlFormat.getFormatHEAD("ID");
        //head = head + HtmlFormat.getFormatHEAD("ORDEN TRABAJO");
        head = head + HtmlFormat.getFormatHEAD("CODIGO");
        head = head + HtmlFormat.getFormatHEAD("DESCRIPCION");
        
        for(Sppoligono poligono : poligonos){
            row = row + "<tr>";
            row = row + HtmlFormat.getFormatDATA(String.valueOf(poligono.getPkpoligono()));
           //row = row + HtmlFormat.getFormatDATA(poligono.getSpordentrabajo().getData());
            row = row + HtmlFormat.getFormatDATA(poligono.getCodigo());
            row = row + HtmlFormat.getFormatDATA(poligono.getDescripcion());
            row = row + "</tr>";
        }            
        data = data.replace("ENCABEZADO", head);
        data = data.replace("DATA", row);
        return data;
    }
        
    public static String getFormatoOrdenTrabajo(List<Spordentrabajo> ordenes){
        String data = "<thead><tr>ENCABEZADO</tr></thead><tbody>DATA</tbody>";
        String head = "";
        String row  = "";
        
        head = head + HtmlFormat.getFormatHEAD("ID");
        head = head + HtmlFormat.getFormatHEAD("CODIGO");
        head = head + HtmlFormat.getFormatHEAD("NOMBRE");
        head = head + HtmlFormat.getFormatHEAD("AREA EST.(HA)");
        head = head + HtmlFormat.getFormatHEAD("SUPERVISOR");
        
        for(Spordentrabajo ot : ordenes){
            row = row + "<tr>";
            row = row + HtmlFormat.getFormatDATA(String.valueOf(ot.getPkordentrabajo()));
            row = row + HtmlFormat.getFormatDATA(ot.getData());
            row = row + HtmlFormat.getFormatDATA(ot.getNombre());
            row = row + HtmlFormat.getFormatDATA(String.valueOf(ot.getAreaestimada()));
            row = row + HtmlFormat.getFormatDATA(ot.getSupervisor());
            row = row + "</tr>";
        }            
        data = data.replace("ENCABEZADO", head);
        data = data.replace("DATA", row);
        return data;
    }
    public static String getFormatoItemObra(List<Spitemobra> ios){
        String data = "<thead><tr>ENCABEZADO</tr></thead><tbody>DATA</tbody>";
        String head = "";
        String row  = "";
        
        head = head + HtmlFormat.getFormatHEAD("ID");
        //head = head + HtmlFormat.getFormatHEAD("ORDEN TRABAJO");
        //head = head + HtmlFormat.getFormatHEAD("POLIGONO");
        //head = head + HtmlFormat.getFormatHEAD("ACTIVIDAD");
        head = head + HtmlFormat.getFormatHEAD("CODIGO");
        head = head + HtmlFormat.getFormatHEAD("DESCRIPCION");
        head = head + HtmlFormat.getFormatHEAD("AREA TRAB.(HA)");
        //head = head + HtmlFormat.getFormatHEAD("RENDIMIENTO");
        
        for(Spitemobra io : ios){
            row = row + "<tr>";
            row = row + HtmlFormat.getFormatDATA(String.valueOf(io.getPkitemobra()));
            //row = row + HtmlFormat.getFormatDATA(io.getSpordentrabajo().getData());
            //row = row + HtmlFormat.getFormatDATA(io.getSppoligono().getCodigo());
            //row = row + HtmlFormat.getFormatDATA(io.getSpactividad().getCodigo());
            row = row + HtmlFormat.getFormatDATA(io.getCodigo());
            row = row + HtmlFormat.getFormatDATA(io.getDescripcion());
            row = row + HtmlFormat.getFormatDATA(String.valueOf(io.getAreatrab()));
            //row = row + HtmlFormat.getFormatDATA(String.valueOf(io.getRendimiento()));
            row = row + "</tr>";
        }            
        data = data.replace("ENCABEZADO", head);
        data = data.replace("DATA", row);
        return data;
    }
    
    private static String getFormatHEAD(String s){
        return "<th class='cabecera'>" + s + "</th>";
    }
    private static String getFormatDATA(String s){
        return "<td class='data'>" + s + "</td>";
    }

    public static void main(String[] args) {
        File f=new File("src\\main\\resources\\ayuda.html");
        
        if (f.exists()) {
            System.out.println("Archivo encontrado sac");
            
        }
    }
}
