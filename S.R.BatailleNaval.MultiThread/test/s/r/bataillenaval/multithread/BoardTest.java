/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.bataillenaval.multithread;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fsalles
 */
public class BoardTest extends TestCase
{
    
    private static Board board;
    
    public BoardTest() {
        board = Board.getInstance();
    }

    /**
     * Test of attemptAlreadyExist method, of class Board.
     */
    @Test
    public void testAttemptAlreadyExist() {
        Attempt testAttempt = new Attempt(1, 1);
        assertFalse(board.attemptAlreadyExist(1, 1));
        board.bombing(testAttempt);
        assertTrue(board.attemptAlreadyExist(1, 1));
    }

    /**
     * Test of bombing method, of class Board.
     */
    @Test
    public void testBombing() {
        
    }

    /**
     * Test of getNumberSunkenShip method, of class Board.
     */
    @Test
    public void testGetNumberSunkenShip() {
        assertTrue(board.getNumberSunkenShip() == 0);
    }

    /**
     * Test of containsBoatToSink method, of class Board.
     */
    @Test
    public void testContainsBoatToSink() {
        assertTrue(board.containsBoatToSink());
    }

    /**
     * Test of getNumberBoat method, of class Board.
     */
    @Test
    public void testGetNumberBoat() {
        assertTrue(board.getNumberBoat() == Config.NB_BOAT);
    }

   
    /**
     * Test of getInstance method, of class Board.
     */
    @Test
    public void testGetInstance() {
        Board result1 = Board.getInstance();
        Board result2 = Board.getInstance();
        assertEquals(result1, result2);
    }
}
