public class objet implements java.lang.Comparable {

    private int num; //numéro de l'objet'
    private int poids; // poids de l'objet
    private int util; // utilité de l'objet
    
    // Ajouter objet

    public objet(int num, int poids, int util) {
        this.num = num;
        this.poids = poids;
        this.util = util;
    }

    public double getratio() {
        return (double) util / poids;

    }

    public int getnum() {
        return num;
    }

    public int getpoids() {
        return poids;
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