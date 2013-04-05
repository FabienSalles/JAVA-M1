/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
import java.util.Vector;

public class noeud implements java.lang.Comparable {

    public static int nbnoeuds = 0;
    public static solution meilleure;
    public static instance probleme;
    private int num;
    private listeobjets choisis;
    private listeobjets rejetes;
    private listeobjets variables;
    private int evalexces;
    private int evaldefaut;
    private int statut;
    private objet frontiere;
    private Vector<noeud> listefils;

    public noeud(listeobjets c, listeobjets r, listeobjets v) {
        num = this.nbnoeuds++;
        choisis = c;
        rejetes = r;
        variables = v;
    }

    public void traiteracine(instance p) {
        this.probleme = p;
        this.variables = p.objets.duplique();
        meilleure = new solution(new listeobjets());
        this.dominance();
        this.evalue();
        this.setstatut();
    }

    public void traitenoeud() {
        this.dominance();
        this.evalue();
        this.setstatut();
    }

    /**
     * 
     */
    public void dominance() {
        int p = choisis.getpoids();
        int i = 0;
        while ((variables.taille() != 0) && (i < variables.taille())) {
            if ((p + variables.get(i).getpoids() > probleme.PoidsMax) || (p + variables.get(i).getVolumes() < probleme.VolumesMax)) {
                rejetes.ajout(variables.get(i));
                variables.retire(i);
            } else {
                i++;
            }
        }
        if (variables.taille() == 1) {
            choisis.ajout(variables.get(0));
            variables.retire(0);
        }
    }

    /**
     * Evalue par excès et defaut
     */
    public void evalue() {
        listeobjets l = choisis.duplique();
        int pm = probleme.PoidsMax;
        int pv = probleme.VolumesMax;
        int pvm = pm+pv;
        int i = 0;
        double x;
        int p2, v2;
        int p = choisis.getpoids();
        int v = choisis.getVolumes();
        
        solution s;
        if (variables.taille() != 0) {
            variables.trie();
            while ((i < variables.taille()) && (p + variables.get(i).getpoids() + v + variables.get(i).getVolumes() <= pvm)) {
                p = p + variables.get(i).getpoids();
                v = v + variables.get(i).getVolumes();
                l.ajout(variables.get(i));
                i++;
            }
            if ((i == variables.taille()) || (l.getpoids()+l.getVolumes() == pvm)) {
                evalexces = l.getutil();
                evaldefaut = evalParDefaut();
            } else {
                frontiere = variables.get(i);
                p2 = frontiere.getpoids();
                v2 = frontiere.getVolumes();
                x = (double) (pvm - p + v) / (double) (p2+v2);
                evalexces = l.getutil() + (int) Math.floor(x * frontiere.getutil());
                for (int j = i + 1; j < variables.taille(); j++) {
                    if (p + variables.get(j).getpoids() + v + variables.get(j).getVolumes() <= pvm) {
                        p = p + variables.get(j).getpoids();
                        v = v + variables.get(j).getVolumes();
                        l.ajout(variables.get(j));
                    }
                }
                evaldefaut = evalParDefaut();
            }

        } else {
            evalexces = l.getutil();
            evaldefaut = evalexces;
        }
        if (evaldefaut > meilleure.valeur) {
            meilleure = new solution(l);
        }
    }

    public int evalParDefaut()
    {
          // Algo on trie on range dans le tableau pas le rouge

        listeobjets l = choisis.duplique(); // Liste dans laquel on ajoute les objets
        int pm = probleme.PoidsMax; // Limite max du poids du sac
        int vm = probleme.VolumesMax; // Limite max du volume du sac
        int i = 0;
        int pSac = choisis.getpoids(); // Poids des objets deja dans le sac
        int vSac = choisis.getVolumes(); // Volume des objets dans la sac

        // S'il y a des objets restants a placés on les traitent
        if (variables.taille() != 0) {
            variables.trie(); // On trie les variable utilité / poids + volume

            // Tant que on peut ajouter l'objet dans le sac
            // L'objet n'atteint pas le poids max et de meme pour le volume

            // Tant qu'il y a des objets
            while ((i < variables.taille())) {
                // Eval par defaut on prend sans coupé
                // Si le poids de l'objet est inferieur au poids max du sac et si le volume de l'objet est inferieur au volume max du sac on l'ajoute
                if (pSac + variables.get(i).getpoids() <= pm && vSac + variables.get(i).getpoids() <= vm) {
                    pSac = pSac + variables.get(i).getpoids(); // Ajoute le poids de l'objet au sac
                    vSac = vSac + variables.get(i).getVolumes(); // Ajoute le volume de l'objet au sac
                    // On l'ajoute dans le sac
                    l.ajout(variables.get(i));
                }
                i++;
            }
            evaldefaut = l.getutil();
        }
        return evaldefaut;
    }
    public int getstatut() {
        return statut;
    }

    public int getevalexces() {
        return evalexces;
    }

    public Vector<noeud> getfils() {
        return listefils;
    }

    public void setstatut() {
        if ((variables.taille() == 0) || (evaldefaut == evalexces) || (evalexces <= meilleure.valeur)) {
            statut = 0;
        } else {
            statut = 1;
        }
    }

    public void affiche() {
        System.out.println(num + " exces : " + evalexces + " defaut: " + evaldefaut + " statut " + statut + "\n");
        if (statut == 1) {
            System.out.println("fronti�re" + frontiere.getnum() + "\n");
        }
// System.out.println(meilleure.affiche());
    }

    /**
     * Sépare un noeud en 2 fils
     */
    public void separe() {
        listefils = new Vector<noeud>();
        if (statut == 1) {
            listeobjets cg, rg, vg, cd, rd, vd;
            noeud filsgauche, filsdroit;
            cg = choisis.duplique();
            cg.ajout(frontiere);
            cd = choisis.duplique();
            rg = rejetes.duplique();
            rd = rejetes.duplique();
            rd.ajout(frontiere);
            vg = variables.duplique();
            vg.retireobjet(frontiere);
            vd = vg.duplique();
            filsgauche = new noeud(cg, rg, vg);
            filsdroit = new noeud(cd, rd, vd);
            filsgauche.traitenoeud();
            filsdroit.traitenoeud();
            listefils.add(filsgauche);
            listefils.add(filsdroit);
            filsgauche.traitenoeud();
            filsdroit.traitenoeud();
        }
        statut = 0;
    }

    public solution getmeilleure() {
        return meilleure;
    }

    public int compareTo(Object n) {
        if (this.evalexces < ((noeud) n).getevalexces()) {
            return 1;
        } else if (this.evalexces == ((noeud) n).getevalexces()) {
            return 0;
        } else {
            return -1;
        }
    }
}