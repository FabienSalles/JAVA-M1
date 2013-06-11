/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import car2.corba.job.JobFact.JobFactoryHelper;
import car2.corba.job.JobFactoryLB.FactoryLB;
import car2.corba.job.JobFactoryLB.FactoryLBHelper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author fsalles
 */
public class server {
    public static void main(String[] args) {
        try{
            // initialiser l’ORB
            ORB orb = ORB.init(args, null);
            // recuperer l’IOR du rootpoa & activer le POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            BufferedReader br = new BufferedReader(new FileReader("FicPourIORLB"));
            String ior = br.readLine();
            br.close();
            org.omg.CORBA.Object obj = orb.string_to_object(ior);
            FactoryLB href = FactoryLBHelper.narrow(obj);
            // creer le servant
            JobFactoryImpl facto = new JobFactoryImpl(rootpoa);
            // creer l’objet CORBA et l’enregistrer auprès du POA
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(facto);
            href.register(JobFactoryHelper.narrow(ref));
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