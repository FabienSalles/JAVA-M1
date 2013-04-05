/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.td2.exo1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author fasalles
 */
public interface BalItf extends Remote
{
    public Job getJob() throws RemoteException;
    public void putJob(Job value) throws RemoteException;
}
