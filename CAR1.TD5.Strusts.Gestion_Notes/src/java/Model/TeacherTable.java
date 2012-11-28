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
public class TeacherTable
{
    
    private static Teacher teacher;
    
    public static Teacher findByLoginAndPassword(String login, String pwd) throws ConnectionNotFoundException, SQLException, ObjectNotFoundInDatabaseException
    {
        teacher = new Teacher();
        
        PreparedStatement prepare = Query
            .getInstance()
            .prepareStatement("SELECT * FROM Enseignant WHERE login = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        prepare.setString(1, login);

        ResultSet rs = prepare.executeQuery();
        
        if(!rs.first())
            throw new ObjectNotFoundInDatabaseException("Login incorrect");
        else {
            if(pwd.equals(rs.getString("password"))) {
                teacher.init(rs);
            } else {
                throw new ObjectNotFoundInDatabaseException("Password incorrect");
            }
        }
        
        return teacher;
    }
    
    public static Teacher findById(Integer id) throws ConnectionNotFoundException, SQLException, ObjectNotFoundInDatabaseException
    {
        teacher = new Teacher();
        
        PreparedStatement prepare = Query
            .getInstance()
            .prepareStatement("SELECT * FROM Enseignant WHERE numen = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        prepare.setInt(1, id);

        ResultSet rs = prepare.executeQuery();
        
        if(!rs.first()){
            throw new ObjectNotFoundInDatabaseException("Etudiant don't exist in the database");
        }    
        else {
            teacher.init(rs);
        }
        
        return teacher;
    }
}
