/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogue;

import java.sql.*;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fasalles
 */
public class QueryBD {
    
    private Statement req;
    private Connection cx;
    
    public QueryBD()
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
         
        } catch( Exception ex){
            System.err.println("Erreur lors du changement du driver");
            System.exit(1);     
        }
    }
    
    public Set<DVD> getDVDs()
    {
        new QueryBD();
        Set<DVD> result = new HashSet();
        try {
            String sql = "SELECT * FROM catalogue";
            ResultSet rs = this.req.executeQuery(sql);
            while(rs.next())
                result.add(new DVD(rs.getInt("id"),rs.getString("description"), rs.getFloat("prix")));
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return result;
        }
    }
    
    public void destroy()
    {
        try {
            this.req.close();
            this.cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
