/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td0.batailleNaval;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Communication
 * @author fsalles
 */
public class Communication {

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

    public synchronized Game getGame() throws IOException, ClassNotFoundException
    {
        return (Game) this.input.readObject();
    }

    public synchronized void setGame(Game game) throws IOException
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
}
