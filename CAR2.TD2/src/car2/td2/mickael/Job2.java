package car2.td2.mickael;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mirolo
 */
public class Job2 implements JobItf,Serializable
{


    public Job2() {
    }

    @Override
    public String kelJob() {
        return "job2";
    }
    
}
