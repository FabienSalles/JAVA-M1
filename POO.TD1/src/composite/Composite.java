/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lom
 */
public class Composite implements Component {

    private static char next = 'a';
    private List<Component> children = new ArrayList<Component>();
    private char letter = next++;

    public void add(Component c) {
        children.add(c);
    }

    public void traverse() {
        System.out.print(letter + " ");
        for (int i = 0; i < children.size(); i++) {
            children.get(i).traverse();
        }
    }
}
