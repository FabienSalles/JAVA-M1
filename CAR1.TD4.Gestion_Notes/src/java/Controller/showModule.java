/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Exception.ConnectionNotFoundException;
import Exception.ObjectNotFoundInDatabaseException;
import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fasalles
 */
@WebServlet(name = "showModule", urlPatterns = {"/showModule"})
public class showModule extends MyServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        checkSession(request);
        
        if(!checkPermission("enseignant"))
            response.sendRedirect(request.getContextPath()+"/index");
        
        try {
            Module module = new Module(Integer.parseInt(request.getParameter("id")));
            
            try {
                Set<Etudiant> students = EtudiantTable.findStudentsByModule(module.getId());

                request.setAttribute("module", module);
                request.setAttribute("students", students);
                goToPage("/showModule.jsp", request, response);
                
            } catch (ConnectionNotFoundException ex) {
                Logger.getLogger(showModule.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(showModule.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ObjectNotFoundInDatabaseException ex) {
            Logger.getLogger(showModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Show Students in Module";
    }// </editor-fold>
}
