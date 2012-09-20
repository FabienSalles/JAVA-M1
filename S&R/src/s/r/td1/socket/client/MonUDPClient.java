/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td1.socket.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author fasalles
 */
class MonUDPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        // 1 - Creation du buffer de lecture clavier
        BufferedReader inFromUser = new BufferedReader
        (new InputStreamReader(System.in));
        // 2 - Creation de la socket, n de port par defaut
        DatagramSocket clientSocket = new DatagramSocket();
        System.out.println("socket client attaché au port " + clientSocket.getLocalPort());
        // 3 - Recuperation de l'@IP du serveur
        InetAddress IPAddress = InetAddress.getByName("localhost");
        // 3bis - preparation de l'echange
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        int length = sendData.length;
        // 3ter - Initialisation de la (UDP)PDU a emettre
        DatagramPacket sendPacket = new DatagramPacket
        (sendData, sendData.length, IPAddress, 9878);
        // 4 - Emission de la (UDP)PDU
        clientSocket.send(sendPacket);
        // Détails de l'envoie
        System.out.println("Paquet de " + clientSocket.getLocalAddress() + ":" + clientSocket.getLocalPort() + " envoyé vers " + sendPacket.getAddress() + ":" + sendPacket.getPort());
        // 5 - Creation d'un buffer de (UDP)PDU arrivant sur la socket
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        // 5bis - Reception de la (UDP)PDU
        clientSocket.receive(receivePacket);
        // 6 - Affichage des donnees recues
        String modifiedSentence = new String (receivePacket.getData());
        System.out.println("Réponse du serveur " + receivePacket.getAddress() + ":" + receivePacket.getPort()+ " : " + modifiedSentence);
        // Fermeture de la socket
        clientSocket.close();
    }
}
