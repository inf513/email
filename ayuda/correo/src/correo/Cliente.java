/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correo;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author Estudiante
 */
public class Cliente {
    static final String HOST= "172.20.172.8";
    static final int PUERTO=5000;
    public Cliente(){
        try{
            Socket socket=new Socket(HOST, PUERTO);
            InputStream is=socket.getInputStream();
            DataInputStream dis=new DataInputStream(is);
            System.out.println(dis.readUTF());
            socket.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
