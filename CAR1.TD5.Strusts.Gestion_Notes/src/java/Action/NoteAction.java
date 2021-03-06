/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Model.Auth;
import Model.Note;
import Model.NoteTable;
import Model.Student;
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
public class NoteAction extends org.apache.struts.action.Action {

    /*
     * forward name="success" path=""
     */
    private static final String SUCCESS = "showNote";
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
        String render = FAIL;
        
        if(Auth.isGrant(request, Auth.STUDENT)){
            Set<Note> notes = NoteTable.findNotesByStudent((Student)Auth.getUser(request));
            request.setAttribute("notes", notes);
            render = SUCCESS;
        }
        
        return mapping.findForward(render);
    }
}
