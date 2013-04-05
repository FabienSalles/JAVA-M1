package car2.td2.mickael;


import java.io.Serializable;
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
public interface CallbackItf   extends Remote,Serializable{
    
    public void fini()  throws RemoteException;;
    
}
