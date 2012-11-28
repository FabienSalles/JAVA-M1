/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exception.ConnectionNotFoundException;
import Exception.ObjectNotFoundInDatabaseException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;

/**
 *
 * @author fasalles
 */
public class ModuleTable 
{
    private static LinkedHashSet<Module> modules;
    private static Module module;
    
    public static Module findById(Integer id) throws ConnectionNotFoundException, SQLException, ObjectNotFoundInDatabaseException
    {
        module = new Module();
        PreparedStatement prepare = Query
            .getInstance()
            .prepareStatement("SELECT * FROM Module WHERE id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        prepare.setInt(1, id);

        ResultSet rs = prepare.executeQuery();
        
        if(!rs.first()){
            throw new ObjectNotFoundInDatabaseException("Module don't exist in the database");
        }    
        else {
            module.init(rs);
        }
        
        return module;
    }
    
    public static LinkedHashSet findByTeacher(Teacher teacher) throws ConnectionNotFoundException, SQLException
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
