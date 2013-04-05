package car2.td1.rmi.helloworld;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author fasalles
 */
public interface HelloItf extends Remote{
    String concat( String a, String b ) throws RemoteException;
}
