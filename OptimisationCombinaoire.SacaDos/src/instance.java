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
    public int VolumesMax;

    public instance(int nb, listeobjets obj, int pm, int vm) {
        this.nbobjet = nb;
        this.PoidsMax = pm;
        this.VolumesMax = vm;
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
