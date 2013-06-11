package op.sacados;

import java.util.Vector;

/**
 * 
 * @author Fabien
 */
public class Noeud implements java.lang.Comparable
{
    public static int nbnoeuds = 0; 
    public static Solution meilleure;
    public static Instance probleme;
    private int num;
    private int evalexces;
    private int evaldefaut;
    private int statut;
    private ListeObjets choisis;
    private ListeObjets rejetes;
    private ListeObjets variables;
    private Objet frontiere;
    private Vector<Noeud> listefils;

    public Noeud(ListeObjets c, ListeObjets r, ListeObjets v)
    {
        num = this.nbnoeuds++;
        choisis = c;
        rejetes = r;
        variables = v;
    }

    public void traiteracine(Instance p)
    {
        this.probleme = p;
        this.variables = p.objets.duplique();
        meilleure = new Solution(new ListeObjets());
        this.dominance();
        this.evalue();
        this.setstatut();
    }

    public void traitenoeud()
    {
        this.dominance();
        this.evalue();
        this.setstatut();
    }

    /**
     * Elimine les cas simples
     */
    public void dominance()
    {
        int p = choisis.getpoids();
        int i = 0;
        
        while ((variables.taille() != 0) && (i < variables.taille()))
        {
            if (p + variables.get(i).getpoids() > probleme.PoidsMax || p + variables.get(i).getVolumes() > probleme.VolumeMax)
            {
                rejetes.ajout(variables.get(i));
                variables.retire(i);
            }
            else
            {
                i++;
            }
        }
        
        if (variables.taille() == 1)
        {
            choisis.ajout(variables.get(0));
            variables.retire(0);
        }
    }

    /**
     * Fait les evaluations par exces et par defaut
     */
    public void evalue()
    {
        ListeObjets l = choisis.duplique();
        int p = choisis.getpoids();
        int v = choisis.getVolume();
        int pm = probleme.PoidsMax;
        int vm = probleme.VolumeMax;
        int pvm = pm + vm;
        int i = 0;
        int p2;
        int v2;
        double x;
        Solution s;
        
        // S'il y a des objets restants a placés on les placent
        if (variables.taille() != 0)
        {
            variables.trie();
            
            // Tant que l'objet rentre dans le sac
            while ((i < variables.taille()) && ((p + variables.get(i).getpoids()) + (v + variables.get(i).getVolumes()) <= pvm))
            {
                p = p + variables.get(i).getpoids(); 
                v = v + variables.get(i).getVolumes();
                l.ajout(variables.get(i));
                i++;
            }

            if ((i == variables.taille()) || (l.getpoids() + l.getVolume() == pvm))
            {
                evalexces = l.getutil();
                evaldefaut = evalParDefaut();
            }
            else
            {
                frontiere = variables.get(i);
                p2 = frontiere.getpoids();
                v2 = frontiere.getVolumes();
                x = (double) (pvm - (p + v)) / (double) (p2 + v2);
                evalexces = l.getutil() + (int) Math.floor(x * frontiere.getutil());

                for (int j = i + 1; j < variables.taille(); j++)
                {
                    if ((p + variables.get(j).getpoids()) + (v + variables.get(j).getVolumes()) <= pvm)
                    {
                        p = p + variables.get(j).getpoids();
                        v = v + variables.get(j).getVolumes();
                        l.ajout(variables.get(j));
                    }
                }

                evaldefaut = evalParDefaut();
            }
        }
        // exces = defaut
        else
        {
            evalexces = l.getutil();
            evaldefaut = evalexces;
        }

        // Si la meilleur solution a changer on l'a change
        if (evaldefaut > meilleure.valeur) {
            meilleure = new Solution(l);
        }
    }

    /**
     * Evalutation par defaut
     * @return 
     */
    public int evalParDefaut()
    {
        ListeObjets l = choisis.duplique();
        int p = choisis.getpoids();
        int v = choisis.getVolume();
        int pm = probleme.PoidsMax;
        int vm = probleme.VolumeMax;
        int i = 0;

        // S'il y a des objets restants a placés on les placent
        if (variables.taille() != 0)
        {
            variables.trie();

            while ((i < variables.taille()))
            {
                if (p + variables.get(i).getpoids() <= pm && v + variables.get(i).getpoids() <= vm)
                {
                    p = p + variables.get(i).getpoids();
                    v = v + variables.get(i).getVolumes();
                    l.ajout(variables.get(i));
                }
                
                i++;
            }
            evaldefaut = l.getutil();
        }
        
        return evaldefaut;
    }

    public int getstatut()
    {
        return statut;
    }

    public int getevalexces()
    {
        return evalexces;
    }

    public Vector<Noeud> getfils()
    {
        return listefils;
    }

    /**
     * Set le status du noeud (fermé ou ouvert)
     */
    public void setstatut()
    {
        if ((variables.taille() == 0) || (evaldefaut == evalexces) || (evalexces <= meilleure.valeur))
        {
            statut = 0;
        }
        else
        {
            statut = 1;
        }
    }

    public void affiche()
    {
        System.out.println(num + " exces : " + evalexces + " defaut: " + evaldefaut + " statut " + statut + "\n");
        if (statut == 1)
        {
            System.out.println("fronti�re" + frontiere.getnum() + "\n");
        }
    }

    public void separe()
    {
        listefils = new Vector<Noeud>();
        
        if (statut == 1)
        {
            ListeObjets cg, rg, vg, cd, rd, vd;
            Noeud filsgauche, filsdroit;
            cg = choisis.duplique();
            cg.ajout(frontiere);
            cd = choisis.duplique();
            rg = rejetes.duplique();
            rd = rejetes.duplique();
            rd.ajout(frontiere);
            vg = variables.duplique();
            vg.retireobjet(frontiere);
            vd = vg.duplique();
            filsgauche = new Noeud(cg, rg, vg);
            filsdroit = new Noeud(cd, rd, vd);
            filsgauche.traitenoeud();
            filsdroit.traitenoeud();
            listefils.add(filsgauche);
            listefils.add(filsdroit);
            filsgauche.traitenoeud();
            filsdroit.traitenoeud();
        }
        statut = 0;
    }

    public Solution getmeilleure()
    {
        return meilleure;
    }

    public int compareTo(Object n)
    {
        if (this.evalexces < ((Noeud) n).getevalexces())
        {
            return 1;
        }
        else if (this.evalexces == ((Noeud) n).getevalexces())
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
}