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
public class StudentTable {
    
    private static LinkedHashSet<Student> students;
    
    private static Student student;
    
    public static LinkedHashSet findByModule(Integer idModule) throws ConnectionNotFoundException, SQLException
    {
        students = new LinkedHashSet();
        
        PreparedStatement prepare = Query
                .getInstance()
                .prepareStatement("SELECT * FROM Etudiant e INNER JOIN Note n on n.netudiant = e.netudiant WHERE id_module = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        prepare.setInt(1, idModule);

        ResultSet rs = prepare.executeQuery();

        while(rs.next())
            students.add(new Student(rs));
        
        return students;
    }
    
    public static Student findByLoginAndPassword(String login, String pwd) throws ConnectionNotFoundException, SQLException, ObjectNotFoundInDatabaseException
    {
        student = new Student();
        
        PreparedStatement prepare = Query
            .getInstance()
            .prepareStatement("SELECT * FROM Etudiant WHERE login = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        prepare.setString(1, login);

        ResultSet rs = prepare.executeQuery();
        
        if(!rs.first())
            throw new ObjectNotFoundInDatabaseException("Login incorrect");
        else {
            if(pwd.equals(rs.getString("password"))) {
                student.init(rs);
            } else {
                throw new ObjectNotFoundInDatabaseException("Password incorrect");
            }
        }
        
        return student;
    }
    
    public static Student findById(String id) throws ConnectionNotFoundException, SQLException, ObjectNotFoundInDatabaseException
    {
        student = new Student();
        
        PreparedStatement prepare = Query
            .getInstance()
            .prepareStatement("SELECT * FROM Etudiant WHERE netudiant = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        prepare.setString(1, id);

        ResultSet rs = prepare.executeQuery();
        
        if(!rs.first()){
            throw new ObjectNotFoundInDatabaseException("Etudiant don't exist in the database");
        }    
        else {
            student.init(rs);
        }
        
        return student;
    }
}
