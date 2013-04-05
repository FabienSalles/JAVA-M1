/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.bataillenaval.multithread.multiMachine;

import fr.p10.miagem1a.reseau.bataillenavale.client.Client;
import fr.p10.miagem1a.reseau.bataillenavale.system.Communication;
import fr.p10.miagem1a.reseau.bataillenavale.system.Message;
import fr.p10.miagem1a.reseau.bataillenavale.system.Plateau;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author visreng
 */
public class Server_1 implements Runnable{
    
    private ArrayList ClientList = new ArrayList(); //contient les flux de sortie vers les clients
    private int nbClient = 0; //nombre total de clients connectés
    private Plateau plateau;
    private Communication com;
    private Message m;
    
    public Server_1(Plateau plateau, Message m) {
       this.plateau=plateau;
       this.m=m;
    }
    
    public static void main(String args[]) throws Exception {
        Plateau plateau = new Plateau(20);
        Message m = new Message(100,plateau.getNbBateaux());
        ServerSocket serverSocket = new ServerSocket(6789);
        Main server = new Main(plateau,m);
        while(serverSocket.accept()!=null){
            Communication com = new Communication(serverSocket);
            server.setCom(com);
            new Thread(server).start();   
        }
    }
    
    synchronized public void sendAll(Message m, String sLast){
        PrintWriter out;
        for(int i = 0; i< ClientList.size();i++){
            out = (PrintWriter) ClientList.get(i);
            if(out != null){
                out.print(m);
                out.flush();
            }
        }
    }
    
    synchronized public int addClient(PrintWriter out){
        nbClient++;
        ClientList.add(out);
        return ClientList.size()-1;       
    }
    
    synchronized public int getNbClients(){
        return nbClient;
    }

    public void setCom(Communication com) {
        this.com = com;
    }

    @Override
    public void run() {
        try{
            System.out.println("Serveur demarré!");
            while(true){
                com.ecouter();
                com.envoyerMessage(m);
                m = com.recevoirMessage();
                m.setTouche(plateau.contientNavire(m.getPosX(), m.getPoxY()));
                m.setCombien(plateau.getNbBateaux());
                com.envoyerMessage(m);
            }
        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
 