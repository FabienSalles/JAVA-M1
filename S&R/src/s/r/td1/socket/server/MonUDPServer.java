/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td1.socket.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author fasalles
 */
class MonUDPServer {

    // creation d'un socket sur le port 9876. Le serveur attend sur ce port
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9878);
        System.out.println("socket serveur attaché au port " + serverSocket.getLocalPort());
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true){
            // Traitement de la reception
            // creation d'un buffer de (UDP)PDU arrivant sur le socket
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            // reception d'un (UDP)PDU sur le socket
            serverSocket.receive(receivePacket);
            // rangement du champ de donnees de l'(UDP)PDU dans un string
            String sentence = new String(receivePacket.getData());
            // recuperation de l'adresse IP de l'emetteur
            InetAddress IPAddress = receivePacket.getAddress();
            // recuperation du n de port de l'emetteur
            int port = receivePacket.getPort();
            // traitement du champ de donnees
            String [] s = sentence.split(" ");
            String capitalizedSentence = s[s.length-1];
            // Traitement de l'emission
            // initialisation du champ de donnees de l'(UDP) PDU a emettre
            sendData = capitalizedSentence.getBytes();
            // initalisation de l'(UDP)PDU en reponse, donc a l'@IP et n°port
            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, port);
            System.out.println("Paquet de " + serverSocket.getLocalAddress() + ":" + serverSocket.getPort() + " envoyé vers " + sendPacket.getAddress() + ":" + sendPacket.getPort());
            // emission de l'(UDP)PDU en reponse
            serverSocket.send(sendPacket);
        }
    }
}