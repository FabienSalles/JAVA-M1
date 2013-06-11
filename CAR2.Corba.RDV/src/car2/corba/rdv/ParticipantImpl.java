/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.corba.rdv;

import rdv.ParticipantPOA;

/**
 *
 * @author fsalles
 */
public class ParticipantImpl extends ParticipantPOA{

    @Override
    public void rdvTermine(String nom) {
        System.out.println("RDv "+nom+" terminé !");
    }
    
    
}
