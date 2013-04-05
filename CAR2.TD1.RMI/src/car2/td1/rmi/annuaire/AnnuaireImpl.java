/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.td1.rmi.annuaire;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author fasalles
 */
public class AnnuaireImpl implements AnnuaireItf, Serializable
{
    
    private Map<String,Object> annuaire;
    
    public AnnuaireImpl()
    {
        annuaire = new Hashtable();
    }
    
    public Object search(String key)
    {
        if(!annuaire.containsKey(key))
        {
        }
        return annuaire.get(key);
    }
    
    public void add(String key, Personne value)
    {
        annuaire.put(key, value);
    }
    
}
