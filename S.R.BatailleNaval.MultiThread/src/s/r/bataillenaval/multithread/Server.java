/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.bataillenaval.multithread;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import s.r.bataillenaval.multithread.Communication;
import s.r.bataillenaval.multithread.Config;
import s.r.bataillenaval.multithread.Game;

/**
 * @author fsalles
 */
public class Server {
    
    private Communication com;
    private Game game;
    private static Server instance;
    private final static Lock lock = new ReentrantLock();
    
    private Server()
    {
        try {
            this.com = Communication.getServerInstance();
            this.com.listen(this.com.getServerSocket());
            this.game = Game.getInstance();
            System.out.println("Serveur en attente sur le port " + this.com.getServerSocket().getLocalPort());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Communication getCom() {
        return com;
    }

    public Game getGame() {
        return game;
    }

    public static Lock getLock() {
        return lock;
    }

    
    public void setCom(Communication com) {
        this.com = com;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    
    public final static Server getInstance() {
        Server result = instance;
        if (result == null) { // 1er verif sans verrou
            synchronized (Server.class) {
                result = instance;
                if (result == null) { // 2eme verif, apres acquisition du verrou
                    result = instance = new Server();
                }
            }
        }
        return instance;
    }
}
