package car2.td2.mickael;


import java.io.Serializable;
import java.rmi.RemoteException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mirolo
 */
public class Callback implements CallbackItf,Serializable{

    public Callback() {
    }

    
    
    
    @Override
    public void fini() {
        System.out.println("Le client a finis");;
    }

    
}
