package s.r.td0.batailleNaval;

import java.util.Random;

public class Plateau {
    
    public final static int TAILLE = 50; // Taille du plateau
    
    private long[][] grille; // Grille du plateau de jeu
    private int nbBateaux; // Nombre de bateaux flottants sur la grille
    private int nbBateauxDown = 0; // Nombre de bateaux coulés par le joueur

    /**
     * Initialise le plateau de jeu avec nbb bateaux à couler sur la grille
     * @param nbb Nombre de bateaux sur la grille à couler
     */
    public Plateau(int nbb) {
        this.grille = new long[TAILLE][TAILLE];
        int x,y;
        Random random = new Random();
        this.nbBateaux = nbb;
        for(int i=0;i<nbb;i++){
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
     * Teste si la case (i,j) contient un navire à couler
     * @param i
     * @param j
     * @return 
     */
    public boolean contientNavire(int i, int j){
        if(grille[i][j] == -1)
            return true;
        else
            return false;
    }
    
    /**
     * Bombardement de la case (i,j)
     * Il faut mettre à jour le nombre de bateaux flottants
     * @param i
     * @param j 
     */
    public void bombarde(int i,int j){
        if(grille[i][j] == -1){
            grille[i][j] = 2;
            this.nbBateaux--;
            this.nbBateauxDown++;
        }
    }
    
    /**
     * Retourne le nombre de bateaux coulés par le joueur
     * @return 
     */
    public int nombreHit(){
        return this.nbBateauxDown;
    }
    
    /**
     * Retourne true s'il reste des bateaux à couler
     * @return 
     */
    public boolean bateauxACouler(){
        return this.nbBateaux > 0;
    }

    public int getNbBateaux() {
        return this.nbBateaux;
    }
}
