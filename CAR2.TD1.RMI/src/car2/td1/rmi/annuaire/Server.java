/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.td1.rmi.annuaire;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author fasalles
 */
public class Server
{
    public static void main (String[] args) throws Exception
    {
        AnnuaireItf obj = new AnnuaireImpl();
        Personne pers1 = new Personne("bob", "henry");
        
        obj.add("bob", pers1);
        // créer le stub (0 => port attribué dynamiquement)
        AnnuaireItf stub = (AnnuaireItf)UnicastRemoteObject.exportObject(obj, 0);
        //lancer rmiregistry sur 1099 (port par défaut)
        Registry registry = LocateRegistry.createRegistry(1099);
        // on binde le stub et pas l'objet
        registry.rebind("//MIAGE210A-19.dmiage.u-paris10.fr/HelloServer", stub);
        System.out.println("server ready...");
        
    }
}