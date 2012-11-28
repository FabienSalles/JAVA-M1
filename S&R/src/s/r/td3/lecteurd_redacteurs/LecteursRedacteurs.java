/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td3.lecteurd_redacteurs;

/**
 *
 * @author fasalles
 */
public class LecteursRedacteurs {
    private int nbLecture = 0;
    private boolean redacteurPresent = false;
    
    synchronized void entreLecture()
    {
        while(this.redacteurPresent)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.nbLecture++;
        }
    }
    
    synchronized void sortLecture()
    {
        this.nbLecture--;
        notify();
    }
    
    synchronized void entreEcriture()
    {
        while(this.redacteurPresent || this.nbLecture > 0)
        {
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            this.redacteurPresent = true;
        }
    }
    
    synchronized void sortEcriture()
    {
        this.redacteurPresent = false;
        notify();
    }
}
