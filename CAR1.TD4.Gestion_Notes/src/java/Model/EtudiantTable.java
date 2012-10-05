/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exception.ConnectionNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;

/**
 *
 * @author fasalles
 */
public class EtudiantTable {
    
    private static LinkedHashSet<Etudiant> students;
    
    public static LinkedHashSet findStudentsByModule(Integer idModule) throws ConnectionNotFoundException, SQLException
    {
        students = new LinkedHashSet();
        
        PreparedStatement prepare = Query
                .getInstance()
                .prepareStatement("SELECT * FROM Etudiant e INNER JOIN Note n on n.netudiant = e.netudiant WHERE id_module = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        prepare.setInt(1, idModule);

        ResultSet rs = prepare.executeQuery();

        while(rs.next())
            students.add(new Etudiant(rs));
        
        return students;
    }
}
