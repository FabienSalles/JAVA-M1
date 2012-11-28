/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author fasalles
 */
import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author muzquiano
 * @author kevinr
 */
public class Auth
{
    public final static String SESSION_ATTRIBUTE = "user";
    public final static Integer STUDENT = 1;
    public final static Integer TEACHER = 2;
 
    public static void logout(HttpServletRequest request, HttpServletResponse response)
    {
        request.getSession(false).invalidate();
    }
    
    public static void login(HttpServletRequest request, User user)
    {
        request.getSession(true).setAttribute(SESSION_ATTRIBUTE, user);
    }
    
    public static User getUser(HttpServletRequest request)
    {
        return (User)request.getSession().getAttribute(SESSION_ATTRIBUTE);
    }
    
    public static boolean isAuthenticated(HttpServletRequest request)
    {
        User user = getUser(request);
        
        return (user != null);
    }
    
    public static boolean isGrant(HttpServletRequest request, Integer grant)
    {
        boolean isGrant = false;
        
        if(isAuthenticated(request))
        {
            User user = getUser(request);
            
            if(grant==STUDENT && user instanceof Student)
            {
                isGrant = true;
            }
            else if(grant == TEACHER && user instanceof Teacher)
            {
                isGrant = true;
            }        
        }
        
        return isGrant;
    }
}
