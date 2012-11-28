/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produitFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yvrenaud
 */
public final class Client {

    List<Products> productsList = new ArrayList<Products>();

    public Client() {
    }

    public void add(Products s) {
        productsList.add(s);
    }

    public void del(int id) {
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getID() == id) {
                productsList.remove(i);
                break;
            }
        }
    }

    public Products get(int pos) {
        return productsList.get(pos);
    }

    public int size() {
        return productsList.size();
    }

    public void afficheAll() {
        for (Products p : productsList) {
            p.affiche();
        }
    }
}
