package s.r.td0.batailleNaval;

import java.io.Serializable;


public class Message implements Serializable{
    
    private static final long serialVersionUID = -4878277265195707824L;
    private int combien = 0;
    private int posX = -1;
    private int posY = -1;
    private int score = 0;
    private String auRevoir = "NON";
    private String text;

    public String getAuRevoir() {
        return auRevoir;
    }

    public int getCombien() {
        return combien;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getScore() {
        return score;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getText() {
        return text;
    }

    public void setAuRevoir(String auRevoir) {
        this.auRevoir = auRevoir;
    }

    public void setCombien(int combien) {
        this.combien = combien;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    /**
     * combien : combien de navire dessus
     * @param taille
     * @param combien 
     */
    public Message(int combien) {
        this.combien = combien;

    }
    
    public String afficherDemandeClient(int caseDemande){
        return "Client demande " + caseDemande;
    }
    
    @Override
    public String toString() {
        return this.text;
    }
}
