package sacados;

/*
 * testmain.java
 *
 * Created on 8 mai 2008, 15:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.util.*;

public class testmain {

    /**
     * Creates a new instance of testmain
     */
    public testmain() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Arbre a;

        ListeObjets x = new ListeObjets();
        
        Objet obj1 = new Objet(0, 3, 3, 1);
        Objet obj2 = new Objet(1, 4, 4, 6);
        Objet obj3 = new Objet(2, 1, 18, 3);
        Objet obj4 = new Objet(3, 2, 42, 5);
        Objet obj5 = new Objet(4, 5, 24, 2);
        Objet obj6 = new Objet(5, 6, 50, 7);
        Objet obj7 = new Objet(6, 4, 12, 2);
        Objet obj8 = new Objet(7, 2, 23, 3);
        
        x.ajout(obj1);
        x.ajout(obj2);
        x.ajout(obj3);
        x.ajout(obj4);
        x.ajout(obj5);
        x.ajout(obj6);
        x.ajout(obj7);
        x.ajout(obj8);
        
        long s, t = System.currentTimeMillis();
        a = new Arbre(new Instance(8, x, 16, 18));
        s = System.currentTimeMillis() - t;
        
        System.out.println("Temps : " + s + " millisec");
        a.affiche();
    }
}
