/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.corba.td0.HelloApp;

import HelloApp.Hello;
import HelloApp.HelloHelper;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.*;
/**
 *
 * @author fsalles
 */
public class HelloClient
{
    static Hello href;
    
    public static void main(String args[])
    {
        BufferedReader br = null;
        try {
            // init l'ORB
            ORB orb = ORB.init(args, null);
            br = new BufferedReader(new FileReader("FicPourIOR"));
            String ior = br.readLine();
            br.close();
            
            // conversion String to Object et restriction au type Hello
            org.omg.CORBA.Object obj = orb.string_to_object(ior);
            href = HelloHelper.narrow(obj);
            
            //utiliser l'objet server en invoquant ses méthodes
            System.out.println("Obtained a handle on server object : "+href);
            System.out.println(href.sayHello());
        } catch (IOException ex) {
            Logger.getLogger(HelloClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(HelloClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
