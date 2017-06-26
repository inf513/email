/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Estudiante
 */
public class ClienteSMTP {
    public static void main(String[] args) {
        String servidor="mail.ficct.uagrm.edu.bo";
        String user_receptor="grupo05sc@ficct.uagrm.edu.bo";
        String user_emisor="eamachaca@hotmail.com";
        String line;
        String comando ="";
        int puerto =25;
        try{
            Socket socket=new Socket(servidor,puerto);
            BufferedReader entrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream salida=new DataOutputStream(socket.getOutputStream());
            if (socket!=null && entrada!=null && salida !=null) {
                System.out.println("S. "+entrada.readLine());
                comando="EHLO "+servidor+"\r\n";
                System.out.println("C: "+comando);
                salida.writeBytes(comando);
                System.out.println("S: "+getMultiline(entrada));
                comando="QUI \r\n";
                System.out.println("C: "+comando);
                salida.writeBytes(comando);
                System.out.println("S: "+entrada.readLine());
            }
            salida.close();
            entrada.close();
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static String getMultiline(BufferedReader entrada) throws IOException {
        String lines="";
        while(true){
            String line=entrada.readLine();
            if (line==null) {
                throw  new IOException("S: Server unawares closed the connection");
            }
            if (line.charAt(3)==' ') {
                lines=lines+"\n"+line;
                break;
            }
            lines=lines+"\n"+line;
        }
        return lines;
    }
}