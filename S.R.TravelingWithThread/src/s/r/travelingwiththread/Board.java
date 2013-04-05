/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.travelingwiththread;

import java.io.Serializable;
import java.util.Random;

/**
 * GameBoard
 * @author fsalles
 */
public class Board
{
    private static final long serialVersionUID = -23456765495707824L;

    /**
     * grid of the board
     */
    private Box[][] grid;
    
    /**
     * Instance of the board for the singleton
     */
    private static Board instance;
    
    /**
     * Initialize the gameboard with the number of boat sinking and size of the grid
     */
    private Board()
    {
        this.grid = new Box[Config.GRID_SIZE][Config.GRID_SIZE];
        
        for(int i = 0; i < Config.NB_WALLS; i++)
        {
            this.initBoxes(Wall.ID);
        }
        
        for(int i = 0; i < Config.NB_CHAIR; i++)
        {
            this.initBoxes(Chair.ID);
        }
        
        for(int i = 0; i < Config.NB_PLAYER; i++)
        {
            this.initBoxes(Chair.ID);
        }
    }
    
    private void initBoxes(Integer id)
    {
        Integer x, y;
        Random random = new Random();
        do
        {
            x = random.nextInt(Config.GRID_SIZE);
            y = random.nextInt(Config.GRID_SIZE);
        }
        while(this.grid[x][y] != null);
        
        switch(id)
        {
            case Wall.ID:
                this.grid[x][y] = new Wall();
                break;
            default:
        }
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
