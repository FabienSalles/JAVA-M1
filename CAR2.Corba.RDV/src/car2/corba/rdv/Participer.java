/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.corba.rdv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import rdv.FactRdv;
import rdv.FactRdvHelper;
import rdv.Participant;
import rdv.ParticipantHelper;
import rdv.RdvItf;
import rdv.RdvItfHelper;

/**
 *
 * @author fsalles
 */
public class Participer {
    public static void main(String args[]) throws InvalidName, AdapterInactive, ServantNotActive, WrongPolicy{
        BufferedReader br = null;
        try {
            // initialiser l’ORB
            ORB orb = ORB.init(args, null);
            br = new BufferedReader(new FileReader("FicPourIOR"));
            String ior = br.readLine();
            br.close();
            // conversion String to Object et restriction au type Hello
            org.omg.CORBA.Object obj = orb.string_to_object(ior);
            FactRdv href = FactRdvHelper.narrow(obj);
            Scanner scan = new Scanner(System.in);
            
            // initialise et converti le participant afin de pouvoir le transférer
            ParticipantImpl participant = new ParticipantImpl();
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(participant);
            Participant moi = ParticipantHelper.narrow(ref);
            
            while(true){
                System.out.println("Que voulez vous faire ?");
                System.out.println("1-Ajouter un Rdv\n2-Lister les rdvs\n3-Participer à un rdv\n4-Terminer un rdv\n0-Quitter");
                int choix = scan.nextInt();
                switch(choix){
                    case 0:
                        orb.shutdown(false);
                        break;
                    case 1:
                        System.out.println("Nombre de participants : ");
                        Integer nb = scan.nextInt();
                        System.out.println("Nom du rdv : ");
                        String nom = scan.next();
                        href.creer(nb, nom);
                        break;
                    case 2:
                        System.out.println("Liste des rdvs : ");
                        RdvItf[] rdvs = href.getRdvs();
                        for(int i=0; i<href.getNb(); i++)
                        {
                            System.out.println("nom : "+rdvs[i].getNom()+" ,nombre : "+rdvs[i].getNombre());
                        }
                        break;
                    case 3:
                        System.out.println("Nom du rdv : ");
                        String name = scan.next();
                        RdvItf rdv = (RdvItf) href.chercher(name);
                        rdv.rejoindre((Participant)moi);
                        break;
                    default:
                        System.out.println("Erreur");
                        break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Participer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Participer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
