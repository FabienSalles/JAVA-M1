/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.corba.td2.coureur;

import car2.corba.td2.coureur.THPackage.Personne;
import car2.corba.td2.coureur.THPackage.participantsHolder;
import java.util.ArrayList;

/**
 *
 * @author fsalles
 */
public class THImpl extends THPOA{

    ArrayList<Personne> list = new ArrayList();
    
    @Override
    public void inscrire_coureur(Personne p) {
        this.list.add(p);
    }

    @Override
    public void liste_des_coureurs(participantsHolder coureurs) {
        coureurs.value = new Personne[this.list.size()];
        for(int i=0; i < this.list.size(); i++)
        {
            coureurs.value[i] = (Personne) this.list.get(i);
        }
    }
    
}
