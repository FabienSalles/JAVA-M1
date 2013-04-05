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

    public static int nbnoeuds = 0; // Compte le nombre de noued que l'on a créé
    // Variables partagées
    public static solution meilleure; // X0 dans le cours
    public static instance probleme;
    private int num; // Numero du noeud
    private listeobjets choisis;
    private listeobjets rejetes;
    private listeobjets variables; // Les autres objets
    
    // Caracterise le noeud
    private int evalexces;
    private int evaldefaut;
    
    private int statut; // Ouvert ou fermé
    private objet frontiere; // Correspond a l'objet a la fin du sac (celui qu'on ajoute a moitié)
    private Vector<noeud> listefils;
    
    
    
    // A modifier le plus

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
     * Elimine des cas simples et logique (triviaux)
     * Ajouter au objets rejetés les objets qui ne seront pas compatibles par la suite
     */
    public void dominance() {
        int p = choisis.getpoids();
        int i = 0;
        while ((variables.taille() != 0) && (i < variables.taille())) {
            if (p + variables.get(i).getpoids() > probleme.PoidsMax) {
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
     * Rempli les evaluations par exces et par defaut du noeud
     */
    public void evalue() {
        listeobjets l = choisis.duplique();
        int pm = probleme.PoidsMax;
        int i = 0;
        double x;
        int z;
        int p = choisis.getpoids();
        solution s;
        if (variables.taille() != 0) {
            variables.trie();
            while ((i < variables.taille()) && (p + variables.get(i).getpoids() <= pm)) {
                p = p + variables.get(i).getpoids();
                l.ajout(variables.get(i));
                i++;
            }
            if ((i == variables.taille()) || (l.getpoids() == pm)) {
                evalexces = l.getutil();
                evaldefaut = evalParDefaut();
            } else {
                frontiere = variables.get(i);
                z = frontiere.getpoids();
                x = (double) (pm - p) / (double) z;
                evalexces = l.getutil() + (int) Math.floor(x * frontiere.getutil());
                for (int j = i + 1; j < variables.taille(); j++) {
                    if (p + variables.get(j).getpoids() <= pm) {
                        p = p + variables.get(j).getpoids();
                        l.ajout(variables.get(j));
                    }
                }
                evaldefaut = l.getutil();
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
        return 0;
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

    /**
     * Ferme ou ouvre un noeud
     */
    public void setstatut() {
        if ((variables.taille() == 0) || (evaldefaut == evalexces) || (evalexces <= meilleure.valeur)) {
            statut = 0; // Fermé
        } else {
            statut = 1; // Ouvert
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
     * Créer deux fils a partir d'un noued
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