/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.bataillenaval.multithread;

/**
 *
 * @author fsalles
 */
public class Config {
    /**
     * Localisation of the server
     */
    public static final String HOST = "localhost";
    /**
     * Port of the server
     */
    public static final int PORT = 9876;
    /**
     * Maximum attempts per guest
     */
    public static final Integer MAX_NUMBER_STROKES = 100;
    /**
     * Size of the grid ex 10 = 10*10 => 100 boxes
     */
    public static final Integer GRID_SIZE = 50;
    /**
     * Number of boat in the Board
     */
    public static final Integer NB_BOAT = 50;
    /**
     * Number of guest
     */
    public static final Integer NB_GUEST = 250;
}
