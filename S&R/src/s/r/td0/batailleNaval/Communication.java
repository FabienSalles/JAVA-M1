/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td0.batailleNaval;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

/**
 *
 * @author fasalles
 */
public class Communication {
    
    private ObjectOutputStream sortie;
    private ObjectInputStream entree;
    private int port;
    private String hote;
    private Socket socket;
    
    
    public Communication(String host, int port)
    {
        this.hote = host;
        this.port = port;
        this.socket = null;
    }
    
    public Message recevoirMessage(Message msg)
    {

    }
    
    public void connecter()
    {
        
    }
    
    public void deconnecter()
    {
        
    }
}
