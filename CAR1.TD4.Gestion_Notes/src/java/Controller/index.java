/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fasalles
 */
@WebServlet(name = "index", urlPatterns = {"/index"})
public class index extends MyServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("user", new Utilisateur());
        
        goToPage("/index.jsp", request, response);
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Utilisateur user = processForm(request);
        
        if(user.getErrors().hasErrors()){
            goToPage("/index.jsp", request, response);
        } else {
             // create the session of the user
            createSession(request, user);
            
            if(user instanceof Enseignant) {
                goToPage("/modules", request, response);
            } else
                goToPage("/notes", request, response);
        }
            
    }
    
    protected Utilisateur processForm(HttpServletRequest request)
    {
        Utilisateur user;
        
        if(request.getParameter("type") == null){
            user = new Utilisateur(request.getParameter("login"), request.getParameter("pwd"));
            user.getErrors().addError("type", "You must be choice type of user");
        } else if(request.getParameter("type").equals("1"))
            user = new Etudiant(request.getParameter("login"), request.getParameter("pwd"));
        else
            user = new Enseignant(request.getParameter("login"), request.getParameter("pwd"));
        
        return user;
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Home of the application";
    }// </editor-fold>
}
