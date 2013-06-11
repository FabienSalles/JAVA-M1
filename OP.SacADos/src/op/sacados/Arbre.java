package op.sacados;

import java.util.TreeSet;

/**
 * Class Arbre
 * @author Fabien
 */
public class Arbre {

    private Noeud racine;
    private Instance probleme;
    private TreeSet<Noeud> ouverts;
    private Solution optimale;
    private int nbnoeuds;

    public Arbre(Instance pb)
    {
        Noeud courant;
        ouverts = new TreeSet<Noeud>();
        probleme = pb;
        racine = new Noeud(new ListeObjets(), new ListeObjets(), new ListeObjets());
        racine.traiteracine(probleme);
        
        if (racine.getstatut() == 1)
        {
            ouverts.add(racine);
        }
        
        while (!ouverts.isEmpty())
        {
            courant = ouverts.first();
            ouverts.remove(courant);
            courant.separe();
            int i = 0;
            
            while (i < courant.getfils().size())
            {
                if (courant.getfils().get(i).getstatut() == 1)
                {
                    ouverts.add(courant.getfils().get(i));
                }
                i++;
            }

        }
        optimale = racine.getmeilleure();
        nbnoeuds = racine.nbnoeuds;
    }

    public void affiche()
    {
        System.out.println(optimale.affiche());
    }

    public int getnb()
    {
        return nbnoeuds;
    }
}
