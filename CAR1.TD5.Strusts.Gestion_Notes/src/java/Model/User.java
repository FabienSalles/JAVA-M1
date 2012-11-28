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
public class User {
    
    protected String nom;
    protected String prenom;
    protected String login;
    protected String password;

    public User()
    {
    }

    public User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public User(User user)
    {
        this.init(user);
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

    public void init(User user)
    {
        this.login    = user.getLogin();
        this.nom      = user.getNom();
        this.password = user.getPassword();
        this.prenom   = user.getPrenom();
    }
    
    @Override
    public String toString() {
        return "Personne{" + "nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password + '}';
    }
}
