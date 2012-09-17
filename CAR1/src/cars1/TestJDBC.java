/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cars1;

import java.sql.*;

/**
 *
 * @author fasalles
 */
public class TestJDBC {
    
    public static void main( String[] args) throws SQLException{
        
        /** Chargement du driver JDBC - Etape 1 */
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch( Exception ex){
            System.err.println("Erreur lors du changement du driver");
            System.exit(1);
        }
        
        try{
            /** connexion à la base */
            String url="jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:1521:MIAGE";
            Connection cx = DriverManager.getConnection(url, "fasalles", "apprentis2011pw");
            Statement req = cx.createStatement();
            String sql = "SELECT * FROM TEST";
            ResultSet rs = req.executeQuery(sql);
            while(rs.next())
                System.out.println(rs.getString("nom"));
            rs.close();
            req.close();
            cx.close();
        } catch( Exception ex){
            System.err.println("Erreur lors du changement du driver");
            System.exit(1);     
        }
    }
}
