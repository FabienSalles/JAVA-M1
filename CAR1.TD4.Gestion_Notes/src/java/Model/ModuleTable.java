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
public class ModuleTable {
    
    private static LinkedHashSet<Module> modules;
    
    public static LinkedHashSet findModulesByTeacher(Enseignant teacher) throws ConnectionNotFoundException, SQLException
    {
        modules = new LinkedHashSet();
        
        PreparedStatement prepare = Query
                .getInstance()
                .prepareStatement("SELECT * FROM Module WHERE numen = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        prepare.setInt(1, teacher.getNumen());

        ResultSet rs = prepare.executeQuery();

        while(rs.next())
            modules.add(new Module(rs));
        
        return modules;
    }
}
