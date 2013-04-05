/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package car2.td1.rmi.annuaire;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author fasalles
 */
public class Personne implements Serializable{
    private String name;
    private String num;

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personne other = (Personne) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }

    public Personne() {
    }

    public Personne(String name, String num) {
        this.name = name;
        this.num = num;
    }
}
