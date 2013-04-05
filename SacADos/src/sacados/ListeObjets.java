package sacados;

import java.util.*;

/**
 * 
 * @author Fabien
 */
public class ListeObjets
{
    private Vector<Objet> lst;

    public ListeObjets()
    {
        lst = new Vector<Objet>();
    }

    public void setliste(Vector<Objet> v)
    {
        lst = v;
    }

    public Vector<Objet> getliste()
    {
        return lst;
    }

    public void trie()
    {
        Collections.sort(lst);
    }

    public int taille()
    {
        return lst.size();
    }

    public void ajout(Objet x)
    {
        lst.add(x);
    }

    public void retire(int i)
    {
        lst.remove(i);
    }

    public void retireobjet(Objet x)
    {
        lst.remove(x);
    }

    public Objet get(int i)
    {
        return (lst.get(i));
    }

    /**
     * Retourne le poids des objets
     */
    public int getpoids()
    {
        int pds = 0;
        
        for (int i = 0; i < lst.size(); i++)
        {
            pds += lst.get(i).getpoids();
        }
        
        return pds;
    }

    /**
     * Retourne l'utilité des objets
     */
    public int getutil()
    {
        int u = 0;
        
        for (int i = 0; i < lst.size(); i++)
        {
            u += lst.get(i).getutil();
        }
        
        return u;
    }

    /**
     * Retourne le volume des objets
     */
    public int getVolume()
    {
        int v = 0;
        
        for (int i = 0; i < lst.size(); i++)
        {
            v += lst.get(i).getVolumes();
        }
        
        return v;
    }

    /**
     * Duplique la liste
     * @return 
     */
    public ListeObjets duplique()
    {
        ListeObjets l = new ListeObjets();
        Vector<Objet> v = (Vector<Objet>) lst.clone();
        l.setliste(v);
        return l;
    }

    public void append(ListeObjets l)
    {
        lst.addAll(l.getliste());
    }

    public int index(Objet o)
    {
        // index si l'objet est dans la liste, -1 sinon'
        if (lst.contains(o)) {
            return lst.indexOf(o);
        } else {
            return (-1);
        }
    }

    public String affiche()
    {
        String s = "";
        for (int i = 0; i < lst.size(); i++) {
            s = s + lst.get(i).affiche();
        }
        return s + "\n";
    }

    public String affichelnum()
    {
        String s = "";
        for (int i = 0; i < lst.size(); i++)
        {
            s = s + " " + lst.get(i).getnum();
        }
        
        return s + "\n";
    }

    public String affichelpoids()
    {
        String s = "";
        for (int i = 0; i < lst.size(); i++)
        {
            s = s + " " + lst.get(i).getpoids();
        }
        
        return s + "\n";
    }

    public String affichelutil()
    {
        String s = "";
        for (int i = 0; i < lst.size(); i++)
        {
            s = s + " " + lst.get(i).getutil();
        }
        
        return s + "\n";
    }

    public String affichelVolume()
    {
        String s = "";
        
        for (int i = 0; i < lst.size(); i++)
        {
            s = s + " " + lst.get(i).getVolumes();
        }
        return s + "\n";
    }
}
