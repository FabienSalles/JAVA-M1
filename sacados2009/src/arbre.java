/**
 *
 * @author claire Hanen cette classe contient les éléments de la méthode
 * arborescente.
 */
import java.util.TreeSet;

public class arbre {

    private noeud racine;
    private instance probleme;
    private TreeSet<noeud> ouverts;
    private solution optimale;
    private int nbnoeuds;

    public arbre(instance pb) {
        noeud courant;
        ouverts = new TreeSet<noeud>();
        probleme = pb;
        racine = new noeud(new listeobjets(), new listeobjets(), new listeobjets());
        racine.traiteracine(probleme);
        if (racine.getstatut() == 1) {
            ouverts.add(racine);
        }
        while (!ouverts.isEmpty()) {
            courant = ouverts.first();
            ouverts.remove(courant);
            courant.separe();
            int i = 0;
            while (i < courant.getfils().size()) {
                if (courant.getfils().get(i).getstatut() == 1) {
                    ouverts.add(courant.getfils().get(i));
                }
                i++;
            }

        }
        optimale = racine.getmeilleure();
        nbnoeuds = racine.nbnoeuds;
    }

    public void affiche() {
        // racine.affiche();
        System.out.println("nbnoeuds :" + nbnoeuds + "\n  " + optimale.affiche());
    }

    public int getnb() {
        return nbnoeuds;
    }
}
