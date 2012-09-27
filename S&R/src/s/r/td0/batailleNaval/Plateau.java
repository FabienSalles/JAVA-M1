/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td0.batailleNaval;

import java.util.Random;

/**
 *
 * @author fasalles
 */
public class Plateau {
    
    final static int TAILLE = 100;
    long[][] grille;
    int nbBateaux;
    
    /**
     * Initialise le jeux de bataille navale avec nbb bateaux
     * @param nbb 
     */
    public Plateau(int nbb)
    {
        int x, y;
        Random random = new Random();
        this.nbBateaux = nbb;
        
        for(int i=0; i<nbb; i++){
            x = random.nextInt(TAILLE);
            y = random.nextInt(TAILLE);
            while(this.grille[x][y] == -1){
                x = random.nextInt(TAILLE);
                y = random.nextInt(TAILLE); 
            }
            this.grille[x][y] = -1;
        }
    }
    
    /**
     * Test si la case (i,j) contient un navire a couler
     * @param i
     * @param j
     * @return 
     */
    public boolean contientNavire(int i, int j)
    {
        return true;
    }
    
    /**
     * Bombardement de la case (i, j)
     * @param i
     * @param j 
     */
    public void bombarde(int i, int j)
    {
        
    }
    
    /**
     * Retourne le nombre de bateaux coulés
     * @return 
     */
    public int nombreHit()
    {
        return 0;
    }
    
    /**
     * Retourne true s'il reste des bateaux
     * @return 
     */
    public boolean bateauxAcouler()
    {
        return this.nbBateaux>0;
    }
}
