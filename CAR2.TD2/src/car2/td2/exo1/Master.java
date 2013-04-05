/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.td2.exo1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author fasalles
 */
public class Master {
    public static void main (String[] args)throws Exception
    {
        // exécution avec une seule machine
        Registry registry = LocateRegistry.getRegistry("MIAGE210A-17.dmiage.u-paris10.fr", 1099);
        //exécution avec deux machines
        // Registry registry =
        //LocateRegistry.getRegistry("IP de la machine où tourne rmiregistry");
        BalItf refObjDistant = (BalItf)registry.lookup("HelloServer");
        System.out.println("Ajout du job1");
        refObjDistant.putJob(new Job1("Je suis le job 1"));
        System.out.println("Ajout du job2");
        refObjDistant.putJob(new Job2("Je suis le job 2"));
    }
}
