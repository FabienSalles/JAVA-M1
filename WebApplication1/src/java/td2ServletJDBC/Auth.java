/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td2ServletJDBC;

import java.sql.*;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fasalles
 */
public class Auth {
    
    private Statement req;
    private Connection cx;
    private Hashtable<String, String> result;
    
    public Auth()
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(Exception ex){
            System.err.println("Erreur lors du changement du driver");
            System.exit(1);
        }
        
        try{
            /** connexion à la base */
            String url="jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:1521:MIAGE";
            this.cx = DriverManager.getConnection(url, "fasalles", "apprentis2011pw");
            this.req = cx.createStatement();
            String sql = "SELECT * FROM LOGPWD";
            ResultSet rs = req.executeQuery(sql);
            while(rs.next())
                result.put(rs.getString("LOGIN"),rs.getString("PWD"));
            rs.close();
            this.req.close();
            this.cx.close();
        } catch( Exception ex){
            System.err.println("Erreur lors du changement du driver");
            System.exit(1);     
        }
    }
    
    public boolean estReconnue(String login, String password)
    {
        return result.get(login).equals(password);
    }
}
