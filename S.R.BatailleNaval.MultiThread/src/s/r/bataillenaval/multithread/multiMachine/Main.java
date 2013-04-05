/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.bataillenaval.multithread.multiMachine;

import s.r.bataillenaval.multithread.Config;
import s.r.bataillenaval.multithread.Server;

/**
 *
 * @author fasalles
 */
public class Main {
    public static void main(String args[]) throws Exception
    {           
        Server server = Server.getInstance();
        
        for(;;)
        {
            if(!server.getGame().isFinish())
            {
                server.getCom().setGame(server.getGame());
                server.setGame(server.getCom().getGame());
                // RECEPTION DE LA DEMANDE DU CLIENT
                System.out.println("Le client demande "+server.getGame().getAttempt());

                // vérifie la présence d'un bateau
                if (server.getGame().getBoard().containsBoatSinking(server.getGame().getAttempt()))
                {
                    server.getGame().setHit(true);
                }
                else
                {
                    server.getGame().setHit(false);
                }
                server.getGame().getBoard().bombing(server.getGame().getAttempt());
            }
            else
            {
                break;
            }
        }
    }
}
