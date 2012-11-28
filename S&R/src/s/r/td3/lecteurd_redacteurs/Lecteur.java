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
public class Lecteur extends Thread{
    LecteursRedacteurs lr;
    String desc;

    public Lecteur(LecteursRedacteurs lr, String desc) {
        this.lr = lr;
        this.desc = desc;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for(int i = 0; i< 100; i++)
        {
            System.out.println("Ecriture"+this.desc);
            this.lr.entreLecture();
            try{
                sleep(rand.nextInt(10));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            this.lr.sortLecture();
            try{
                sleep(rand.nextInt(10));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
   
}
