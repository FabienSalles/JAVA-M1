package car2.corba.rdv;

import java.util.HashSet;
import java.util.Set;
import rdv.Participant;
import rdv.RdvItfPOA;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fsalles
 */
public class RdvImpl extends RdvItfPOA{
    private String nom;
    
    private Integer nombre;
    
    private Set<Participant> participants;

    public RdvImpl() {
        this.participants = new HashSet();
    }

    public RdvImpl(int nombre, String nom) {
       this.nom = nom;
       this.nombre = nombre;
    }

    @Override
    public int getNombre() {
        return nombre;
    }

    @Override
    public void rejoindre(Participant participant) {
        synchronized (this) {
            this.participants.add(participant);
        }
    }

    @Override
    public String toString() {
        return "nom=" + nom + ", nombre max=" + nombre +" nombre actuel="+participants.size();
    }

    @Override
    public String getNom() {
        return nom;
    }
    
    
    
}
