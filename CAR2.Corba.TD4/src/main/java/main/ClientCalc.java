/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import calculatrice.Calculatrice;
import calculatrice.CalculatriceHelper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TCKind;

/**
 *
 * @author keberne
 */
public class ClientCalc {
    static Calculatrice href;
    public static void main(String args[]){
        try{
            // initialiser l’ORB
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Any a = orb.create_any();
            org.omg.CORBA.Any b = orb.create_any();
            // recuperer la chaine de carac via le fichier
            BufferedReader br = new BufferedReader(new FileReader("FicPourIOR"));
            String ior = br.readLine();
            br.close();
            // conversion String to Object et restriction au type Hello
            org.omg.CORBA.Object obj = orb.string_to_object(ior);
            href = CalculatriceHelper.narrow(obj);
            Scanner scan = new Scanner(System.in);
            while(true){
                Any result = null;
                System.out.println("Que voulez vous faire ?");
                System.out.println("1-Addition\n2-Soustraction\n3-Multiplication\n4-Division\n0-Quitter");
                int choix = scan.nextInt();
               switch(choix)
               {
                   case 0:
                       orb.shutdown(false);
                       break;
                   case 1:
                       a.insert_double(1.20);b.insert_double(8);
                       result = href.addition(a, b);
                        System.out.println(result.extract_double());
                       break;
                   case 2:
                       a.insert_float(12);b.insert_double(8);
                       result = href.sub(a, b);
                       break;
                   case 3:
                        a.insert_double(1.2);b.insert_long(8);
                        result = href.mult(a, b);
                       break;
                   case 4:
                       a.insert_long(10);b.insert_long(8);
                       result = href.div(a, b);
                       break;
                   default:
                       System.out.println("Erreur");
                       break;
               }
               switch(result.type().kind().value())
               {
                   case TCKind._tk_float:
                       System.out.println(result.extract_float());
                       break;
                   case TCKind._tk_double:
                       System.out.println(result.extract_double());
                       break;
                   case TCKind._tk_long:
                       System.out.println(result.extract_long());
                       break;
                   default:
                        System.out.println("Erreur type : "+result.type().kind().value());
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
