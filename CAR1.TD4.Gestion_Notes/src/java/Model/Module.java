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
public class Module {
    
    private Integer id;
    
    private String intitule;
    
    private Integer numen;

    public Module()
    {
    }

    public Module(Integer id) throws ObjectNotFoundInDatabaseException
    {
        this.id = id;
        try {
            this.findModuleById();
        } catch (ConnectionNotFoundException ex) {
            Logger.getLogger(Module.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Module.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Module(ResultSet rs) throws SQLException
    {
        this.init(rs);
    }
    
    
    public Integer getId() {
        return id;
    }

    public String getIntitule() {
        return intitule;
    }

    public Integer getNumen() {
        return numen;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setNumen(Integer numen) {
        this.numen = numen;
    }
    
    public void init(ResultSet rs) throws SQLException
    {
        this.id = rs.getInt("id");
        this.intitule = rs.getString("intitule");
        this.numen = rs.getInt("numen");
    }
    
    public void findModuleById() throws ConnectionNotFoundException, SQLException, ObjectNotFoundInDatabaseException
    {
        PreparedStatement prepare = Query
            .getInstance()
            .prepareStatement("SELECT * FROM Module WHERE id = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        prepare.setInt(1, this.id);

        ResultSet rs = prepare.executeQuery();
        
        if(!rs.first()){
            throw new ObjectNotFoundInDatabaseException("Module don't exist in the database");
        }    
        else {
            this.init(rs);
        }
    }

    @Override
    public String toString() {
        return "Module{" + "id=" + id + ", intitule=" + intitule + ", numen=" + numen + '}';
    }
}
