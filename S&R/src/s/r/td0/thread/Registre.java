/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td0.thread;

/**
 *
 * @author fasalles
 */
public class Registre {
    int[] Tab;
    
    public Registre(int n) {
        Tab = new int[n];
    }
    
    public int[] lit_Registre() {
        int[] res = new int[this.Tab.length];
        for (int i = 0; i < res.length; i++) { res[i] = this.Tab[i];}
            return res;
    }
    
    public void ecrit_Registre(int[] T) {
        for (int i = 0; i < Tab.length; i++) { Tab[i] = T[i];}
    }
}