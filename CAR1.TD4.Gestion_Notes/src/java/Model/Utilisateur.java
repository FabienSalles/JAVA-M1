/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fasalles
 */
public class Utilisateur {
    
    protected String nom;
    protected String prenom;
    protected String login;
    protected String password;
    protected Integer type;
    protected Error errors;

    public Utilisateur()
    {
        String[] label = {"nom", "prenom", "login", "password", "type"};
        this.errors = new Error(label);
    }

    public Utilisateur(String login, String password)
    {
        this();
        
        this.login = login;
        this.password = password;
        
        if(this.login == null || this.login.equals(""))
            this.errors.addError("login", "The login is require");
        if(this.password == null || this.password.equals(""))
            this.errors.addError("password", "The password is require");
        
    }

    public String getLogin() {
        return login;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getPrenom() {
        return prenom;
    }

    public Integer getType() {
        return type;
    }

    
    public Error getErrors() {
        return errors;
    }

    
    public void setLogin(String login) {
        this.login = login;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    
    
    /**
     * Initialize Object    
     * @param rs 
     */
    public void init(ResultSet rs) throws SQLException
    {
        this.nom = rs.getString("nom");
        this.prenom = rs.getString("prenom");
        this.login = rs.getString("login");
        this.password = rs.getString("password");
    }

    @Override
    public String toString() {
        return "Personne{" + "nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password + '}';
    }
    
    
}
