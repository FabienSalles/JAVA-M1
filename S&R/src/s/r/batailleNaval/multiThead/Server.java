/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.batailleNaval.multiThead;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fsalles
 * 1. Envoie DEBUT PARIE
 * 2. ENVOI NB BATEAUX SUR LE PLATEAU
 * 3. ENVOI TOUCHER OU PAS TOUCHER
 */
public class Server {
    
    private Communication com;
    private Game game;
    private static Server instance;
    
    private Server()
    {
        try {
            this.com = new Communication(Config.PORT);
            this.com.listen(this.com.getServerSocket());
            this.game = Game.getInstance();
            System.out.println("Serveur en attente sur le port " + this.com.getServerSocket().getLocalPort());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public final static Server getInstance() {
        Server result = instance;
        if (result == null) { // 1er verif sans verrou
            synchronized (Server.class) {
                result = instance;
                if (result == null) { // 2eme verif, apres acquisition du verrou
                    result = instance = new Server();
                }
            }
        }
        return instance;
    }
    
    public static void main(String args[]) throws Exception
    {           
        Server server = Server.getInstance();
        
        do
        {
            server.com.setGame(server.game);
            server.game = server.com.getGame();
            // RECEPTION DE LA DEMANDE DU CLIENT
            System.out.println("Le client demande "+server.game.getAttempt());

            // vérifie la présence d'un bateau
            if (server.game.getBoard().containsBoatSinking(server.game.getAttempt()))
            {
                server.game.setMessage("Toucher");
            }
            else
            {
                server.game.setMessage("Pas Toucher");
            }
            server.game.getBoard().bombing(server.game.getAttempt());
            
            // for check secondly if the game is finish
            server.com.setGame(server.game);
            server.game = server.com.getGame();
        }
        while (!server.game.isFinish());
        
        // For the guests finish the game properly
        for(int i = 1; i< Config.NB_GUEST; i++)
        {
            server.com.setGame(server.game);
        }
    }
}
