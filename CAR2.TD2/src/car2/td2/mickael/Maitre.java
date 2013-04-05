package car2.td2.mickael;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mirolo
 */
public class Maitre 
{
    public static void main(String args[])
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry("MIAGE210A-17.dmiage.u-paris10.fr", 1099);

            BalItf balItf = (BalItf) registry.lookup("BalItf");
            
            JobItf j1 = RMIFactory.createJob(1);
            JobItf j2 = RMIFactory.createJob(2);
            
            balItf.putJob(j1);
            balItf.putJob(j2);

            Callback cb = new Callback();
            CallbackItf cbItf = (CallbackItf) UnicastRemoteObject.exportObject(cb,0);
            registry.rebind("CallbackItf", cbItf);// on binde le stub et pas l'objet
            
            System.out.println("Le maître a ajouté des jobs...");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
