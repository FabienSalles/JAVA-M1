package car2.td2.mickael;


import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mirolo
 */
public interface JobItf  extends Remote
{
    public String kelJob() throws RemoteException;;
    
    
    
}
