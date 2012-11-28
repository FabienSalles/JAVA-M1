/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td4.DeadLock;

/**
 *
 * @author fasalles
 */
public class Table {
    private int N;
    private boolean available[];

    Table(int N) {
        this.N = N;
        this.available = new boolean[N];
        for (int i = 0; i < N; i++) {
            available[i] = true;
        }
    }

    public synchronized void request(int me) {
        while (available[me] == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        available[me] = false;
        while (available[(me + 1) % N] == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        available[(me + 1) % N] = false;
    }

    public synchronized void release(int me) {
        available[me] = true;
        available[(me + 1) % N] = true;
        notifyAll();
    }
}
