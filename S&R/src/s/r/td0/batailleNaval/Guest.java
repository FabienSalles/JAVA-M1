package s.r.td0.batailleNaval;

import java.io.IOException;
import java.net.SocketException;
import java.util.Random;

/**
 * Guest
 * @author fsalles
 */
public class Guest
{
    private static final Integer MAX_NUMBER_STROKES = 100;
    
    private Integer numberOfAttempts;
    private Integer numberOfSuccess;
    private Integer numberOfFail;
    
    public Guest()
    {
        this.numberOfAttempts = this.numberOfSuccess = this.numberOfFail = 0;
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
    
    public void run() throws SocketException, IOException, ClassNotFoundException
    {
        Guest guest = new Guest();
        
        int x, y;
        Random random = new Random();
        
        Communication c = new Communication("localhost", 9876);
        c.logOn();
        
        Game game = c.getGame();
        System.out.println("Début de la partie");
        System.out.println("Nombre de bateaux sur le plateau : "+game.getNbBoat());

        while (this.numberOfAttempts < Guest.MAX_NUMBER_STROKES && !game.isFinish())
        {
            x = random.nextInt(game.getSize());
            y = random.nextInt(game.getSize());
            
            while (game.getBoard().attemptAlreadyExist(x, y))
            {
                x = random.nextInt(game.getSize());
                y = random.nextInt(game.getSize());
               
            }
            
            
            game.setAttempt(new Attempt(x, y));
            
            System.out.println("Bombarde "+game.getAttempt());
            c.setGame(game);
            
            game = c.getGame();
            if (game.getMessage().equals("Toucher"))
            {
                this.numberOfSuccess++;
            }
            else
            {
                this.numberOfFail++;
            }
            System.out.println(game.getMessage());
            c.setGame(game);
            // Recoit le nombre de bateaux restant après le coup
            game = c.getGame();
            System.out.println(game.getMessage());
            
            if(game.getNbBoat() == 0)
            {
               break;
            }
            guest.numberOfAttempts++;
        }
        
        game.setIsFinish(true);
        c.setGame(game);
        
        game = c.getGame(); // Recoit le resultat gagné ou non
        System.out.println(game.getMessage());
        System.out.println("Nombre de fail  : " + guest.getNumberOfFail());
        System.out.println("Nombre de success : " + guest.getNumberOfSuccess());
        
        c.disconnect();
    }
}
