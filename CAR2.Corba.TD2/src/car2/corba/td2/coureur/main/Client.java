/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.corba.td2.coureur.main;

import car2.corba.td2.coureur.TH;
import car2.corba.td2.coureur.THHelper;
import car2.corba.td2.coureur.THPackage.Personne;
import car2.corba.td2.coureur.THPackage.participantsHolder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import org.omg.CORBA.ORB;

/**
 *
 * @author fsalles
 */
public class Client {
    static TH href;
    public static void main(String args[]){
        try{
            // initialiser l’ORB
            ORB orb = ORB.init(args, null);
            // recuperer la chaine de carac via le fichier
            BufferedReader br = new BufferedReader(new FileReader("FicPourIOR"));
            String ior = br.readLine();
            br.close();
            // conversion String to Object et restriction au type Hello
            org.omg.CORBA.Object obj = orb.string_to_object(ior);
            href = THHelper.narrow(obj);
            Scanner scan = new Scanner(System.in);
            
            while(true){
                System.out.println("Que voulez vous faire ?");
                System.out.println("1-Inscrire un coureur\n2-Voir la liste des coureurs\n0-Quitter");
                int choix = scan.nextInt();
                if(choix>2)
                    System.out.println("Erreur");
                else if(choix==0)
                    orb.shutdown(false);
                else{
                    if(choix==1){
                        String nom,prenom;
                        //System.out.println("Tapez le prenom");
                        prenom = "Fabien            ";
                        //System.out.println("Tapez le nom");
                        nom = "Salles";
                        href.inscrire_coureur(new Personne(prenom,nom));
                    }
                    else {
                        participantsHolder ph = new participantsHolder();
                        href.liste_des_coureurs(ph);
                        for(int i=0;i<ph.value.length-1;i++)
                        System.out.println(ph.value[i].nom + " " + ph.value[i].prenom);
                    }
                }
            }
        // Gestion des exceptions
        } catch (Exception e) {
        System.out.println("ERROR : " + e) ;
        e.printStackTrace(System.out);
        }
    }
}
