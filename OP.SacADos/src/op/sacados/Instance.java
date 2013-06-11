package op.sacados;
import java.util.*;

/**
 * 
 * @author Fabien
 */
public class Instance
{

    public ListeObjets objets;
    public int nbobjet;
    public int PoidsMax;
    public int VolumeMax;

    public Instance(int nb, ListeObjets obj, int pm, int vm)
    {
        this.objets = obj;
        this.nbobjet = nb;
        this.PoidsMax = pm;
        this.VolumeMax = vm;
        this.objets.trie();
    }

    public void affiche()
    {
        System.out.println(nbobjet + " " + PoidsMax + "\n");
        System.out.println(objets.affichelnum());
        System.out.println(objets.affichelpoids());
        System.out.println(objets.affichelutil());
        System.out.println(objets.affichelVolume());
    }
}
