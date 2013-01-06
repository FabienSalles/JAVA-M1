package s.r.batailleNaval.multiThead;

import java.io.IOException;
import java.net.SocketException;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Guest
 * @author fsalles
 */
public class Guest implements Runnable
{   
    private Integer id;
    private Integer numberOfAttempts;
    private Integer numberOfSuccess;
    private Integer numberOfFail;
    private Attempt attempt;
    private Random  random;
    private Communication com;
    
    private static Semaphore semaphore = new Semaphore(1,true);
    
    public Guest()
    {
        this.numberOfAttempts = this.numberOfSuccess = this.numberOfFail = 0;
        this.attempt = new Attempt();
        this.random = new Random();
        this.com = Communication.getInstance();
    }
    
    public Guest(Integer id)
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
    
    
    public void run()
    {
        try 
        {
            Game game = null;
            int x, y;
            
            for(;;)
            {
                Guest.semaphore.acquire();
                game = com.getGame();
                if(this.numberOfAttempts < Config.MAX_NUMBER_STROKES && !game.isFinish())
                {
                    System.out.println("Guest : "+this.id+" prend la main");

                    do
                    {
                        x = random.nextInt(Config.GRID_SIZE);
                        y = random.nextInt(Config.GRID_SIZE);

                    }
                    while (game.getBoard().attemptAlreadyExist(x, y));

                    game.setAttempt(new Attempt(x, y));

                    System.out.println("Bombarde "+game.getAttempt());
                    com.setGame(game);

                    game = com.getGame();
                    if (game.getMessage().equals("Toucher"))
                    {
                        this.numberOfSuccess++;
                    }
                    else
                    {
                        this.numberOfFail++;
                    }
                    this.numberOfAttempts++;
                    System.out.println(game.getMessage());
                    System.out.println("Bateaux restants : "+game.getBoard().getNumberBoat());
                }
                if(game.getBoard().getNumberBoat() != 0)
                {
                   com.setGame(game);
                }
                else
                {
                    break;
                }
                
                Guest.semaphore.release();
                
            }
            if(!game.isFinish())
            {
                game.setIsFinish(true);
                com.setGame(game);
                System.out.println("Bravo il n'y a plus de bateaux");
            }
            else
            {
                
            }
            System.out.println("Guest : "+this.id);
            System.out.println("Nombre de fail  : " + this.numberOfFail);
            System.out.println("Nombre de success : " + this.numberOfSuccess);
            Guest.semaphore.release();
    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
                Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
