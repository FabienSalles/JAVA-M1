/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.bataillenaval.multithread;

import junit.extensions.ActiveTestSuite;
import junit.framework.TestSuite;
import org.junit.Test;

/**
 *
 * @author fsalles
 */
public class Main {
    
    public static TestSuite suite() {
        TestSuite suite = new ActiveTestSuite();
        suite.addTest(new TestSuite(AttemptTest.class));
        suite.addTest(new TestSuite(BoardTest.class));
        return suite;
    }
 
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}
