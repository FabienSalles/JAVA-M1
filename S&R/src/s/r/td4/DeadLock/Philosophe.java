/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td4.DeadLock;

/**
 *
 * @author fasalles
 */
public class Philosophe extends Thread {

    private Table table;
    private int x;

    public Philosophe(int x, Table table) {
        this.x = x;
        this.table = table;
        new Thread(this).start();
    }

    private void thinking() {
        System.out.println(x + " pense");
        yield();
    }

    private void eating() {
        System.out.println(x + " mange");
        yield();
    }

    public void run() {
        while (true) {
            thinking();
            table.request(x);
            eating();
            table.release(x);
        }
    }
}
