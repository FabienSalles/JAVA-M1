/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Form.LoginForm;
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
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        LoginForm loginForm = (LoginForm)form;
        String render = FAIL;
        User user = loginForm.getUser();
        Auth.login(request, user);
        
        if(loginForm.getType() == 1)
        {
            render = "listNote";
        }
        else if(loginForm.getType() == 2)
        {
            render = "listModule";
        }
        
        return mapping.findForward(render);
    }
}
