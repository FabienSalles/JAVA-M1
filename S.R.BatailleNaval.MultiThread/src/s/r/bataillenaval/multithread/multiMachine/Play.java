/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.bataillenaval.multithread.multiMachine;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import s.r.bataillenaval.multithread.Communication;
import s.r.bataillenaval.multithread.Player;

/**
 *
 * @author fasalles
 */
public class Play {
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException { 
        Communication com = Communication.getPlayerInstance();
        com.logOn();
        new Thread(new Player()).start();
    }
}
