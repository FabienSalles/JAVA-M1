/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author fasalles
 */
public class ConnectionNotFoundException extends Exception{
    
    private String msg;
    
    public ConnectionNotFoundException(String msg)
    {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
    
}
