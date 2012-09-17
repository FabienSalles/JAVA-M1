/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package td0.airline.management.system;

/**
 *
 * @author fasalles
 */
public class TD0AirlineManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        SystemManager res = new SystemManager();
        
        res.createAirport("DEN");
        res.createAirport("DFW");
        res.createAirport("LON");
        //res.createAirport("DEN");
        res.createAirport("CDG");
        res.createAirport("JPN");
        //res.createAirport("DEN");
        //res.createAirport("DE");
        res.createAirport("DEH");
        //res.createAirport("DRlrdn3");
        
        // Ai r l i n e s
        res.createAirline("DELTA");
        res.createAirline("AIRFR");
        res.createAirline("AMER");
        res.createAirline("JET");
        //res.createAirline("DELTA");
        res.createAirline("SWEST");
        //res.createAirline("FRONTIER");
        
        res.displaySystemDetails();
    }
}
