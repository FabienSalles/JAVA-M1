/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td0.airline.management.system;

import java.util.Objects;
import td0.airline.management.system.exception.*;

/**
 *
 * @author fasalles
 */
public class Airline
{
    private String name;
    
    
    
//    public Flight createFlight()
//    {
//        
//    }

    public Airline(String name) throws ObjectNameLengthException
    {
        if( name.length() <= 5 )
            this.name = name;
        else
            throw new ObjectNameLengthException("The name of the airline is too long (5 char max)");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Airline other = (Airline) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public String toString() {
        return "Airline{" + "name=" + name + '}';
    }
    
    
}
