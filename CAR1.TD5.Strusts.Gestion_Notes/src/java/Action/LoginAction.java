/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Model.Auth;
import Model.Query;
import Model.StudentTable;
import Model.TeacherTable;
import Model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author fasalles
 */
public class LoginAction extends org.apache.struts.action.Action {
    
    /*
     * forward name="success" path=""
     */
    private static final String SUCCESS = "success";

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
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String render = SUCCESS;
        User user = null;
        if(request.getParameter("type").equals("1"))
        {
            user = (User)StudentTable.findByLoginAndPassword(request.getParameter("login"), request.getParameter("password"));
            render = "listNote";
        }
        else if(request.getParameter("type").equals("2"))
        {
            user = (User)TeacherTable.findByLoginAndPassword(request.getParameter("login"), request.getParameter("password"));
            render = "listModule";
        }
        else
        {
            render = "index";
        }
        Auth.login(request, user);
        return mapping.findForward(render);
    }
}
