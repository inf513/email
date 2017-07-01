/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.servidor;

import com.grupo06sa.emailweb.negocios.Analizador;
import com.grupo06sa.emailweb.negocios.COMANDO;
import com.grupo06sa.emailweb.negocios.Respuesta;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class ServicioCorreo {
    private String usuario = "";
    private String password = "";
    private Analizador a=new Analizador();
    private Properties propiedades = null;
    
    public ServicioCorreo(String usuario, String pass){
        this.usuario = usuario;
        this.password = pass;
        this.inicializarConfiguracion();
    }
    /**
     * Configuracion del servicio
     */
    private void inicializarConfiguracion(){
        propiedades = new Properties();
        propiedades.put("mail.smtp.user", usuario);
        propiedades.put("mail.smtp.password", password);
        //propiedades.put("mail.smtp.host", "mail.ficct.uagrm.edu.bo");
        propiedades.put("mail.smtp.host", "200.87.51.3");
        propiedades.put("mail.smtp.port", "25");
    }
    /**
     * Metodo que envia un correo electronico html
     * @param msg el mensaje que se enviara
     */
    private void SendMail(Mensaje msg) {
        try {
                Authenticator auth = new autentificadorSMTP();
                Session session = Session.getInstance(this.propiedades, auth);

                MimeMessage mime = new MimeMessage(session);
                mime.setSubject(msg.getAsunto());
                mime.setFrom(new InternetAddress(usuario + "@mail.ficct.uagrm.edu.bo"));
                mime.addRecipient(Message.RecipientType.TO, new InternetAddress(msg.getEmail()));
                
                mime.setContent(msg.getContenido(), "text/html");
                                
                Transport.send(mime);
        } catch (Exception e) {
            System.out.println("[ServicioCorreo.SendMail] " + e.getMessage());
        }
    }
    private void SendMailMultiParte(Mensaje msg){
        try {
                Authenticator auth = new autentificadorSMTP();
                Session session = Session.getInstance(this.propiedades, auth);

                MimeMessage mime = new MimeMessage(session);
                mime.setSubject(msg.getAsunto());
                mime.setFrom(new InternetAddress(usuario + "@mail.ficct.uagrm.edu.bo"));
                mime.addRecipient(Message.RecipientType.TO, new InternetAddress(msg.getEmail()));
                
                Multipart multiparte = new MimeMultipart("related");
                
                // se adiciona el mensage
                BodyPart body = new MimeBodyPart();
                body.setContent(msg.getContenido(), "text/html");
                
                //se adiciona la imagen
                MimeBodyPart imagen = new MimeBodyPart();
                imagen.attachFile(Mensaje.logo1);
                imagen.setHeader("Content-ID", "<logo1>");
                                
                multiparte.addBodyPart(body);
                multiparte.addBodyPart(imagen);
                
                mime.setContent(multiparte);
                
                Transport.send(mime);
        } catch (Exception e) {
            System.out.println("[ServicioCorreo.SendMailMultiParte] " + e.getMessage());
        }
    }
    
    /**
     * Metodo que responde mediante un correo electronico a las peticiones realizadas
     */
    private void responseEmail(Respuesta response, String to, String replyAsunt){
        Mensaje m = new Mensaje(to, replyAsunt, "", new Date(), new Date());
        switch(response.getCode().trim()){
            case COMANDO.MS_COMAN:
                m.setContenido(this.getDocumentoHtml(Mensaje.mailEstado, response));
                break;
            case COMANDO.MS_ERROR:                
                m.setContenido(this.getDocumentoHtml(Mensaje.mailEstado, response));
                break;
            case COMANDO.MS_SUCCE:
                m.setContenido(this.getDocumentoHtml(Mensaje.mailEstado, response));
                break;
            case COMANDO.MS_TABLA:
                m.setContenido(this.getDocumentoHtml(Mensaje.mailEstado, response));
                break;
            case COMANDO.MS_TRVAL:
                m.setContenido(this.getDocumentoHtml(Mensaje.mailEstado, response));
                break;
            case COMANDO.MS_VALID:
                m.setContenido(this.getDocumentoHtml(Mensaje.mailEstado, response));
                break;
            case COMANDO.CM_AYU:
                m.setContenido(this.getDocumentoHtml(Mensaje.mailAyuda, response));
                break;
            case COMANDO.MS_LST:
                m.setContenido(this.getDocumentoHtml(Mensaje.mailList, response));
                break;
            default:
                break;
        } 
        
        //System.out.println("Correo enviado a : " + m.getEmail());
        //System.out.println("Asunto : " + m.getAsunto());
        //System.out.println("PAGINA : " + m.getContenido());
        System.out.println("correo enviado");
        this.SendMail(m);
        //this.SendMailMultiParte(m);
    }
    /**
     * Metodo que genera un documento html a partir de la direccion que se envia
     * @param link direccion de la pagina web
     * @param desc la cadena que se reemplazara en la pagina web
     * @param codigo Codigo de peticion
     * @return 
     */
    private String getDocumentoHtml(String link, Respuesta r){
        String archivo = "";
        String linea;       
        try {
            BufferedReader br = new BufferedReader(new FileReader(link));
            while((linea = br.readLine()) != null){
                if(linea.contains(Respuesta.code_replace)){
                    if(r.getCode().equals(COMANDO.MS_LST)){
                        linea = linea.replace(Respuesta.code_replace, "LISTADO DE " + r.getNombreTabla());
                    }else{
                        linea = linea.replace(Respuesta.code_replace, r.getCode());
                    }                    
                }
                if(linea.contains(Respuesta.desc_replace)){
                    linea = linea.replace(Respuesta.desc_replace, r.getDescripcion());
                }
                archivo +=linea;
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("[ServicioCorreo.getDocumentoHtml] " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("[ServicioCorreo.getDocumentoHtml] " + ex.getMessage());
        }
        return archivo;
    }
    private class autentificadorSMTP extends javax.mail.Authenticator {
              @Override
              public PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(usuario,password);
              }
    }
    /**
     * Metodo que realiza la lectura de correo electronico
     */
    public void readEmail(){
        // Obtenemos las propiedades del sistema
        //String popHost = "mail.ficct.uagrm.edu.bo";
        String popHost = "200.87.51.3";
        Properties props = System.getProperties();
        // Obtener una sesión con las propiedades anteriormente definidas
        Session sesion = Session.getDefaultInstance(props,null);
        try {
            // Crear un Store indicando el protocolo de acceso y
            Store store = sesion.getStore("imap");
            store.connect(popHost,usuario,password);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);
            
            this.ReadMailNoRead(inbox);
            
            inbox.close(true);
            store.close();
        } catch (MessagingException me) {
            System.out.println("[ServicioCorreo.readEmail] " + me.getMessage());
        }
    }
    /**
     * Metodo que lee los correos no leidos del folder 
     * @param inbox Folder con el contenido de los mensajes
     */
    private void ReadMailNoRead(Folder inbox){        
        Message messages[];
        try {
            FlagTerm flagTerm = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            messages = inbox.search(flagTerm);

            for (Message msg : messages) {
                this.ReadMessage(msg);
            }
        } catch (MessagingException ex) {
            System.out.println("[ServicioCorreo.ReadMailNoRead]" + ex.getMessage());
        }        
    }
    /**
     * Metodo que lee un mensaje del correo electronico
     * @param msg mensaje de correo electronico
     */
    private void ReadMessage(Message msg){
        try {
            Address dfrom = msg.getFrom()[0];
            Object ob = msg.getContent();
            msg.setFlag(Flags.Flag.SEEN, true);
            
            Mensaje msj = new Mensaje(dfrom.toString(), msg.getSubject(), ob.toString(), msg.getSentDate(),msg.getReceivedDate());
            this.procesarPeticion(msj);
            //System.out.println(msj.toString());
        } catch (MessagingException | IOException e) {
            System.out.println("[ServicioCorreo.ReadMEssage] " + e.getMessage());
        }
    }
    /**
     * Metodo que procesa la peticion del mensaje
     * @param m mensaje a procesar
     */
    private void procesarPeticion(Mensaje m){
        Respuesta r = a.analizarTrama(m.getAsunto());
        if(r != null){
            this.responseEmail(r, m.getEmail(), m.getAsunto());
        }else{
            this.responseEmail(new Respuesta("ERROR", "NO SE ENTENDIO TRAMA", ""), m.getEmail(), m.getAsunto());
        }
    }
    public void iniciarServicio(){
        try {
            int iteracion = 1;
            while(true){
                this.readEmail();
                System.out.println("iteracion de hilo nro : " + String.valueOf(iteracion));
                Thread.sleep(15000);
                iteracion = iteracion + 1;
            }            
        } catch (InterruptedException ex) {
            System.out.println("Error en hilo" + ex.getMessage());
        }
    }
    public static void main(String[] main){
        
        ServicioCorreo s = new ServicioCorreo("grupo06sa", "grupo06grupo06");
        s.iniciarServicio();
        //falta ver si funciona la parte del hilo
        //s.readEmail();
        //Mensaje m = new Mensaje("limbertx@hotmail.com", "LST|ITEMOBRA|[]", "", new Date(), new Date());
        //s.procesarPeticion(m);
        System.exit(0);
    }
}