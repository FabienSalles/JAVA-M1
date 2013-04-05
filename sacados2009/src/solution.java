public class solution {

    public listeobjets sac;
    public int valeur;

    public solution(listeobjets s) {
        sac = s;
        valeur = s.getutil();
    }

    public String affiche() {
        return "valeur : " + valeur + " poids :" + sac.getpoids() + "  objets :" + sac.affichelnum();
    }
}
