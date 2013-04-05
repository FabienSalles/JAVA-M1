/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
public class objet implements java.lang.Comparable {

    private int num;//num�ro de l'objet'
    private int poids; // poids de l'objet
    private int volumes;
    private int util; // utilité de l'objet

    public objet(int num, int poids, int volumes, int util) {//constructeur
        this.num = num;
        this.poids = poids;
        this.volumes = volumes;
        this.util = util;
    }

    public double getratio() {
        return (double) util / (poids+volumes);

    }

    public int getnum() {
        return num;
    }

    public int getpoids() {
        return poids;
    }

    public int getVolumes() {
        return volumes;
    }
    
    

    public int getutil() {
        return util;
    }

    public int compareTo(Object t2) {
        if (this.getratio() < ((objet) t2).getratio()) {
            return 1;
        } else if (this.getratio() == ((objet) t2).getratio()) {
            return 0;
        } else {
            return -1;
        }
    }

    public String affiche() {
        return "(" + num + "," + poids + "," + util + ")";
    }
}