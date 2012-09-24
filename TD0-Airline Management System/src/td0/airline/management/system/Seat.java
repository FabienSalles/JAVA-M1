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
    
    /**
     * Constructor
     * @param id 
     */
    public Seat(SeatID id)
    {
        this.seatNum = id;
        this.isBooked = false;
    }
    
    /**
     * 
     * @return num of the seat
     */
    public SeatID getSeatNum()
    {
        return this.seatNum;
    }
    
    /**
     * 
     * @return status of the seat
     */
    public boolean getStatus()
    {
        return this.isBooked;
    }

    /**
     * Set status of the seat
     * @param isBooked 
     */
    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb = sb.append("Seat{seatNum=")
            .append(seatNum)
            .append(", isBooked=")
            .append(isBooked)
            .append("}");
        return  sb.toString();
    }
    
    
    
}
