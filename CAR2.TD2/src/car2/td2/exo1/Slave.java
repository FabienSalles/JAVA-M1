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
public class Slave {
    public static void main (String[] args)throws Exception
    {
        // exécution avec une seule machine
        Registry registry = LocateRegistry.getRegistry("MIAGE210A-17.dmiage.u-paris10.fr");
        BalItf refObjDistant = (BalItf)registry.lookup("HelloServer");
        System.out.println("Récupère le job1");
        System.out.println(refObjDistant.getJob());
        System.out.println("Récupère le job2");
        System.out.println(refObjDistant.getJob());
    }
}
