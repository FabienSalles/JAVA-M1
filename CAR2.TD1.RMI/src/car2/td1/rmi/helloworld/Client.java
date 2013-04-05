package car2.td1.rmi.helloworld;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client
{
    public static void main (String[] args)throws Exception
    {
        // exécution avec une seule machine
        Registry registry = LocateRegistry.getRegistry();
        //exécution avec deux machines
        // Registry registry =
        LocateRegistry.getRegistry("IP de la machine où tourne rmiregistry");
        HelloItf refObjDistant = (HelloItf)registry.lookup("//MIAGE210A-19.dmiage.u-paris10.fr/HelloServer");
        System.out.println(refObjDistant.concat("Hello ","world"));
    }
}
