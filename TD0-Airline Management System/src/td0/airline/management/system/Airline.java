/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td0.airline.management.system;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import td0.airline.management.system.exception.*;

/**
 * Class Airline
 * @author fasalles
 */
public class Airline
{
    private String name;
    
    private Set<Flight> flights;

    /**
     * Constructor
     * @param name
     * @throws FieldLengthException 
     */
    public Airline(String name) throws FieldLengthException
    {
        if( name.length() <= 5 ){
            this.name = name;
            this.flights = new LinkedHashSet();
        }
        else
            throw new FieldLengthException("The name of the airline is too long (5 char max)");
    }

    /**
     * 
     * @return LinkedHashSet of Flight
     */
    public Set<Flight> getFlights() {
        return flights;
    }

    /**
     * 
     * @return name of Airline
     */
    public String getName() {
        return name;
    }

    
    /**
     * Create Flight of the Airline
     * @param orig
     * @param dest
     * @param date
     * @param id
     * @throws FieldLengthException
     * @throws ObjectExistInHashSetException 
     */
    public void createFlight(Airport orig, Airport dest, Calendar date, String id) throws FieldLengthException, ObjectExistInHashSetException
    {    
        if(!this.flights.add(new Flight(id, orig, dest, date)))
            throw new ObjectExistInHashSetException("ID : "+id+" already exist");
    }
    
    /**
     * Find flight in the Airline
     * @param id
     * @return Flight
     * @throws ObjectNotExistInHashSetException 
     */
    public Flight findFlight(String id) throws ObjectNotExistInHashSetException
    {
        for(Flight flight: this.flights)
            if(flight.getId().equals(id))
                return flight;
        
        throw new ObjectNotExistInHashSetException("Flight "+id+" doesn't exist");
    }
    
    /**
     * create Section in the Airline
     * @param id
     * @param rows
     * @param cols
     * @param s
     * @throws ObjectExistInHashSetException
     * @throws FieldLengthException
     * @throws ObjectNotExistInHashSetException 
     */
    public void createSection(String id, int rows, int cols, SeatClass s) throws ObjectExistInHashSetException, FieldLengthException, ObjectNotExistInHashSetException
    {
         Flight flight = this.findFlight(id);
         flight.createSection(rows, cols, s);
  
    }
    
    /**
     * Book fight in the Airline
     * @param fl
     * @param s
     * @param row
     * @param col
     * @throws ObjectNotExistInHashSetException
     * @throws FieldLengthException
     * @throws ObjectExistInHashSetException 
     */
    public void bookFight(String fl, SeatClass s, int row, char col) throws ObjectNotExistInHashSetException, FieldLengthException, ObjectExistInHashSetException
    {
        Flight flight = this.findFlight(fl);
        
        flight.bookSeat(s, row, col);
    }
            
    /**
     * Display all flights existing in the Airline
     */ 
    public void displayFlights()
    {
        for(Flight flight: this.flights){
            System.out.println(flight);
            flight.displayFlightSections();
        }
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
        StringBuffer sb = new StringBuffer();
        sb = sb.append("Airline{name=").append(name).append("}");
        return  sb.toString();
    }
    
    
}
