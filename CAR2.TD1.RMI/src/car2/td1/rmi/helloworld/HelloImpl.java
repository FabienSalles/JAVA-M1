package car2.td1.rmi.helloworld;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;
/**
 *
 * @author fasalles
 */
public class HelloImpl implements HelloItf
{
    public HelloImpl() 
    {
        
    }
    
    public String concat(String a, String b)
    {
        return a+b;
    } 
}
