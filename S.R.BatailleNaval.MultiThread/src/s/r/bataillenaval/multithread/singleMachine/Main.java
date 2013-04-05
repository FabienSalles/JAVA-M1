/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.bataillenaval.multithread.singleMachine;

import s.r.bataillenaval.multithread.*;

/**
 *
 * @author fasalles
 */
public class Main {
    public static void main(String args[]) throws Exception
    {           
        Server server = Server.getInstance();
        
        do
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
            
            // for check secondly if the game is finish
            server.getCom().setGame(server.getGame());
            server.setGame(server.getCom().getGame());
        }
        while (!server.getGame().isFinish());
        
        // For guests finish the game properly
        // because when the game is finish with one player
        // all other want to retrieve the game for check if the game
        // is finish and stop them threads
        for(int i = 1; i< Config.NB_GUEST; i++)
        {
            server.getCom().setGame(server.getGame());
        }
    }
}
