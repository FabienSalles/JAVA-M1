/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td3.lecteurd_redacteurs;

import java.util.Random;

/**
 *
 * @author fasalles
 */
public class Redacteur extends Thread{
    
    LecteursRedacteurs lr;
    String desc;
    
    public Redacteur(LecteursRedacteurs lr, String desc) {
        this.lr = lr;
        this.desc = desc;
    }
    
    @Override
    public void run() {
        Random rand = new Random();
        for(int i = 0; i< 100; i++)
        {
            System.out.println("Ecriture"+this.desc);
            this.lr.entreEcriture();
            try{
                sleep(rand.nextInt(10));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            this.lr.sortEcriture();
            try{
                sleep(rand.nextInt(10));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
