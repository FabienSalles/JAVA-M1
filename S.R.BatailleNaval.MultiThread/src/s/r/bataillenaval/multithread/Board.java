package s.r.bataillenaval.multithread;

import java.io.Serializable;
import java.util.Random;

/**
 * GameBoard
 * @author fsalles
 */
public class Board implements Serializable
{
    private static final long serialVersionUID = -23456765495707824L;

    /**
     * grid of the board
     */
    private long[][] grid;
    /**
     * number of boat
     */
    private int numberBoat;
    /**
     * number of sunken ship
     */
    private int numberSunkenShip;
    
    /**
     * Instance of the board for the singleton
     */
    private static Board instance;
    
    /**
     * Initialize the gameboard with the number of boat sinking and size of the grid
     */
    private Board()
    {
        this.numberBoat = Config.NB_BOAT;
        this.grid = new long[Config.GRID_SIZE][Config.GRID_SIZE];
        this.numberSunkenShip = 0;
        int x,y;
        Random random = new Random();
        
        
        for (int i=0;i<this.numberBoat;i++)
        {
            x = random.nextInt(Config.GRID_SIZE);
            y = random.nextInt(Config.GRID_SIZE);
            while (this.grid[x][y] == 1)
            {
                x = random.nextInt(Config.GRID_SIZE);
                y = random.nextInt(Config.GRID_SIZE);
            }
            this.grid[x][y] = 1;
        }
    }
    
    /**
     * Look if the box (i,j) contains a boat sinking 
     * @param Attempt attempt
     * @return true or false
     */
    public boolean containsBoatSinking(Attempt attempt)
    {
        if (this.grid[attempt.getPosX()][attempt.getPosY()] == 1)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Look if the box (i,j) contains a ship that has already sunk
     * @param i
     * @param j
     * @return true or false
     */
    public boolean attemptAlreadyExist(int i, int j)
    {
        if(this.grid[i][j] == 2 || this.grid[i][j] == 3)
        {
            return true;
        }
        return false;
    }
    
    /**
     * bombing the box (i,j)
     * update the number of boat and sunken ship if the case contains a boat
     * and change the valeur of the box in the grid :
     *  2 for no boat
     *  3 for boat sinking 
     * @param Attempt attempt
     * @return true or false if the boat sinks
     */
    public boolean bombing(Attempt attempt)
    {
        if(this.containsBoatSinking(attempt))
        {
            this.grid[attempt.getPosX()][attempt.getPosY()] = 3;
            this.numberBoat--;
            this.numberSunkenShip++;
            return true;
        }
        this.grid[attempt.getPosX()][attempt.getPosY()] = 2;
        return false;
    }
    
    /**
     * Get the number of sunken ship
     * @return numberSunkenShip
     */
    public int getNumberSunkenShip()
    {
        return this.numberSunkenShip;
    }
    
    /**
     * Look if there are boats to sink
     * @return true or false
     */
    public boolean containsBoatToSink()
    {
        return this.numberBoat > 0;
    }

    /**
     * Get the number of boat to sink
     * @return numberBoat
     */
    public int getNumberBoat()
    {
        return this.numberBoat;
    }
    
    /**
     * 
     * @return serialVersionUID
     */
    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }
    
    /**
     * Return instance of the Board class
     * @return Board 
     */
    public final static Board getInstance() {
        Board result = instance;
        if (result == null) { // 1er verif sans verrou
            synchronized (Board.class) {
                result = instance;
                if (result == null) { // 2eme verif, apres acquisition du verrou
                    result = instance = new Board();
                }
            }
        }
        return instance;
    }
}
