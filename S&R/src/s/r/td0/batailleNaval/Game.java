package s.r.td0.batailleNaval;

import java.io.Serializable;


public class Game implements Serializable{
    
    private static final long serialVersionUID = -4878277265195707824L;
    private int nbBoat;
    private int size;
    private boolean isFinish;
    private Attempt attempt;
    private String message;
    private Board board;
    private static Game instance;
    
    /**
     * Constructor of the game
     * @param size
     * @param nbBoat 
     */
    public Game(int nbBoat, int size)
    {
        this.nbBoat = nbBoat;
        this.size = size;
        this.board = Board.getInstance(this.nbBoat, this.size);
        this.isFinish = false;
    }

    public int getNbBoat()
    {
        return nbBoat;
    }

    public boolean isFinish()
    {
        return this.isFinish;
    }

    public String getMessage()
    {
        return message;
    }

    public Attempt getAttempt()
    {
        return attempt;
    }

    public int getSize() {
        return size;
    }

    
    public Board getBoard()
    {
        return board;
    }
    
    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public void setNbBoat(int nbBoat)
    {
        this.nbBoat = nbBoat;
    }

    public void setIsFinish(boolean isFinish)
    {
        this.isFinish = isFinish;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setAttempt(Attempt attempt)
    {
        this.attempt = attempt;
    }
    
    public String displayRequest(String request){
        return "Client demande " + request;
    }
    
    public final static Game getInstance(int nbBoat, int size) {
        Game result = instance;
        if (result == null) { // 1er verif sans verrou
            synchronized (Game.class) {
                result = instance;
                if (result == null) { // 2eme verif, apres acquisition du verrou
                    result = instance = new Game(nbBoat, size);
                }
            }
        }
        return instance;
    }
}
