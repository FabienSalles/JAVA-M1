/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td0.batailleNaval;

/**
 *
 * @author fsalles
 * 1. Envoie DEBUT PARIE
 * 2. ENVOI NB BATEAUX SUR LE PLATEAU
 * 3. ENVOI TOUCHER OU PAS TOUCHER
 */
public class Server {
    
    public static final int SIZE = 10;
    public static void main(String args[]) throws Exception
    {    
        Communication c = new Communication(9876);
        c.listen(c.getServerSocket());
        
        System.out.println("Serveur en attente sur le port " + c.getServerSocket().getLocalPort());
        Game game = new Game(SIZE, SIZE);
        c.setGame(game);
        game = c.getGame();
        
        while (!game.isFinish())
        {
            // RECEPTION DE LA DEMANDE DU CLIENT
            System.out.println("Le client demande "+game.getAttempt());

            // vérifie la présence d'un bateau
            if (game.getBoard().containsBoatSinking(game.getAttempt()))
            {
                game.setMessage("Toucher");
            }
            else
            {
                game.setMessage("Pas Toucher");;
            }
            game.getBoard().bombing(game.getAttempt());
            
            c.setGame(game);
            game = c.getGame();
            // Message d'actualisation du nombre de bateaux sur le plateau
            game.setNbBoat(game.getBoard().getNumberBoat());
            game.setMessage("Bateaux restants : "+game.getNbBoat());
            c.setGame(game);
            
            // Recoit le message OUI ou NON
            game = c.getGame();
        }


        // Si il n'y a plus de bateaux sur le plateau il a gagné
        if (game.getNbBoat() == 0)
        {
            game.setMessage("BRAVO IL N'Y A PLUS DE BATEAUX SUR LE PLATEAUX");
        }
        else
        {
            game.setMessage("T'ES NUL");
        }
        
        // ENVOI DU MESSAGE DE FIN
        c.setGame(game);
        c.disconnect();
    }
}
