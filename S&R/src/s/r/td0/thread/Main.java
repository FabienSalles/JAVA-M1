/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td0.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fasalles
 */
public class Main {
    
    public static void main(String args[]) throws InterruptedException{
        Registre R = new Registre(10);
        MonThread Th1 = new MonThread(R);
        MonThread Th2 = new MonThread(R);
        Th1.start(); // démarrage des threads
        Th2.start();
        Th1.join(); // attente de la terminaison des threads
        Th2.join();
        int[] T = R.lit_Registre();
        System.out.println( "Valeur finale du Registre ");
        for (int i = 0; i<T.length; i++){
            System.out.println(T[i]);
        }
    }
}
