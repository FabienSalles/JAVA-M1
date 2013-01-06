/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.bataillenaval.multithread;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fsalles
 */
public class Play
{
    public static void main(String args[]) throws InterruptedException
    {
        try {
            Communication com = Communication.getGuestInstance();
            com.logOn();
            System.out.println("Début de la partie");
            System.out.println("Nombre de bateaux sur le plateau : "+Config.NB_BOAT);
            System.out.println("Nombre d'essaie max par joueur : "+Config.MAX_NUMBER_STROKES);
            ExecutorService es = Executors.newFixedThreadPool(Config.NB_GUEST);
            Guest [] guests = new Guest[Config.NB_GUEST];
            for(int i = 0; i < Config.NB_GUEST; i++)
            {
                guests[i] = new Guest(i+1);
            }
            
            for(int i = 0; i < Config.NB_GUEST; i++)
            {
                es.execute(guests[i]);
            }
            
            es.shutdown();
        } catch (IOException ex) {
            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
