package Catalogue;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fasalles
 */
public class DVD {
    
    private int id;
    private String description;
    private float prix;

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public float getPrix() {
        return prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public DVD() {
    }

    public DVD(int id, String description, float prix) {
        this.id = id;
        this.description = description;
        this.prix = prix;
    }
}
