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
public interface BalItf  extends Remote,Serializable
{
    public void putJob(JobItf j) throws RemoteException;
    public JobItf getJob() throws RemoteException;
     
}
