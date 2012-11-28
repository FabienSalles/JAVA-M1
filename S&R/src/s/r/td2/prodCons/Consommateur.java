/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td2.prodCons;

/**
 *
 * @author fasalles
 */
public class Consommateur extends Thread{
    ProdCons pc;

    public Consommateur(ProdCons pc) {
        this.pc = pc;
    }
    
    @Override
    public void run(){
        for(int i = 0;i<5;i++){
            System.out.println("Lecture");
            pc.Get();
        }
    }
}