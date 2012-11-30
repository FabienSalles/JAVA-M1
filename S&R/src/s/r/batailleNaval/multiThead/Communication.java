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

/**
 *
 * @author yvrenaud
 */
public class Communication {

    private ObjectOutputStream sortie;
    private ObjectInputStream entree;
    private String hote;
    private int port;
    private Socket socket;
    private ServerSocket serverSocket;

    public Communication(String host, int port) throws SocketException {
        this.hote = host;
        this.port = port;
        this.socket = null;
    }

    public Communication(int port) throws IOException {
        this.port = port;
        this.socket = null;
        this.serverSocket = new ServerSocket(this.port);
    }

    public Message recevoirMessage() throws IOException, ClassNotFoundException {
        Message m = (Message) this.entree.readObject();
        return m;
    }

    public void envoyerMessage(Message msg) throws IOException {
        this.sortie.writeObject(msg);
    }

    public void connecter() throws IOException {
        this.socket = new Socket(this.hote, this.port);
        // Initialiser les entrées sorties client
        this.sortie = new ObjectOutputStream(this.socket.getOutputStream());
        this.entree = new ObjectInputStream(this.socket.getInputStream());
    }

    public void deconnecter() throws IOException {
        this.socket.close();
        if(this.serverSocket != null){
            this.serverSocket.close();
        }
    }

    public void ecouter(ServerSocket s) throws IOException {
        this.socket = serverSocket.accept();
        // Initialiser l'entrée sortie du server
        this.sortie = new ObjectOutputStream(this.socket.getOutputStream());
        this.entree = new ObjectInputStream(this.socket.getInputStream());
    }

    public ServerSocket getServerSocket() {
        return this.serverSocket;
    }

    public Socket getSocket() {
        return this.socket;
    }
}
