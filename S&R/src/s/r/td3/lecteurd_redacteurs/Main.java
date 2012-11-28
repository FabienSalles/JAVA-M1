/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td3.lecteurd_redacteurs;

/**
 *
 * @author fasalles
 */
public class Main {
    
    public static void main(String [] args) throws InterruptedException{
        LecteursRedacteurs lr = new LecteursRedacteurs();
        Lecteur l = new Lecteur(lr, "Lecteur");
        Redacteur r = new Redacteur(lr, "Redacteur");
        
        r.start();
        l.start();
        r.join();
        l.join();
    }
}
