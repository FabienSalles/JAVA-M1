/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

/**
 *
 * @author lom
 */
public class Leaf implements Component {

    private int number;

    public Leaf(int num) {
        number = num;
    }

    public void traverse() {
        System.out.print(number + " ");
    }
}
