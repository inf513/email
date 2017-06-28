/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.servidor;

import com.grupo06sa.emailweb.negocios.Analizador;
import com.grupo06sa.emailweb.negocios.Respuesta;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class ServicioCorreo {
    private String usuario = "";
    private String password = "";
    private String mailReceptor="";
    private String asunto ="";
    private String cuerpo="";
    private Analizador a=new Analizador();
    public ServicioCorreo(String usuario, String pass){
        this.usuario = usuario;
        this.password = pass;
    }
      
      public void SendMail(String mailReceptor, String asunto, String cuerpo) {
		this.mailReceptor = mailReceptor;
		this.asunto = asunto;
		this.cuerpo = cuerpo;

		Properties props = new Properties();
		props.put("mail.smtp.user", usuario);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.host", "mail.ficct.uagrm.edu.bo");
		props.put("mail.smtp.port", "25");		
		try {
			Authenticator auth = new autentificadorSMTP();
			Session session = Session.getInstance(props, auth);
			// session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setText(cuerpo);
			msg.setSubject(asunto);
			msg.setFrom(new InternetAddress(usuario + "@mail.ficct.uagrm.edu.bo"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mailReceptor));
			Transport.send(msg);
		} catch (Exception mex) {
			mex.printStackTrace();
		}

	}
      private class autentificadorSMTP extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(usuario,password);
		}
	}
    
    public void readEmail(){
        // Obtenemos las propiedades del sistema
        String popHost = "mail.ficct.uagrm.edu.bo";
        Properties props = System.getProperties();
        // Obtener una sesión con las propiedades anteriormente definidas
        Session sesion = Session.getDefaultInstance(props,null);
        // Capturar las excepciones
        try {
            // Crear un Store indicando el protocolo de acceso y
            // conectarse a él
            Store store = sesion.getStore("imap");
            store.connect(popHost,usuario,password);
            // Crear un Folder y abrir la carpeta INBOX en modo SOLO LECTURA
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);
            // Obtener los mensajes almacenados en la carpeta
            Message [] mensajes = folder.getMessages();
            // cantidad de mensajes en la bandeja
            System.out.println("Cantidad de correos: " + mensajes.length);
            // Procesar los mensajes
            Mensaje msg = null;

            for (Message mensaje : mensajes) {
                Flags flags = mensaje.getFlags();
                
                if (!flags.contains(Flags.Flag.SEEN)){
                    Address dfrom = mensaje.getFrom()[0];
                    Object ob = mensaje.getContent();                
                    mensaje.setFlag(Flags.Flag.SEEN, true);
                    System.out.println("pase por aqui ---------->");
                    // si el correo no fue leido se enviara una respuesta
                    respuesta(mensaje.getSubject(), mensaje.getContent().toString(), mensaje.getFrom()[0].toString());
                    msg = new Mensaje("yo mismo", dfrom.toString(), mensaje.getSubject(), ob.toString());
                   
                   // respuesta(mensaje.getSubject(), mensaje.getContent().toString(), mensaje.getFrom()[0].toString());
                    System.out.println(msg.toString());
                }                
            }
            //Cerrar el Folder y el Store
            folder.close(true);
            store.close();
        } catch (MessagingException me) {
            System.err.println(me.toString());
        } catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
    }
    public void respuesta(String sAsunto, String sMensaje, String sCorreo){
       
         Respuesta r=a.analizarTrama(sAsunto);
         System.out.println(r.getCode() + "*****" + r.getDescripcion());
         SendMail(sCorreo, "respuesta del servidor", r.getDescripcion());
    
    }
    public static void main(String[] main){
        ServicioCorreo s = new ServicioCorreo("grupo06sa", "grupo06grupo06");
        //s.SendMail("pauljesus@hotmail.com", "es un mesaje atraves del servidor de ficct222222", "hola paul saludos del servidor de la uagrm");
       s.readEmail();
    }
}
