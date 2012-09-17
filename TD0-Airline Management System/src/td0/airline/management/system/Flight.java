/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td0.airline.management.system;

import java.util.Calendar;
import td0.airline.management.system.exception.*;

/**
 *
 * @author fasalles
 */
public class Flight {
    
    private String id;
    private Airport orig;
    private Airport dest;
    private Calendar date;

    public Flight(String id, Airport orig, Airport dest, Calendar date) throws ObjectNameLengthException
    {
        if(id.length() <= 5 ){
            this.id = id;
            this.orig = orig;
            this.dest = dest;
            this.date = date;
        } else {
            throw new ObjectNameLengthException("The id of the flight is too long (5 char max)");
        }
        
    }

    public Calendar getDate()
    {
        return date;
    }

    public Airport getDest()
    {
        return dest;
    }

    public String getId()
    {
        return id;
    }

    public Airport getOrig()
    {
        return orig;
    }
   
    
}
