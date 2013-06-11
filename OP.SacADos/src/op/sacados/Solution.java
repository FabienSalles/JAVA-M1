package op.sacados;
/**
 * 
 * @author Fabien
 */
public class Solution
{

    public ListeObjets sac;
    public int valeur;

    public Solution(ListeObjets s)
    {
        sac = s;
        valeur = s.getutil();
    }

    public String affiche()
    {
        return "valeur : " + valeur;
    }
}
