/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
import java.util.*;

public class listeobjets {
    
    
    // Ajouter un element

    private Vector<objet> lst;

    public listeobjets() {
        lst = new Vector<objet>();
    }

    public void setliste(Vector<objet> v) {
        lst = v;
    }

    public Vector<objet> getliste() {
        return lst;
    }

    public void trie() {
        Collections.sort(lst);
    }

    public int taille() {
        return lst.size();
    }

    public void ajout(objet x) {
        lst.add(x);
    }

    public void retire(int i) {
        lst.remove(i);
    }

    public void retireobjet(objet x) {
        lst.remove(x);
    }

    public objet get(int i) {
        return (lst.get(i));
    }

    public int getpoids() {
        int pds = 0;
        for (int i = 0; i < lst.size(); i++) {
            pds += lst.get(i).getpoids();
        }
        return pds;
    }

    public int getutil() {
        int u = 0;
        for (int i = 0; i < lst.size(); i++) {
            u += lst.get(i).getutil();
        }
        return u;
    }

    public listeobjets duplique() {
        listeobjets l = new listeobjets();
        Vector<objet> v = (Vector<objet>) lst.clone();
        l.setliste(v);
        return l;
    }

    public void append(listeobjets l) {
        lst.addAll(l.getliste());
    }

    public int index(objet o) {
        // index si l'objet est dans la liste, -1 sinon'
        if (lst.contains(o)) {
            return lst.indexOf(o);
        } else {
            return (-1);
        }
    }

    public String affiche() {
        String s = "";
        for (int i = 0; i < lst.size(); i++) {
            s = s + lst.get(i).affiche();
        }
        return s + "\n";
    }

    public String affichelnum() {
        String s = "";
        for (int i = 0; i < lst.size(); i++) {
            s = s + " " + lst.get(i).getnum();
        }
        return s + "\n";
    }

    public String affichelpoids() {
        String s = "";
        for (int i = 0; i < lst.size(); i++) {
            s = s + " " + lst.get(i).getpoids();
        }
        return s + "\n";
    }

    public String affichelutil() {
        String s = "";
        for (int i = 0; i < lst.size(); i++) {
            s = s + " " + lst.get(i).getutil();
        }
        return s + "\n";

    }
}
