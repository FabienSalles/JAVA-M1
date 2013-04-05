/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.bataillenaval.multithread.singleMachine;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import s.r.bataillenaval.multithread.Communication;
import s.r.bataillenaval.multithread.Config;
import s.r.bataillenaval.multithread.Player;

/**
 *
 * @author fsalles
 */
public class Play
{
    public static void main(String args[]) throws InterruptedException
    {
        try {
            Communication com = Communication.getPlayerInstance();
            com.logOn();
            System.out.println("Début de la partie");
            System.out.println("Nombre de bateaux sur le plateau : "+Config.NB_BOAT);
            System.out.println("Nombre d'essaie max par joueur : "+Config.MAX_NUMBER_STROKES);
            // Create threads
            ExecutorService es = Executors.newFixedThreadPool(Config.NB_GUEST);
            //ExecutorService es = Executors.newSingleThreadExecutor();
            // Instanciation
            Player [] players = new Player[Config.NB_GUEST];
            for(int i = 0; i < Config.NB_GUEST; i++)
            {
                players[i] = new Player(i+1);
            }

            // Players play 
            for(int i = 0; i < Config.NB_GUEST; i++)
            {
                es.execute(players[i]);
            }
            // All player finish the game
            es.shutdown();
        } catch (IOException ex) {
            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
