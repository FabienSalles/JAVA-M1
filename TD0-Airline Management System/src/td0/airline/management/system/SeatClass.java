/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td0.airline.management.system;

/**
 *
 * @author fasalles
 */
public enum SeatClass {
    
    FIRST("First"),
    BUSI("Business"),
    ECO("Economy");
    
    private String name;
    
    private SeatClass(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
}
