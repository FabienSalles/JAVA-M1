/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Exception.ConnectionNotFoundException;
import Exception.ObjectNotFoundInDatabaseException;
import Model.Auth;
import Model.Module;
import Model.Student;
import Model.StudentTable;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author fasalles
 */
public class ShowModuleAction extends org.apache.struts.action.Action {

    /*
     * forward name="success" path=""
     */
    private static final String SUCCESS = "showModule";
    private static final String FAIL = "index";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            
        String render = FAIL;
        
        if(Auth.isGrant(request, Auth.TEACHER))
        {
            Module module = new Module(Integer.parseInt(request.getParameter("id")));
            Set<Student> students = StudentTable.findByModule(module.getId());

            request.setAttribute("module", module);
            request.setAttribute("students", students);
            
            render = SUCCESS;
        }
            
        return mapping.findForward(render);
    }
}
