/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td1.socket.tcp;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fasalles
 */
public class TCPServer {
    
    public static void main(String argv[])
    {
        try {
            String clientSentence;
            String capitalizedSentence;
            
            ServerSocket welcomeSocket = new ServerSocket(6789);
            
            while(true){
                
                Socket connectionSocket = welcomeSocket.accept();
                
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                
                clientSentence = inFromClient.readLine();
                
                capitalizedSentence = clientSentence.toUpperCase()+ '\n';
                
                outToClient.writeBytes(capitalizedSentence);
            }
        } catch (IOException ex) {
            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
