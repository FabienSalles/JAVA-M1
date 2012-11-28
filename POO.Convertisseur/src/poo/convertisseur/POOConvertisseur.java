/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.convertisseur;

/**
 *
 * @author fasalles
 */
public class POOConvertisseur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new convertisseurGUI();
            }
        });
    }
}
