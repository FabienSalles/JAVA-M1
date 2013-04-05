/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.td1.rmi.annuaire;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author fasalles
 */
public class Client {
    public static void main (String[] args)throws Exception
    {
        // exécution avec une seule machine
        Registry registry = LocateRegistry.getRegistry();
        //exécution avec deux machines
        // Registry registry =
        LocateRegistry.getRegistry("IP de la machine où tourne rmiregistry");
        AnnuaireItf refObjDistant = (AnnuaireItf)registry.lookup("//MIAGE210A-19.dmiage.u-paris10.fr/HelloServer");
        System.out.println("Recherche de bob "+((Personne)refObjDistant.search("bob")).getNum());
    }
}
