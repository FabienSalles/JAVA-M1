/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.td2.exo1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author fasalles
 */
public class Bal {
    public static void main (String[] args) throws Exception
    {
        BalItf obj = new BalImpl();
        // créer le stub (0 => port attribué dynamiquement)
        BalItf stub = (BalItf)UnicastRemoteObject.exportObject(obj, 0);
        //lancer rmiregistry sur 1099 (port par défaut)
        Registry registry = LocateRegistry.createRegistry(1099);
        // on binde le stub et pas l'objet
        registry.rebind("HelloServer", stub);
        System.out.println("server ready...");
        
    }
}
