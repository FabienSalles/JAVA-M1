/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td0.airline.management.system;

import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Set;
import td0.airline.management.system.exception.FieldLengthException;
import td0.airline.management.system.exception.ObjectExistInHashSetException;

/**
 *
 * @author fasalles
 */
public class FlightSection {
    
    
    private SeatClass section;
    private int rows;
    private char cols;
    private Set<Seat> seats;
  
    public FlightSection(int rows, int cols, SeatClass s) throws FieldLengthException
    {
        if(rows < 1 || rows > 10)
            throw new FieldLengthException("The Rows must be between 1 and 10");
        else {
            if(FlightSection.intToChar(cols) != 0){
                this.seats = new LinkedHashSet();
                this.rows = rows;
                this.cols = FlightSection.intToChar(cols);
                this.section = s;
                this.initSeat(cols);
            }
        }
        
    }
    public SeatClass getSeatClass()
    {
        return  this.section;
    }
    
    public boolean hasAvailableSeats()
    {
        boolean available = false;
        
        for(Seat seat: this.seats)
            if(seat.getStatus())
                available = true;
        
        return available;
    }

    public void bookSeat(int row, int col) throws FieldLengthException, ObjectExistInHashSetException
    {
        Seat seat;
        
        if(rows < 1 || rows > 10)
            throw new FieldLengthException("The Rows must be between 1 and 10");
        else {
            if(FlightSection.intToChar(cols) != 0){
                for(Seat s: this.seats){
                    if(s.getSeatNum().getRow() == row && s.getSeatNum().getColumn() == FlightSection.intToChar(col)){
                        seat = s;
                        if(seat.getStatus())
                            throw new ObjectExistInHashSetException("The seat "+row+col+" isn't available");
                        else
                            seat.setIsBooked(true);
                        break;
                    }
                }
            }
        }
        
    }
    
    private void initSeat(int cols) throws FieldLengthException
    {
        for(int i = 1; i<=cols; i++)
            for(int j=1; j<= this.rows; j++)
                this.seats.add(new Seat(new SeatID(j, FlightSection.intToChar(i))));
    }
    
    public static char intToChar(int i) throws FieldLengthException
    {
        char cols;
        
        switch(i){
            case 1:
                cols = 'A';
                break;
            case 2:
                cols = 'B';
                break;
            case 3:
                cols = 'C';
                break;
            case 4:
                cols = 'D';
                break;
            case 5:
                cols = 'E';
                break;
            case 6:
                cols = 'F';
                break;
            case 7:
                cols = 'H';
                break;
            case 8:
                cols = 'I';
                break;
            case 9:
                cols = 'J';
                break;
            default:
                cols = '0';
                throw new FieldLengthException("the length of cols must be between 1 and 9");
        }
        return cols;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FlightSection other = (FlightSection) obj;
        if (this.section != other.section) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.section != null ? this.section.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "FlightSection{" + "section=" + section + ", rows=" + rows + ", cols=" + cols + '}';
    }
}
