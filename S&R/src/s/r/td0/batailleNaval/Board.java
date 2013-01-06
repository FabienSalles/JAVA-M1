package s.r.td0.batailleNaval;

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
    
    private static Board instance;
    
    /**
     * Initialize the gameboard with the number of boat sinking in parameter
     * @param nbBoat number of boat sinking
     */
    public Board(int nbBoat, int size)
    {
        this.grid = new long[size][size];
        this.numberSunkenShip = 0;
        int x,y;
        Random random = new Random();
        this.numberBoat = nbBoat;
        
        for (int i=0; i< size; i++)
        {
           for(int j=0; j<size; j++)
           {
               this.grid[i][j] = 0;
           }
        }
        
        for (int i=0;i<nbBoat;i++)
        {
            x = random.nextInt(size);
            y = random.nextInt(size);
            while (this.grid[x][y] == 1)
            {
                x = random.nextInt(size);
                y = random.nextInt(size);
            }
            this.grid[x][y] = 1;
        }
    }
    
    /**
     * Look if the box (i,j) contains a boat sinking 
     * @param i
     * @param j
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
     * bombing the case (i,j)
     * update the number of boat and sunken ship if the case contains a boat
     * @param i
     * @param j 
     * @return true or false if the boat sinks
     */
    public synchronized boolean bombing(Attempt attempt)
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
    
    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }
    
    public final static Board getInstance(int nbBoat, int size) {
        Board result = instance;
        if (result == null) { // 1er verif sans verrou
            synchronized (Board.class) {
                result = instance;
                if (result == null) { // 2eme verif, apres acquisition du verrou
                    result = instance = new Board(nbBoat, size);
                }
            }
        }
        return instance;
    }
}
