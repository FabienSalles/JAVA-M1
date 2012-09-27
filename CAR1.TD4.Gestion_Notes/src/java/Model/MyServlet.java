/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fasalles
 */
public abstract class MyServlet extends HttpServlet{
    
    protected Connection connect;
    protected HttpSession session;
    protected String path;
    protected Error errors;
    
    public void init()
    {
        this.path = getServletContext().getRealPath("");
        this.connect = Query.getInstance(this.path);
        this.errors = new Error();

    }
    
    protected void goToPage(String url, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext()    
            .getRequestDispatcher(url)
            .forward(request, response);
    }
    
    protected void createSession(HttpServletRequest request, Utilisateur user)
    {
        session = request.getSession(true);
        session.setAttribute("user", user);
    }
    
    protected void deconnection()
    {
        session.removeAttribute("user");
    }
    
    protected boolean checkPermission(String credantial)
    {
        boolean permitted = false;
        
        if(session != null){
            Utilisateur user = (Utilisateur) session.getAttribute("user");
            if(credantial.equals("enseignant") && user instanceof Enseignant)
                permitted = true;
            else if(credantial.equals("etudiant") && user instanceof Etudiant)
                permitted = true;
        }
        
        return permitted;
            
    }
}
