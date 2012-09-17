/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td0.airline.management.system;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import td0.airline.management.system.exception.*;

/**
 *
 * @author fasalles
 */
public class SystemManager
{
    private Set<Airport> airports;
    private Set<Airline> airlines;
    
    public SystemManager()
    {
        this.airports = new LinkedHashSet();
        this.airlines = new LinkedHashSet();
    }
    
    
    public void createAirport(String airport)
    {
        try {
            if(!this.airports.add(new Airport(airport)))
                throw new ObjectExistInHashSetException("Airport "+airport+" already exist");
        } catch (ObjectNameLengthException ex) {
            Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (ObjectExistInHashSetException ex) {
            Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
    
    public void createAirline(String airline)
    {
        try {
            if(!this.airlines.add(new Airline(airline)))
                throw new ObjectExistInHashSetException("Airline "+airline+" already exist");
        } catch (ObjectNameLengthException ex) {
            Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (ObjectExistInHashSetException ex) {
            Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
    
    public void displaySystemDetails()
    {
        
        System.out.println("Airports : ");
        for(Airport airport: this.airports)
            System.out.println(airport);
        
        System.out.println("\nAirlines : ");
        for(Airline airline: this.airlines)
            System.out.println(airline);
    }
}
