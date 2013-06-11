/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileWriter;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author fsalles
 */
public class serverLb {
    public static void main(String[] args) {
        try{
            // initialiser l’ORB
            ORB orb = ORB.init(args, null);
            // recuperer l’IOR du rootpoa & activer le POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            // creer le servant
            JobFactLbImpl facto = new JobFactLbImpl(rootpoa);
            // creer l’objet CORBA et l’enregistrer auprès du POA
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(facto);
            // Publication de l’IOR par fichier
            String IORenString = orb.object_to_string(ref);
            FileWriter fw = new FileWriter("FicPourIORLB");
            fw.write(IORenString);
            fw.close();
            // Attendre les invocations des clients
            orb.run();
        }
        // Gestion des exceptions
        catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
}
