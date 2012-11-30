/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exception.ConnectionNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fasalles
 * patern singleton
 */
public class Query{
    
    private final static String FILE_PROPS = "/properties/database.properties";
    /**
     * Driver
     */
    private String driver;
    /**
    * URL de connection
    */
    private String url;
    /**
    * Nom du user
    */
    private String user;
    /**
    * Mot de passe du user
    */
    private String passwd;

    /**
    * Objet Connection
    */
    private static Connection connect;
   
    /**
    * Constructeur privé
    */
    private Query()
    {
        Properties prop = new Properties();
        
        try {
            prop.load(Query.class.getResourceAsStream(FILE_PROPS));
        } catch (IOException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.driver = prop.getProperty("driver");
        this.url = prop.getProperty("url");
        this.user = prop.getProperty("user");
        this.passwd = prop.getProperty("passwd");
        
        try{
            Class.forName(this.driver);
        }
        catch(Exception ex){
            System.err.println("Erreur lors du changement du driver");
            ex.printStackTrace();
            System.exit(1);
        }
        
        try {
            connect = DriverManager.getConnection(this.url, this.user, this.passwd);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données");
            System.exit(1);
        }
    }

    @Override
    public String toString() {
        return "Query{" + "driver=" + driver + ", url=" + url + ", user=" + user + ", passwd=" + passwd + '}';
    }

    /**
    * Méthode qui va nous retourner notre instance
    * et la créer si elle n'existe pas...
    * @return Connection connect
    */
    public static Connection getInstance()
    {
        if(connect == null){
             new Query();
        }
        return connect;	
    }	
}
