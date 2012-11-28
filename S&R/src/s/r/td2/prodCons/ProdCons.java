/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td2.prodCons;

/**
 *
 * @author fasalles
 */
public class ProdCons {
    private Object buffer[];
    private int sizeMax;
    private int lire, ecrire;
    private int nbElmt;
    
    ProdCons(int N){
        this.buffer = new Object[N];
        this.sizeMax = N;
        this.lire = this.ecrire = this.nbElmt = 0;
    }
    
    public synchronized void Put(Object m){
        while(this.nbElmt == this.sizeMax){
            try{
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.buffer[this.ecrire++] =m;
        this.nbElmt++;
        notify();
        this.ecrire%= this.sizeMax;
    }
    
    public synchronized Object Get(){
        while(this.nbElmt ==0){
            try{
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        Object m = this.buffer[this.lire++];    
        this.lire %= this.sizeMax;
        this.nbElmt--;
        notify();
        return m;
    }
}