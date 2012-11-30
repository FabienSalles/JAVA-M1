/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Exception.ConnectionNotFoundException;
import Exception.ObjectNotFoundInDatabaseException;
import Model.Student;
import Model.StudentTable;
import Model.TeacherTable;
import Model.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author fasalles
 */
public class LoginForm extends UserForm {
    
    protected Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /**
     *
     */
    public LoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User getUser() throws ConnectionNotFoundException, SQLException, ObjectNotFoundInDatabaseException
    {
        User user = null;
        if (this.type == 1)
        {
            user = StudentTable.findByLoginAndPassword(this.login, this.password);
        }
        else if (this.type == 2)
        {
            user = TeacherTable.findByLoginAndPassword(this.login, this.password);
        }
        return user;
    }
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = super.validate(mapping, request);
        if (this.type == null) {
            errors.add("type", new ActionMessage("errors.required", "Le type de personne"));
        }
        else
        {
            try {
                this.getUser();
            } catch (ConnectionNotFoundException ex) {
                // je n'ai pas utilisé ActionMessages.GLOBAL_MESSAGE
                // pour séparer les messages d'erreurs en évitant d'utiliser
                // simplement une balise <html:errors/> dans le fichier jsp
                errors.add("bdd", new ActionMessage("errors.detail", ex));
            } catch (SQLException ex) {
                errors.add("bdd", new ActionMessage("errors.detail", ex));
            } catch (ObjectNotFoundInDatabaseException ex) {
                errors.add("bdd", new ActionMessage("errors.detail", ex));
            }
        }
        return errors;
    }
}
