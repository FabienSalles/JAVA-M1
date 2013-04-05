
import java.util.Vector;

public class generator {

    public int nbinst;
    public int op;
    public int ow;
    public int t;
    public Vector<instance> instances;

    /**
     * Générer des instances
     * @param nbinst nb instances a générer aux hasards
     * @param t nombre d'objets des instances
     * @param op limite de poids des objets
     * @param ow limite max d'utilité des objets
     */
    public generator(int nbinst, int t, int op, int ow) {
        this.op = op;
        this.t = t;
        this.ow = ow;
        this.nbinst = nbinst;
        this.instances = new Vector<instance>();
        for (int i = 0; i < nbinst; i++) {
            this.instances.add(MakeInstance(t, op, ow));
        }
    }

    /**
     * Créer une instance
     * @param taille Nombre d'objets
     * @param ordrepoids Poids max
     * @param ordreprofit // Utilité max
     * @return 
     */
    public instance MakeInstance(int taille, int ordrepoids, int ordreprofit) {
        instance pb;
        int poids;
        int util;
        listeobjets x;
        Vector<objet> tableau;

        x = new listeobjets();
        for (int i = 0; i < taille; i++) {
            poids = (int) (Math.random() * ordrepoids) + 1;
            util = (int) (Math.random() * ordreprofit) + 1;
            x.ajout(new objet(i, poids, util));
        }
        poids = (int) (Math.random() * x.getpoids()) + 5;
        pb = new instance(taille, x, poids);
        return pb;
    }

    public void affiche() {
        for (int i = 0; i < nbinst; i++) {
            System.out.println("instance " + i + "\n");
            instances.get(i).affiche();
        }
    }
}
