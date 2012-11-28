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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fasalles
 */
public class Note
{
    private Integer idModule;
    
    private String netudiant;
    
    private Double note;
    
    private Student student;
    
    private Module module;

    public Note()
    {
    }

    public Note(ResultSet rs) throws SQLException
    {
        this.init(rs);
        
        try {
            this.student = new Student(this.netudiant);
            this.module = new Module(this.idModule);
        } catch (ConnectionNotFoundException ex) {
            Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ObjectNotFoundInDatabaseException ex) {
            Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Integer getIdModule()
    {
        return idModule;
    }

    public String getNetudiant()
    {
        return netudiant;
    }

    public Double getNote()
    {
        return note;
    }
    
    public Student getEtudiant()
    {
        return student;
    }
    
    public Module getModule()
    {
        return module;
    }

    public void setIdModule(Integer idModule)
    {
        this.idModule = idModule;
    }

    public void setNetudiant(String netudiant)
    {
        this.netudiant = netudiant;
    }

    public void setNote(Double note)
    {
        this.note = note;
    }
    
    /**
     * Initialize Object    
     * @param rs 
     */
    public void init(ResultSet rs) throws SQLException
    {
        this.idModule = rs.getInt("id_module");
        this.netudiant = rs.getString("netudiant");
        this.note = rs.getDouble("note");
    }

    @Override
    public String toString() {
        return "Note{" +  module + ", "+ student + ", note=" + note + '}';
    }
}
