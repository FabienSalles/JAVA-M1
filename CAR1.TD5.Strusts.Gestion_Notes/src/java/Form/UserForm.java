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
public class UserForm extends org.apache.struts.action.ActionForm {
    
    protected String login;
    protected String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     */
    public UserForm() {
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
        if (this.login == null || this.login.length() < 1) {
            errors.add("login", new ActionMessage("errors.required", "Login"));
        }
        if (this.password == null || this.password.length() < 1) {
            errors.add("password", new ActionMessage("errors.required", "Password"));
        }
        return errors;
    }
}
