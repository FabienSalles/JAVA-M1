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
import java.util.Set;

/**
 *
 * @author fasalles
 */
public class NoteTable {
    
    private static LinkedHashSet<Note> notes;
    
    public static LinkedHashSet findNotesByStudent(Etudiant user) throws ConnectionNotFoundException, SQLException
    {
        notes = new LinkedHashSet();
        
        PreparedStatement prepare = Query
                .getInstance()
                .prepareStatement("SELECT * FROM Note WHERE netudiant = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        prepare.setString(1, user.getNetudiant());

        ResultSet rs = prepare.executeQuery();

        while(rs.next())
            notes.add(new Note(rs));
        
        return notes;
    }
}
