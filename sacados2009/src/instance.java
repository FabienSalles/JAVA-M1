/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
import java.util.*;

public class instance {

    public int nbobjet;
    public listeobjets objets;
    public int PoidsMax;

    public instance(int nb, listeobjets obj, int pm) {
        this.nbobjet = nb;
        this.PoidsMax = pm;
        this.objets = obj;
        this.objets.trie();
    }

    public void affiche() {
        System.out.println(nbobjet + " " + PoidsMax + "\n");
        System.out.println(objets.affichelnum());
        System.out.println(objets.affichelpoids());
        System.out.println(objets.affichelutil());

    }
}
