/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td4.DeadLock;

/**
 *
 * @author fasalles
 */
public class Main {
    public static void main(String[] args) {
        final int N = 5; // 5 philosophes 5 baguettes
        Table table = new Table(N);
        for (int i = 0; i < N; i++) {
            new Philosophe(i, table);
        }
    }
}
