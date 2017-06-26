/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.servidor;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class ServicioCorreo {
    private String usuario = "";
    private String password = "";
    
    public ServicioCorreo(String usuario, String pass){
        this.usuario = usuario;
        this.password = pass;
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
                    msg = new Mensaje("yo mismo", dfrom.toString(), mensaje.getSubject(), ob.toString());
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
    public static void main(String[] main){
        ServicioCorreo s = new ServicioCorreo("grupo06sa", "grupo06grupo06");
        s.readEmail();
    }
}
