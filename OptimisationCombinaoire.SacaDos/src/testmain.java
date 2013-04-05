/*
 * testmain.java
 *
 * Created on 8 mai 2008, 15:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author claire hanen Cette classe principale permet d'appeler le générateur
 * d'instances (classe generator) en en donnant les paramètres nombre
 * d'instances, nombre d'objets, ordre de grandeur pour les tailles et les
 * utilités (poids), et ensuite pour chaque instance, elle appelle la méthode
 * arborescente de résolution et affiche le nombre de noeuds de l'arbre générés
 * et le temps en millisecondes.
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
    public static void main(String[] args) {
        arbre a;
        generator xtest = new generator(10, 10000, 1000, 1000, 1000);
        for (int i = 0; i < xtest.nbinst; i++) {
            long s, t = System.currentTimeMillis();
            a = new arbre(xtest.instances.get(i));
            s = System.currentTimeMillis() - t;
            System.out.println("nbnoeuds : " + a.getnb() + "   temps : " + s + " millisec\n");
        }
    }
}
