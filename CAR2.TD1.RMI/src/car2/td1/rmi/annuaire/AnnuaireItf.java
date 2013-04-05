/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.td1.rmi.annuaire;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 *
 * @author fasalles
 */
public interface AnnuaireItf extends Remote
{
    public Object search(String key) throws RemoteException;
    public void add(String key, Personne value) throws RemoteException;
}
