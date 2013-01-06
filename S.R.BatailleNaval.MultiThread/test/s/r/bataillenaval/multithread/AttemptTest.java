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
public class AttemptTest extends TestCase
{
    
    private Attempt testAttempt;
    
    public AttemptTest() {
        testAttempt = new Attempt();
    }
    
  

    /**
     * Test of getPosX method, of class Attempt.
     */
    @Test
    public void testGetPosX() {
        assertTrue("Default value is 0", testAttempt.getPosX() == 0);
        testAttempt.setPosX(2);
        assertTrue("Value of posX is 2", testAttempt.getPosX() == 2);
    }

    /**
     * Test of getPosY method, of class Attempt.
     */
    @Test
    public void testGetPosY() {
        assertTrue("Default value is 0", testAttempt.getPosX() == 0);
        testAttempt.setPosY(2);
        assertTrue("Value of posY is 2", testAttempt.getPosY() == 2);
    }

    /**
     * Test of setPosX method, of class Attempt.
     */
    @Test
    public void testSetPosX() {
        testAttempt.setPosX(2);
        assertTrue("Value of posX is 2", testAttempt.getPosX() == 2);
    }

    /**
     * Test of setPosY method, of class Attempt.
     */
    @Test
    public void testSetPosY() {
        testAttempt.setPosY(2);
        assertTrue("Value of posY is 2", testAttempt.getPosY() == 2);
    }

    /**
     * Test of toString method, of class Attempt.
     */
    @Test
    public void testToString() {
        String expResult = "(0,0)";
        String result = testAttempt.toString();
        assertEquals(expResult, result);
        testAttempt.setPosX(1);
        testAttempt.setPosY(2);
        expResult = "(1,2)";
        result = testAttempt.toString();
        assertEquals(expResult, result);
    }
}
