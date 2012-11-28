/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td2.prodCons;

/**
 *
 * @author fasalles
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ProdCons pc = new ProdCons(5);
        Producteur p = new Producteur(pc);
        Consommateur c = new Consommateur(pc);
        
        Producteur p2 = new Producteur(pc);
        Consommateur c2 = new Consommateur(pc);
        
        Producteur p3 = new Producteur(pc);
        Consommateur c3 = new Consommateur(pc);
        
        p.start();
        c.start();
        p.join();
        c.join();
        
        p2.start();
        c2.start();
        p2.join();
        c2.join();
        
        p3.start();
        c3.start();
        p3.join();
        c3.join();
        
    }
}
