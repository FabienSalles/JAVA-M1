package sacados;

import java.util.Vector;

/**
 * Generator
 * @author Fabien
 */
public class Generator
{
    public int nbinst;
    public int op;
    public int ow;
    public int ov;
    public int t;
    public Vector<Instance> instances;

    /**
     * Génération des instances
     */
    public Generator(int nbinst, int t, int op, int ow, int ov)
    {
        this.op = op;
        this.t = t;
        this.ow = ow;
        this.ov = ov;
        this.nbinst = nbinst;
        this.instances = new Vector<Instance>();
        
        for (int i = 0; i < nbinst; i++)
        {
            this.instances.add(this.MakeInstance(t, op, ow, ov));
        }
    }

    /**
     * Fait une instance
     */
    public Instance MakeInstance(int taille, int ordrepoids, int ordreprofit, int ordrevolumes)
    {
        Instance pb;
        int poids;
        int util;
        int volume;
        ListeObjets x;
        Vector<Objet> tableau;

        x = new ListeObjets();
        
        for (int i = 0; i < taille; i++)
        {
            poids = (int) (Math.random() * ordrepoids) + 1;
            util = (int) (Math.random() * ordreprofit) + 1;
            volume = (int) (Math.random() * ordrevolumes) + 1;
            x.ajout(new Objet(i, poids, util, volume));
        }
        
        poids = (int) (Math.random() * x.getpoids()) + 5;
        volume = (int) (Math.random() * x.getVolume()) + 5;
        pb = new Instance(taille, x, poids, volume);
        
        return pb;
    }

    public void affiche()
    {
        for (int i = 0; i < nbinst; i++)
        {
            System.out.println("instance " + i + "\n");
            instances.get(i).affiche();
        }
    }
}
