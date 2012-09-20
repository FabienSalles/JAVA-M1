/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td0.airline.management.system;

/**
 *
 * @author fasalles
 */
public class Seat {
    
    private SeatID seatNum;
    private boolean isBooked;
    
    public Seat(SeatID id)
    {
        this.seatNum = id;
        this.isBooked = false;
    }
    
    public SeatID getSeatNum()
    {
        return this.seatNum;
    }
    
    public boolean getStatus()
    {
        return this.isBooked;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
    
    
}
