/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fasalles
 */
@WebServlet(name = "Seconnecter", urlPatterns = {"/seconnecter"})
public class Seconnecter extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Properties prop = new Properties();
        
        FileInputStream in = new FileInputStream(getServletContext().getRealPath("") +"/WEB-INF/prop.properties");
        
        prop.load(in);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String login = request.getParameter("login");
        String login2 = prop.getProperty("login");
       out.println("<h1>"+login+"</h1>");
       out.println("<h1>"+login2+"</h1>");
        
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
