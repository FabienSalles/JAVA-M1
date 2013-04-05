package car2.td2.mickael;


import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mirolo
 */
public class Bal implements BalItf,Serializable
{
    
    Vector <JobItf> listeJob;

    public Bal()
    {
        this.listeJob =new Vector();
    }
    
    
    @Override
    public void putJob(JobItf j)
    {
        listeJob.addElement(j);
    }
    
    
    @Override
    public JobItf getJob()
    {

        if(listeJob.size()>0)
        {
            return listeJob.remove(0);
        }

        return null;
    }

    public static void main(String args[])
    {
        try
        {
            Bal bal = new Bal();

            BalItf balItf = (BalItf) UnicastRemoteObject.exportObject(bal,0);

            Registry registry = LocateRegistry.createRegistry(1099);
            
            registry.rebind("BalItf", balItf);// on binde le stub et pas l'objet
        
            System.out.println("La boite aux lettres est prête...");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    
}
