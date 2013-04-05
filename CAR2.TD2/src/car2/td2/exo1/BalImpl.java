/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.td2.exo1;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author fasalles
 */
public class BalImpl implements BalItf, Serializable
{
    
    Queue<Job> bal;
    
    public BalImpl()
    {
        bal = new LinkedList<Job>();
    }

    public Job getJob(){
        return (Job)bal.remove();
    }

    public void putJob(Job value) {
        bal.add(value);
    }
    
}
