/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exception.ConnectionNotFoundException;
import Model.Query;
import Model.Enseignant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fasalles
 */
public class Etudiant extends Utilisateur{
    
    private String netudiant;

    
    public Etudiant()
    {
        super();
        this.type = 1;
        this.errors.addProperty("netudiant");
    }
    
    public Etudiant(String login, String password)
    {
        super(login, password);
        
        this.type = 1;
        this.errors.addProperty("netudiant");
        
        try {
            this.findEtudiantByLogin();
        } catch (ConnectionNotFoundException ex) {
            Logger.getLogger(Enseignant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Enseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNetudiant()
    {
        return netudiant;
    }

    public void setNetudiant(String nuetudiant)
    {
        this.netudiant = nuetudiant;
    }
    
    public void findEtudiantByLogin() throws ConnectionNotFoundException, SQLException
    {
        if(!this.errors.hasErrors()){
            PreparedStatement prepare = Query
                .getInstance()
                .prepareStatement("SELECT * FROM Etudiant WHERE login = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            prepare.setString(1, this.login);

            ResultSet rs = prepare.executeQuery();
            System.out.println(this);
            if(!rs.first())
                this.errors.addError("login","Etudiant with the login "+this.login+" don't exist in the database");

            else {
                if(this.password.equals(rs.getString("password"))) {
                    this.init(rs);
                } else {
                this.errors.addError("password"," The password isn't correct");
                }
            }
        }
    }
    
    /**
     * Initialize Object    
     * @param rs 
     */
    public void init(ResultSet rs) throws SQLException
    {
        super.init(rs);
        this.netudiant = rs.getString("netudiant");
    }
}