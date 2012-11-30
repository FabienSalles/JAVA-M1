/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.batailleNaval.multiThead;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;

/**
 *
 * @author fsalles
 */
public class Client implements Runnable{
    
    private static Communication com;
    private static Thread thd;
    private static Socket sock;
    public static int BATEAUX = Plateau.TAILLE;

    public Client(Communication com) {
        Client.com = com;
        Client.thd = new Thread(this);
        Client.sock = com.getSocket();
    }

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException { 
        com = new Communication("localhost", 6789);
        com.connecter();
        if (com.getSocket() != null) {
            new Thread(new Client(com)).start();
        }
    }

    @Override
    public void run() {
        try{
            System.out.print("Start!!");
            int i,j;
            Message m = com.recevoirMessage();
            System.out.println(m);   
            for(i=1;i<BATEAUX;i++){
                for(j=1;j<BATEAUX;j++){
                    System.out.println(" --- TIR EFFECTUE A LA POSITION " + i + " " + j);
                    m.setPos(i, j);
                    com.envoyerMessage(m);
                    m = com.recevoirMessage();
                    if(m.isTouche()){
                        System.out.println(" -- Bateau touché à la position " + m.getPosX() + " " + m.getPoxY());
                    }
                    else{
                        System.out.println(" -- Tir raté à la position " + m.getPosX() + " " + m.getPoxY()); 
                    }
                    System.out.println("Il reste " + m.getCombien() + " bateau(x).");
                } 
            }
        } catch (ClassNotFoundException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
