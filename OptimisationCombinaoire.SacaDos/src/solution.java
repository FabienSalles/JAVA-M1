/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
import java.util.*;

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
