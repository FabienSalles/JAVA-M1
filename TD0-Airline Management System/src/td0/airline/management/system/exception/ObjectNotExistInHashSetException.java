/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td0.airline.management.system.exception;

/**
 *
 * @author fasalles
 */
public class ObjectNotExistInHashSetException extends Exception{
    
    /**
     * Constructor
     * @param message 
     */
    public ObjectNotExistInHashSetException(String message)
    {
        super(message);
    }
}
