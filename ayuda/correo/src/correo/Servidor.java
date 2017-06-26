/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class Servidor {
   static final int PUERTO=5000;
   public Servidor(){
       try {
           ServerSocket serverSocket=new ServerSocket(PUERTO);
           System.out.println("Escucho el puerto "+PUERTO);
           for (int i = 0; i < 3; i++) {
               Socket socket=serverSocket.accept();
               System.out.println("Sirvo al Cliente " + i);
               OutputStream os=socket.getOutputStream();
               DataOutputStream dos=new DataOutputStream(os);
               dos.writeUTF("Hola Cliente #"+i);
               socket.close();
           }
           System.out.println("Demasiados clientes por hoy");
           serverSocket.close();
       } catch (IOException ex) {
           System.out.println(ex.getMessage());
       }
   }
}