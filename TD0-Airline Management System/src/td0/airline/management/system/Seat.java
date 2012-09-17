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
    
    public SeatID getSeatNum()
    {
        return this.seatNum;
    }
    
    public boolean getStatus()
    {
        return this.isBooked;
    }
}
