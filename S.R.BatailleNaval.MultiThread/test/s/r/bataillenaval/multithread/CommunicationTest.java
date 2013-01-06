/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.bataillenaval.multithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fsalles
 */
public class CommunicationTest {
    
    private static Communication serverConnection;
    private static Communication guestConnection;
    private static Game game;
    
    public CommunicationTest() throws IOException {
        serverConnection = Communication.getServerInstance();
        serverConnection.listen(serverConnection.getServerSocket());
        guestConnection = Communication.getGuestInstance();
        guestConnection.logOn();
        game = Game.getInstance();
    }
    

    /**
     * Test of getGame method, of class Communication.
     */
    @Test
    public void testGetGame() throws Exception
    {
        serverConnection.setGame(game);
        assertEquals(guestConnection.getGame(), game);
    }

    /**
     * Test of setGame method, of class Communication.
     */
    @Test
    public void testSetGame() throws Exception {
        guestConnection.setGame(game);
        assertEquals(serverConnection.getGame(), game);
    }

   
    /**
     * Test of getGuestInstance method, of class Communication.
     */
    @Test
    public void testGetGuestInstance() {
        Communication testGuestInstance = Communication.getGuestInstance();
        assertEquals(guestConnection, testGuestInstance);
    }

    /**
     * Test of getServerInstance method, of class Communication.
     */
    @Test
    public void testGetServerInstance() {
      Communication testServerInstance = Communication.getServerInstance();
        assertEquals(testServerInstance, serverConnection);
    }
}
