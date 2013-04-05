package s.r.bataillenaval.multithread;

import java.io.IOException;
import java.net.SocketException;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Player
 * @author fsalles
 */
public class Player implements Runnable
{   
    /**
     * id of the player
     */
    private Integer id;
    /**
     * Number of attempt of the player
     */
    private Integer numberOfAttempts;
    /**
     * number of success when the player sunk a ship
     */
    private Integer numberOfSuccess;
    private Integer numberOfFail;
    private Attempt attempt;
    private Random  random;
    private Communication com;
    
    /**
     * One semaphore for all players
     */
    private final static Semaphore semaphore = new Semaphore(1,true);
    //private final static Lock lock = new ReentrantLock();
    
    public Player()
    {
        this.numberOfAttempts = this.numberOfSuccess = this.numberOfFail = 0;
        this.attempt = new Attempt();
        this.random = new Random();
        // same connection for all players
        this.com = Communication.getPlayerInstance();
    }
    
    public Player(Integer id)
    {
        this();
        this.id = id;
    }
    
    public Integer getNumberOfAttempts()
    {
        return numberOfAttempts;
    }

    public Integer getNumberOfSuccess()
    {
        return numberOfSuccess;
    }

    public Integer getNumberOfFail()
    {
        return numberOfFail;
    }

    public void setNumberOfAttempts(Integer numberOfAttempts)
    {
        this.numberOfAttempts = numberOfAttempts;
    }

    public void setNumberOfSuccess(Integer numberOfSuccess)
    {
        this.numberOfSuccess = numberOfSuccess;
    }

    public void setNumberOfFail(Integer numberOfFail)
    {
        this.numberOfFail = numberOfFail;
    }    

    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Player play the game
     */
    public void run()
    {
        try 
        {
            Game game = null;
            int x, y;
            
            // this boucle finish when all boats were sunk
            for(;;)
            {
                // The first player take the semaphore
                // and all others wait here
                Player.semaphore.acquire();
                //Player.lock.lock();
                
                // this player retrieves the game
                game = com.getGame();
                // if the player has attemps and if the game isn't finish
                if(this.numberOfAttempts < Config.MAX_NUMBER_STROKES && !game.isFinish())
                {
                    System.out.println("Player : "+this.id+" prend la main");

                    // try with new coordinates
                    do
                    {
                        x = random.nextInt(Config.GRID_SIZE);
                        y = random.nextInt(Config.GRID_SIZE);

                    }
                    while (game.getBoard().attemptAlreadyExist(x, y));

                    game.setAttempt(new Attempt(x, y));

                    System.out.println("Bombarde "+game.getAttempt());
                    // send this attempt
                    com.setGame(game);
                    
                    // retrieves response
                    game = com.getGame();
                    if (game.getHit())
                    {
                        this.numberOfSuccess++;
                        System.out.println("Touché");
                    }
                    else
                    {
                        this.numberOfFail++;
                        System.out.println("Pas touché");
                    }
                    this.numberOfAttempts++;
                    
                    System.out.println("Bateaux restants : "+game.getBoard().getNumberBoat());
                }
                
                Thread.sleep(250);
                
                // if the game isn't finish this player gives the hand a server
                // because the server wait
                if(game.getBoard().getNumberBoat() != 0)
                {
                   com.setGame(game);
                }
                // else the game is finish
                else
                {
                    break;
                }
                
                Player.semaphore.release();
                //Player.lock.unlock();
            }
            Thread.sleep(250);
            // If this value isn't set
            if(!game.isFinish() && game.getBoard().getNumberBoat() == 0)
            {
                game.setIsFinish(true);
                com.setGame(game);
                System.out.println("Bravo il n'y a plus de bateaux");       
            }
            else 
            {
                System.out.println("Perdu !"); 
            }
            System.out.println("Player : "+this.id);
            System.out.println("Nombre de fail  : " + this.numberOfFail);
            System.out.println("Nombre de success : " + this.numberOfSuccess);
            Player.semaphore.release();
            //Player.lock.unlock();
    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
