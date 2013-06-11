/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import car2.corba.job.Job;
import car2.corba.job.JobFact.JobFactory;
import car2.corba.job.JobFact.JobFactoryHelper;
import car2.corba.job.JobFactoryLB.FactoryLB;
import car2.corba.job.JobFactoryLB.FactoryLBHelper;
import car2.corba.job.JobProcess;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import org.omg.CORBA.ORB;

/**
 *
 * @author fsalles
 */
public class client {
    public static void main(String args[]){
        try{
            // initialiser l’ORB
            ORB orb = ORB.init(args, null);
            // recuperer la chaine de carac via le fichier
            BufferedReader br = new BufferedReader(new FileReader("FicPourIORLB"));
            String ior = br.readLine();
            br.close();
            // conversion String to Object et restriction au type Hello
            org.omg.CORBA.Object obj = orb.string_to_object(ior);
            FactoryLB href = FactoryLBHelper.narrow(obj);
            Scanner scan = new Scanner(System.in);
            
            while(true){
                System.out.println("Que voulez vous faire ?");
                System.out.println("1-Ajouter un Job\n0-Quitter");
                int choix = scan.nextInt();
                switch(choix){
                    case 0:
                        orb.shutdown(false);
                        break;
                    case 1:
                        System.out.println("Type : ");
                        double type = scan.nextDouble();
                        System.out.println("Message : ");
                        String msg = scan.next();
                        JobProcess job = href.createJob(new Job(msg, type));
                        job.run();
                        break;  
                    default:
                        System.out.println("Erreur");
                        break;
                }
            }
        // Gestion des exceptions
        } catch (Exception e) {
        System.out.println("ERROR : " + e) ;
        e.printStackTrace(System.out);
        }
    }
}
