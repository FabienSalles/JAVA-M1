/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exception.ConnectionNotFoundException;
import Exception.ObjectNotFoundInDatabaseException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fasalles
 */
public class Teacher extends User
{
    private Integer numen;

    public Teacher()
    {
        super();
    }
    
    public Teacher(ResultSet rs) throws SQLException
    {
        this.init(rs);
    }
    
    public Teacher(Integer numen) throws ObjectNotFoundInDatabaseException, ConnectionNotFoundException, SQLException
    {
        this(TeacherTable.findById(numen));
    }
    
    public Teacher(String login, String password) throws ConnectionNotFoundException, SQLException, ObjectNotFoundInDatabaseException
    {
        this(TeacherTable.findByLoginAndPassword(login, password));
    }

    public Teacher(Teacher teacher)
    {
        this.init(teacher);
    }

    public Integer getNumen()
    {
        return numen;
    }

    public void setNumen(Integer numen)
    {
        this.numen = numen;
    }
    
    public void init(ResultSet rs) throws SQLException
    {
        super.init(rs);
        this.numen = rs.getInt("numen");
    }
    
    public void init(Teacher teacher)
    {
        super.init((User)teacher);
        this.numen = teacher.getNumen();
    }
}
