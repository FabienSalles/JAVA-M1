/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td0.batailleNaval;

import java.util.Random;

/**
 *
 * @author yvrenaud
 */
public class Client {

    // C'est lui qui utilise l'object communication
    public static void main(String args[]) throws Exception {

        // Nombre de coups max permis pour le client
        int nb_coups_max = 100000;
        // Nombre de coups joués actuellement
        int nb_actuel = 0;
        int x, y;
        Random random = new Random();
        
        Communication c = new Communication("localhost", 9876);
        c.connecter();
        
        Message m = c.recevoirMessage();
        System.out.println("Début de la partie");
        System.out.println("Nombre de bateaux sur le plateau : "+m.getCombien());

        while (nb_actuel < nb_coups_max && m.getAuRevoir().equals("NON"))
        {
            x = random.nextInt(Plateau.TAILLE);
            y = random.nextInt(Plateau.TAILLE);

            m.setPosX(x);
            m.setPosY(y);
            System.out.println("Bombarde (" + m.getPosX() + ":" + m.getPosY() + ")");
            c.envoyerMessage(m);
            m = c.recevoirMessage();
            System.out.println(m.getText());
            c.envoyerMessage(m);
            m = c.recevoirMessage(); // Recoit le nombre de bateaux restant après le coup
            System.out.println(m.getText() + m.getCombien());
            
            if(m.getCombien() == 0)
            {
               break;
            }

            nb_actuel++;
        }
        
        m.setAuRevoir("OUI");
        c.envoyerMessage(m);
        
        m = c.recevoirMessage(); // Recoit le resultat gagné ou non
        System.out.println(m.getText());
        
        c.deconnecter();
    }
}
