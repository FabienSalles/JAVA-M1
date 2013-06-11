/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.corba.rdv;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import rdv.FactRdvPOA;
import rdv.RdvItf;
import rdv.RdvItfHelper;
import rdv.rdvsHolder;

/**
 *
 * @author fsalles
 */
public class FactRdvImpl extends FactRdvPOA{
    private POA poa;
    rdvsHolder rdvs;
    private int nb;
    
    public FactRdvImpl(POA poa)
    {
        this.rdvs = new rdvsHolder();
        this.rdvs.value = new RdvItf[20];
        this.poa = poa;
        nb = 0;
    }
    
    @Override
    public RdvItf creer(int nombre, String nom) {
       RdvImpl rdv = new RdvImpl(nombre, nom);
      
       org.omg.CORBA.Object ref = null;
        try {
    
           ref = this.poa.servant_to_reference(rdv);
            
        } catch (ServantNotActive ex) {
           
        } catch (WrongPolicy ex) {
           
        }
        
        this.rdvs.value[this.nb] = (RdvItf) RdvItfHelper.narrow(ref);
        nb++;
        return (RdvItf) RdvItfHelper.narrow(ref);
    }

    @Override
    public RdvItf chercher(String nom) {
        RdvItf find = null;
        for(int i=0; i<this.nb; i++)
        {
            if (this.rdvs.value[i].getNom().equals(nom))
            {
                find = this.rdvs.value[i];
            }
        }
        
        return find;
    }

    @Override
    public RdvItf[] getRdvs() {
        return rdvs.value;
    }

    @Override
    public int getNb() {
        return this.nb;
    }
    
}
