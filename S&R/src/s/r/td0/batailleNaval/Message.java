/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td0.batailleNaval;

import java.io.Serializable;

/**
 *
 * @author fasalles
 */
public class Message implements Serializable{
    
    private static final long serialVersionUID = -4878277265195707824L;
    private final int taille;
    private int combien = 0;
    private int posX = -1;
    private int posY = -1;
    private int score = 0;
    private boolean touche = false;
    private String auRevoir = "NON"; // BYE si le client souhaite arreter;
    
    public Message(int taille, int combien)
    {
        //
    }
}
