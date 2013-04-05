package car2.td1.rmi.helloworld;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
public class Server
{
    public static void main (String[] args) throws Exception
    {
        HelloImpl obj = new HelloImpl();
        // créer le stub (0 => port attribué dynamiquement)
        HelloItf stub = (HelloItf)UnicastRemoteObject.exportObject(obj, 0);
        //lancer rmiregistry sur 1099 (port par défaut)
        Registry registry = LocateRegistry.createRegistry(1099);
        // on binde le stub et pas l'objet
        registry.rebind("//MIAGE210A-19.dmiage.u-paris10.fr/HelloServer", stub);
        System.out.println("server ready...");
    }
}
