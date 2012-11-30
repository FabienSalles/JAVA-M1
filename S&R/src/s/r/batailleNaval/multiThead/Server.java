/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.batailleNaval.multiThead;

/**
 *
 * @author yvrenaud
 * 1. Envoie DEBUT PARIE
 * 2. ENVOI NB BATEAUX SUR LE PLATEAU
 * 3. ENVOI TOUCHER OU PAS TOUCHER
 */
public class Server {

    public static int BATEAUX = Plateau.TAILLE;
    
    public static void main(String args[]) throws Exception {

        Plateau p = new Plateau(BATEAUX);
        
        Communication c = new Communication(9876);
        c.ecouter(c.getServerSocket());
        
        System.out.println("Serveur en attente sur le port " + c.getServerSocket().getLocalPort());
        Message m = new Message(p.getNbBateaux());
        m.setAuRevoir("NON");
        m.setCombien(BATEAUX);
        c.envoyerMessage(m);
        m = c.recevoirMessage();
        
        while (m.getAuRevoir().equals("NON"))
        {
            // RECEPTION DE LA DEMANDE DU CLIENT
            System.out.println("Le client demande X : " + m.getPosX() + " Y : " + m.getPosY());

            // vérifie la présence d'un bateau
            if (p.contientNavire(m.getPosX(), m.getPosY()))
            {
                m.setText("Toucher");
                p.bombarde(m.getPosX(), m.getPosY());
            }
            else
            {
                m.setText("Pas Toucher");;
            }
            c.envoyerMessage(m);
            m = c.recevoirMessage();
            // Message d'actualisation du nombre de bateaux sur le plateau
            m.setText("Bateaux restants : ");
            m.setCombien(p.getNbBateaux());
            c.envoyerMessage(m);
            
            // Recoit le message OUI ou NON
            m = c.recevoirMessage();
            System.out.println(m.getAuRevoir());
        }


        // Si il n'y a plus de bateaux sur le plateau il a gagné
        if (m.getCombien() == 0)
        {
            m.setText("BRAVO IL N'Y A PLUS DE BATEAUX SUR LE PLATEAUX");
        }
        else
        {
            m.setText("T'ES NUL");
        }
        
        // ENVOI DU MESSAGE DE FIN
        c.envoyerMessage(m);
        c.deconnecter();
    }
}
