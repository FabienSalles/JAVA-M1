/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exception.ConnectionNotFoundException;
import Model.Query;
import Model.Etudiant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fasalles
 */
public class Enseignant extends Utilisateur{
    
    private Integer numen;

    public Enseignant()
    {
        super();
        this.type = 2;
        this.errors.addProperty("numen");
    }

    
    public Enseignant(String login, String password)
    {
        super(login, password);
        
        this.type = 2;
        this.errors.addProperty("numen");

        try {
            this.findEnseignantByLogin();
        } catch (ConnectionNotFoundException ex) {
            Logger.getLogger(Enseignant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Enseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Integer getNumen()
    {
        return numen;
    }

    public void setNumen(Integer numen)
    {
        this.numen = numen;
    }
    
    public void findEnseignantByLogin() throws ConnectionNotFoundException, SQLException
    {
        if(!this.errors.hasErrors()){
            PreparedStatement prepare = Query
                .getInstance()
                .prepareStatement("SELECT * FROM Enseignant WHERE login = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            prepare.setString(1, this.login);

            ResultSet rs = prepare.executeQuery();
            
            if(!rs.first())
                this.errors.addError("login","Enseignant with the login "+this.login+" don't exist in the database");

            else {
                if(this.password.equals(rs.getString("password"))) {
                    this.init(rs);
                } else {
                this.errors.addError("password"," The password isn't correct");
                }
            }
        }
    }
    
    @Override
    public void init(ResultSet rs) throws SQLException
    {
        super.init(rs);
        this.numen = rs.getInt("numen");
    }
}
