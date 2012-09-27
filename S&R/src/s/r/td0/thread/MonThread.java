/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td0.thread;

/**
 *
 * @author fasalles
 */
public class MonThread extends Thread {
    Registre leRegistre;
    public MonThread(Registre R) {
    leRegistre = R;
    }
    public void run() {
        for (int turn=0; turn<1000000; turn++) {
            int Tab[];
            synchronized (leRegistre){
                Tab = leRegistre.lit_Registre();
                for (int i = 0; i < Tab.length; i++) {
                    Tab[i]++;
                }
                leRegistre.ecrit_Registre(Tab);
            }
        }
    }
}
