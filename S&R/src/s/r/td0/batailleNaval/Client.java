/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td0.batailleNaval;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import s.r.td1.socket.tcp.TCPClient;

/**
 *
 * @author fasalles
 */
public class Client {
    public static void main(String argv[])
    {
        try {
            String sentence;
            String modifiedSentence;
            
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            
            Socket clientSocket = new Socket("localhost", 6789);        
            
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            sentence = inFromUser.readLine();
            
            outToServer.writeBytes(sentence+'\n');
            
            modifiedSentence = inFromServer.readLine();
            
            System.out.println("From Server : "+modifiedSentence);
            
            clientSocket.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
