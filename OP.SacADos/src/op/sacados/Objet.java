package op.sacados;

/**
 * 
 * @author Fabien
 */
public class Objet implements java.lang.Comparable
{
    public static Integer Heuristique = 1;
    
    private int num;
    private int poids;
    private int util;
    private int volumes;

    public Objet(int num, int poids, int util, int volume)
    {
        this.num = num;
        this.poids = poids;
        this.util = util;
        this.volumes = volume;
    }

    public double getratio()
    {
        double ratio;
        switch(Heuristique)
        {
            case 2:
                ratio = (double) util / poids;
                break;
            case 3:
                ratio = (double) util / volumes;
                break;
            case 1:
            default:
                ratio = (double) util / (poids + volumes);
                break;
        }
        return ratio;

    }

    public int getnum()
    {
        return num;
    }

    public int getpoids()
    {
        return poids;
    }

    public int getutil()
    {
        return util;
    }

    public int getVolumes()
    {
        return volumes;
    }
    
    

    public int compareTo(Object t2)
    {
        if (this.getratio() < ((Objet) t2).getratio()) {
            return 1;
        } else if (this.getratio() == ((Objet) t2).getratio()) {
            return 0;
        } else {
            return -1;
        }
    }

    public String affiche()
    {
        return "(" + num + "," + poids + "," + util + "," + volumes + ")";
    }
}