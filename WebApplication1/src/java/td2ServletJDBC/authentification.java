/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td2ServletJDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fasalles
 */
@WebServlet(name = "authentification", urlPatterns = {"/td2ServletJDBC/authentification"})
public class authentification extends HttpServlet {

    Auth auth;
    
    @Override
    public void init(ServletConfig c) throws ServletException
    {
        auth = new Auth();
    }
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    

        PrintWriter out = response.getWriter();
        if(auth.estReconnue(request.getParameter("login"), request.getParameter("pwd"))){
            out.print("Bonjour "+request.getParameter("login"));
        }
        else
            out.print("Pseudo ou mot de passe incorrect");
        out.close();                     
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
