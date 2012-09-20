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
    
    public SeatID(int row, Character column)
    {
        this.row = row;
        this.column = column;
    }

    public Character getColumn()
    {
        return column;
    }

    public Integer getRow()
    {
        return row;
    }

    public void setColumn(Character column) 
    {
        this.column = column;
    }

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
        return "SeatID{" + "row=" + row + ", column=" + column + '}';
    }
    
    
    
    
}
