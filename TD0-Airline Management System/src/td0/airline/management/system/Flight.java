/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td0.airline.management.system;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Set<FlightSection> flightSections;

    /**
     * Constructor
     * @param id
     * @param orig
     * @param dest
     * @param date
     * @throws FieldLengthException 
     */
    public Flight(String id, Airport orig, Airport dest, Calendar date) throws FieldLengthException
    {
        if(id.length() <= 5 ){
            this.id = id;
            this.orig = orig;
            this.dest = dest;
            this.date = date;
            this.flightSections = new LinkedHashSet();
        } else {
            throw new FieldLengthException("The id of the flight is too long (5 char max)");
        }
        
    }

    /**
     * 
     * @return Date in French format
     */
    public String getDate()
    {
        Date time = this.date.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(time);
    }

    /**
     * 
     * @return Airport of the Destination
     */
    public Airport getDest()
    {
        return dest;
    }

    /**
     * 
     * @return id of the Flight
     */
    public String getId()
    {
        return id;
    }

    /**
     * 
     * @return Airport of the Origine
     */
    public Airport getOrig()
    {
        return orig;
    }
    
    /**
     * Create Section in the flight
     * @param rows
     * @param cols
     * @param s
     * @throws ObjectExistInHashSetException
     * @throws FieldLengthException 
     */
    public void createSection(int rows, int cols, SeatClass s) throws ObjectExistInHashSetException, FieldLengthException
    {
        if(!this.flightSections.add(new FlightSection(rows, cols, s)))
            throw new ObjectExistInHashSetException("Flight section : "+s+" already exist for flight "+this.id);
    }
    
    /**
     * Checks if the section exist in the flight
     * @param s
     * @return 
     */
    public boolean hasSection(SeatClass s)
    {
        boolean result = false;
        
        for(FlightSection fs: this.flightSections)
            if(fs.getSeatClass().equals(s))
                result = true;
        
        return result;
    }
    
    /**
     * Find section in the flight
     * @param s
     * @return
     * @throws ObjectNotExistInHashSetException 
     */
    public FlightSection findSection(SeatClass s) throws ObjectNotExistInHashSetException
    {
        
        for(FlightSection fs: this.flightSections)
            if(fs.getSeatClass().equals(s))
                return fs;
        
        throw new ObjectNotExistInHashSetException("SeatClass "+s+" doesn't exist in flight id "+this.getId());
    }
    
    /**
     * Book seat in the flight
     * @param s
     * @param row
     * @param col
     * @throws FieldLengthException
     * @throws ObjectExistInHashSetException 
     */
    public void bookSeat(SeatClass s, int row, char col) throws FieldLengthException, ObjectExistInHashSetException
    {
        try {
            FlightSection fs = this.findSection(s);
            fs.bookSeat(row, col);
        } catch (ObjectNotExistInHashSetException ex) {
            Logger.getLogger(Flight.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    /**
     * Display all flightsection who existing in the flight
     */
    public void displayFlightSections()
    {
        for(FlightSection flightSection: this.flightSections)
        {
            System.out.println(flightSection);
            flightSection.getSeats();
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
        final Flight other = (Flight) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb = sb.append("Flight{id=")
            .append(id)
            .append(", orig=")
            .append(orig.getName())
            .append(", dest=")
            .append(dest.getName())
            .append(", date=")
            .append(this.getDate())
            .append("}");
        return  sb.toString();
    }
    
    
   
    
    
}
