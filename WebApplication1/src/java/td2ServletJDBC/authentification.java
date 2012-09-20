/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td2ServletJDBC;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "authentification", urlPatterns = {"/authentification"})
public class authentification extends HttpServlet {


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
        
//        HttpSession session = request.getSession(true) ;
//        if(session.getAttribute("auth") == null)
//            session.setAttribute("auth", new Auth());
        
        PrintWriter out = response.getWriter();
        Auth  auth = new Auth();
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
