/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Model.*;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author fasalles
 */
public class ListModuleAction extends org.apache.struts.action.Action {

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
        
        if(Auth.isGrant(request, Auth.TEACHER)){
            Set<Module> modules = ModuleTable.findByTeacher((Teacher)Auth.getUser(request));
            request.setAttribute("modules", modules);
            render = SUCCESS;
        }
        
        return mapping.findForward(render);
    }
}
