package car2.td2.mickael;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mirolo
 */
public class Esclave 
{
     
    public static void main(String args[])
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry("MIAGE210A-17.dmiage.u-paris10.fr", 1099);

            BalItf balItf = (BalItf) registry.lookup("BalItf");
            
            System.out.println("Job : " + balItf.getJob().kelJob());

            
            CallbackItf cbItf = (CallbackItf) registry.lookup("CallbackItf");
            
            cbItf.fini();
            
        }
        catch(Exception e)
        {
        }
        
        
        
    }
    
        
}
