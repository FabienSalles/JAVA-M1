package s.r.bataillenaval.multithread;

import java.io.Serializable;


public class Game implements Serializable{
    
    private static final long serialVersionUID = -4878277265195707824L;

    private boolean isFinish;
    private Attempt attempt;
    private boolean hit;
    private Board board;
    private static Game instance;
    
    /**
     * Constructor of the game
     * @param size
     * @param nbBoat 
     */
    private Game()
    {
        // initialize the single board for the game
        this.board = Board.getInstance();
        this.isFinish = false;
    }

    /**
     * Check if the game is finish
     * @return Boolean true or false
     */
    public boolean isFinish()
    {
        return this.isFinish;
    }

    /**
     * Get hit
     * @return boolean hit
     */
    public boolean getHit()
    {
        return hit;
    }

    /**
     * Get attempt
     * @return Attempt attempt
     */
    public Attempt getAttempt()
    {
        return attempt;
    }
    
    /**
     * Get boardgame
     * @return Board board
     */
    public Board getBoard()
    {
        return board;
    }
    
    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    /**
     * Set value of isFinish propertie
     * @param isFinish 
     */
    public void setIsFinish(boolean isFinish)
    {
        this.isFinish = isFinish;
    }

    /**
     * set value of hit propertie
     * @param hit 
     */
    public void setHit(boolean hit)
    {
        this.hit = hit;
    }

    /**
     * Set value of attempt propertie
     * @param attempt 
     */
    public void setAttempt(Attempt attempt)
    {
        this.attempt = attempt;
    }
    
    /**
     * static method for singleton
     * @return 
     */
    public final static Game getInstance() {
        Game result = instance;
        if (result == null) { // 1er verif sans verrou
            synchronized (Game.class) {
                result = instance;
                if (result == null) { // 2eme verif, apres acquisition du verrou
                    result = instance = new Game();
                }
            }
        }
        return instance;
    }
}
