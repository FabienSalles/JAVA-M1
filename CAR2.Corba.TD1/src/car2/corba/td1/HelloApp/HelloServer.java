/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.corba.td1.HelloApp;

import HelloApp.Hello;
import HelloApp.HelloHelper;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/**
 *
 * @author fsalles
 */
public class HelloServer
{
    public static void main(String args[])
    {
        // init l'ORB
        ORB orb = ORB.init(args, null);
        POA rootpoa;
        try {
            // récuperer l'IOR du rootpoa & activer le POAManager
            rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            // créer le servant
            HelloImpl helloImpl = new HelloImpl();
            helloImpl.setORB(orb); 
            
            // créer l'objet corba et l'enregistrer auprés du POA
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
            Hello href = HelloHelper.narrow(ref);
            // Use NamingContextExt which is part of the Interoperable
            // Naming Service (INS) specification.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(ref);

            // bind the Object Reference in Naming
            String name = "Hello";
            NameComponent path[] = ncRef.to_name( name );
            ncRef.rebind(path, href);
      
            // publication de l'IOR par fichier
            String IORenString = orb.object_to_string(ref);
            FileWriter fw = new FileWriter("FicPourIOR");
            fw.write(IORenString);
            fw.close();
            
            // attendre les invocations des clients
            orb.run();
        } catch (NotFound ex) {
            Logger.getLogger(HelloServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotProceed ex) {
            Logger.getLogger(HelloServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(HelloServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HelloServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServantNotActive ex) {
            Logger.getLogger(HelloServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WrongPolicy ex) {
            Logger.getLogger(HelloServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AdapterInactive ex) {
            Logger.getLogger(HelloServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidName ex) {
            Logger.getLogger(HelloServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
