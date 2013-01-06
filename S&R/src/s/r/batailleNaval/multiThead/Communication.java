/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.batailleNaval.multiThead;

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

    public Communication(String host, int port) throws SocketException
    {
        this.host = host;
        this.port = port;
        this.socket = null;
    }

    public Communication(int port) throws IOException
    {
        this.port = port;
        this.socket = null;
        this.serverSocket = new ServerSocket(this.port);
    }

    public Game getGame() throws IOException, ClassNotFoundException
    {
        return (Game) this.input.readObject();
    }

    public void setGame(Game game) throws IOException
    {
        this.output.writeObject(game);
    }

    public void logOn() throws IOException
    {
        this.socket = new Socket(this.host, this.port);
        // Initialiser les entrées outputs client
        this.output = new ObjectOutputStream(this.socket.getOutputStream());
        this.input = new ObjectInputStream(this.socket.getInputStream());
    }

    public void disconnect() throws IOException
    {
        this.socket.close();
        if (this.serverSocket != null)
        {
            this.serverSocket.close();
        }
    }

    public void listen(ServerSocket s) throws IOException
    {
        this.socket = serverSocket.accept();
        // Initialiser l'entrée output du server
        this.output = new ObjectOutputStream(this.socket.getOutputStream());
        this.input = new ObjectInputStream(this.socket.getInputStream());
    }

    public ServerSocket getServerSocket()
    {
        return this.serverSocket;
    }

    public Socket getSocket()
    {
        return this.socket;
    }
    
    public final static Communication getInstance() {
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
}
