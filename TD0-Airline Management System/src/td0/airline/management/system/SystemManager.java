/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td0.airline.management.system;

import java.util.GregorianCalendar;
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
    
    /**
     * Constructor
     */
    public SystemManager()
    {
        this.airports = new LinkedHashSet();
        this.airlines = new LinkedHashSet();
    }
    
    /**
     * Create airport in the SystemManager
     * @param airport 
     */
    public void createAirport(String airport)
    {
        try {
            if(!this.airports.add(new Airport(airport)))
                throw new ObjectExistInHashSetException("Airport "+airport+" already exist");
        } catch (FieldLengthException ex) {
            Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (ObjectExistInHashSetException ex) {
            Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
    
    /**
     * Create airline in the SystemManager
     * @param airline 
     */
    public void createAirline(String airline)
    {
        try {
            if(!this.airlines.add(new Airline(airline)))
                throw new ObjectExistInHashSetException("Airline "+airline+" already exist");
        } catch (FieldLengthException | ObjectExistInHashSetException ex) {
            Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
    
    /**
     * Create Flight in the SystemManager
     * @param n
     * @param orig
     * @param dest
     * @param year
     * @param month
     * @param day
     * @param id 
     */
    public void createFlight(String n, String orig, String dest, int year, int month, int day, String id)
    {

        try {
            Airline airline = this.findAirline(n);
            Airport origine = this.findAirport(orig),
                    destination = this.findAirport(dest);
            
            GregorianCalendar cal = new GregorianCalendar(year, month, day);
            
            try {
                airline.createFlight(origine, destination, cal, id);
            } catch (    FieldLengthException | ObjectExistInHashSetException ex) {
                Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
                ex.getMessage();
            }
            
        } catch (ObjectNotExistInHashSetException ex) {
            Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
    
    /**
     * Create Section in the systemmanger
     * @param air
     * @param flid
     * @param rows
     * @param cols
     * @param s 
     */
    public void createSection(String air, String flid, int rows, int cols, SeatClass s)
    {
        try {
            Airline airline = this.findAirline(air);
            airline.createSection(flid, rows, cols, s);
            
        } catch (ObjectExistInHashSetException | FieldLengthException | ObjectNotExistInHashSetException ex) {
            Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
        
    }
    
    /**
     * Display available flight in the SystemManager
     * @param orig
     * @param dest 
     */
    public void findAvailableFlights(String orig, String dest)
    {
        for(Airline air: this.airlines)
            for(Flight fl: air.getFlights())
                if(fl.getOrig().getName().equals(orig) && fl.getDest().getName().equals(dest))
                    System.out.println(fl);
    }
    
    /**
     * Book seat in the SystemManger
     * @param air
     * @param fl
     * @param s
     * @param row
     * @param col 
     */
    public void bookSeat(String air, String fl, SeatClass s, int row, char col)
    {
        Airline airline;
        try {
            airline = this.findAirline(air);
            airline.bookFight(fl, s, row, col);
        } catch (FieldLengthException | ObjectExistInHashSetException | ObjectNotExistInHashSetException ex) {
            Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
    
    /**
     * Find airline in the SystemManager
     * @param n
     * @return
     * @throws ObjectNotExistInHashSetException 
     */
    public Airline findAirline(String n) throws ObjectNotExistInHashSetException
    {
        for(Airline airline: this.airlines)
            if(airline.getName().equals(n))
                return airline;
        
        throw new ObjectNotExistInHashSetException("Airline "+n+" doesn't exist");
    }
    
    /**
     * Find Airport in the SystemManager
     * @param n
     * @return
     * @throws ObjectNotExistInHashSetException 
     */
    public Airport findAirport(String n) throws ObjectNotExistInHashSetException
    {
        for(Airport airport: this.airports)
            if(airport.getName().equals(n))
                return airport;
        
        throw new ObjectNotExistInHashSetException("Airport "+n+" doesn't exist");
    }
    
    /**
     * Display all SystemManager
     */
    public void displaySystemDetails()
    {
        
        System.out.println("Airports : ");
        for(Airport airport: this.airports)
            System.out.println(airport);
        
        System.out.println("\n#########################\n");
        
        System.out.println("Airlines : ");
        for(Airline airline: this.airlines){
            System.out.println(airline);
            airline.displayFlights();
        }
        
        System.out.println("\n#########################\n");
            
    }
}
