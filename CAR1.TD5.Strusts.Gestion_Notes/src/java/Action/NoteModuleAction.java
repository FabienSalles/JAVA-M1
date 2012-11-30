/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Form.NotesModuleForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author fasalles
 */
public class NoteModuleAction extends org.apache.struts.action.Action {

    /*
     * forward name="success" path=""
     */
    private static final String SUCCESS = "rowStudentNote";

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
        
        NotesModuleForm noteForm = (NotesModuleForm) form;
        
        request.setAttribute("id_module", noteForm.getIdModule());
        request.setAttribute("netudiant", noteForm.getNetudiant());
        request.setAttribute("note", noteForm.getNote());
        
        this.servlet.getServletContext()    
            .getRequestDispatcher("/rowStudentNote.jsp")
            .include(request, response);
            
        return null;
    }
}
