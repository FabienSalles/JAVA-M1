/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbs.td1;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fasalles
 */
public class SGBSTD1 {

    /**
     * @param args the command line arguments
     */
    public static void main (String args []) throws SQLException
    {
        Test t=new Test();
        t.connect("fasalles", "apprentis2011pw"); //mettre en parameter le login et le mot de passe
        ResultSet res=t.executeQuery("select idClient from sejour where station= 'venuza'");
        t.browseResultInt(res, 1);
        t.disconnect();
    } 
}
