/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
import java.util.Vector;
import java.util.Random;

public class generator {

    public int nbinst;
    public int op;
    public int ow;
    public int t;
    public Vector<instance> instances;
    
    /**
     * genère instance
     * @param nbinst
     * @param t nb objet
     * @param op limite poid
     * @param ow limite utilité
     */
    public generator(int nbinst, int t, int op, int ov, int ow) {
        this.op = op;
        this.t = t;
        this.ow = ow;
        this.nbinst = nbinst;
        this.instances = new Vector<instance>();
        for (int i = 0; i < nbinst; i++) {
            this.instances.add(this.MakeInstance(t, op, ov, ow));
        }
    }

    /**
     * 
     * @param taille
     * @param ordrepoids ordre de grandeur poids
     * @param ordreprofit
     * @return instance
     */
    public instance MakeInstance(int taille, int ordrepoids, int odrevolumes, int ordreprofit) {
        instance pb;
        int poids;
        int volumes;
        int util;
        listeobjets x;
        Vector<objet> tableau;

        x = new listeobjets();
        for (int i = 0; i < taille; i++) {
            poids = (int) (Math.random() * ordrepoids) + 1;
            volumes = (int) (Math.random() * odrevolumes) + 1;
            util = (int) (Math.random() * ordreprofit) + 1;
            x.ajout(new objet(i, poids, volumes, util));
        }
        poids = (int) (Math.random() * x.getpoids()) + 5;
        volumes = (int) (Math.random() * x.getVolumes()) + 5;
        pb = new instance(taille, x, poids, volumes);
        return pb;
    }

    public void affiche() {
        for (int i = 0; i < nbinst; i++) {
            System.out.println("instance " + i + "\n");
            instances.get(i).affiche();
        }
    }
}
