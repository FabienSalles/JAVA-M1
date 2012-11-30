/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author fasalles
 */
public class NotesModuleForm extends org.apache.struts.action.ActionForm {
    
    private String netudiant;
    private Integer idModule;
    private double note;

    public Integer getIdModule() {
        return idModule;
    }

    public String getNetudiant() {
        return netudiant;
    }

    public double getNote() {
        return note;
    }

    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    public void setNetudiant(String netudiant) {
        this.netudiant = netudiant;
    }

    public void setNote(double note) {
        this.note = note;
    }

    /**
     *
     */
    public NotesModuleForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        return errors;
    }
}
