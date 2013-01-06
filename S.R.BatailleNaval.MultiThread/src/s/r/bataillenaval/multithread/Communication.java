/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.bataillenaval.multithread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Communication
 * @author fsalles
 */
public class Communication {

    private static Communication instance;
    
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String host;
    private int port;
    private Socket socket;
    private ServerSocket serverSocket;

    /**
     * Constructor for Guest connection
     * @param host
     * @param port
     * @throws SocketException 
     */
    public Communication(String host, int port) throws SocketException
    {
        this.host = host;
        this.port = port;
        this.socket = null;
    }

    /**
     * Constructor for Server connection
     * @param port
     * @throws IOException 
     */
    public Communication(int port) throws IOException
    {
        this.port = port;
        this.socket = null;
        this.serverSocket = new ServerSocket(this.port);
    }

    /**
     * Return game instance when it is set with setGame() method
     * @return Game game
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Game getGame() throws IOException, ClassNotFoundException
    {
        return (Game) this.input.readObject();
    }

    /**
     * Set the game
     * @param game
     * @throws IOException 
     */
    public void setGame(Game game) throws IOException
    {
        this.output.writeObject(game);
    }

    /**
     * Connection for Guests
     * @throws IOException 
     */
    public void logOn() throws IOException
    {
        this.socket = new Socket(this.host, this.port);
        // Initialiser les entrées outputs client
        this.output = new ObjectOutputStream(this.socket.getOutputStream());
        this.input = new ObjectInputStream(this.socket.getInputStream());
    }

    /**
     * Disconnection for the server
     * @throws IOException 
     */
    public void disconnect() throws IOException
    {
        this.socket.close();
        if (this.serverSocket != null)
        {
            this.serverSocket.close();
        }
    }

    /**
     * Listen for the server
     * @param s
     * @throws IOException 
     */
    public void listen(ServerSocket s) throws IOException
    {
        this.socket = serverSocket.accept();
        // Initialiser l'entrée output du server
        this.output = new ObjectOutputStream(this.socket.getOutputStream());
        this.input = new ObjectInputStream(this.socket.getInputStream());
    }

    /**
     * Get serverSocket
     * @return ServerSocket serverSocket
     */
    public ServerSocket getServerSocket()
    {
        return this.serverSocket;
    }

    /**
     * Get Socket
     * @return Socket socket
     */
    public Socket getSocket()
    {
        return this.socket;
    }
    
    /**
     * For Singleton of the Communication class
     * Constructor for guest connection
     * @return Connection
     */
    public final static Communication getGuestInstance() {
        Communication result = instance;
        // 1er verif sans verrou
        if (result == null) { 
            synchronized (Communication.class) {
                result = instance;
                // 2eme verif, apres acquisition du verrou
                if (result == null) {
                    try {
                        result = instance = new Communication(Config.HOST, Config.PORT);
                    } catch (SocketException ex) {
                        Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return instance;
    }
    
     /**
     * For Singleton of the Communication class
     * Constructor for server connection
     * @return Connection
     */
    public final static Communication getServerInstance() {
        Communication result = instance;
        // 1er verif sans verrou
        if (result == null) { 
            synchronized (Communication.class) {
                result = instance;
                // 2eme verif, apres acquisition du verrou
                if (result == null) {
                    try {
                        result = instance = new Communication(Config.PORT);
                    } catch (IOException ex) {
                        Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return instance;
    }
}
