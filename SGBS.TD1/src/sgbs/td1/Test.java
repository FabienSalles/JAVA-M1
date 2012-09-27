/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbs.td1;

/**
 *
 * @author fasalles
 */
import java.sql.*;
public class Test {
	
    private Connection conn;

    public Test(){}

    public void connect(String login, String password)
    {	
        try{

        } catch (SQLException e){
            System.out.println ("Problème de connexion !!!");
            System.out.println (e.getMessage()); 
        }	    
    }
	
    public void disconnect(){
        try {
            
        }catch (SQLException e){
            System.out.println ("Problème de déconnexion !!!");
            System.out.println (e.getMessage()); 
        }	    
    }
	
    public ResultSet executeQuery(String query)
    {
        try {
            System.out.println("--------------Execution de la requête: "+query+" ----------------------------------");
            return rset;
        }
        catch (SQLException e){
            System.out.println ("Problème quelque part !!!");
            System.out.println (e.getMessage()); 
        }
        return null;
    }
	
    //cette fonction affiche le cas ou le resultat est de type entier; nbcolumn constitue la ième colonne du resultset à afficher.
    public void browseResultInt(ResultSet res, int nbColumn)
    {
        int nb=1;
        try {	

        }
        catch (SQLException e){
            System.out.println ("Problème d'affichage du résultat !!!");
            System.out.println (e.getMessage());
        }
    }
    //cette fonction affiche le cas ou le resultat est de type chaine de caractères; nbcolumn constitue la ième colonne du resultset à afficher.
    public void browseResultString(ResultSet res, int nbColumn)
    {
        int nb=1;
        try {	

        } catch (SQLException e)
        {
            System.out.println ("Problème d'affichage du résultat !!!");
            System.out.println (e.getMessage());
        }
    }

}
