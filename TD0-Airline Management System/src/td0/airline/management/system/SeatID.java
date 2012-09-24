/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td0.airline.management.system;

import java.util.Objects;

/**
 *
 * @author fasalles
 */
public class SeatID {
    
    private int row;
    private Character column;
    
    /**
     * Constructor
     * @param row
     * @param column 
     */
    public SeatID(int row, Character column)
    {
        this.row = row;
        this.column = column;
    }

    /**
     * 
     * @return column of the seat
     */
    public Character getColumn()
    {
        return column;
    }

    /**
     * 
     * @return row of the seat
     */
    public Integer getRow()
    {
        return row;
    }

    /**
     * Set column of the seat
     * @param column 
     */
    public void setColumn(Character column) 
    {
        this.column = column;
    }

    /**
     * Set row of the seat
     * @param row 
     */
    public void setRow(Integer row)
    {
        this.row = row;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SeatID other = (SeatID) obj;
        if (!Objects.equals(this.row, other.row)) {
            return false;
        }
        if (!Objects.equals(this.column, other.column)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.row);
        hash = 71 * hash + Objects.hashCode(this.column);
        return hash;
    }

    @Override
    // utiliser string buffers
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb = sb.append("SeatId{row=")
            .append(row)
            .append(", column=")
            .append(column)
            .append("}");
        return  sb.toString();
    }
    
    
    
    
}
